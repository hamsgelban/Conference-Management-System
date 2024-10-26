package container;

import java.util.ArrayList;
import java.util.List;

import model.Reviewer;
import model.Venu;

public class VenuContainer {
	
	public static List<Venu> venus = new ArrayList<Venu>();
	
	public static Venu findVenu(String venuId) {
		venus.add(new Venu("1", "address 1"));
		venus.add(new Venu("2", "address 2"));
		for (Venu venu : venus) 
			if(venu.getVenuId().equals(venuId))
				return venu;
		
		return null;
	}
}
