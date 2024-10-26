package testing;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import model.Reviewer;

public class ReviewerTestCase1 {
	
    Reviewer reviewer = new Reviewer("reviewer_mmm", "reviewerPassword",
            "FirstName", "LastName","R123", "Machine Learning");


    @Test
    public void testReviewer() {
    	
    	testGetExpertise();
    	testGetReviewerId();
		testGetUsername();
		testIsLogged();
		testIsValid();
		testLogin();
 
    }
    

	@Test
	public final void testGetUsername() {
        assertEquals("reviewer_mmm", reviewer.getUsername());	
        }

	@Test
	public final void testLogin() {
        boolean loginResult = reviewer.login("reviewer_mmm", "reviewerPassword");

		
		 assertTrue(loginResult);

	}

	@Test
	public final void testIsLogged() {
		reviewer.setIsLogged(true);
        assertTrue(reviewer.isLogged());
	}

	@Test
	public final void testIsValid() {
        boolean isValidCredentials = reviewer.isValid("reviewer_mmm", "reviewerPassword");

        assertTrue(isValidCredentials);
	}

    @Test
    public void testGetReviewerId() {

        assertEquals("R123", reviewer.getReviewerId());
    }

    @Test
    public void testGetExpertise() {

        assertEquals("Machine Learning", reviewer.getExpertise());
    }
}
