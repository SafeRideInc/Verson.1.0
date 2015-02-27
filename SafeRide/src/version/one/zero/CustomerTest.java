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
	}


	@Rule
	public ExpectedException thrown_exception = ExpectedException.none();
	@Test
	public void throwsPhoneNumberException() throws Exception {

		pickup = new Location("Lory Student Center", "Fort Collins", "CO", 80521);
		dest = new Location("1925 West Lake Street","Fort Collins" , "CO", 80521);
		thrown_exception.expect(InvalidPhoneNumberException.class);
		thrown_exception.expectMessage("Error: Invalid phone number ");
		new Customer("Joe Smo", "123456", pickup, dest);
		new Customer("Joe Smo", "123456789", pickup, dest);
		new Customer("Joe Smo", "22345678911", pickup, dest);
		new Customer("Joe Smo", "", pickup, dest);
	}
	
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	@Test
	public void throwsNameException() throws Exception {

		pickup = new Location("Lory Student Center", "Fort Collins", "CO", 80521);
		dest = new Location("1925 West Lake Street","Fort Collins" , "CO", 80521);
		thrown_exception.expect(Exception.class);
		thrown_exception.expectMessage("Error: Invalid name ");
		new Customer("", "1234567", pickup, dest);
		new Customer(" ", "1234567", pickup, dest);
		new Customer("\n", "1234567", pickup, dest);
		new Customer("\t", "1234567", pickup, dest);
	}

	
	@Test
	public void testCustomer() {
		fail("Not yet implemented");
	}

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
		c2 = new Customer("Spencer Hinkley", "1234567", pickup, dest);
		c3 = new Customer("Hauk", "12345678912", pickup, dest);
		
		String actual = "Matt Whisler9166014645Fort Collins CO80521";
		String actual2 = "Spencer Hinkley1234567Fort Collins CO80521";
		String actual3 = "Hauk12345678912Fort Collins CO80521";
		assertEquals(actual, c1.getCustomer());
		assertEquals(actual2, c2.getCustomer());
		assertEquals(actual3, c3.getCustomer());
		
	}

	@Test
	public void testGetCurrentLocation() throws Exception {
		pickup = new Location("Lory Student Center", "Fort Collins", "CO", 80521);
		Location pickup2 = new Location("Lory Student Center", "Lincoln", "NE", 68506);
		Location pickup3 = new Location("Lory Student Center", "Denver", "CO", 80521);
		dest = new Location("1925 West Lake Street","Fort Collins" , "CO", 80154);
		c1 = new Customer("Matt Whisler", "9166014645", pickup, dest );
		c2 = new Customer("Spencer Hinkley", "1234567", pickup2, dest);
		c3 = new Customer("Hauk", "12345678912", pickup3, dest);
		
		String actual = "Lory Student Center" + "\n";
		actual += "Fort Collins, CO" + "\n"; 
		actual += "80521";
		String actual2 = "Lory Student Center" + "\n";
		actual2 += "Denver, CO" + "\n"; 
		actual2 += "80521";
		String actual3 = "Lory Student Center" + "\n";
		actual3 += "Lincoln, NE" + "\n"; 
		actual3 += "68506";
		assertEquals(actual.trim(), c1.getCurrentLocation());
		assertEquals(actual2.trim(), c2.getCurrentLocation());
		assertEquals(actual3.trim(), c3.getCurrentLocation());
	}

	@Test
	public void testGetDestination() throws Exception {
		pickup = new Location("Lory Student Center", "Fort Collins", "CO", 80521);
		dest = new Location("1925 West Lake Street","Fort Collins" , "CO", 80154);
		Location dest2 = new Location("Lory Student Center", "Lincoln", "NE", 80521);
		Location dest3 = new Location("Lory Student Center", "Denver", "CO", 80521);
		c1 = new Customer("Matt Whisler", "9166014645", pickup, dest );
		c2 = new Customer("Spencer Hinkley", "1234567", pickup, dest2);
		c3 = new Customer("Hauk", "12345678912", pickup, dest3);
		
		String actual = "Lory Student Center" + "\n";
		actual += "Fort Collins, CO" + "\n"; 
		actual += "80521";
		String actual2 = "Lory Student Center" + "\n";
		actual2 += "Denver, CO" + "\n"; 
		actual2 += "80521";
		String actual3 = "Lory Student Center" + "\n";
		actual3 += "Lincoln, NE" + "\n"; 
		actual3 += "68506";
		assertEquals(actual, c1.getDestination());
		assertEquals(actual2, c2.getDestination());
		assertEquals(actual3, c3.getDestination());
	}

	@Test
	public void testGetName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPhoneNumber() {
		fail("Not yet implemented");
	}

}
