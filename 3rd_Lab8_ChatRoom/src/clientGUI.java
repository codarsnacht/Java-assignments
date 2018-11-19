import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class clientGUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel label, imgLabel;
	private JTextField textField;
	private JTextField serverTf, portTf;
	private client client;
	private int defaultPort;
	private String defaultHost;
	private JButton login, logout, whoIsIn, changeColour, uploadImg;
	private JTextArea textArea;
	private boolean connected;
	
	//image -- not working 
	String[] img= {"hsCowboyHat.jpg" };
	
	// Constructor 
	clientGUI(String host, int port) {
		super("Chat Room");
		defaultPort = port;
		defaultHost = host;
		
		//southPanel 
		JPanel southPanel = new JPanel(new GridLayout(2,1));
		JPanel namePanel = new JPanel(new GridLayout(2,1));
		serverTf = new JTextField(host);
		portTf = new JTextField("" + port);
		portTf.setHorizontalAlignment(SwingConstants.RIGHT);

														//centres the text 
		label = new JLabel("Enter your username below", SwingConstants.CENTER);
		southPanel.add(label);
		textField = new JTextField("Enter Username"); // default username // user should enter in new username
		textField.setBackground(Color.WHITE);
		southPanel.add(textField);
		add(southPanel, BorderLayout.SOUTH);

		// The CenterPanel which is the chat room
		textArea = new JTextArea("Welcome to the Chat room\n", 185, 185);
		JPanel centerPanel = new JPanel(new GridLayout(1,1));
		centerPanel.add(new JScrollPane(textArea));
		textArea.setEditable(false);
		add(centerPanel, BorderLayout.CENTER);

		// the buttons
		login = new JButton("Login");
		login.setBackground(Color.YELLOW);
		login.addActionListener(this);
		
		changeColour = new JButton("Change colour") ;
		changeColour.addActionListener(this);
		
		logout = new JButton("Logout");
		logout.setBackground(Color.red);
		logout.addActionListener(this);
		logout.setEnabled(false);	// you have to login before being able to logout
		
		whoIsIn = new JButton("Who is in chat room");
		whoIsIn.setBackground(Color.WHITE);
		whoIsIn.addActionListener(this);
		whoIsIn.setEnabled(false);	 // you have to login before being able to who is in the chat room
		
		//button for uploading image
		uploadImg = new JButton("Upload Image");
		uploadImg.addActionListener(this);
		uploadImg.setBackground(Color.CYAN);//set background colour for the upload image button
		

		
		//northPanel containing the user interaction buttons
		JPanel northPanel = new JPanel();
		//adds buttons to panel
		northPanel.add(login);
		northPanel.add(logout);
		northPanel.add(whoIsIn);
		northPanel.add(changeColour);
		northPanel.add(uploadImg);
		add(northPanel, BorderLayout.NORTH);
		northPanel.setBackground(Color.blue); //gives background colour on top of gui
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 400); //size of GUI
		setVisible(true);
		textField.requestFocus();
	}

	void append(String str) {
		textArea.append(str);
		textArea.setCaretPosition(textArea.getText().length() - 1);
	}

	void connectionFailed() {
		login.setEnabled(true);
		logout.setEnabled(false);
		whoIsIn.setEnabled(false);
		changeColour.setEnabled(true);
		label.setText("Enter your username below");
		textField.setText("USERNAME");
		
		serverTf.setEditable(false);//user cannot change the 
		portTf.setEditable(false); //port or server numbers 
		
		textField.removeActionListener(this);
		connected = false;
	}
	
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		// if button = "Logout" button
		if(o == logout) {
			client.sendMessage(new chatMessage(chatMessage.LOGOUT, ""));
			return;
		}
		// if button = "who is in" button
		if(o == whoIsIn) {
			client.sendMessage(new chatMessage(chatMessage.WHOISIN, ""));				
			return;
		}
		//if button pressed = "change colour" 
		//gives user option to choose background colour of the text area
		//for some reason it requires user to enter colour choice twice and second choice 
		//- is the colour that is choosen
		if(o == changeColour){	
				Color ic = Color.red;
				Color color = JColorChooser.showDialog(this,"Select colour" , ic);
				textArea.setBackground(color);		
		}
		
		//if button = "uploadImg" button
		//upload image to text area
		if(o==uploadImg){
			textArea.add(imgLabel);
			addImageToLabel(2,img ,imgLabel);
			
		}
		//sends message to chat room 
		if(connected) {
			client.sendMessage(new chatMessage(chatMessage.MESSAGE, textField.getText()));				
			textField.setText("");
			return;
	}
		
		//if button = "login" button , can only use when not originally logged in
		if(o == login) {
			String username = textField.getText().trim();
			if(username.length() == 0)	// empty username 
				return;
			
			String server = serverTf.getText().trim(); // empty or invalid server number
			if(server.length() == 0)
				return;
			
			String portNumber = portTf.getText().trim();// empty or invalid port number
			if(portNumber.length() == 0)
				return;
			int port = 0;
			try {
				port = Integer.parseInt(portNumber);
			}
			catch(Exception en) {
				return;  
			}

			// create new Client with GUI
			client = new client(server, port, username, this);
			if(!client.start()) 
				return;
			textField.setText("");
			label.setText("Enter your message below");
			connected = true;
			
			//once logged in: 
			// disable login button
			login.setEnabled(false);
			
			// enable the 4 other buttons
			logout.setEnabled(true);
			whoIsIn.setEnabled(true);
			changeColour.setEnabled(true);
			uploadImg.setEnabled(true);
			
			// disable the Server and Port options, so user cant change the server/port number
			serverTf.setEditable(false);
			portTf.setEditable(false);
			
			//action listener for when user selects the change colour button
			changeColour.addActionListener(this);
			uploadImg.addActionListener(this);
			
			// Action listener for when the user enter a message
			textField.addActionListener(this);
		}

	}
	//method for adding image to label
	public void addImageToLabel(int size, String[] list, JLabel label) {
		Icon icon = new ImageIcon(getClass().getResource(list[size]));
		label.setIcon(icon);
	}
	
	// start  
	public static void main(String[] args) {
		new clientGUI("localhost", 1500);
	}}//end of class