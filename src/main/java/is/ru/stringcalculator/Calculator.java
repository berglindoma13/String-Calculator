package is.ru.stringcalculator;


public class Calculator {

	public static String DELIMINATORS = "[,\n]";

	public static int add(String text){
		if(text.equals(""))
		{
			return 0;
		}
		else if(text.startsWith("//"))
		{
			String[] temp = text.split("//", 2);
			String rest = temp[1];

			temp = splitNumbers(rest);
			String addedDelim = temp[0];

			rest = temp[1];
			temp = rest.split(addedDelim);

			int results = sum(temp);
			return results;
		}
		else if(text.contains(","))
		{
			return sum(splitNumbers(text));
		}
		else if (text.contains("\n"))
		{
			return sum(splitNumbers(text));
		}
		return 1;
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
		return numbers.split(DELIMINATORS);
	}

	private static int sum(String[] numbers){
		int total = 0;
		for(String number : numbers){
			total += toInt(number);
		}
		return total;
	}
}