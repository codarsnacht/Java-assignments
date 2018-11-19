import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;


public class server {
	
	private static int uniqueId; 
	private ArrayList<ClientThread> clientList; // an ArrayList to keep the list of the Client
	private serverGUI serverGUI;
	private SimpleDateFormat sdf; 				// to display time
	private int port;
	private boolean keepGoing;
	
	//constructor
	public server(int port, serverGUI sg) {
		this.serverGUI = sg;  
		this.port = port;
		sdf = new SimpleDateFormat("HH:mm:ss"); 
		clientList = new ArrayList<ClientThread>(); 
	}
	
	public void start() {
		keepGoing = true;
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			while(keepGoing) 
			{
				// format message saying we are waiting
				display("Server waiting for Clients on port " + port + ".");
				Socket socket = serverSocket.accept();  	// accept connection
				if(!keepGoing) // end condition
				break;
				ClientThread t = new ClientThread(socket);  // make a thread of it // to allow multiple clients to work at same time
				clientList.add(t);									// add it in the ArrayList
				t.start();
			}
			//to stop
			try {
				serverSocket.close();
				for(int i = 0; i < clientList.size(); ++i) {
					ClientThread tc = clientList.get(i);
					try {
					tc.ois.close();
					tc.oos.close();
					tc.socket.close();
					}
					catch(IOException ioE) {
						//catches exception
						ioE.printStackTrace();
					}
				}
			}
			catch (IOException e) {
	            String msg = sdf.format(new Date()) + " Exception on new ServerSocket: " + e + "\n";
				display(msg);
			}
		}
		catch(Exception e) {
			//catches default exception
			e.printStackTrace();
		}
	
		}
			
    
    //to stop server
	protected void stop() {
		keepGoing = false;
		try {
			new Socket("localhost", port);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	private synchronized void broadcast(String message) {
		String time = sdf.format(new Date());
		String messageLf = time + " " + message + "\n"; // adds time format and \n to the message
		serverGUI.appendRoom(messageLf); //display message in GUI
		//to remove a Client because it has disconnected
		for(int i = clientList.size(); --i >= 0;) {
			ClientThread ct = clientList.get(i);
			if(!ct.writeMsg(messageLf)) {
				clientList.remove(i);
				display("Disconnected Client " + ct.username + " removed from list.");
			}
		}
	}

	private void display(String msg) {
		String time = sdf.format(new Date()) + " " + msg;
			serverGUI.appendEvent(time + "\n");
	}
	
	// got Logout message from clientGUI
	synchronized void remove(int id) {
		for(int i = 0; i < clientList.size(); ++i) {
			ClientThread ct = clientList.get(i);
			if(ct.id == id) {
				clientList.remove(i); //removes client from list
				return;
			}
		}
	}
	
	public static void main(String[] args) {
		int portNumber = 1500; //sets default portNumber as 1500 , can be changed in serverGUI
		switch(args.length) {
			case 1:
				try {
					portNumber = Integer.parseInt(args[0]);
				}
				catch(Exception e) {
					System.out.println("Invalid port number.");
					System.out.println("Usage is: > java Server "+portNumber);
					return;
				}
			case 0:
				break;
			default:
				System.out.println("Usage is: > java Server "+portNumber);
				return;
				
		}

	}

	//inner class
	class ClientThread extends Thread {
		Socket socket;
		ObjectInputStream ois;
		ObjectOutputStream oos;
		int id;
		String username;
		chatMessage cm;
		String date;

		// Constructor
		ClientThread(Socket socket) {
			id = ++uniqueId; 
			this.socket = socket;
			try
			{
				// create output first
				oos = new ObjectOutputStream(socket.getOutputStream());
				ois  = new ObjectInputStream(socket.getInputStream());
				username = (String) ois.readObject();
				display(username + " just connected.");
			}
			catch (IOException e) {
				display("Exception creating new Input/output Streams: " + e);
				e.printStackTrace();
				return;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
            date = new Date().toString() + "\n";
		}

		public void run() {
			// to loop until LOGOUT
			boolean keepGoing = true;
			while(keepGoing) {
				try {
					cm = (chatMessage) ois.readObject();//cast as a chatMessage
				}
				catch (IOException e) {
					display(username + " Exception reading Streams: " + e);
					e.printStackTrace();
					break;				
				}
				catch(ClassNotFoundException e2) {
					e2.printStackTrace();
					break;
				}
				
			String message = cm.getMessage(); // the message part of the chatMessage

			// for the buttons on bottom of client gui
			//no need to include the colourChange or uploadImg buttons as it does not need to go through the server 
			if(cm.getType() == chatMessage.MESSAGE){
				broadcast(username + ": " + message);
			}
			else if ( cm.getType() == chatMessage.LOGOUT){
				display(username + " disconnected with a LOGOUT message.");
				keepGoing = false;
			}
			else if ( cm.getType() == chatMessage.WHOISIN){
				writeMsg("List of the users connected at " + sdf.format(new Date()) + "\n");
				for(int i = 0; i < clientList.size(); ++i) { //loop to go through list containing users and print them out when requested
					ClientThread ct = clientList.get(i);
					writeMsg((i+1) + ") " + ct.username + " since " + ct.date);
				}}}	
			// remove user from list of the connected users when user logs out
			remove(id);
			close();
		}
		
		// close everything
		private void close() {
			try {
				if(oos != null) oos.close();
			}
			//catches following exceptions
			catch(Exception e) {e.printStackTrace();}
			try {
				if(ois != null) ois.close();
			}
			catch(Exception e) {e.printStackTrace();};
			try {
				if(socket != null) socket.close();
			}
			catch (Exception e) {e.printStackTrace();}
		}

		private boolean writeMsg(String msg) {
			if(!socket.isConnected()) {
				close();
				return false;
			}
			try {
				oos.writeObject(msg);
			}
			catch(IOException e) {
				display(e.toString());
			}
			return true;
		}}}//end of class