import java.net.*;
import java.io.*;
import java.util.*;

public class client  {
	
	private clientGUI clientGUI;
	private String server, username;
	private int port;
	private ObjectInputStream ois;		
	private ObjectOutputStream oos;		
	private Socket socket;
	
	 // Constructor ,called  by GUI
	client(String server, int port, String username, clientGUI clientgui) {
		this.server = server;
		this.port = port;
		this.username = username;
		this.clientGUI = clientgui;  
	}
	
	public boolean start() {
		try {
			socket = new Socket(server, port);
		} 
		catch(Exception ec) {
			display("Error connectiong to server:" + ec);
			ec.printStackTrace();
			return false;
		}
		String msg = "Connection accepted " + socket.getInetAddress() + ":" + socket.getPort();
		display(msg);
	
		try
		{
			ois  = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
		}
		catch (IOException eIO) {
			display("Exception creating new Input/output Streams: " + eIO);
			eIO.printStackTrace();
			return false;
		}

		// creates the Thread to listen from the server 
		new ListenFromServer().start();
		try{
			oos.writeObject(username);//send username to server
		}
		catch (IOException eIO) {
			display("Exception doing login : " + eIO);
			disconnect();
			return false;
		}
		return true; //no exception, write to server was fine
	}
	void sendMessage(chatMessage msg) {
		try {
			oos.writeObject(msg);
		}
		catch(IOException e) {
			display("Exception writing to server: " + e);
		}
	}
	
	private void disconnect() {
		try { 
			if(ois != null) ois.close();
		}
		//catches following exceptions
		catch(Exception e) {e.printStackTrace();} 
		try {
			if(oos != null) oos.close();
		}
		catch(Exception e) {e.printStackTrace();} 
        try{
			if(socket != null) socket.close();
		}
		catch(Exception e) {e.printStackTrace();} 
		
		if(clientGUI != null)
			clientGUI.connectionFailed();
	}
	
	private void display(String msg) {
		clientGUI.append(msg + "\n");		// prints out in the GUI
}

	
	public static void main(String[] args) {
		int portNumber = 1500;
		String serverAddress = "localhost";
		String userName = "Anon";
		
		if(args.length ==3){
			serverAddress = args[2];
		}
		else if(args.length ==2){
			try {
				portNumber = Integer.parseInt(args[1]);
			}
			catch(Exception e) {
				System.out.println("Invalid port number.");
				System.out.println("Usage is: > java Client [username] "+ portNumber+" "+ serverAddress);
				return;
			}
		}
		else if(args.length ==1){
			userName = args[0];
		}
	}

	
	class ListenFromServer extends Thread {
		public void run() {
			while(true) {
				try {
					String msg = (String) ois.readObject();
						clientGUI.append(msg);
				}
				catch(IOException e) {
					display("Server has close the connection: " + e);
					if(clientGUI != null) 
						clientGUI.connectionFailed();
					break;
				}
				catch(ClassNotFoundException e2) {
					e2.printStackTrace();
				}}}}}//end of class
		
