package app;

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
