package app;

/** Class ItemInterface that is the interface for different item types */
public interface ItemInterface 
{
	/** Declare string method getName() in ItemInterface */
	public String getName();
	/**  Declare string method getDescription() in ItemInterface */
	public String getDescription();
	/**  Declare integer method getPrice() in ItemInterface */
	public int getPrice();
	/**  Declare integer method getQuantity() in ItemInterface */
	public int getQuantity();
	/**  Declare integer method getDefense() in ItemInterface */
	public int getDefense();
	/**  Declare integer method getHealingPower() in ItemInterface */
	public int getHealingPower();
	/**  Declare integer method getAttackPower() in ItemInterface */
	public int getAttackPower();
	/**  Declare integer method increaseQuantity() in ItemInterface */
	public void increaseQuantity(int num); 
	/**  Declare integer method reduceQuantity() in ItemInterface */
	public void reduceQuantity(int num);
}
