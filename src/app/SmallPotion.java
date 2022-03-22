package app;

/** Class for SmallPotion that extends Health*/
public class SmallPotion extends Health 
{
	/** Constructor for  SmallPotion to its superclass Health*/
	public SmallPotion()
	{
		super("SmallPotion", "Heals: 15 hp. It has an odd smell and uncanny bubbles but mends minor wounds", 4, 25, 0, 15, 0);
	}
}
