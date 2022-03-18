package app;

public class Health {
	
	protected String name;
	protected String description;
	protected int price;
	protected int quantity;
	protected int healingPower;
	
	public Health(String name, String description, int price, int quantity, int healingPower)
	{
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.healingPower = healingPower;
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
	
	public int getHealingPower()
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
