package app;

/** Class for RustySword */
public class RustySword {
	/** Private String Variable for items name */
	private String name;
	/** Private int Variable for items price */
	private int basePrice;
	/** Private int Variable for items quantity */
	private int quantity;
	/** Private String Variable for items description */
	private String description;
	
	/** Constructor to initialize name, basePrice, quantity, and description */
	RustySword(){
		this.name = "RustySword";
		this.basePrice = 5;
		this.quantity = 99;
		this.description = "A sword for those low on copper";
	}
	
	/** Getter that returns a String of item's name 
	 * @return name String */
	public String getName(){
		return this.name;
	}
	
	/** Getter that returns an int of item's price 
	 * @return basePrice int */
	public int getBasePrice() {
		return this.basePrice;
	}
	
	/** Getter that returns an int of item's quantity 
	 * @return quantity int */
	public int getQuantity() {
		return this.quantity;
	}

	/** Getter that provides an output stream of the item name: description   */
	public void getDescription() {
		System.out.println("");
		System.out.println(this.name + ": " + this.description);
		System.out.println("");
	}
	
	/** Reduces the number of available RustySwords by the parameter.
	 * quantity = quantity - parameter
	 * @param num int */
	public void reduceStock(int num) {
		this.quantity = this.quantity - num;
	}
	
	/** Increases the number of available RustySwords by 1.
	 * quantity = quantity + 1 */
	public void increaseStock() {
		this.quantity = this.quantity + 1;
	}

}
