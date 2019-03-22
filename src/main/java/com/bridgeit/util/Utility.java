package com.bridgeit.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utility {
	/**
	 * validates a 10-digit mobile number
	 * @param mobileNumber mobile number as a string 
	 * @return true if mobile number is valid else false
	 */
	public static boolean validateMobileNumber(String mobileNumber) {
		String regex = "^[7-9][0-9]{9}$";
		return mobileNumber.matches(regex);
}

	/**
	 * Validates a string of length 3 -45 chars long starting with a letter
	 * @param str string to validate
	 * @return true is string is valid else false
	 */
	public static boolean validateStringForAlphanumericOflength(String str, int length) {
		if (str == null)
			return false;
		if (str.trim().equals(""))
			return false;
		if (str.trim().contains(" "))
			return false;
		if (!Character.isLetter(str.charAt(0)))
			return false;
		if (str.length() >length || str.length() < 3)
			return false;
		return true;
	}

	/**
	 * validates an email
	 * @param email email string
	 * @return true of email is valid else false
	 */
	public static boolean validateEmail(String email) {
		String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
		Pattern pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
		Matcher matcher;
		matcher = pattern.matcher(email);
		return matcher.matches();
	}
}