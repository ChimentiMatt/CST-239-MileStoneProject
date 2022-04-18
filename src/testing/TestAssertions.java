package testing;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import app.Weapon;
import app.CopperSword;
import app.RustySword;

/** Test Assertion class*/
public class TestAssertions {

	/** class testAssertions*/
	@Test
	public void testAssertions() 
	{
		// test data
		Object rustySword = new RustySword();
		Object rustySword2 = new RustySword();
		
		Assert.assertSame(rustySword, rustySword2);
		
//		// test data
//		String str1 = new String("abc");
//		String str2 = new String("abc");
//		String str3 = null;
//		String str4 = "abc";
//		String str5 = "abc";
//		
//		int val1 = 5;
//		int val2 = 6;
//		
//		String[] expectedArray = { "one", "two", "three"};
//		String[] resultArray = { "one", "two", "three"};	
//		
//		// Check that two objects are equal
//		Assert.assertEquals(str1, str2);
//		
//		// Check that a condition is true
//		Assert.assertTrue(val1 < val2);
//		
//		// Check that a condition is false
//		Assert.assertFalse(val1 > val2);
//		
//		// Check that an object isn't null
//		Assert.assertNotNull(str1);
//		
//		// Check that an object is null
//		Assert.assertNull(str3); 
//		
//		// Check is the object reference points to the same object
//		Assert.assertSame(str4, str5);
//		
//		// Check is the object reference not points to the same object
//		Assert.assertNotSame(str1, str3);
//		
//		// Check whether two arrays are equal to each other
//		Assert.assertArrayEquals(expectedArray, resultArray);
		}
}
