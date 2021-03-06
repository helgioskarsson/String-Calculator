package is.ru.stringcalculator;
import java.util.ArrayList;
import java.util.List;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		if(text.length() == 1){
			return toInt(text);
		}

		text = specialDelimiter(text);
		
		if(text.contains(",") || text.contains("\n")){
			text = text.replaceAll("\n", ",");

			return sum(splitNumbers(text));
		}
		return 1;
	} 

	private static String specialDelimiter(String text){
		if(text.contains("//")){
			String tmp;
			if(text.contains("]")){
				text = text.replaceAll("[^\\d]+", ",");
				int indexOfBrac = text.indexOf("]");
				text = text.substring(indexOfBrac + 2);
			}
			else{
				tmp = text.substring(2, 3);
				text = text.substring(4);
				text = text.replaceAll(tmp, ",");
			}
			
		}
		return text;
	}


	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
		return numbers.split(",");
	}
     
    private static int sum(String[] numbers){
    	int total = 0;
		for(String number : numbers){
			if(toInt(number) < 0){
    			printIfNegative(numbers);
    			break;
    		}
    		if(toInt(number) < 1001){
				total += toInt(number);
    		}
		}
		
		return total;
    }
    private static void printIfNegative(String[] numbers){
    		 List<Integer> negNum = new ArrayList<Integer>();
    		int count = 0;
    		for(String number : numbers){
    			int numberInt = toInt(number);
    			if(numberInt < 0){
    				negNum.add(numberInt);
    			}
    		}
    		String negNumsPrint = negNum.toString();
    		negNumsPrint = negNumsPrint.replaceAll("\\[", "");
    		negNumsPrint = negNumsPrint.replaceAll("\\]", "");
    		negNumsPrint = negNumsPrint.replaceAll(" ", "");
    		throw new IllegalArgumentException("Negatives not allowed: " + negNumsPrint);
    }
}
