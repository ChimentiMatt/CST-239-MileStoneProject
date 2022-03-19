package app;

/** Class for Inventory */
public class Inventory {

	/** Create object for shop item RustySword*/
	private Object rustySword = new RustySword();
	/** Create object for shop item CopperSword*/
	private Object copperSword = new CopperSword();
	/** Create object for shop item DustyCloak*/
	private Object dustyCloak = new DustyCloak();
	/** Create object for shop item ClothPants*/
	private Object clothPants = new ClothPants();
	/** Create object for shop item SmallPotion*/
	private Object smallPotion = new SmallPotion();
	/** Create object for shop item MediumPotion*/
	private Object mediumPotion = new MediumPotion();
	
	/**  Output stream displaying the item, price and available quantity */
	public void getInventory() {
		System.out.println("\nWe have the following in stock:");
		System.out.println("\nWeapons:");
		System.out.println("  - " + ((RustySword)rustySword).getName() + " at " + ((RustySword)rustySword).getPrice() + " copper each " + "		(stock " +((RustySword)rustySword).getQuantity() + ")" );
		System.out.println("  - " + ((CopperSword)copperSword).getName() + " at " + ((CopperSword)copperSword).getPrice() + " copper each " + "		(stock " +((CopperSword)copperSword).getQuantity() + ")" );
		System.out.println("Armors:");
		System.out.println("  - " + ((DustyCloak)dustyCloak).getName() + " at " + ((DustyCloak)dustyCloak).getPrice() + " copper each " + "		(stock " +((DustyCloak)dustyCloak).getQuantity() + ")" );
		System.out.println("  - " + ((ClothPants)clothPants).getName() + " at " + ((ClothPants)clothPants).getPrice() + " copper each " + "		(stock " +((ClothPants)clothPants).getQuantity() + ")" );
		System.out.println("Potions:");
		System.out.println("  - " + ((SmallPotion)smallPotion).getName() + " at " + ((SmallPotion)smallPotion).getPrice() + " copper each " + "		(stock " +((SmallPotion)smallPotion).getQuantity() + ")" );
		System.out.println("  - " + ((MediumPotion)mediumPotion).getName() + " at " + ((MediumPotion)mediumPotion).getPrice() + " copper each " + "		(stock " +((MediumPotion)mediumPotion).getQuantity() + ")\n" );
	}
	
	/**  Output stream displaying the item description. If parameter is "back" no output stream. if item does not exist, output stream to tell user
	 * @param object Object.*/
	public void getItemDescription(Object object) {
		if (object instanceof Weapon)
			System.out.println("\n" + ((Weapon)object).getDescription() + "\n");
		else if (object instanceof Armor)
			System.out.println("\n" + ((Armor)object).getDescription() + "\n");
		else if (object instanceof Health)
			System.out.println("\n" + ((Health)object).getDescription() + "\n");
		else {
			System.out.println("Invalid selection\n");
		}
	}
	
	/** Output stream to tell the user their current bill and show the items in the cart */
	public void printCart(Object cartObject) {
		System.out.println("\nYour current total is " + ((ShoppingCart)cartObject).getBill() + " copper");
		((ShoppingCart)cartObject).printCurrentCart();
	}
	
	/** Invokes the checkout method in ShoppingCart */
	public void checkout(Object cartObject) {
		((ShoppingCart)cartObject).checkout();
	}
	
	/** Checks to see if the stock of the item is available using the requested quantity and the item object
	 * @param object Object
	 * @param quantity integer 
	 * @return true/false boolean */
	public boolean stockCheck(Object object, int quantity) {
		if (quantity == 0) {
			return false;
		}
		else if (object instanceof Weapon) {
			if (((Weapon)object).getQuantity() - quantity >= 0) 
				return true;
		}
		else if (object instanceof Armor) { 
			if (((Armor)object).getQuantity() - quantity >= 0) 
				return true;
		}
		else if (object instanceof Health) { 
			if (((Health)object).getQuantity() - quantity >= 0) 
				return true;
		}
		System.out.println("\nInvalid selection\n");
		return false;
	}
	
	/** Adds the item to cart by passing in the item object and quantity 
	 * @param object object
	 * @param quantity integer */
	public void addItemtoCart(Object object, int quantity, Object cartObject) {
		if (object instanceof Weapon) {
			((Weapon)object).reduceQuantity(quantity);
			((ShoppingCart)cartObject).addItem(object, ((Weapon)object).getPrice(), quantity);
		}
		else if (object instanceof Armor) {
			((Armor)object).reduceQuantity(quantity);
			((ShoppingCart)cartObject).addItem(object, ((Armor)object).getPrice(), quantity);
		}
		else if (object instanceof Health) {
			((Health)object).reduceQuantity(quantity);
			((ShoppingCart)cartObject).addItem(object, ((Health)object).getPrice(), quantity);
		}
	}
	
	/** Removes the item to cart by passing in the item object and quantity 
	 * if item is not in cart, output stream tells user
	 * @param object object
	 * @param quantity integer */
	public void removeItemFromCart(Object object, int quantity, Object cartObject) {
		if (object instanceof Weapon) {
			if (((ShoppingCart)cartObject).inCart(((Weapon)object).getName())) {
				((Weapon)object).increaseQuantity(quantity);
				((ShoppingCart)cartObject).removeItem(((Weapon)object).getName(), ((Weapon)object).getPrice());
			}
			else {
				System.out.println("\nYou do not have '" + ((Weapon)object).getName() + " in your current cart\n");
			}
		}
		else if (object instanceof Armor) {
			if (((ShoppingCart)cartObject).inCart(((Armor)object).getName())) {
				((Armor)object).increaseQuantity(quantity);
				((ShoppingCart)cartObject).removeItem(((Armor)object).getName(), ((Armor)object).getPrice());
			}
			else {
				System.out.println("\nYou do not have '" + ((Armor)object).getName() + " in your current cart\n");
			}
		}
		else if (object instanceof Health) {
			if (((ShoppingCart)cartObject).inCart(((Health)object).getName())) {
				((Health)object).increaseQuantity(quantity);
				((ShoppingCart)cartObject).removeItem(((Health)object).getName(), ((Health)object).getPrice());
			}
			else {
				System.out.println("\nYou do not have '" + ((Health)object).getName() + " in your current cart\n");
			}
		}
		else {
			System.out.println("\nThat item is not in your cart\n");
		}
	}
	
	/** Identifies item by using the string passed in and getting the item object
	 * @param itemName String 
	 * @return (itemName) object*/
	public Object identifyItem(String itemName) {
		if (itemName.equals("CopperSword"))
			return copperSword;
		else if (itemName.equals("RustySword"))
			return rustySword;
		else if (itemName.equals("DustyCloak"))
			return dustyCloak;	
		else if (itemName.equals("ClothPants"))
			return clothPants;		
		else if (itemName.equals("SmallPotion"))
			return smallPotion;		
		else if (itemName.equals("MediumPotion"))
			return mediumPotion;		
		else {			
			return null;
		}
	}
	
}
