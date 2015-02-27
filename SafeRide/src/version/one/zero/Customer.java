// SafeRide
// File Description: Customer class to represent SafeRide customers in search of a ride within the dispatching software.
//Author: Matt Whisler, Spencer Hinkley
//Date: Feb 26, 2015
// Email: whisler_matt@yahoo.com

package version.one.zero;

public class Customer {

	// Name attributes of customer
	private String first_name;
	private String last_name;
	private String full_name;

	private String phone_number;
	private Location current_loc; // Location customer currently resides (wants to be picked up from)
	private Location destination; // Location customer wishes to be dropped off at


	// Constructor: Customer will not be created if any piece of data is not valid. Only valid data will allow a customer to be created
	public Customer (final String fullName, final String phoneNum, final Location currentLoc, final Location dest) throws Exception{

		if(validName(fullName))
			this.full_name = fullName.trim();
		else throw new Exception("Error: Invalid name \""+fullName+ "\" detected.");
		String[] name = fullName.split(" "); // Separate first and last name from full name string
		this.first_name = name[0].trim();
		this.last_name = name[0].trim();

		// All data below is validated before set. If data is invalid, appropriate error is thrown and no Customer object is made.
		setPhoneNumber(phoneNum);
		this.current_loc = currentLoc;
		this.destination = dest;

	} // end constructor


	// Method Description: Method first validates the given number, if valid, customers number is set, otherwise error is thrown
	private void setPhoneNumber(final String number){

		validatePhoneNumber(number);
		this.phone_number = number;

	} // end setPhoneNumber()


	// Method Description: A phone number is assumed to be valid if it contains 7,10, or 11 digits. Otherwise it is invalid and error is thrown.
	private void validatePhoneNumber(final String phoneNum){ 

		// Remove any characters other than digits from phone number so validation can take place.
		final String number = trimPhoneNumber(phoneNum);

		switch(number.length()){

		case 7:
			this.phone_number = number; break;
		case 10:
			this.phone_number = number; break;
		case 11:
			if(number.charAt(0) != '1') throw new InvalidPhoneNumberException(number);
			else{ this.phone_number = number; break; }

		default:
			throw new InvalidPhoneNumberException(number);		
		} // end switch

	} // end validatePhoneNumber()

	
	// Method Description: A customer name is valid as long as their is some name present.
	private boolean validName(final String name){
		
		if(name.trim().isEmpty()) return false;
		else return true;
	} // end validName()
	
	// Method Description: Method removes any characters other than digits (0-9) from the given phone number string and return new string that only contains digits
	private String trimPhoneNumber(String phoneNum){

		String newNum = ""; // new number to be returned
		final int size = phoneNum.length();
		char digit = ' ';

		// For every character in phone number...
		for(int i = 0; i < size; ++i){
			// Grab single character from phonNum
			digit = phoneNum.charAt(i);
			// Only include in new string if it is a valid digit
			if (Character.isDigit(digit))
				newNum += digit;
		} // end for loop

		return newNum;
	} // end trimPhoneNumber()

	// Method Description: Method formats customers format to a standard phone number format based on the number of digits present.
	private String formatNumber(){

		final int number_length = this.phone_number.length();

		switch(number_length){

		case 7:
			return this.phone_number.substring(0, 3) + "-" + this.phone_number.substring(3,number_length);
		case 10:
			return "(" + this.phone_number.substring(0, 3) + ") " + this.phone_number.substring(3,6) + "-" + this.phone_number.substring(6, number_length);
		case 11:
			return "1 (" + this.phone_number.substring(1, 4) + ") " + this.phone_number.substring(4,7) + "-" + this.phone_number.substring(7, number_length);

		default: throw new InvalidPhoneNumberException(this.phone_number);
		}

	} // end formatNumber()

	@Override
	public String toString() { 

		String customer = "Name: " + this.full_name + "\n";
		customer += "Phone Number: " + formatNumber() + "\n";
		customer += "Pick-up Location: " + this.current_loc + "\n";
		customer += "Drop-off Location: " + this.destination + "\n";
		return customer; 
	}

	public final Customer getCustomer() throws Exception { return new Customer(this.full_name, this.phone_number, this.current_loc, this.destination); }

	public final Location getCurrentLocation() { return this.current_loc; }

	public final Location getDestination() { return this.destination; }

	public final String getName() {return this.full_name; }

	public final String getPhoneNumber() { return this.phone_number; }


} // end Customer Class
