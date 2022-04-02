package app;

/** Class ItemInterface that is the interface for different item types */
public interface ItemInterface 
{
	/** Declare string method getName() in ItemInterface 
	 * @return name string*/
	public String getName();
	/**  Declare string method getDescription() in ItemInterface 
	 * @return description string*/
	public String getDescription();
	/**  Declare integer method getPrice() in ItemInterface
	 * @return price integer */
	public int getPrice();
	/**  Declare integer method getQuantity() in ItemInterface 
	 * @return quantity integer*/
	public int getQuantity();
	/**  Declare integer method getDefense() in ItemInterface 
	 * @return defense integer */
	public int getDefense();
	/**  Declare integer method getHealingPower() in ItemInterface 
	 * @return healingPower integer*/
	public int getHealingPower();
	/**  Declare integer method getAttackPower() in ItemInterface 
	 * @return attackPower integer */
	public int getAttackPower();
	/**  Declare integer method increaseQuantity() in ItemInterface 
	 * @param num integer */
	public void increaseQuantity(int num); 
	/**  Declare integer method reduceQuantity() in ItemInterface 
	 * @param num integer */
	public void reduceQuantity(int num);
}
