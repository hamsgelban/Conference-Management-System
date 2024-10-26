package controller;

import java.sql.Date;
import java.util.ArrayList;

import container.ConferenceContainer;
import container.ReviewerContainer;
import container.VenuContainer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Window;
import model.Conference;
import model.Reviewer;
import model.Venu;

public class RegisterConferenceController {
	
    @FXML
    private TextField conferenceName;

    @FXML
    private DatePicker startDate;

    @FXML
    private DatePicker endDate;

    @FXML
    private TextField reviewerId;

    @FXML
    private TextField reviewerExpertise;

    @FXML
    private TextField venuId;

    @FXML
    private TextField venuAddress;
    
    @FXML
    private Button confirmButton;

    @FXML
    private TableView<Reviewer> reviewerTable;

    @FXML
    private TableColumn<Reviewer, String>  RevIdCol;
    

    @FXML
    private TableColumn<Reviewer, String> RevExpCol;

    @FXML
    private TableView<Venu> VenuTable;

    @FXML
    private TableColumn<Venu, String> VenIdCol;

    @FXML
    private TableColumn<Venu, String> VenAddressCol;
    
	
    Conference conference = new Conference ();
    
	
    ArrayList<Reviewer> revs = (ArrayList<Reviewer>) conference.getConferenceReviewers();
   
    private final ObservableList<Reviewer> reviewerList = 
    		FXCollections.observableArrayList(revs);
  
     
    ArrayList<Venu> vens = (ArrayList<Venu>) conference.getConferenceVenus();
    
    private ObservableList<Venu> venueList = 
    		FXCollections.observableArrayList(vens);
    
    
    public void initialize() {
    	 
    	//System.out.println(revs.size());
    	
    	RevIdCol.setCellValueFactory(new PropertyValueFactory("reviewerId"));
    	RevExpCol.setCellValueFactory(new PropertyValueFactory("expertise"));
    	
    	reviewerTable.setItems(reviewerList);
    	
    	VenIdCol.setCellValueFactory(new PropertyValueFactory("venuId"));
    	VenAddressCol.setCellValueFactory(new PropertyValueFactory("address"));
    	
    	VenuTable.setItems(venueList);

	}
   

    @FXML
    void onAddReviewer(ActionEvent event) {
        // Get data from text fields
    	String Rid = reviewerId.getText();
        String expertise = reviewerExpertise.getText();

        // Create a new Reviewer object
        Reviewer reviewer = ReviewerContainer.findReviewer(Rid);
       
        if(reviewer!=null && !reviewerList.contains(reviewer)) {
	        // Add the reviewer to the list and update the table
	        reviewerList.add(reviewer);
	        reviewerTable.setItems(reviewerList);
	        
	        conference.conferenceReviewers.add(reviewer);
        }
        
        else {
            // Customize the error message based on the condition
            String errorMessage;
            if (reviewer == null) {
                errorMessage = "Reviewer doesn't exist";
            } else {
                errorMessage = "Reviewer is already in the list";
            }

            showConfirmationDialog(errorMessage, errorMessage, "Error");
            }
        
        // Clear the input fields
        clearReviewerFields();
    }

    @FXML
    void onAddVenu(ActionEvent event) {
        // Get data from text fields
        String vid = venuId.getText();
        String address = venuAddress.getText();

        // Create a new Venu object
        Venu venu = VenuContainer.findVenu(vid);
        if(venu!=null && venu.getIsAvailable() && !venueList.contains(venu)) {
        	
        	// Add the venue to the list and update the table
            venueList.add(venu);
            venu.bookVenu();
            VenuTable.setItems(venueList);
	       
	        conference.conferenceVenus.add(venu);
        }
        else {
            // Customize the error message based on the condition
            String errorMessage;
            if (venu == null) {
                errorMessage = "Venu doesn't exist";
            }
            
            else if (!venu.getIsAvailable()) {
            	 errorMessage = "Venu not available or already assigned";
            	
            }
            else {
                errorMessage = "Venu is already in the listt";
            }

            showConfirmationDialog(errorMessage, errorMessage, "Error");
        }

        // Clear the input fields
        clearVenuFields();
    }

    @FXML
    void onConfirm(ActionEvent event) {
    	conference.setConferenceName(conferenceName.getText());
    	conference.setDate(Date.valueOf(startDate.getValue()));
    	conference.setDeadline(Date.valueOf(endDate.getValue()));
		
    	boolean added = ConferenceContainer.addConference(conference);
        if(added) {
        	showConfirmationDialog("Success", "Conference Added Successfully!", "Success");
        	conferenceName.clear();
        	((Window) confirmButton.getScene().getWindow()).hide();
        }
        else {
        	showConfirmationDialog("Error", "A conference with the same name exists", "Error");
        }
    }
    
    private void clearReviewerFields() {
    	reviewerId.clear();
        reviewerExpertise.clear();
    }

    private void clearVenuFields() {
        venuId.clear();
        venuAddress.clear();
    }
    
    public void showConfirmationDialog(String title, String content, String header) {
 		Alert alert = new Alert(Alert.AlertType.INFORMATION);
 		alert.setTitle(title);
 		alert.setContentText(content);
 		alert.setHeaderText(header);
 		alert.showAndWait();
     }
    

}
