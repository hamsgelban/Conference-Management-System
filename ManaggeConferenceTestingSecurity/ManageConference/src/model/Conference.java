package model;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Conference {
	private String conferenceName;
	private Date date;
	private Date deadline;
	private Boolean isOpen;
	private String conferenceCode;
	
	public List<Reviewer> conferenceReviewers = new ArrayList<Reviewer>();
	public List<Venu> conferenceVenus = new ArrayList<Venu>();
	
	
	public Conference() {
	}

	///////////////////////////////////////////////constructor///////////////////////////////////////////////
    public Conference(String conferenceName, Date date, Date deadline) {
        this.conferenceName = conferenceName;
        this.date = date;
        this.deadline = deadline;
        this.isOpen = !isDeadlineReached();
        this.conferenceCode = generateConferenceCode();
    }
    
    ///////////////////////////////////////////////Getters & Setters///////////////////////////////////////
    public String getConferenceName() {
        return conferenceName;
    }
    public void setConferenceName(String conferenceName) {
        this.conferenceName = conferenceName;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public Date getDeadline() {
        return deadline;
    }
    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
    public Boolean isOpen() {
        return isOpen;
    }
    public void setOpen(Boolean isOpen) {
        this.isOpen = isOpen;
    }
    
    public String getConferenceCode() {
        return conferenceCode;
    }
    
    private void setConferenceCode(String conferenceCode) {
        this.conferenceCode = generateConferenceCode();
    }
    
    ///////////////////////////////////////////////Methods///////////////////////////////////////////////
    public void makeDecision() {
    	//Irrelevant to the use case
    }
    
    
    public List<Reviewer> getConferenceReviewers() {
    		return conferenceReviewers;
		
	}

	public void setConferenceReviewers(Reviewer reviwer) {
		if (!conferenceReviewers.contains(reviwer))
			this.conferenceReviewers.add(reviwer);
	}

	public List<Venu> getConferenceVenus() {
		return conferenceVenus;
	}

	public void setConferenceVenus(Venu conferenceVenus) {
		if (!this.conferenceVenus.contains(conferenceVenus))
			this.conferenceVenus.contains(conferenceVenus);
		
	}

	//Generating a random code for conferences
	// it should  be private but just for testing 
    public String generateConferenceCode() {
    	if (getConferenceName()!= null) {
    		 Random random = new Random();
    	        int randomCode = random.nextInt(1000);
//    	        this.conferenceCode = "CONF-" + randomCode;
    	        return "CONF-" + randomCode;
    	}
    	return null;
       
    }
    
    //Checking whether the deadline has been reached or not
    public boolean isDeadlineReached() {
    	if (getConferenceName()!= null) {
        Date currentDate = new Date();
        return currentDate.after(deadline);
        }
    	return false;
    }
    
    private void assignReviewerToPaper(Reviewer r , String papar) {
    	// not used in this use case 
    	
    }
    

}
