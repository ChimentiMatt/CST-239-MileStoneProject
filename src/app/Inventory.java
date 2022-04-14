package app;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/** Class for Inventory */
public class Inventory {

	/** Create object for shop item RustySword*/
	private Object rustySword = new RustySword();
	/** Create object for shop item CopperSword*/
	private Object copperSword = new CopperSword();
	/** Create object for shop item DustyCloak*/
	private Object dustyCloak = new DustyCloak();
	/** Create object for shop item ClothPants*/
	private Object clothPants = new ClothPants();
	/** Create object for shop item SmallPotion*/
	private Object smallPotion = new SmallPotion();
	/** Create object for shop item MediumPotion*/
	private Object mediumPotion = new MediumPotion();
	/** Create an ArrayList for ItemInterface to be used with reading and writing the file */
	static ArrayList<ItemInterface> buildingArray = new ArrayList<ItemInterface>();
	
	
	/** Generic method that takes in an inputArray and prints out the data either in ascending/descending with name or price
	 * @param ascending boolean
	 * @param name boolean
	 * @param price boolean
	 * @param updatedArray E[]*/
	public void printArray(ArrayList<ItemInterface> updatedArray, boolean ascending, boolean name, boolean price)
	{
		System.out.println("\nGrumbling Goblins Stock--------------------------------");
		// if name was chosen
		if(name) {

			Comparator<ItemInterface> compareByName = (ItemInterface o1, ItemInterface o2) -> o1.getName().compareTo( o2.getName());
			
			// Sort Algorithm in collections 
			Collections.sort(updatedArray, compareByName);
			
			if (ascending == false) {
				
				Collections.sort(updatedArray, Collections.reverseOrder());
			}
		}
		// if price was chosen in ascending order
		else if(price == true  && ascending == true) {
			updatedArray.sort((a, b) -> {
	                if (a.getPrice() > b.getPrice()) {
	                    return -1;
	                }
	                if (a.getPrice() < b.getPrice()) {
	                    return 1;
	                }
	                return 0;
	            });
		}
		// if price was chosen in descending order
		else 
		{
			updatedArray.sort((a, b) -> {
                if (a.getPrice() > b.getPrice()) {
                    return 1;
                }
                if (a.getPrice() < b.getPrice()) {
                    return -1;
                }
                return 0;
            });
		}
		
		// Output stream using forEach the information using the forEach algorithm in collections 
		updatedArray.forEach(element -> System.out.println(element.getName() + "\t\t" + element.getPrice() + " copper " + "\t stock: " + element.getQuantity()));
	}
	
	/** Method that saves the array to the JSON file
	 * @param updatedArray ArrayList
	 * @throws IOExeception IOEception*/
	public static void saveArray(ArrayList<ItemInterface> updatedArray) throws IOException
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
	
	
	
	/** Method that allows the inventory to be updated. Both increasing and decreasing stock. 
	 * creates a new ArrayList to be and clears the global ArrayList
	 *  the new ArrayList is then loops over with logic that adds to the global ArrayList to match the correct stock amount
	 * @param number integer
	 *  @param itemName string 
	 * @throws IOException  throws for IOException*/
	public void updateInventory(int number, String itemName) throws IOException {
		// Make an array to save the content of the read file in
		ArrayList<ItemInterface> itemArray = new ArrayList<ItemInterface>();
		// Clear array as the whole file will be read again
		buildingArray.clear();
		
		try {
			// Open the file File to read
			File file = new File("inventory.json");
			Scanner s = new Scanner(file);
		
			// Create list of Cars by reading JSON file
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
			if (loopItem.getName().toLowerCase().equals(itemName.toLowerCase()))
				loopItem.reduceQuantity(number);
			buildingArray.add(loopItem);
		}
		// Writes to JSON file
		saveToFile();
	}
	

	/** Output stream displaying the item, price and available quantity.
	 * if the updatedArray does not exist yet as there has not been a moment where the inventory changed, it reads directly from JSON
	 * @param ascending boolean
	 * @param name boolean
	 * @param price boolean
	 * @throws FileNotFoundException throws if file not found
	 * @throws IOException throws for IOException*/
	public void getInventory(boolean ascending, boolean name, boolean price) throws FileNotFoundException, IOException 
	{
		// Make an ArrayList to save the content of the read file in
		ArrayList<ItemInterface> itemArray = readFromFile();

		
		// if the updatedArray does not exist yet as there has not been a moment where the inventory changed, it reads directly from JSON
		if (buildingArray.size() == 0)
			printArray(itemArray, ascending, name, price);
		else 
			printArray(buildingArray, ascending, name, price);

	}
	
	/** Method that is used to write to the JSON file when invoked
	 * @throws IOException throws for IOException */
	public static void saveToFile() throws IOException
	{
		saveArray(buildingArray);
	}
	
	/** Method used to read from the JSON file, making an ArrayList of the items
	 * @throws FileNotFoundException throws if file not found
	 * @throws IOException throws for IOException 
	 * @return ArrayList */
	public static ArrayList<ItemInterface> readFromFile() throws FileNotFoundException, IOException
	{
		ArrayList<ItemInterface> items = new ArrayList<ItemInterface>();
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
				ObjectMapper objectMapper = new ObjectMapper();
				RustySword item = objectMapper.readValue(json, RustySword.class);
				items.add(item);
			}
			
			// Cleanup
			scnr.close();
		}
		catch(IOException e)
		{
			// Print Exception
			e.printStackTrace();
		}
		return items;
		
	}
	
	
	/**  Output stream displaying the item description. If invalid selection, output stream tells user
	 * @param object Object.*/
	public void getItemDescription(Object object) {
		if (object instanceof Weapon)
			System.out.println("\n" + ((ItemInterface)object).getDescription() + "\n");
		else if (object instanceof Armor)
			System.out.println("\n" + ((Armor)object).getDescription() + "\n");
		else if (object instanceof Health)
			System.out.println("\n" + ((Health)object).getDescription() + "\n");
		else {
			System.out.println("Invalid selection\n");
		}
	}
	
	/** Output stream to tell the user their current bill and show the items in the cart
	 * @param cartObject Object */
	public void printCart(Object cartObject) {
		System.out.println("\nYour current total is " + ((ShoppingCart)cartObject).getBill() + " copper");
		((ShoppingCart)cartObject).printCurrentCart();
	}
	
	/** Invokes the checkout method in ShoppingCart 
	 * @param cartObject Object */
	public void checkout(Object cartObject) {
		((ShoppingCart)cartObject).checkout();
	}
	
	/** Checks to see if the stock of the item is available using the requested quantity and the item object
	 * @param object Object
	 * @param quantity integer 
	 * @return true/false boolean */
	public boolean stockCheck(Object object, int quantity) {
		if (quantity == 0) {
			return false;
		}
		else if (object instanceof Weapon) {
			if (((Weapon)object).getQuantity() - quantity >= 0) 
				return true;
		}
		else if (object instanceof Armor) { 
			if (((Armor)object).getQuantity() - quantity >= 0) 
				return true;
		}
		else if (object instanceof Health) { 
			if (((Health)object).getQuantity() - quantity >= 0) 
				return true;
		}
		System.out.println("\nInvalid selection\n");
		return false;
	}
	
	/** Adds the item to cart by passing in the item object and quantity 
	 * @param object Object
	 * @param quantity integer
	 * @param cartObject Object */
	public void addItemtoCart(Object object, int quantity, Object cartObject) {
		if (object instanceof Weapon) {
			((Weapon)object).reduceQuantity(quantity);
			((ShoppingCart)cartObject).addItem(object, ((Weapon)object).getPrice(), quantity);
		}
		else if (object instanceof Armor) {
			((Armor)object).reduceQuantity(quantity);
			((ShoppingCart)cartObject).addItem(object, ((Armor)object).getPrice(), quantity);
		}
		else if (object instanceof Health) {
			((Health)object).reduceQuantity(quantity);
			((ShoppingCart)cartObject).addItem(object, ((Health)object).getPrice(), quantity);
		}
	}
	
	/** Removes the item to cart by passing in the item object and quantity 
	 * if item is not in cart, output stream tells user
	 * @param object object
	 * @param quantity integer 
	 * @param cartObject Object */
	public void removeItemFromCart(Object object, int quantity, Object cartObject) {
		if (object instanceof Weapon) {
			if (((ShoppingCart)cartObject).inCart(((Weapon)object).getName())) {
				((Weapon)object).increaseQuantity(quantity);
				((ShoppingCart)cartObject).removeItem(((Weapon)object).getName(), ((Weapon)object).getPrice());
			}
			else {
				System.out.println("\nYou do not have '" + ((Weapon)object).getName() + " in your current cart\n");
			}
		}
		else if (object instanceof Armor) {
			if (((ShoppingCart)cartObject).inCart(((Armor)object).getName())) {
				((Armor)object).increaseQuantity(quantity);
				((ShoppingCart)cartObject).removeItem(((Armor)object).getName(), ((Armor)object).getPrice());
			}
			else {
				System.out.println("\nYou do not have '" + ((Armor)object).getName() + " in your current cart\n");
			}
		}
		else if (object instanceof Health) {
			if (((ShoppingCart)cartObject).inCart(((Health)object).getName())) {
				((Health)object).increaseQuantity(quantity);
				((ShoppingCart)cartObject).removeItem(((Health)object).getName(), ((Health)object).getPrice());
			}
			else {
				System.out.println("\nYou do not have '" + ((Health)object).getName() + " in your current cart\n");
			}
		}
		else {
			System.out.println("\nThat item is not in your cart\n");
		}
	}
	
	/** Identifies item by using the string passed in and getting the item object
	 * @param itemName String 
	 * @return (itemName) object */
	public Object identifyItem(String itemName) {
		if (itemName.equals("rustysword"))
			return rustySword;
		else if (itemName.equals("coppersword"))
			return copperSword;
		else if (itemName.equals("dustycloak"))
			return dustyCloak;	
		else if (itemName.equals("clothpants"))
			return clothPants;		
		else if (itemName.equals("smallpotion"))
			return smallPotion;		
		else if (itemName.equals("mediumpotion"))
			return mediumPotion;		
		else {			
			return null;
		}
	}

	
}
