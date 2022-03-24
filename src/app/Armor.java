package app;

/** Class Armor that implements ItemInterface */
public class Armor implements ItemInterface, Comparable<Armor>
{
	protected String name;
	protected String description;
	protected int price;
	protected int quantity;
	protected int defense;
	protected int healingPower;
	protected int attackPower;
	
	/** Constructor to initialize Armor from subclasses
	 * @param name String
	 * @param description String
	 * @param price integer
	 * @param quantity integer 
	 * @param defense integer
	 * @param healingPower integer
	 * @param attackPower integer */
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
	
	/** Method that gets Armor name
	 * @return name string */
	@Override
	public String getName() {
		return this.name;
	}
	
	/** Method that gets Armor description
	 * @return description string */
	@Override
	public String getDescription() {
		return this.description;
	}

	/** Method that gets Armor price
	 * @return price integer */
	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return this.price;	
	}

	/** Method that gets Armor quantity
	 * @return quantity integer */
	@Override
	public int getQuantity() {
		return this.quantity;
	}

	/** Method that gets Armor defense
	 * @return defense integer */
	@Override
	public int getDefense() {
		return this.defense;
	}

	/** Method that gets healing power
	 * @return healingPower integer */
	@Override
	public int getHealingPower() {
		return this.healingPower;
	}

	/** Method that gets attack power
	 * @return attackPower integer */
	@Override
	public int getAttackPower() {
		return attackPower;
	}
	
	/** Method that adds 1 to Armor quantity or stock
	 * @param num integer */
	@Override
	public void increaseQuantity(int num) {
		this.quantity = this.quantity + num;
	}

	/** Method that removes 1 to Armor quantity or stock
	 * @param num integer */
	@Override
	public void reduceQuantity(int num) {
		this.quantity = this.quantity - num;
		
	}
	
	/** Override method to be used with sort. Sorts by alphabetical order
	* @param armor Armor */
	@Override
	public int compareTo(Armor armor) {
		int value = this.getName().toUpperCase().compareTo(armor.getName().toUpperCase());
		if (value == 0)
		{
			return  this.getName().toUpperCase().compareTo(armor.getName().toUpperCase());
		}
		else 
			return value;
	}

}
