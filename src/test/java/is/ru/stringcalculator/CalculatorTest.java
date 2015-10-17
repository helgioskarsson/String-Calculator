package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;


public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber(){
		assertEquals(1, Calculator.add("1"));
	}
	@Test
	public void testTwoNumbers(){
		assertEquals(3, Calculator.add("1,2"));
	}

	@Test
	public void testMultipleNumbers(){
		assertEquals(6, Calculator.add("1,2,3"));
	}
	@Test
	public void testMultipleNumbers2(){
		assertEquals(2000, Calculator.add("1000,750,250"));
	}

	@Test
	public void testMultipleNumbers3(){
		assertEquals(8, Calculator.add("1,1,1,1,1,1,1,1"));
	}

	@Test
	public void testNewLine1(){
		assertEquals(6, Calculator.add("1\n2,3"));
	}
	@Test
	public void testNewLine2(){
		assertEquals(6, Calculator.add("1\n2\n3"));
	}
	@Test
	public void testNewLine3(){
		assertEquals(1605, Calculator.add("100,3\n999\n300\n200,3"));
	}
	@Test
	public void testDifferentDelimiter(){
		assertEquals(3, Calculator.add("//;\n1;2"));
	}
	@Test(expected = IllegalArgumentException.class)
	public void testExpectedException() {
	  assertEquals("Negatives not allowed:4 -4,-5", Calculator.add("2,-4,3,-5"));
	}

}


/*	@Rule
	public IllegalArgumentException exception = ExpectedException.none();
	@Test
	public void negativesNotallowed(){
		    exception.expect(IllegalArgumentException.class);
   			exception.expectMessage("Negatives not allowed: -4,-5");
	}*/

