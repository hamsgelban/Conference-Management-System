package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Organizer;

public class OrganizerTestCase1 {
	
	Organizer organizer = new Organizer("organizer_mmm", "organizerPassword",
            "FirstName", "LastName", "organizerId123");

	@Test
	public final void testOrganizer() {
		testGetOrganizerId();
		testGetUsername();
		testIsLogged();
		testIsValid();
		testLogin();
	}

	@Test
	public final void testGetOrganizerId() {
        assertEquals("organizerId123", organizer.getOrganizerId());
        }

	@Test
	public final void testGetUsername() {
        assertEquals("organizer_mmm", organizer.getUsername());	
        }

	@Test
	public final void testLogin() {
        boolean loginResult = organizer.login("organizer_mmm", "organizerPassword");

		
		 assertTrue(loginResult);

	}

	@Test
	public final void testIsLogged() {
		organizer.setIsLogged(true);
        assertTrue(organizer.isLogged());
	}

	@Test
	public final void testIsValid() {
        boolean isValidCredentials = organizer.isValid("organizer_mmm", "organizerPassword");

        assertTrue(isValidCredentials);
	}

}
