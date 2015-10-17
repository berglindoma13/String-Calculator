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

				if(rest.startsWith("["))
				{
					temp = splitNumbers(rest);
					rest = temp[1];

					temp = temp[0].split("]", 2);
					String check = temp[1];
					
					if(check.contains("]"))
					{
						String[] temp2 = {};
						String multipledeliminators = "[";
						while(check.contains("]"))
						{
							temp2 = check.split("]");
							temp2 = temp2[0].split("");
							multipledeliminators += "\\" + temp2[1];
							check = temp2[1];
						}
						multipledeliminators += "]";
						temp = rest.split(multipledeliminators);
					}

					else 
					{	
						temp = temp[0].split("");
						String newdelim = "";
						for(int i = 1; i < temp.length; i++)
						{
							newdelim += "\\" + temp[i];
						}

						temp = rest.split(newdelim);					
					}
				}
				else
				{
					temp = splitNumbers(rest);
					String addedDelim = temp[0];
					rest = temp[1];
					temp = rest.split(addedDelim);	
				}

				int results = sum(temp);
				return results;
			}
			else if(text.contains(",") || text.contains("\n"))
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
		String neg = "";
		int i = 0;
		int max = 1000;
		for(String number : numbers){
			if(number.contains("-"))
			{
				neg += " , " + number;
				i++;
			}
			else if(max > toInt(number))
			{
				total += toInt(number);	
			}
		}

		if(i > 0)
		{
			throw new IllegalArgumentException("Negatives not allowed" + neg);
		}
		return total;
	}
}