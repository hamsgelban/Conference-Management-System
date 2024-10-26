package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Conference;

public class ConferenceTestCase2 {
	
	Conference  myConference= new Conference();
	@Test
	public final void testConference() {
		
		testGenerateConferenceCode();
		testGetConferenceCode();
		testGetConferenceName();
		testGetConferenceReviewers();
		testGetConferenceVenus();
		testGetDate();
		testGetDeadline();
		testIsDeadlineReached();
		testIsOpen();
	}

	@Test
	public final void testGetConferenceName() {
        assertNull(myConference.getConferenceName());
        }

	@Test
	public final void testGetDate() {
        assertNull(myConference.getDate());
	}

	@Test
	public final void testGetDeadline() {
        assertNull(myConference.getDeadline());

	}

	@Test
	public final void testIsOpen() {
        assertNull(myConference.isOpen());

	}



	@Test
	public final void testGetConferenceCode() {
        assertNull(myConference.generateConferenceCode());

	}



	@Test
	public final void testGetConferenceReviewers() {
        assertTrue(myConference.getConferenceReviewers().isEmpty());
	}

	@Test
	public final void testGetConferenceVenus() {
        assertTrue(myConference.getConferenceVenus().isEmpty());
	}

	@Test
	public final void testGenerateConferenceCode() {
        assertNull(myConference.generateConferenceCode());

	}

	@Test
	public final void testIsDeadlineReached() {
        assertFalse(myConference.isDeadlineReached());

	}

}
