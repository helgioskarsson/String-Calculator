package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		if(text.length() == 1){
			return toInt(text);
		}
	//	text = text.substring(0);
	//	System.out.println(text.substring(0, 2) );
	//	System.out.println(text.substring(0, 2) + "##############");
	//	System.out.println(text.substring(2, 3) + "$$$$$$$$$$$$$$");
		if(text.contains("//")){
			//System.out.println("&&&&&&&&&&");
			String tmp = text.substring(2, 3);
			text = text.substring(4);
			text = text.replaceAll(tmp, ",");
		}
	//	System.out.println(text + "##############");
		if(text.contains(",") || text.contains("\n")){
			text = text.replaceAll("\n", ",");
			return sum(splitNumbers(text));
		}
		return 1;
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
			total += toInt(number);
		}
		return total;
    }
}