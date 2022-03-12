package app;

import java.util.ArrayList;

public class ShoppingCart {
	private int bill;
	ArrayList<String> inCartArray = new ArrayList<String>();
	private RustySword rustySword = new RustySword();
	
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
	
	
	public void removeSword(RustySword sword, String item) {
		for (int i = 0; i < inCartArray.size(); i++)
		{
			if( inCartArray.get(i).equals(item)) {
				inCartArray.remove(item);
				sword.increaseStock();
				this.bill = this.bill - sword.getBasePrice();
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
		
	}
	
}
