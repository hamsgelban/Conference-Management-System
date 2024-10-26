package container;

import java.util.ArrayList;
import java.util.List;

import model.Organizer;
import model.User;

public class UserContainer {
	
	private static List<User> userAccounts = new ArrayList<User>();
	private static List<Organizer> organizers = new ArrayList<Organizer>();
	
	public static User currentUser;

	public static void addUser(User user) {
		if (user!=null)
			userAccounts.add(user);
	}
	
	public static User find(String username) {
		for (User user : userAccounts) 
			if(user.getUsername().equals(username))
				return user;
		
		return null;
	}
	
	public static User login(String username, String password) {
		User temp = find(username);
		if (temp!=null && temp.isValid(username, password))
		{
			temp.setIsLogged(true);
			currentUser = temp;
			return temp;
		}
		return null;
	}
	
	public static Organizer findOrganizer(String username) {
		for (Organizer organizer : organizers) 
			if(organizer.getUsername().equals(username))
				return organizer;
		
		return null;
	}
}
