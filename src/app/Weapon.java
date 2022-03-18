package app;

/** Class Weapon */
public class Weapon 
{
	protected String name;
	protected String description;
	protected int price;
	protected int quantity;
	protected int attackPower;
	
	/** Constructor to initialize Weapon from subclasses
	 * @param name String
	 * @param description String
	 * @param price integer
	 * @param attackPower integer */
	public Weapon(String name, String description, int price, int quantity, int attackPower)
	{
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.attackPower = attackPower;
	}
	
	/** Getter for Weapon name 
	 * @return name String */
	public String getName()
	{
		return this.name;
	}
	
	/** Getter for Weapon description 
	 * @return description String */
	public String getDescription()
	{
		return this.description;
	}
	
	/** Getter for Weapon price 
	 * @return price integer*/
	public int getPrice()
	{
		return this.price;
	}
	
	/** Getter for Weapon quantity 
	 * @return quantity integer */
	public int getQuantity()
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
