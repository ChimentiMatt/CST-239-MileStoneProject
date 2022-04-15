package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.UnknownHostException;



public class ServerApp {
	static ArrayList<ItemInterface> buildingArrayAdmin = new ArrayList<ItemInterface>();
	static String outString;
	
	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException
	{
		ServerThread serverThread = new ServerThread();
		serverThread.start();
	}
	
//	
//	public static String getStringJSON() {
//		return outString;
//		
//	}
	
	
	
	/** Reads from the JSON file
	 * @throws FileNotFoundException throws if file not found
	 * @throws IOException throws for IOException*/
	public static String readFromFileAdmin() throws FileNotFoundException, IOException
	{
		ArrayList<ItemInterface> items = new ArrayList<ItemInterface>();
		String printString = "";
		String sendString = "";
		try 
		{
			// Open the file File to read
			File file = new File("inventory.json");
			Scanner scnr = new Scanner(file);

			// Create list of Items by reading JSON file
			while(scnr.hasNext())
			{
				// Read a string of JSON and convert to a item
				String json = scnr.nextLine();
				printString += json + "\n";
				sendString += json;
				ObjectMapper objectMapper = new ObjectMapper();
				RustySword item = objectMapper.readValue(json, RustySword.class);
				items.add(item);
			}
			System.out.println(printString);
			outString = printString;
			// Cleanup
			scnr.close();
		}
		catch(IOException e)
		{
			// Print Exception
			e.printStackTrace();
		}
		return sendString;
	}
	

	
	/** Method that allows the inventory to be updated. Both increasing and decreasing stock. 
	 * creates a new ArrayList to be and clears the global ArrayList
	 *  the new ArrayList is then loops over with logic that adds to the global ArrayList to match the correct stock amount
	 * @param number integer
	 * @param itemName string 
	 * @throws IOException  throws for IOException*/
	public static void updateInventoryAdmin(int number, String JSONItem) throws IOException {
		// Make an array to save the content of the read file in
		ArrayList<ItemInterface> itemArray = new ArrayList<ItemInterface>();
		// Clear array as the whole file will be read again
		buildingArrayAdmin.clear();
		
		try {
			// Open the file File to read
			File file = new File("inventory.json");
			Scanner s = new Scanner(file);
		
			// Create list of Cars by readsing JSON file
			while(s.hasNext())
			{
				// Read a string of JSON and convert to a RustySword
				String json = s.nextLine();
				ObjectMapper objectMapper = new ObjectMapper();
				RustySword item = objectMapper.readValue(json,  RustySword.class);
				itemArray.add(item);
			}
			s.close();
		}
		catch(IOException e)
		{
			// Print exception
			e.printStackTrace();
		}
		
		// Loop over read file and reduce quantity if item was removed from cart
		for(ItemInterface loopItem : itemArray)
		{
			buildingArrayAdmin.add(loopItem);
		}
		
		// Writes to JSON file
		saveToFileAdmin(JSONItem);
	}
	
	/** Method that is used to write to the JSON file when invoked
	 * @param JSONItem String
	 * @throws IOException throws for IOException */
	public static void saveToFileAdmin(String JSONItem) throws IOException
	{
		saveArrayAdmin(buildingArrayAdmin, JSONItem);
	}
	
	
	/** Method that saves the array to the JSON file
	 * @param updatedArray ArrayList
	 * @param JSONItem String
	 * @throws IOExeception IOEception*/
	public static void saveArrayAdmin(ArrayList<ItemInterface> updatedArray, String JSONItem) throws IOException
	{
		PrintWriter pw;
		try
		{
			// Create a file File to 
			File file = new File("inventory.json");
			
			FileWriter fw = new FileWriter(file, false);
			pw = new PrintWriter(fw);
			
			// Write items into JSON
			ObjectMapper objectMapper = new ObjectMapper();
			String json = "";
			json += JSONItem + "\n";
			for(ItemInterface loopItem : updatedArray)
			{
				json += objectMapper.writeValueAsString(loopItem) + "\n";
			}
			pw.println(json);
			
			// Cleanup
			pw.close();
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	
}
