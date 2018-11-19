import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class serverGUI extends JFrame implements ActionListener, WindowListener {
	
	private static final long serialVersionUID = 1L;
	private JButton sS; // stop/start Server button
	private JTextArea chat, event;
	private JTextField tPortNumber;
	private server server;
	
	
	// server constructor 
	serverGUI(int port) {
		super("Chat Server");
		server = null;
		
		JPanel north = new JPanel();
		north.add(new JLabel("Port number: "));
		tPortNumber = new JTextField("  " + port);  // have abality to change port number in GUI
		north.add(tPortNumber);
		
		// to stop or start server, start with "Start"
		sS = new JButton("Start");
		sS.addActionListener(this);
		north.add(sS);
		add(north, BorderLayout.NORTH);
		
		// the event and chat room
		JPanel center = new JPanel(new GridLayout(2,1));
		chat = new JTextArea(100,100);
		chat.setEditable(false);
		appendRoom("Chat room.\n");
		center.add(new JScrollPane(chat));
		event = new JTextArea(100,100);
		event.setEditable(false);
		appendEvent("Events log.\n");
		center.add(new JScrollPane(event));	
		add(center);
		
		
		addWindowListener(this);
		setSize(750, 650); //size of serverGUI
		setVisible(true);
	}		

	void appendEvent(String str) {
		event.append(str);
		event.setCaretPosition(chat.getText().length() - 1);
		
	}
	
	// start or stop when button is clicked
	public void actionPerformed(ActionEvent e) {
		if(server != null) {
			server.stop();
			server = null;
			tPortNumber.setEditable(true);
			sS.setText("Start");
			return;
		}
		int port;
		try {
			port = Integer.parseInt(tPortNumber.getText().trim());
		}
		catch(Exception er) {
			appendEvent("Invalid port number");
			return;
		}
		
		server = new server(port, this);
		new ServerRunning().start();
		sS.setText("Stop");
		tPortNumber.setEditable(false);
	}
	// append message to the JTextArea's
	void appendRoom(String str) {
		chat.append(str);
		chat.setCaretPosition(chat.getText().length() - 1);
	}
	
	//main
	public static void main(String[] arg) {
		new serverGUI(1500); 
	}

	//closes window when called for ( pressed X on top right corner of window)
	public void windowClosing(WindowEvent e) {
		if(server != null) {
			try {
				server.stop();	
			}
			catch(Exception eClose) {
				eClose.printStackTrace();
			}
			server = null;
		}
		dispose(); 				//removes and exits window
		System.exit(0);
	}
	//required methods
	public void windowClosed(WindowEvent e) {}
	public void windowOpened(WindowEvent e) {}
	public void windowIconified(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowActivated(WindowEvent e) {}
	public void windowDeactivated(WindowEvent e) {}

	//creates thread for the serverGUI
	class ServerRunning extends Thread {
		public void run() {
			server.start();
			sS.setText("Start");
			tPortNumber.setEditable(true);
			appendEvent("Server crashed\n");
			server = null;
		}}}//end of class
