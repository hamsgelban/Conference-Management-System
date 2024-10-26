package container;

import java.util.ArrayList;
import java.util.List;

import model.Conference;
import model.Main;
import model.Organizer;
import model.User;

public abstract class ConferenceContainer {
	private static List<Conference> conferences = new ArrayList<Conference>();


	public static boolean findConference(String conferenceName) {
		for (Conference conference : conferences) 
			if(conference.getConferenceName().equals(conferenceName))
				return true;
		
		return false;
	}
	
	public static boolean addConference(Conference conference){
		if(findConference(conference.getConferenceName())) {
			return false;
		}
		else {
			conferences.add(conference);
			return true;
		}
	}
	
	
//    public static boolean isConferenceExists(String conferenceName) {
//        for (Conference conference :registeredConferences) {
//            if (conference.getConferenceName().equals(conferenceName)) {
//                return true;
//            }
//        }
//        return false;
//    }

}
