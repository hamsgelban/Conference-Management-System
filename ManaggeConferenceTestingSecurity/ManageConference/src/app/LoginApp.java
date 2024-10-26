package app;
import java.sql.Date;
import java.time.LocalDate;

import container.ConferenceContainer;
import container.ReviewerContainer;
import container.UserContainer;
import container.VenuContainer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Conference;
import model.Reviewer;
import model.User;
import model.Venu;

public class LoginApp extends Application {
    @Override
    public void start(Stage stage) throws Exception{
        Pane root = FXMLLoader.load(getClass().getResource("/view/LoginView.fxml"));
        stage.setScene(new Scene(root, 300, 200));
        stage.setTitle("Login Dialog");
        stage.show();
    }

    public static void main(String[] args) {
	//Create sample UserAccounts:
    	User user1 = new User("john_doe", "password123", "John", "Doe");
        User user2 = new User("alice_smith", "secure_pass", "Alice", "Smith");
    	UserContainer.addUser(user1);
    	UserContainer.addUser(user2);
    	
        // Creating two Venue objects
        Venu venu1 = new Venu("1", "Address 1");
        Venu venu2 = new Venu("2", "Address 2");
        VenuContainer.venus.add(venu1);
        VenuContainer.venus.add(venu2);

        // Creating two Reviewer objects
        Reviewer reviewer1 = new Reviewer("reviewer_mmm", "reviewerPassword",
                "FirstName", "LastName","1", "CS");
        
        Reviewer reviewer2 = new Reviewer("reviewer_mmm2", "reviewerPassword2",
                "FirstName2", "LastName2","2", "EE");
        
        ReviewerContainer.reviewers.add(reviewer1);
        ReviewerContainer.reviewers.add(reviewer2);

        // Creating two Conference objects
        Conference conference1 = new Conference("Conference1", new java.util.Date(), new java.util.Date());
        Conference conference2 = new Conference("Conference2", new java.util.Date(), new java.util.Date());
        ConferenceContainer.addConference(conference1);
        ConferenceContainer.addConference(conference2);
       
        launch(args);
        
    }
}
