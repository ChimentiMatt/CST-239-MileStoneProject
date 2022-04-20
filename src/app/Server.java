package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

/** Class for Server */
public class Server {
	private ServerSocket serverSocket;
	private Socket ClientSocket;
	private PrintWriter out;
	private BufferedReader in;
	
	/** Starts the  server
	 * @param port integer
	 * @throws IOException*/
	public void start(int port) throws IOException
	{
		// Wait for a Client connection
		System.out.println("Recieved a Client connection .......");
		serverSocket = new ServerSocket(port);
		ClientSocket = serverSocket.accept();
		String sendString;
		
		// If you get here then a Client connected to this Server so create some input and output network buffers
		System.out.println("Recieved a Client connection on port " + ClientSocket.getLocalPort());
		out = new PrintWriter(ClientSocket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(ClientSocket.getInputStream()));
		
		// Wait for Command (string that is terminated by a line feed character)
		String inputLine;
		while ((inputLine = in.readLine()) != null)
		{
			System.out.println("Got a message of " + inputLine);
			// If period command then shut down Server
			if ("Q".equals(inputLine))
			{
				System.out.println("Got a message to shut Down the Server");
				out.println("QUIT");
			}
			else if ("R".equals(inputLine))
			{
				sendString = ServerApp.readFromFileAdmin();

				out.println(sendString);			
			}
			else // for U
			{
				// Echo an acknowledgment back to the Client that Command was processed successfully 
				System.out.println("Added item to shop");
				ServerApp.updateInventoryAdmin(1, inputLine);
				out.println("End");
			}
		}
		// Exit message that Server is shut down
		System.out.println("Server is shut down");
	}
	
	/** Cleans up the server
	 * @throws IOException*/
	public void cleanup() throws IOException
	{
		// Close all input and output network buffers and sockets
		in.close();
		out.close();
		ClientSocket.close();
		serverSocket.close();
	}
	
	/** Main method 
	 * @param args String[]
	 * @throws IOException throws for IOException*/
	public static void main(String[] args) throws IOException
	{
		Server server = new Server();
		server.start(6666);
		server.cleanup();
	}
}
