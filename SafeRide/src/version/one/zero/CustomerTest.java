//SafeRide
//Author: Matt Whisler
//Date: Feb 27, 2015
//Class: CS 160
// Email: whisler_matt@yahoo.com

package version.one.zero;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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

		Location pickup = new Location("Lory Student Center", "Fort Collins", "CO", 80521);
		Location dest = new Location("1925 West Lake Street","Fort Collins" , "CO", 80521);
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

		Location pickup = new Location("Lory Student Center", "Fort Collins", "CO", 80521);
		Location dest = new Location("1925 West Lake Street","Fort Collins" , "CO", 80521);
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
	public void testToString() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCustomer() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCurrentLocation() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDestination() {
		fail("Not yet implemented");
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
