//SafeRide
//Author: Matt Whisler
//Date: Feb 26, 2015
//Class: CS 160
// Email: whisler_matt@yahoo.com

package version.one.zero;

@SuppressWarnings("serial")
public class InvalidPhoneNumberException extends java.lang.RuntimeException {
	
	public InvalidPhoneNumberException(String number){
		super("Error: Invalid phone number " + number + " detected.");
	}
}
