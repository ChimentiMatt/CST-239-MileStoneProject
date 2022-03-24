package app;

import java.util.Arrays;

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
	/** Create an array for all available weapons */

	/**  Output stream displaying the item, price and available quantity.*/
	public void getInventory() {
		System.out.println("\nWe have the following in stock Gladiator:");
		System.out.println("\nWeapons:");
		this.getWeaponList();
		System.out.println("Armors:");
		this.getArmorList();
		System.out.println("Potions:");
		this.getHealthList();
	}
	
	/**  Output stream displaying the item description. If invalid selection, output stream tells user
	 * @param object Object.*/
	public void getItemDescription(Object object) {
		if (object instanceof Weapon)
			System.out.println("\n" + ((ItemInterface)object).getDescription() + "\n");
		else if (object instanceof Armor)
			System.out.println("\n" + ((Armor)object).getDescription() + "\n");
		else if (object instanceof Health)
			System.out.println("\n" + ((Health)object).getDescription() + "\n");
		else {
			System.out.println("Invalid selection\n");
		}
	}
	
	/** Output stream to tell the user their current bill and show the items in the cart
	 * @param cartObject Object */
	public void printCart(Object cartObject) {
		System.out.println("\nYour current total is " + ((ShoppingCart)cartObject).getBill() + " copper");
		((ShoppingCart)cartObject).printCurrentCart();
	}
	
	/** Invokes the checkout method in ShoppingCart 
	 * @param cartObject Object */
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
	 * @param object Object
	 * @param quantity integer
	 * @param cartObject Object */
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
	 * @param quantity integer 
	 * @param cartObject Object */
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
	 * @return (itemName) object */
	public Object identifyItem(String itemName) {
		if (itemName.equals("custysword"))
			return rustySword;
		else if (itemName.equals("coppersword"))
			return copperSword;
		else if (itemName.equals("dustycloak"))
			return dustyCloak;	
		else if (itemName.equals("clothpants"))
			return clothPants;		
		else if (itemName.equals("smallpotion"))
			return smallPotion;		
		else if (itemName.equals("mediumpotion"))
			return mediumPotion;		
		else {			
			return null;
		}
	}
	
	/** Sort the weapons item alphabetically by invoking Arrays.sort which then uses the compareTo method that has been overwritten  
	 * then output streams the result */
	public void getWeaponList() {
		Weapon[] weapon = new Weapon[2];
		weapon[0] = new Weapon("RustySword", "Attack Power: 1. A sword for those low on copper", 3, ((Weapon)rustySword).getQuantity(), 0, 0, 2);
		weapon[1] = new Weapon("CopperSword", "Attack Power: 3. It's a very impractical metal for a weapon", 8, ((Weapon)copperSword).getQuantity(), 0, 0, 5);

		Arrays.sort(weapon);
		for (int i = 0; i < 2; i++)
		{
			System.out.println(weapon[i].getName() + "\t" + weapon[i].getPrice() + " copper" + "\tStock: " + weapon[i].getQuantity());
		}
		System.out.println("");
	}
	
	/** Sort the armors item alphabetically by invoking Arrays.sort which then uses the compareTo method that has been overwritten  
	 * then output streams the result */
	public void getArmorList() {
		Armor[] armor = new Armor[2];
		armor[0] = new Armor("ClothPants", "Defense: 1. Pants not even good enough to stop a cold breeze ", 1, ((Armor)clothPants).getQuantity(), 2, 0, 0);
		armor[1] = new Armor("DustyCloak", "Defense: 3. It's old and it does not smell right", 3, ((Armor)dustyCloak).getQuantity(), 3, 0, 0);

		Arrays.sort(armor);
		for (int i = 0; i < 2; i++)
		{
			System.out.println(armor[i].getName() + "\t" + armor[i].getPrice() + " copper" + "\tStock: " + armor[i].getQuantity());
		}
		System.out.println("");
	}
	
	/** Sort the health items alphabetically by invoking Arrays.sort which then uses the compareTo method that has been overwritten 
	 * then output streams the result  */
	public void getHealthList() {
		Health[] health = new Health[2];
		health[0] = new Health("SmallPotion", "Heals: 15 hp. It has an odd smell and uncanny bubbles but mends minor wounds", 4, ((Health)smallPotion).getQuantity(), 0, 15, 0);
		health[1] = new Health("MediumPotion", "Heals: 40hp. If it didnt save your life, you wouldn't drink something so vile", 10, ((Health)mediumPotion).getQuantity(), 0, 40, 0);

		Arrays.sort(health);
		for (int i = 0; i < 2; i++)
		{
			System.out.println(health[i].getName() + "\t" + health[i].getPrice() + " copper" + "\tStock: " + health[i].getQuantity() );
		}
		System.out.println("");
	}
	
}
