package app;

import java.util.ArrayList;

public class ShoppingCart {
	private ArrayList<String> inCartArray = new ArrayList<String>();
	private int bill;
	
	ShoppingCart() {
		this.bill = 0;
	}

	public int getBill() {
		return this.bill;
	}
	
	public void addSword(RustySword sword, int quantity){
		this.bill += sword.getBasePrice() * quantity;
		sword.reduceStock(quantity);
		for (int i = 0; i < quantity; i++) {
			this.inCartArray.add("RustySword");			
		}
		this.printBill();
	}
	
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
	
	public void removeSword(RustySword sword, String item) {
		for (int i = 0; i < inCartArray.size(); i++)
		{
			if( inCartArray.get(i).equals(item)) {
				inCartArray.remove(item);
				sword.increaseStock();
				this.bill = this.bill - sword.getBasePrice();
				System.out.println("Removed from cart");
				System.out.println("");
				break;
			}	
		}
	}
	
	public void printBill(){
		System.out.println("Your total bill is " + this.getBill() + " copper");
		System.out.println("");
	}
	
	public void printCurrentCart() {
		for (int i = 0; i < inCartArray.size(); i++)
		{
			System.out.println(i + 1 + ". " + inCartArray.get(i));
		}
	}
	
	public void checkout(){
		inCartArray.clear();
		System.out.println("You spent " + this.getBill() + " on the following items");
		this.printCurrentCart();
		this.bill = 0;
		System.out.println("");
	}
	
}
