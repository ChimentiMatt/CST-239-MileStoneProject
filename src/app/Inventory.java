package app;

/** Class for Inventory */
public class Inventory {
	/** Create object of RustySword stored in rustySword */
	private RustySword rustySword = new RustySword();
	/** Create object of ShoppingCart stored in shoppingCart */
	private ShoppingCart shoppingCart = new ShoppingCart();
	
	/** Constructor to initialize rustySword and shoppingCart variables 
	 * @param Rustysword object */
	Inventory(RustySword rustySword){
		this.rustySword = rustySword;
		this.shoppingCart = shoppingCart;
	}
	
	/**  Output stream displaying the item, price and available quantity */
	public void getInventory() {
		System.out.println("");
		System.out.println("We have the following in stock:");
		System.out.println(" - " + rustySword.getName() + " at " + rustySword.getBasePrice() + " copper each " + "		(stock " + rustySword.getQuantity() + ")" );
		System.out.println("");
	}
	
	/**  Output stream displaying the item description. If parameter is "back" no output stream. if item does not exist, output stream to tell user
	 * @param item String.*/
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
	
	/**  Adds item to shopping cart if first passing an inventory check. If check if failed, output stream either tells user the quantity left over, or that the item doesnt exist
	 * @param item String. 
	 * @param quantity int */
	public void inventoryCheck(String item, int quantity) {
		if (item.equals("RustySword")) 
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
			System.out.println("Sorry, but we do not sell '" + item + "'");
			System.out.println("");
		}
	}
	
	/** Removes Item from shopping cart. Uses parameter to identify specific item, then use methods that remove item specifically. 
	 * If that item is not in the users cart, output stream tells user
	 * If that item is not a vaild item, not one that can be sold, output stream tells user
	 * @param item String*/
	public void removeItem(String item){
		if (item.equals("RustySword"))
		{
			if (shoppingCart.inCart(item)) {
				shoppingCart.removeSword(rustySword, item);
			}
			else {
				System.out.println("");
				System.out.println("You do not have '" + item + " in your current cart" );
				System.out.println("");
			}
		}
		else {
			System.out.println("");
			System.out.println("We do not sell '" + item + "'" );
			System.out.println("");
		}
	}
	
	/** Output stream to tell the user their current bill and show the items in the cart */
	public void printCart() {
		System.out.println("");
		System.out.println("Your current total is " + shoppingCart.getBill() + " copper");
		shoppingCart.printCurrentCart();
		System.out.println("");
	}
	
	/** Invokes the checkout method in ShoppingCart */
	public void checkout() {
		shoppingCart.checkout();
	}
}
