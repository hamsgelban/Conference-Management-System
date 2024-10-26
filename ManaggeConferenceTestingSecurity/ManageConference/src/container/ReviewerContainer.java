package container;

import java.util.ArrayList;
import java.util.List;

import model.Reviewer;

public class ReviewerContainer {
public static List<Reviewer> reviewers = new ArrayList<Reviewer>();
	
	public static Reviewer findReviewer(String reviewerId) {
		reviewers.add(new Reviewer("reviewer_mmm", "reviewerPassword",
                "FirstName", "LastName","R123", "Machine Learning"));
		for (Reviewer reviewer : reviewers) 
			if(reviewer.getReviewerId().equals(reviewerId))
				return reviewer;
		
		return null;
	}
}
