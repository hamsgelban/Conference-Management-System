package model;

import java.util.List;

public class Reviewer extends User {
	
	private String reviewerId;
	//private List<String> expertise;
	private String expertise;
	

	
	public Reviewer(String username, String password, String fname,
			String lname, String reviewerId, String expertise) {
		super(username, password, fname, lname);
		this.reviewerId = reviewerId;
		this.expertise = expertise;
	}
	
	/////////////////////////////////////////Getters & Setters/////////////////////////////////////////
	public String getReviewerId() {
		return reviewerId;
	}
	public void setReviewerId(String reviewerId) {
		this.reviewerId = reviewerId;
	}
	public String getExpertise() {
		return expertise;
	}
	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}
	
	

	/////////////////////////////////////////Methods/////////////////////////////////////////

	public void submitReview (String paperNo, String comment, Double ratting) {
		
		
	}
	public void getAssignedPaper() {
		
	}
	
	public void acknowledgeReviewTask() {
		
	}

	@Override
	public String toString() {
		return "Reviewer [reviewerId=" + reviewerId + ", expertise=" + expertise + ", getUsername()=" + getUsername()
				+ ", isLogged()=" + isLogged() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}


	
	

}
