package app;

import java.util.ArrayList;

/** Class for RustySword */
public class ShoppingCart {
	/** Private ArrayList String Variable for items in cart */
	private ArrayList<String> inCartArray = new ArrayList<String>();
	/** Private int Variable for bill due */
	private int bill;
	
	/** Constructor to initialize bill */
	ShoppingCart() {
		this.bill = 0;
	}
	
	/** Getter that returns an int of the total bill 
	 * @return bill int */
	public int getBill() {
		return this.bill;
	}
	
	/** Adds a sword or swords to the shopping cart
	 * Invokes RustySword reduceStock by the quantity parameter
	 * Uses the quantity parameter to add specific number of RustySword 
	 * Invokes ShoppingCart printBill to output stream new bill
	 * @param rustySword RustySword 
	 * @param quantity int*/
	public void addSword(RustySword rustySword, int quantity){
		this.bill += rustySword.getBasePrice() * quantity;
		rustySword.reduceStock(quantity);
		for (int i = 0; i < quantity; i++) {
			this.inCartArray.add("RustySword");			
		}
		this.printBill();
	}
	
	/** A check to determine if the item passed in as a parameter is in the shopping cart 
	 * loops over cart inCartArray, if element equals item, return true, if no items match, return false
	 * @param item String
	 * @return true if item parameter is in shopping cart or false if item parameter is not in shopping cart. */
	public boolean inCart(String item) {
		for (int i = 0; i < inCartArray.size(); i++)
		{
			if (inCartArray.get(i).equals(item)) 
			{
				return true;
			}
		}
		return false;
	}
	
	/** Removes one RustySword from shopping cart's array inCartArray by looping over cart 
	 * If item parameter matches element, invokes ShoppingCart's .remove(item)
	 * Updates bill bill = bill - sword.getBasePrice() 
	 * Output stream to tell user item was removed from cart
	 * beaks if one item is found in cart, therefore stopping for loop from removing multiple
	 * @param rustySword RustySword 
	 * @param item String*/
	public void removeSword(RustySword rustySword, String item) {
		for (int i = 0; i < inCartArray.size(); i++)
		{
			if( inCartArray.get(i).equals(item)) {
				inCartArray.remove(item);
				rustySword.increaseStock();
				this.bill = this.bill - rustySword.getBasePrice();
				System.out.println("Removed from cart");
				System.out.println("");
				break;
			}	
		}
	}
	
	/** Output stream to display to user their bill by invoking .getBill */
	public void printBill(){
		System.out.println("Your total bill is " + this.getBill() + " copper");
		System.out.println("");
	}
	
	/** Output stream that displays current items in cart using a for loop */
	public void printCurrentCart() {
		for (int i = 0; i < inCartArray.size(); i++)
		{
			System.out.println(i + 1 + ". " + inCartArray.get(i));
		}
	}
	
	/** Ends transaction by clearing out cart, output stream how much the user spent and updating bill to 0.*/
	public void checkout(){
		inCartArray.clear();
		System.out.println("You spent " + this.getBill() + " on your purchase");
		this.printCurrentCart();
		this.bill = 0;
		System.out.println("");
	}
	
}
