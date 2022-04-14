package app;

import java.util.Scanner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	private Socket clientSocket;
	private PrintWriter out;
	private BufferedReader in;
	
	public void start(String ip, int port) throws UnknownHostException, IOException
	{
		// Connect to the Remote Server on the specified IP Address and Port
		clientSocket = new Socket(ip, port);
		
		// Create some input and output network buffers to communicate back and forth with the Sever
		out = new PrintWriter(clientSocket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	}
	
	public String sendMessage(String msg) throws IOException
	{
		// sendPrint a message to the server with a termination line feed
		out.println(msg);
		return in.readLine();
	}
	
	public String sendJSONMessage(ObjectNode jSONPackage) throws IOException
	{
		// sendPrint a message to the server with a termination line feed
		out.println(jSONPackage);
		return in.readLine();
	}
	
	
	public void cleanup() throws IOException
	{
		// Close all input and output network buffers and sockets
		in.close();
		out.close();
		clientSocket.close();
	}
	
	public static void main(String[] args) throws IOException
	{
		// Create a Client and connect to the remote Server on the specified IP Address and Port
		Client client = new Client();
		client.start("127.0.0.1", 6666);

		Scanner myScnr = new Scanner(System.in);

		String response;
		
		System.out.println("Client connected. IP: 127.0.0.1, PORT: 6666 ");
		// Send message to the server and on the 9th one send a shut down command 
		String message;
		String itemName;
		String description;
		int price;
		int quantity;
		int defense;
		int healingPower;
		int attackPower;
		
		String jsonString;
		
			System.out.println("Welcome to ADMIN Client: Enter a command: U / R or Q to quit: ");
			message = myScnr.nextLine();
			
			if (message.equals("Q"))
				System.out.println("Goodbye");
			
			else if (message.equals("U")) {
				System.out.println("Enter the item Name:: ");
				itemName = myScnr.nextLine();
				System.out.println("Enter the item Description:  ");
				description = myScnr.nextLine();
				System.out.println("Enter the item Price:  ");
				price = myScnr.nextInt();
				System.out.println("Enter the item Stock Quantity:  ");
				quantity = myScnr.nextInt();
				System.out.println("Enter the item Defense:  ");
				defense = myScnr.nextInt();
				System.out.println("Enter the item Healing Power:  ");
				healingPower = myScnr.nextInt();		
				System.out.println("Enter the item Atttack Power:  ");
				attackPower = myScnr.nextInt();	
				
				ObjectMapper mapper = new ObjectMapper();
				ObjectNode JSONPackage = mapper.createObjectNode();
				JSONPackage.put("name", itemName);
				JSONPackage.put("description", description);
				JSONPackage.put("price", price);
				JSONPackage.put("quantity", quantity);
				JSONPackage.put("defense", defense);
				JSONPackage.put("healingPower", healingPower);
				JSONPackage.put("attackPower", attackPower);
				
				// System.out.println(JSONPackage);
				
				response = client.sendJSONMessage(JSONPackage);

			}
			else if (message.equals("R")) {
				response = client.sendMessage(message);
			}
		
		
		// On exit cleans everything up
		System.out.println("cleaning up");
		client.cleanup();
	}
}
