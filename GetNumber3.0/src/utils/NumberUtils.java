package utils;

public class NumberUtils {

	/**
	 * Generates Random number, within a given max limit
	 * @param maxLimit
	 * @return a random number <= maxLimit
	 */
	public static Integer generateRandomNumber(Integer maxLimit) {

		Integer generatedNumber = (Integer.valueOf((int) Math.floor(Math.random() * maxLimit)));

		return generatedNumber;
	}
	
	
	public static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
}
