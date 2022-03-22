package app;

/** Class for MediumPotion that extends Health*/
public class MediumPotion extends Health
{
	/** Constructor for  MediumPotion to its superclass Health*/
	public MediumPotion()
	{
		super("MediumPotion", "Heals: 40hp. If it didnt save your life, you wouldn't drink something so vile", 10, 20, 0, 40, 0);
	}
}
