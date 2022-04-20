package testing;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import app.Weapon;
import app.CopperSword;
import app.RustySword;
import app.ShoppingCart;
import app.Inventory;
import app.ShoppingCart;

/** Test Assertion class*/
public class TestAssertions {

	/** class testAssertions
	 * @throws IOException 
	 * @throws FileNotFoundException */
	@Test
	public void testAssertions() throws FileNotFoundException, IOException 
	{
		// test data
		Object rustySword = new RustySword();
		Object rustySword2 = new RustySword();
		Object copperSword = new CopperSword();
		Object shoppingCartTest = new ShoppingCart();
		
		// Check if the Weapon is itself
		Assert.assertSame(rustySword, rustySword);

		// Check if two Weapon objects are not the same
		Assert.assertNotSame(rustySword, rustySword2);
		
		// Check if two different items are not the same
		Assert.assertNotSame(copperSword, rustySword);
		
		// Check to see items quantity increases
		Assert.assertTrue(checkIncreaseItemQuantity());
		
		// Check to see items quantity reduces 
		Assert.assertTrue(checkReduceItemQuantity());
		
		// Check to see if item setDescription changes the value
		((Weapon) rustySword).setDescription("Test");
		Assert.assertFalse(((Weapon) rustySword).getDescription().equals(checkNewDescription()));
		
		// Check to see if inCart returns False when it is empty and given an item name
		Assert.assertFalse(((ShoppingCart) shoppingCartTest).inCart("Dummy Data"));
		
		// Check to see if inCart is empty with no items in it
		Assert.assertTrue(((ShoppingCart) shoppingCartTest).getArray().size() == 0);
		
		// Check to see if inCart returns True when an item is added to it
		((ShoppingCart) shoppingCartTest).addItem(rustySword, 1, 1);
		Assert.assertTrue(((ShoppingCart) shoppingCartTest).inCart("RustySword"));
		
		// Check to see if inCart returns False when the array is not empty, but it is the wrong item name
		Assert.assertFalse(((ShoppingCart) shoppingCartTest).inCart("FakeWeapon"));
		
		// Check to see if removeItem does not work if given an item that is not in the array
		((ShoppingCart) shoppingCartTest).removeItem("FakeWeapon", 1);
		Assert.assertFalse(((ShoppingCart) shoppingCartTest).getArray().size() == 0);
		
		// Check to see if removeItem removes an item from the cart successfully using the test that checked if size was 0
		((ShoppingCart) shoppingCartTest).removeItem("RustySword", 1);
		Assert.assertTrue(((ShoppingCart) shoppingCartTest).getArray().size() == 0);
		
	}
	
	/** Method that checks to see if Weapons quantity can be updated by returning a boolean for use with Assert 
	 * @return boolean */
	public boolean checkIncreaseItemQuantity() {
		Object rustySword = new RustySword();
		int amount = ((Weapon) rustySword).getQuantity();
		
		((Weapon) rustySword).increaseQuantity(5);
		int newAmount = ((Weapon) rustySword).getQuantity();

		return amount + 5 - newAmount == 0;
	}
	
	/** Method that checks to see if item quantity was reduced by returning a boolean for use with Assert 
	 * @return boolean */
	public boolean checkReduceItemQuantity() {
		Object rustySword = new RustySword();
		int amount = ((Weapon) rustySword).getQuantity();
		
		((Weapon) rustySword).reduceQuantity(5);
		int newAmount = ((Weapon) rustySword).getQuantity();
		
		return amount - 5 - newAmount == 0;
	}
	
	/** Method that checks to see if the Description was changed by returning a string for use with Assert 
	 * @return String */
	public String checkNewDescription() {
		Object rustySword = new RustySword();
		
		return ((Weapon) rustySword).getDescription();
	}

}
