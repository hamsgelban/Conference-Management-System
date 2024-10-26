package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Venu;

public class VenuTestCase1 {
	
	
    Venu venu = new Venu("V001", "123 Main Street");

	@Test
	public final void testVenu() {
		testBookVenu();
		testGetVenuId();
		testGetAddress();
		testGetIsAvailable();
		
	}
	
	//remove it 

	@Test
	public final void testBookVenu() {
		boolean bookingResult = venu.bookVenu();

        // Checking if the booking was successful
        assertTrue(bookingResult);

	}

	@Test
	public final void testGetVenuId() {
        assertEquals("V001", venu.getVenuId());	}

	@Test
	public final void testGetAddress() {
		
		
        assertEquals("123 Main Street", venu.getAddress());	}

	//problem in main test 
	@Test
	public final void testGetIsAvailable() {
		venu.bookVenu();
        assertFalse(venu.getIsAvailable());	}

}
