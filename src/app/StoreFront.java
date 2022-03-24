package app;
import java.util.Scanner;

/**@author Matthew Chimenti chimcode@gmail.com */

/** Class for StoreFront */
public class StoreFront {
	/** This is the main method for a program that is a RPG's item shop
	 * @param args String[]*/
	public static void main(String[] args) {

		// Create object of Inventory stored in inventory 
		Inventory inventory = new Inventory();
		/** Create object of ShoppingCart stored in shoppingCart */
		Object shoppingCart = new ShoppingCart();
		// Variable name for Scanner 
		Scanner scnr = new Scanner(System.in);
		// Variable to control the REPL's 
		int choice;
		// Variable to store item name from user 
		String item;
		// Variable to store quantity of items 
		int quantity;
		Object currentItem;
		// Output streams to green the user 
		System.out.println("\nWelcome to Grumbling Goblins Gladiator\n");

		// Start of the game REPL
		while (true) {
			// Output streams to display REPL choices 
			System.out.println("What would you like to do? ");
			System.out.println("1: View stock ");
			System.out.println("2: Add Item to cart ");
			System.out.println("3: View your cart ");
			System.out.println("4: Remove item from cart ");
			System.out.println("5: Checkout ");
			System.out.println("6: Leave ");
			
			// Assign choice from user input to control REPL 
			choice = scnr.nextInt();
			
			// Check if REPL choice is 1 to show inventory and potentially description of item
			if (choice == 1) 
			{
				// invoke the .getInventory method from Inventory to Output Stream the available inventory
				inventory.getInventory();
				// Output streams to prompt the user to go back or name an item to see the description 
				System.out.print("Enter a items name to see its description or enter 'back': ");
				// Reassign item variable with input from user to use next to get description of item 
				item = scnr.next();
				// Gets the object for the item
				currentItem = inventory.identifyItem(item);
				// invoke the .getItemDescription method from Inventory 
				inventory.getItemDescription(currentItem);
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
				// Gets the object for the item
				currentItem = inventory.identifyItem(item);
				// Output stream to prompt the user for how many of the item they want to buy 
				System.out.print("Enter the amount you want to purchase: ");
				// Reassign quantity variable with integer input to be then passed onto the Inventory method inventoryCheck 
				quantity = scnr.nextInt();
				// Makes sure item is in stock 
				if (inventory.stockCheck(currentItem, quantity)) {
					// Adds item to cart
					inventory.addItemtoCart(currentItem, quantity, shoppingCart);
				}
			}
			// Check if REPL choice is 3 to show what currently is in the cart
			else if (choice == 3) {
				// Output streams cart objects
				inventory.printCart(shoppingCart);
			}
			// Check if REPL choice is 4 to do logic that removes item from the cart 
			else if (choice == 4) 
			{
				// Invoke the .printCart() method from Inventory to Output Stream the items currently in the users cart 
				inventory.printCart(shoppingCart);
				// Output stream to prompt the user to name item with an input 
				System.out.print("Enter the items name you wish to remove: ");
				// Reassign item variable with input from user to then use as a param on the removeItem method from Inventory 
				item = scnr.next();
				// Gets the object for the item
				currentItem = inventory.identifyItem(item);
				// Removes item from cart, right now always 1 at a time
				inventory.removeItemFromCart(currentItem, 1, shoppingCart);
				
			}
			// Check if REPL choice is 5 to do logic that end the transaction or 'checkout.' 
			else if (choice == 5) 
			{
				// Invoke the .printCart() method from Inventory to Output Stream the items currently in the users cart 
				inventory.printCart(shoppingCart);
				// Invoke the .checkout() method from Inventory to handle logics of clearing out shopping cart and purchasing item 
				inventory.checkout(shoppingCart);
			}
			// Check if REPL choice is 6 output stream a goodbye message and break program 
			else if (choice == 6) 
			{
				// Output stream to prompt Goodbye 
				System.out.println("\nGoodbye Gladiator");
				// Use Break keyword to end program as user selected Leave from the REPL
				break;
			}
			// Output stream telling user their REPL selection was not valid */
			else {
				// Output stream to display Invalid selection 
				System.out.println("\nInvalid selection\n");
			}
		
		}
	}
	

}
