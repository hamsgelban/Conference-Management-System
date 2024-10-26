package model;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import container.ConferenceContainer;
import security.Hashing;

public class Main {
	
	// ArrayList to store all registered conferences in the system
	static ArrayList<Conference> registeredConferences; 

	public static void main(String[] args) {
		
		
        // Creating a Date object for the conference date and deadline
        Date conferenceDate = new Date();  
        Date conferenceDeadline = new Date();  

        // Creating a Conference object
        Conference myConference = new Conference("Conference 1", conferenceDate, conferenceDeadline);

        // Adding the conference to the list of registered conferences
        ConferenceContainer.addConference(myConference);
        
        System.out.println("--------------------Creating the conference----------------------------");
        
        
        // Accessing the properties of the conference
        System.out.println("Conference Name: " + myConference.getConferenceName());
        System.out.println("Conference Date: " + myConference.getDate());
        System.out.println("Conference Deadline: " + myConference.getDeadline());
        System.out.println("Is Conference Open?: " + myConference.isOpen());
        System.out.println("Conference Code: " + myConference.getConferenceCode());

        // Calling methods of the conference
        myConference.makeDecision();  // Irrelevant to the use case

        // Checking if the deadline is reached
        System.out.println("Is Deadline Reached?: " + myConference.isDeadlineReached());

        // Checking if a conference with a given name exists
        System.out.println("Conference Exists: " + ConferenceContainer.findConference(myConference.getConferenceName()));
        
        
        
        
        //-----------------------------------------------------------------------------
        System.out.println("-----------------------Reviewer---------------------------------------");
        
        Reviewer reviewer = new Reviewer("reviewer_mmm", "reviewerPassword",
                "FirstName", "LastName","R123", "Machine Learning");

        // Accessing the properties of the reviewer
        System.out.println("Reviewer ID: " + reviewer.getReviewerId());
        System.out.println("Expertise: " + reviewer.getExpertise());
        
        System.out.println("Username: " +reviewer.getUsername());
        System.out.println("Is Logged In: " + reviewer.isLogged());

        // Logging in
        System.out.println("Login Result: " + reviewer.login("reviewer_mmm", "reviewerPassword"));


        // Validating credentials
        boolean isValidCredentialsr = reviewer.isValid("reviewer_mmm", "reviewerPassword");
        System.out.println("Are Valid Credentials: " + isValidCredentialsr);

        // Setting isLogged to true
        reviewer.setIsLogged(true);
        
        System.out.println("Is Logged In: " + reviewer.isLogged());

        reviewer.submitReview("1", "Good work", 5.5);

        
        System.out.println("-----------------------User---------------------------------------");
        
        User user = new User("john_doe", "password123", "John", "Doe");

        // Accessing the properties of the user
        System.out.println("Username: " + user.getUsername());
        System.out.println("Is Logged In: " + user.isLogged());

        // Logging in
        System.out.println("Login Result: " + user.login("john_doe", "password123"));


        // Validating credentials
        boolean isValidCredentials = user.isValid("john_doe", "password123");
        System.out.println("Are Valid Credentials: " + isValidCredentials);

        // Setting isLogged to true
        user.setIsLogged(true);
        
        System.out.println("Is Logged In: " + user.isLogged());

        
        System.out.println("-----------------------Venu---------------------------------------");

        
        
        Venu venu = new Venu("V001", "123 Main Street");

        // Accessing the properties of the venu
        System.out.println("Venu ID: " + venu.getVenuId());
        System.out.println("Address: " + venu.getAddress());
        System.out.println("Is Available: " + venu.getIsAvailable());

        // Booking the venu
        boolean bookingResult = venu.bookVenu();
        System.out.println("Booking Result: " + bookingResult);

        // Checking if the venu is available after booking
        System.out.println("Is Available: " + venu.getIsAvailable());
        
        
        
        System.out.println("-----------------------Organizer---------------------------------------");

        
        
        
        Organizer organizer = new Organizer("organizer_mmm", "organizerPassword",
                "FirstName", "LastName", "organizerId123");

        // Creating a Conference object

        // Registering the conference with the organizer
        organizer.assignConference(myConference);
        
        System.out.println("ID: " +organizer.getOrganizerId());
        System.out.println("Username:  " +organizer.getUsername());
        boolean loginResultO = organizer.login("organizer_mmm", "organizerPassword");
        System.out.println("Login Result: " + loginResultO);

        // Checking if the user is logged in
        System.out.println("Is Logged In: " + organizer.isLogged());

        // Validating credentials
        boolean isValidCredentialsO = organizer.isValid("organizer_mmm", "organizerPassword");
        System.out.println("Are Valid Credentials: " + isValidCredentialsO);

        // Setting isLogged to true
        organizer.setIsLogged(true);
        
        System.out.println("Is Logged In: " + organizer.isLogged());

        
        
        
        
        System.out.println("-----------------------------TestConference----------------------");
        System.out.println("-------------------Adding reviewer and venu----------------------");

        
        myConference.getConferenceReviewers().add(reviewer);
        myConference.getConferenceVenus().add(venu);
        
        List<Reviewer> conferenceReviewers =myConference.getConferenceReviewers();
        
        System.out.println("Conference Reviewers : " + conferenceReviewers);
        
        System.out.println("Conference Venu : " + myConference.getConferenceVenus());
        
        System.out.println("");
        
        System.out.println("-----------------------------TestHashing----------------------");

        System.out.println("");
        
        System.out.println("Trying hash Password");

        
        System.out.println(Hashing.hashPassword("organizerPassword"));
		
		
		

	}

}
