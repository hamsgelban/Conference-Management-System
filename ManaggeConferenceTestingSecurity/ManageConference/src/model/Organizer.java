package model;

import container.ConferenceContainer;

public class Organizer extends User {
	
	private String organizerId;

    public Organizer(String username, String password, String fname, String lname, String organizerId) {
        super(username, password, fname, lname);
        this.organizerId = organizerId;
    }
    
    
    
	
    public String getOrganizerId() {
		return organizerId;
	}




	public void setOrganizerId(String organizerId) {
		this.organizerId = organizerId;
	}




	public void assignConference(Conference conference) {
    	if(!ConferenceContainer.findConference(conference.getConferenceName())) {
    		Main.registeredConferences.add(conference);
    		confirmationMessage(conference, conference.getConferenceCode());
    	}
    	else {
    		//Error message? Return to step 3?
    	}
    }
    

    private void confirmationMessage(Conference conference, String conferenceCode) {
        //Implement UI here 
    	//A banner message for the organizer
    }
    

}
