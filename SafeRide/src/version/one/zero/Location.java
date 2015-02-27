//SafeRide
//Author: Matt Whisler
//Date: Feb 26, 2015
// Email: whisler_matt@yahoo.com

package version.one.zero;

public class Location {
	
	String address;
	String state;
	String city;
	int zipcode;
	
	public Location(final String addr, final int zip){
		
		this.address = addr;
		this.zipcode = zip;
	}
	
	public Location(final String theAddr, final String theCity, final String theState, final int theZip){
		
		this.address = theAddr;
		this.state = theState;
		this.city = theCity;
		this.zipcode = theZip;
		
	}
	
	@Override
	public String toString(){
		
		String newString = "";
		newString += this.address + "\n";
		newString += this.city + ", " + this.state + "\n";
		newString += this.zipcode;
		
		return newString;
	}

}
