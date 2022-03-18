package app;

public class Armor 
{
	protected String name;
	protected String description;
	protected int price;
	protected int quantity;
	protected int defense;
	
	public Armor(String name, String description, int price, int quantity, int defense)
	{
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.defense = defense;
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
	
	public int getDefense()
	{
		return this.defense;
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
