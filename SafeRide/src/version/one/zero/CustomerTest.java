//SafeRide
//Author: Matt Whisler
//Date: Feb 27, 2015
//Class: CS 160
// Email: whisler_matt@yahoo.com

package version.one.zero;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

// THIS BETTER SHOW UP
public class CustomerTest {

	private Location pickup;
	private Location dest;
	private Customer c1;
	private Customer c2;
	private Customer c3;

	@Before
	public void setUp() throws Exception {

		pickup = new Location("Lory Student Center", "Fort Collins", "CO", 80521);
		dest = new Location("1925 West Lake Street","Fort Collins" , "CO", 80521);
		// Legal Customers with valid data
		c1 = new Customer("Matt Whisler", "9166014645", pickup, dest );
		c2 = new Customer("Spencer Hinkley", "1234567", pickup, dest);
		c3 = new Customer("Hauk", "12345678912", pickup, dest);

	} // end setUp()

	@After
	public void tearDown() throws Exception {

		this.pickup = null;
		this.dest = null;
		this.c1 = null;
		this.c2 = null;
		this.c3 = null;
	} // end tearDown()


	@Rule
	public ExpectedException thrown_exception = ExpectedException.none();
	@Test
	public void throwsPhoneNumberException() throws Exception {

		// 6 digit phone number
		thrown_exception.expect(InvalidPhoneNumberException.class);
		thrown_exception.expectMessage("Error: Invalid phone number ");
		new Customer("Joe Smo", "123456", pickup, dest);
		
		// 9 digit phone number
		thrown_exception.expect(InvalidPhoneNumberException.class);
		thrown_exception.expectMessage("Error: Invalid phone number ");
		new Customer("Joe Smo", "123456789", pickup, dest);
		
		// 11 digit number not leading with 1
		thrown_exception.expect(InvalidPhoneNumberException.class);
		thrown_exception.expectMessage("Error: Invalid phone number ");
		new Customer("Joe Smo", "22345678911", pickup, dest);
		
		// Empty phone number
		thrown_exception.expect(InvalidPhoneNumberException.class);
		thrown_exception.expectMessage("Error: Invalid phone number ");
		new Customer("Joe Smo", "", pickup, dest);
		
		// 7 spaces phone number
		thrown_exception.expect(InvalidPhoneNumberException.class);
		thrown_exception.expectMessage("Error: Invalid phone number ");
		new Customer("Joe Smo", "       ", pickup, dest);
		
		// 10 spaces phone number
		thrown_exception.expect(InvalidPhoneNumberException.class);
		thrown_exception.expectMessage("Error: Invalid phone number ");
		new Customer("Joe Smo", "          ", pickup, dest);
		
		// 1 with 10 spaces after it
		thrown_exception.expect(InvalidPhoneNumberException.class);
		thrown_exception.expectMessage("Error: Invalid phone number ");
		new Customer("Joe Smo", "1          ", pickup, dest);

	} // end throwsPhoneNumberException()


	@Rule
	public ExpectedException exception = ExpectedException.none();
	@Test
	public void throwsNameException() throws Exception {

		// empty name
		thrown_exception.expect(Exception.class);
		thrown_exception.expectMessage("Error: Invalid name ");
		new Customer("", "1234567", pickup, dest);
		
		// name with just a space
		thrown_exception.expect(Exception.class);
		thrown_exception.expectMessage("Error: Invalid name ");
		new Customer(" ", "1234567", pickup, dest);
		
		// newline whitespace name
		thrown_exception.expect(Exception.class);
		thrown_exception.expectMessage("Error: Invalid name ");
		new Customer("\n", "1234567", pickup, dest);
		
		// tab whitespace name
		thrown_exception.expect(Exception.class);
		thrown_exception.expectMessage("Error: Invalid name ");
		new Customer("\t", "1234567", pickup, dest);

	} // end throwsNameException()


	@Test
	public void testCustomer() throws Exception { 

		assertNotNull(this.c1);
		assertNotNull(this.c2);
		assertNotNull(this.c3);
	
	} // end testCustomer()

	@Test
	public void testToString() throws Exception {
		
		pickup = new Location("Lory Student Center", "Fort Collins", "Co", 80521);
		dest = new Location("1925 West Lake Street","Fort Collins" , "Co", 80521);
		c1 = new Customer("Matt Whisler", "9166014645", pickup, dest );
		c2 = new Customer("Spencer Hinkley", "1234567", pickup, dest);
		c3 = new Customer("Hauk", "12345678912", pickup, dest);
			
		//Customer 1
		String actual = "Name: " + c1.getName() + "\n";
		actual += "Phone Number: " + c1.getPhoneNumber() + "\n";
		actual += "Pick-up Location: " + c1.getCurrentLocation() + "\n";
		actual += "Drop-off Location: " + c1.getDestination() + "\n";
		
		String expected = "Name: " + "Matt Whisler" + "\n";
		expected += "Phone Number: " + "9166014645" + "\n";
		expected += "Pick-up Location: " + "Lory Student Center" + "\n";
		expected += "Fort Collins, Co"  + "\n";
		expected += "80521" + "\n";
		expected += "Drop-off Location: " + "1925 West Lake Street" + "\n";
		expected += "Fort Collins, Co"  + "\n";
		expected += "80521" + "\n";
		
		//Customer 2
		String actual2 = "Name: " + c2.getName() + "\n";
		actual2 += "Phone Number: " + c2.getPhoneNumber() + "\n";
		actual2 += "Pick-up Location: " + c2.getCurrentLocation() + "\n";
		actual2 += "Drop-off Location: " + c2.getDestination() + "\n";
		
		String expected2 = "Name: " + "Spencer Hinkley" + "\n";
		expected2 += "Phone Number: " + "1234567" + "\n";
		expected2 += "Pick-up Location: " + "Lory Student Center" + "\n";
		expected2 += "Fort Collins, Co"  + "\n";
		expected2 += "80521" + "\n";
		expected2 += "Drop-off Location: " + "1925 West Lake Street" + "\n";
		expected2 += "Fort Collins, Co"  + "\n";
		expected2 += "80521" + "\n";
		
		//Customer 3
		String actual3 = "Name: " + c3.getName() + "\n";
		actual3 += "Phone Number: " + c3.getPhoneNumber() + "\n";
		actual3 += "Pick-up Location: " + c3.getCurrentLocation() + "\n";
		actual3 += "Drop-off Location: " + c3.getDestination() + "\n";
		
		String expected3 = "Name: " + "Hauk" + "\n";
		expected3 += "Phone Number: " + "12345678912" + "\n";
		expected3 += "Pick-up Location: " + "Lory Student Center" + "\n";
		expected3 += "Fort Collins, Co"  + "\n";
		expected3 += "80521" + "\n";
		expected3 += "Drop-off Location: " + "1925 West Lake Street" + "\n";
		expected3 += "Fort Collins, Co"  + "\n";
		expected3 += "80521" + "\n";

		assertEquals("Customer 1 is correct", actual, expected);
		assertEquals("Customer 2 is correct", actual2, expected2);
		assertEquals("Customer 3 is correct", actual3, expected3);
		assertNotSame("Customer 1 is NOT correct", actual, expected);
		assertNotSame("Customer 2 is NOT correct", actual2, expected2);
		assertNotSame("Customer 3 is NOT correct", actual3, expected3);
		
	}

	@Test
	public void testGetCustomer() throws Exception {
		pickup = new Location("Lory Student Center", "Fort Collins", "CO", 80521);
		dest = new Location("1925 West Lake Street","Fort Collins" , "CO", 80521);
		c1 = new Customer("Matt Whisler", "9166014645", pickup, dest );

		String actual = "Name: Matt Whisler" + "\n"; 
		actual += "Phone Number: (916) 601-4645" + "\n";
		actual += "Pick-up Location: Lory Student Center" + "\n";
		actual += "Fort Collins, CO" + "\n";
		actual += "80521" + "\n";
		actual += "Drop-off Location: 1925 West Lake Street" + "\n";
		actual += "Fort Collins, CO" + "\n";
		actual += "80521" + "\n";

		assertTrue(actual.equals(c1.getCustomer().toString()));
		
	}

	@Test
	public void testGetCurrentLocation() throws Exception {
		pickup = new Location("Lory Student Center", "Fort Collins", "CO", 80521);
		dest = new Location("1925 West Lake Street","Fort Collins" , "CO", 80154);
		c1 = new Customer("Matt Whisler", "9166014645", pickup, dest );
		
		String actual = "Lory Student Center" + "\n";
		actual += "Fort Collins, CO" + "\n"; 
		actual += "80521";

		assertTrue(actual.equals(c1.getCurrentLocation().toString()));

	}

	@Test
	public void testGetDestination() throws Exception {
		pickup = new Location("Lory Student Center", "Fort Collins", "CO", 80521);
		dest = new Location("1925 West Lake Street","Fort Collins" , "CO", 80521);
		c1 = new Customer("Matt Whisler", "9166014645", pickup, dest );
	
		String actual = "1925 West Lake Street" + "\n";
		actual += "Fort Collins, CO" + "\n"; 
		actual += 80521;

		assertTrue(actual.equals(c1.getDestination().toString()));

	}

	@Test
	public void testGetName() { 

		assertEquals("Matt Whisler", c1.getName());
		assertEquals("Spencer Hinkley", c2.getName());
		assertEquals("Hauk", c3.getName());

	} // end testGetName

	@Test
	public void testGetPhoneNumber() { 

		assertEquals("9166014645",c1.getPhoneNumber());
		assertEquals("1234567",c2.getPhoneNumber());
		assertEquals("12345678912",c3.getPhoneNumber());

	} // end testGetPhonePhumber()

	@Test
	public void testEquals() throws Exception{

		assertTrue(c1.equals(new Customer("Matt Whisler", "9166014645", pickup, dest)));
		assertFalse(c1.equals(new Customer("Matt Whisler", "9166014646", pickup, dest)));
		assertFalse(c1.equals(new Customer("Matt W", "9166014645", pickup, dest)));

	} // end testEquals()
	

}
