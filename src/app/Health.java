package app;

/** Class Health */
public class Health {
	
	protected String name;
	protected String description;
	protected int price;
	protected int quantity;
	protected int healingPower;
	
	/** Constructor to initialize Weapon from subclasses
	 * @param name String
	 * @param description String
	 * @param price integer
	 * @param quantity integer 
	 * @param healingPower integer*/
	public Health(String name, String description, int price, int quantity, int healingPower)
	{
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.healingPower = healingPower;
	}
	
	/** Getter for Health name 
	 * @return name String */
	public String getName()
	{
		return this.name;
	}
	/** Getter for Health description 
	 * @return description String */
	public String getDescription()
	{
		return this.description;
	}
	
	/** Getter for Health price 
	 * @return price Integer*/
	public int getPrice()
	{
		return this.price;
	}
	
	/** Getter for Health quantity 
	 * @return quantity integer */
	public int getQuantity()
	{
		return this.quantity;
	}
	
	/** Getter for Health healingPower 
	 * @return quantity integer*/
	public int getHealingPower()
	{
		return this.quantity;
	}
	
	/** Increases the quantity by the parameters amount
	 * @param num Integer */
	public void increaseQuantity(int num)
	{
		this.quantity = this.quantity + num;
	}
	
	/** Decreases the quantity by the parameters amount
	 * @param num Integer */
	public void reduceQuantity(int num)
	{
		this.quantity = this.quantity - num;
	}
}
