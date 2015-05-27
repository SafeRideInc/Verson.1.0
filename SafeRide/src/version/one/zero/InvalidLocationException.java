//SafeRide
//Author: Matt Whisler, Spencer Hinkley
//Date: Feb 26, 2015
//Class: CS 160
// Email: whisler_matt@yahoo.com

package version.one.zero;

@SuppressWarnings("serial")
public class InvalidLocationException extends java.lang.RuntimeException {

	public InvalidLocationException(){
		super("Error: Invalid location detected.");
	}
}
