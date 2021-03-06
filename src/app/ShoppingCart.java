package app;

import java.util.ArrayList;

/** Class for RustySword */
public class ShoppingCart 
{
	/** Private ArrayList String Variable for items in cart */
	private ArrayList<ItemInterface> inCartArray = new ArrayList<ItemInterface>();
	/** Private integer Variable for bill due */
	private int bill;
	
	/** Constructor to initialize bill */
	public ShoppingCart() 
	{
		this.bill = 0;
	}
	
	/** Getter that returns the inCart Array
	 * @return inCartArray inCartArray*/
	public ArrayList<ItemInterface> getArray() 
	{
		return inCartArray;
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
	public boolean inCart(String item) 
	{
		for (int i = 0; i < inCartArray.size(); i++)
		{
			if (inCartArray.get(i).getName().equals(item)) 
				return true;
		}
		return false;
	}
	
	/** Output stream to display to user their bill by invoking .getBill */
	public void printBill()
	{
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
			System.out.println(i + 1 + ". " + inCartArray.get(i).getName() + " \t\t " +  inCartArray.get(i).getPrice() + " copper");
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
	
	/** Adds item to cart taking in the item object, price and quantity 
	 * @param object Object
	 * @param price integer
	 * @param quantity integer */
	public void addItem(Object object, int price, int quantity) 
	{
		this.bill += price * quantity;
		for (int i = 0; i < quantity; i++) 
		{
			if (object instanceof Weapon) 
				this.inCartArray.add((ItemInterface) object);		
			else if (object instanceof Armor) 
				this.inCartArray.add((ItemInterface) object);	
			else if (object instanceof Health) 
				this.inCartArray.add((ItemInterface) object);
		}
		this.printBill();
	}
	
	/** Removes item from cart taking in price and quantity 
	 * @param itemName String
	 * @param price integer */
	public void removeItem(String itemName, int price) 
	{
		for (int i = 0; i < inCartArray.size(); i++)
		{
			if( inCartArray.get(i).getName().equals(itemName)) {
				inCartArray.remove(inCartArray.get(i));
				this.bill -= price;
				System.out.println("Removed from cart");
				System.out.println("");
				break;
			}	
		}
	}
}
