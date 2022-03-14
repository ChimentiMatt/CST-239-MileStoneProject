package app;
import java.util.Scanner;

/**@author      Matthew Chimenti chimcode@gmail.com */

/** Class for StoreFront */
public class StoreFront {
	/** This is the main method for a program that is a RPG's item shop
	 * @param args*/
	public static void main(String[] args) {
		// Create object of RustySword stored in rustySword 
		RustySword rustySword = new RustySword();
		// Create object of Inventory stored in inventory 
		Inventory inventory = new Inventory(rustySword);
		// Variable name for Scanner 
		Scanner scnr = new Scanner(System.in);
		// Variable to control the REPL's 
		int choice;
		// Variable to store item name from user 
		String item;
		// Variable to store quantity of items 
		int quantity;
		// Output streams to green the user 
		System.out.println("Welcome Gladiator to our shop");
		System.out.println("");
		
		while (true) {
			// Output streams to display REPL choices 
			System.out.println("What would you like to do? ");
			System.out.println("1: View stock ");
			System.out.println("2: Add Item to cart ");
			System.out.println("3: Remove item from cart ");
			System.out.println("4: Checkout ");
			System.out.println("5: Leave ");
			
			// Assign choice from user input to control REPL 
			choice = scnr.nextInt();
			
			// Check if REPL choice is 1 to do inventory logics 
			if (choice == 1) 
			{
				// invoke the .getInventory method from Inventory to Output Stream the available inventory
				inventory.getInventory();
				// Output streams to prompt the user to go back or name an item to see the description 
				System.out.print("Enter a items name to see its description or enter 'back': ");
				// Reassign item variable with input from user to use next to get description of item 
				item = scnr.next();
				// invoke the .getItemDescription method from Inventory 
				inventory.getItemDescription(item);
			}
			// Check if REPL choice is 2 to do logic that places item in cart 
			else if (choice == 2)
			{
				// Invoke the .getInventory method from Inventory to Output Stream the available inventory 
				inventory.getInventory();
				// Output stream to prompt the user to name item with an input 
				System.out.print("Enter the items name you wish to add: ");
				// Reassign item variable with input from user to then do inventory and cart logics 
				item = scnr.next();
				// Output stream to prompt the user for how many of the item they want to buy 
				System.out.print("Enter the amount you want to purchase: ");
				// Reassign quantity variable with int input to be then passed onto the Inventory method inventoryCheck 
				quantity = scnr.nextInt();
				// Invoke the .inventoryCheck method from Inventory to check if the item is in stock, is a valid item and then add it to the 
				// shopping cart if it passes the test 
				inventory.inventoryCheck(item, quantity);
			}
			// Check if REPL choice is 3 to do logic that removes item from the cart 
			else if (choice == 3) 
			{
				// Invoke the .printCart() method from Inventory to Output Stream the items currently in the users cart 
				inventory.printCart();
				// Output stream to prompt the user to name item with an input 
				System.out.print("Enter the items name you wish to remove: ");
				// Reassign item variable with input from user to then use as a param on the removeItem method from Inventory 
				item = scnr.next();
				// Invoke the .removeItem method from Inventory to remove an item from the shopping cart
				inventory.removeItem(item);
				
			}
			// Check if REPL choice is 4 to do logic that end the transaction or 'checkout.' 
			else if (choice == 4) 
			{
				// Invoke the .printCart() method from Inventory to Output Stream the items currently in the users cart 
				inventory.printCart();
				// Invoke the .checkout() method from Inventory to handle logics of clearing out shopping cart and purchasing item 
				inventory.checkout();
			}
			// Check if REPL choice is 5 output stream a goodbye message and break program 
			else if (choice == 5) 
			{
				// Output stream to prompt Goodbye 
				System.out.println("");
				System.out.println("Goodbye Gladiator");
				// Use Break keyword to end program as user selected Leave from the REPL
				break;
			}
			// Output stream telling user their REPL selection was not valid */
			else {
				// Output stream to display Invalid selection 
				System.out.println("");
				System.out.println("Invalid selection");
			}
		
		}
	}
	

}
