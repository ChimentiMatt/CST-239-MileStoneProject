package app;

/** Class Weapon */
public class Armor implements ItemInterface
{
	protected String name;
	protected String description;
	protected int price;
	protected int quantity;
	protected int defense;
	protected int healingPower;
	protected int attackPower;
	
	/** Constructor for Armor 
	 * @param name String
	 * @param description String
	 * @param price Integer
	 * @param quantity Integer
	 * @param defense Integer */
	public Armor(String name, String description, int price, int quantity, int defense, int healingPower, int attackPower)
	{
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.defense = defense;
		this.healingPower = healingPower;
		this.attackPower = attackPower;
	}
	
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getDescription() {
		return this.description;
		
	}

	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return this.price;
		
	}

	@Override
	public int getQuantity() {
		return this.quantity;
	}

	@Override
	public int getDefense() {
		return this.defense;
	}

	@Override
	public int getHealingPower() {
		return this.healingPower;
	}

	@Override
	public void increaseQuantity(int num) {
		this.quantity = this.quantity + num;
		
	}

	@Override
	public void reduceQuantity(int num) {
		this.quantity = this.quantity - num;
		
	}

	@Override
	public int getAttackPower() {
		return attackPower;
	}
	
}
