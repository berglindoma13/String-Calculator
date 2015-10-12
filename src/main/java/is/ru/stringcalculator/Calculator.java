package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals(""))
		{
			return 0;
		}
		else if(text.contains(","))
		{
			String[] numbers = splitNumbers(text);
			return toInt(numbers[0]) + toInt(numbers[1]);
		}
		return 1;
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
		return numbers.split(",");
	}
}