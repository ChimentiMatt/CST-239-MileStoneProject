package app;

import java.util.ArrayList;

/** Class for RustySword */
public class ShoppingCart {
	/** Private ArrayList String Variable for items in cart */
	private ArrayList<String> inCartArray = new ArrayList<String>();
	/** Private integer Variable for bill due */
	private int bill;
	
	/** Constructor to initialize bill */
	ShoppingCart() {
		this.bill = 0;
	}
	
	/** Getter that returns an integer of the total bill 
	 * @return bill integer */
	public int getBill() {
		return this.bill;
	}
	
	/** A check to determine if the item passed in as a parameter is in the shopping cart 
	 * loops over cart inCartArray, if element equals item, return true, if no items match, return false
	 * @param item String
	 * @return true if item parameter is in shopping cart or false if item parameter is not in shopping cart. */
	public boolean inCart(String item) {
		for (int i = 0; i < inCartArray.size(); i++)
		{
			if (inCartArray.get(i).equals(item)) 
				return true;
		}
		return false;
	}
	
	/** Output stream to display to user their bill by invoking .getBill */
	public void printBill(){
		System.out.println("Your total bill is " + this.getBill() + " copper");
		System.out.println("");
	}
	
	/** Output stream that displays current items in cart using a for loop */
	public void printCurrentCart() {
		if (inCartArray.size() == 0) {
			System.out.println("You cart is empty");
		}
		for (int i = 0; i < inCartArray.size(); i++)
		{
			System.out.println(i + 1 + ". " + inCartArray.get(i));
		}
		System.out.println("");
	}
	
	/** Ends transaction by clearing out cart, output stream how much the user spent and updating bill to 0.*/
	public void checkout(){
		inCartArray.clear();
		System.out.println("You spent " + this.getBill() + " on your purchase");
		this.printCurrentCart();
		this.bill = 0;
		System.out.println("");
	}
	
	public void addItem(Object object, int price, int quantity) {
		this.bill += price * quantity;
		for (int i = 0; i < quantity; i++) 
		{
			if (object instanceof Weapon) 
				this.inCartArray.add(((Weapon)object).getName());		
			else if (object instanceof Armor) 
				this.inCartArray.add(((Armor)object).getName());		
			else if (object instanceof Health) 
				this.inCartArray.add(((Health)object).getName());		
		}
		this.printBill();
	}
	
	public void removeItem(String itemName, int price) {
		for (int i = 0; i < inCartArray.size(); i++)
		{
			if( inCartArray.get(i).equals(itemName)) {
				inCartArray.remove(itemName);
				this.bill -= price;
				System.out.println("Removed from cart");
				System.out.println("");
				break;
			}	
		}
	}
	
}
