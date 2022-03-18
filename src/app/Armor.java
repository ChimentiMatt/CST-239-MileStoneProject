package app;

/** Class Weapon */
public class Armor 
{
	protected String name;
	protected String description;
	protected int price;
	protected int quantity;
	protected int defense;
	
	/** Constructor for Armor 
	 * @param name String
	 * @param description String
	 * @param price Integer
	 * @param quantity Integer
	 * @param defense Integer */
	public Armor(String name, String description, int price, int quantity, int defense)
	{
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.defense = defense;
	}
	
	/** Getter for Armor name 
	 * @return name String*/
	public String getName()
	{
		return this.name;
	}
	
	/** Getter for Armor Description 
	 * @return description String */
	public String getDescription()
	{
		return this.description;
	}

	/** Getter for Armor price 
	 * @return armor String */
	public int getPrice()
	{
		return this.price;
	}
	
	/** Getter for Armor quantity
	 * @return quantity integer */
	public int getQuantity()
	{
		return this.quantity;
	}
	
	/** Getter for Armor defense
	 * @return defense integer */
	public int getDefense()
	{
		return this.defense;
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
