package testing;

//import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import app.Weapon;

import app.CopperSword;


@RunWith(Parameterized.class)
public class MilestoneTest {

	enum Type {ADD}
	
	// variable type Type
	@Parameter(0)
	public Type type;
	@Parameter(1)
	// variable a1 integer
	public int a1;
	// variable a2 integer
	@Parameter(2)
	public int a2;
	// variable a3 integer
	@Parameter(3)
	public int result;
	
	@Parameters
	public static Collection<Object[]> data()
	{
		Object[][] data = new Object[][] {
			{Type.ADD, 2, 1, 3}, {Type.ADD, 5, 2, 7},

			
		};
		
		return Arrays.asList(data);
	}
	
	/** test method for add */
	@Test
	public void testAdd() 
	{
		Assume.assumeTrue(type == Type.ADD); 

		Assert.assertEquals(result, add(a1, a2));
	}
	
	
	
	public static int add(int a, int b)
	{
		return a + b;
	}
}
