package app;
import java.util.Scanner;

public class StoreFront {
	public static void main(String[] args) {
		RustySword rustySword = new RustySword();
		Inventory inventory = new Inventory(rustySword);
		Scanner scnr = new Scanner(System.in);
		int choice;
		String item;
		int quantity;
		System.out.println("Welcome to Our Shop");
		System.out.println("");
		
		while (true) {
			System.out.println("What would you like to do? ");
			System.out.println("1: View stock ");
			System.out.println("2: Add Item to cart ");
			System.out.println("3: Remove item from cart ");
			System.out.println("4: Checkout ");
			System.out.println("5: Leave ");
			
			choice = scnr.nextInt();
			
			if (choice == 1) 
			{
				inventory.getInventory();
				System.out.print("Enter a items name to see its description or enter 'back': ");
				item = scnr.next();
				inventory.getItemDescription(item);
			}
			else if (choice == 2)
			{
				inventory.getInventory();
				System.out.print("Enter the items name you wish to add: ");
				item = scnr.next();
				System.out.print("Enter the amount you want to purchase: ");
				quantity = scnr.nextInt();
				inventory.inventoryCheck(item, quantity);
			}
			else if (choice == 3) 
			{
				inventory.printCart();
				System.out.print("Enter the items name you wish to remove: ");
				item = scnr.next();
				inventory.removeItem(item);
				
			}
			else if (choice == 4) 
			{
				inventory.printCart();
			}
			
			
		}
	}
	

}
