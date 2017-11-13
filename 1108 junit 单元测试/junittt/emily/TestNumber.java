package emily;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class TestNumber {
	@Test
	public void testAdd(){
		Number number=new Number();
		number.add(3, 2);
	}

	@Test
	public void testMinus(){
		Number number=new Number();
		number.add(3,1);
	}

	@Ignore
	public void testMultiply(){
		Number number=new Number();
		number.multiply(3, 2);
	}
	
	@Before
	public void testBefore(){
		System.out.println("------before------");
	}

	@After
	public void testAfter(){
		System.out.println("------after------");
		
	}
}
