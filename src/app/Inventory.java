package app;

public class Inventory {
	private RustySword rustySword = new RustySword();
	private ShoppingCart shoppingCart = new ShoppingCart();
	
	Inventory(RustySword rustySword){
		this.rustySword = rustySword;
		this.shoppingCart = shoppingCart;
	}
	
	public void getInventory() {
		System.out.println("");
		System.out.println("We have the following in stock:");
		System.out.println(" - " + rustySword.getName() + " at " + rustySword.getBasePrice() + " copper each " + "		(stock " + rustySword.getQuantity() + ")" );
		System.out.println("");
	}
	
	public void getItemDescription(String item) {
		if (item.equals("back")) {
			System.out.println("");
		}
		else if (item.equals("RustySword")) 
		{
			rustySword.getDescription();
		}
		else 
		{
			System.out.println("There is no item by that name");
			System.out.println("");
		}
	}
	
	public void inventoryCheck(String itemName, int quantity) {
		if (itemName.equals("RustySword")) 
		{
			if (rustySword.getQuantity() - quantity > 0) {
				shoppingCart.addSword(rustySword, quantity);
			}
			else {
				System.out.println("");
				System.out.println("Sorry, but there are only " + rustySword.getQuantity() + " RustySwords left in stock");
				System.out.println("");
			}
		}
		else {
			System.out.println("Sorry, but we do not sell '" + itemName + "'");
			System.out.println("");
		}
	}
	
	public void removeItem(String itemName){
		if (itemName.equals("RustySword"))
		{
			if (shoppingCart.inCart(itemName)) {
				shoppingCart.removeSword(rustySword, itemName);
			}
			else {
				System.out.println("");
				System.out.println("You do not have '" + itemName + " in your current cart" );
				System.out.println("");
			}
		}
		else {
			System.out.println("");
			System.out.println("We do not sell '" + itemName + "'" );
			System.out.println("");
		}
	}
	
	public void printCart() {
		System.out.println("");
		System.out.println("Your current total is " + shoppingCart.getBill() + " copper");
		shoppingCart.printCurrentCart();
		System.out.println("");
	}
	
	public void checkout() {
		shoppingCart.checkout();
	}
}
