package app;

/** Class Weapon */
public class Weapon 
{
	protected String name;
	protected String description;
	protected int price;
	protected int quantity;
	
	/** Constructor to initialize Weapon from subclasses
	 * @param name String
	 * @param description String
	 * @param price integer
	 * @param quantity integer */
	public Weapon(String name, String description, int price, int quantity)
	{
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getDescription()
	{
		return this.description;
	}

	public int getPrice()
	{
		return this.price;
	}
	
	public int getQuantity()
	{
		return this.quantity;
	}
	
	public void increaseQuantity(int num)
	{
		this.quantity = this.quantity + num;
	}
	
	public void reduceQuantity(int num)
	{
		this.quantity = this.quantity - num;
	}

}
