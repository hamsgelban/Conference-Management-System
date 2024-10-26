package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import model.User;

public class UserTestCase1 {
	
	
    User user = new User("Hams_m", "password123", "Hams", "Mohammed");

	@Test
	public final void testUser() {
		
		testGetUsername();
		testIsLogged();
		testIsValid();
		testLogin();
	}

	@Test
	public final void testGetUsername() {
		assertEquals("Hams_m", user.getUsername());
	}

	@Test
	public final void testLogin() {
		// Attempting to login with correct credentials
        assertTrue(user.login("Hams_m", "password123"));

        // Attempting to login with incorrect credentials
        assertFalse(user.login("Hams_m", "wrong_password"));
	}

	@Test
	public final void testIsLogged() {
		assertFalse(user.isLogged());

        user.setIsLogged(true);

        assertTrue(user.isLogged());
	}

	@Test
	public final void testIsValid() {
		assertTrue(user.isValid("Hams_m", "password123"));

        assertFalse(user.isValid("Hams_m", "wrong_password"));
	}

}
