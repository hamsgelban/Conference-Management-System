package controller;

import java.io.IOException;

import container.UserContainer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;
import model.User;

public class LoginController {
	@FXML
	private PasswordField password;

	@FXML
	private TextField username;

	@FXML
	private Button loginButton;

	@FXML
	void login(ActionEvent event) throws IOException {
		User user = UserContainer.login(
                                     username.getText(), password.getText());
		if (user != null && user.isLogged()) {
			displayMessage("Welcome " + user.getUsername() 
                                              + ". You have successfully logged in.",
                                              AlertType.CONFIRMATION);
			username.clear();
			password.clear();
		
			((Window) loginButton.getScene().getWindow()).hide();
			
			Pane root = FXMLLoader.load(getClass().getResource("/view/RegisterConferenceView.fxml"));
	    	Stage stage = new Stage();
	    	stage.setScene(new Scene(root, 600, 500));
			stage.setTitle("Toolbar Preview");
			stage.show();
		} else
			displayMessage("Unsuccessfull login. Try again.", AlertType.ERROR);
	}

	public void displayMessage(String message, AlertType type) {
		Alert alert = new Alert(type);
		alert.setTitle("System Message");
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
	}
}
