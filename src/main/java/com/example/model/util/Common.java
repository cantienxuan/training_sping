package com.example.model.util;

public class Common {
	
	/**
	 * replace space and character '-'
	 * @param input input 
	 * @return output without space and character '-'
	 */
	public static String replaceInput(String input) {
		return input.replace(" ", "").replace("-", "");
		
	}
	
	/**
	 * Check null and regex digit
	 * @param stringInput inputString to check
	 * @return true if input is half size digit, false if not
	 */
	public static boolean checkInput(String stringInput) {
		boolean isOK = false;
		
		if (stringInput != null) {
			if (stringInput.matches("\\d+")) {
				isOK = true;
			}
		}
		
		return isOK;
	}
}
