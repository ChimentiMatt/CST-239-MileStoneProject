package app;

/** class ItemInterface that is the interface for different item types */
public interface ItemInterface 
{
	public String getName();
	public String getDescription();
	public int getPrice();
	public int getQuantity();
	public int getDefense();
	public int getHealingPower();
	public int getAttackPower();
	public void increaseQuantity(int num);
	public void reduceQuantity(int num);
}
