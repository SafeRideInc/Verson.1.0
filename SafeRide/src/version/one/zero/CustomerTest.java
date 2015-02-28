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
