package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
		org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");

	}

	@Test
	public void testEmptyString(){
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber(){
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}

	@Test
	public void testMultipleNumbers(){
		assertEquals(5, Calculator.add("1,2,2"));
	}

	@Test 
	public void testWithWhitespace(){
		assertEquals(5, Calculator.add("1\n2,2"));
	}

	@Test
	public void customDeliminator()
	{
		assertEquals(3, Calculator.add("//;\n1;2"));
	}
}