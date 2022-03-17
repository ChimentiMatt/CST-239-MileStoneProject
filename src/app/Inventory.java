package app;

/** Class for Inventory */
public class Inventory {

	/** Create object of CopperSword stored in copperSword */
	public Object copperSword = new CopperSword();
	/** Create object of ShoppingCart stored in shoppingCart */
	private ShoppingCart shoppingCart = new ShoppingCart();
	
	/**  Output stream displaying the item, price and available quantity */
	public void getInventory() {
		System.out.println("\nWe have the following in stock:");
		System.out.println(" - " + ((CopperSword)copperSword).getName() + " at " + ((CopperSword)copperSword).getPrice() + " copper each " + "		(stock " +((CopperSword)copperSword).getQuantity() + ")\n" );
	}
	
	/**  Output stream displaying the item description. If parameter is "back" no output stream. if item does not exist, output stream to tell user
	 * @param item String.*/
	public void getItemDescription(Object object) {
		System.out.println("\nIt's a very impractical metal for a weapon " + ((Weapon)object).getDescription() + "\n");
	}
	
	/** Output stream to tell the user their current bill and show the items in the cart */
	public void printCart() {
		System.out.println("\nYour current total is " + shoppingCart.getBill() + " copper");
		shoppingCart.printCurrentCart();
	}
	
	/** Invokes the checkout method in ShoppingCart */
	public void checkout() {
		shoppingCart.checkout();
	}
	
	
	public boolean stockCheck(Object object, int quantity) {
		if (((Weapon)object).getQuantity() - quantity > 0) {
			return true;
		}
		else 
			return false;
	}
	
	public void addItemtoCart(Object object, int quantity) {
		((Weapon)object).reduceQuantity(quantity);
		shoppingCart.addItem(object, ((Weapon)object).getPrice(), quantity);
	}
	
	public void removeItemFromCart(Object object, int quantity) {
			if (shoppingCart.inCart(((Weapon)object).getName())) {
				((CopperSword)copperSword).increaseQuantity(quantity);
				shoppingCart.removeItem(((Weapon)object).getName(), ((Weapon)object).getPrice());
			}
			else {
				System.out.println("\nYou do not have '" + ((Weapon)object).getName() + " in your current cart\n");
			}
	}
	
	
	public Object identifyItem(String itemName) {
		if (itemName.equals("CopperSword"))
			return copperSword;
		else {			
			return copperSword;
		}
	}
	
}
