package testing;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import model.Conference;
import model.Reviewer;
import model.Venu;

public class ConferenceTestCase1 {
	
	
    Date conferenceDate;
    Date conferenceDeadline;
    Conference myConference;

    @Before
    public void setUp() {
        // Initialize the Date objects and Conference object before each test
        conferenceDate = new Date();  
        conferenceDeadline = new Date(System.currentTimeMillis() + 100000); 
        myConference = new Conference("Conference 1", conferenceDate, conferenceDeadline);
        
        Reviewer reviewer = new Reviewer("reviewer_mmm", "reviewerPassword",
                "FirstName", "LastName","R123", "Machine Learning");
        
        
        Venu venu = new Venu("V001", "123 Main Street");

        myConference.getConferenceReviewers().add( reviewer);
        myConference.getConferenceVenus().add(venu);
        
        
    }
    

	@Test
	public final void testConferenceStringDateDate() {
		testGenerateConferenceCode();
		testGetConferenceCode();
		testGetConferenceName();
		testGetDate();
		testGetDeadline();
		testIsDeadlineReached();
		testIsOpen();
		testGetConferenceReviewers();
		testGetConferenceVenus();
		}


	@Test
	public final void testGetConferenceName() {
		assertEquals("Conference 1", myConference.getConferenceName());
		}

	@Test
	public final void testGetDate() {
        assertEquals(conferenceDate, myConference.getDate());
        }

	@Test
	public final void testGetDeadline() {
        assertEquals(conferenceDeadline, myConference.getDeadline());
	}

	@Test
	public final void testIsOpen() {
        assertTrue(myConference.isOpen());	}

	@Test
	public final void testGetConferenceCode() {
		String conferenceCode = myConference.getConferenceCode();
	    assertTrue(conferenceCode.matches("CONF-\\d+"));	}

	@Test
	public final void testGenerateConferenceCode() {
		String conferenceCode = myConference.generateConferenceCode();
	    assertTrue(conferenceCode.matches("CONF-\\d+"));	}

	@Test
	public final void testIsDeadlineReached() {
        assertFalse(myConference.isDeadlineReached());
	}
	

	@Test
	public final void testGetConferenceReviewers() {
        Reviewer reviewer = new Reviewer("reviewer_mmm", "reviewerPassword",
                "FirstName", "LastName","R123", "Machine Learning");

		assertEquals(reviewer.getReviewerId(), myConference.getConferenceReviewers().get(0).getReviewerId());
		assertEquals(reviewer.getExpertise(), myConference.getConferenceReviewers().get(0).getExpertise());

	}

	@Test
	public final void testGetConferenceVenus() {
        Venu venu = new Venu("V001", "123 Main Street");
		assertEquals(venu.getVenuId(), myConference.getConferenceVenus().get(0).getVenuId());
		assertEquals(venu.getAddress(), myConference.getConferenceVenus().get(0).getAddress());


	}


	
	

}
