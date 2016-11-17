
import java.io.File;

import model.AccessUsers;
import model.User;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Login  {
	
	public Login(){
		
		Stage primarystage=new Stage();
		Pane mainPane = new Pane();
		GridPane gp = new GridPane();
		VBox vbox = new VBox();
		HBox sp = new HBox();
		
		gp.setHgap(10);
		gp.setVgap(10);
		
		Label username = new Label("Username");
		Label password = new Label("Password");
		username.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 20));
		password.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 20));
		Text error = new Text ("Username and Passwords do not match");
		error.setId("actiontarget");
		error.setVisible(false);
		TextField userField = new TextField();
		userField.setFont(Font.font("Verdana", FontWeight.NORMAL, 20));
		PasswordField passField = new PasswordField();
		passField.setFont(Font.font("Verdana", FontWeight.NORMAL, 20));
		
		Button login = new Button(" Login ");
		login.getStyleClass().add("cancel");
		Button cancel=new Button("Cancel");
		cancel.getStyleClass().add("cancel");
		cancel.setOnAction(e->{
			primarystage.setScene(new StartPage().exe(primarystage));
			primarystage.centerOnScreen();
		});
		
		login.setFont(Font.font("Verdana", FontWeight.NORMAL, 21));
		cancel.setFont(Font.font("Verdana", FontWeight.NORMAL, 21));
		
		login.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				String username = userField.getText();
				String password = passField.getText();
				
				File file = new File(AccessUsers.filename);
				boolean found = false;
				if(file.exists() && !file.isDirectory())
				{
					AccessUsers fileUsers = new AccessUsers();
					User user = fileUsers.checkUser(username, password);
					
					if(user != null)
					{
						primarystage.setScene(new Adminpage().exe(primarystage));
					
					}else
						error.setVisible(true);
					}
				}
				
			
			
		});
		
		primarystage.close();
		gp.add(username, 0, 0);
		gp.add(userField, 1, 0);
		gp.add(password, 0, 1);
		gp.add(passField, 1, 1);
		
		
		gp.setPadding(new Insets(20, 20, 20, 20));
		
		sp.getChildren().addAll(login,cancel);
		sp.setPadding(new Insets(10, 10, 10, 10));
		sp.setMargin(login, new Insets(0, 10, 0, 0));
		sp.setAlignment(Pos.CENTER);
		
		vbox.getChildren().add(gp);
		vbox.getChildren().add(error);
		vbox.getChildren().add(sp);
		vbox.alignmentProperty().set(Pos.CENTER);
		mainPane.getChildren().add(vbox);
		
		
		Scene scene=new Scene(mainPane, 410, 220);
		primarystage.setTitle("Login");
		primarystage.setScene(scene);
		scene.getStylesheets().addAll(this.getClass().getResource("resources/style.css").toExternalForm());
		primarystage.getIcons().add(new Image(getClass().getResourceAsStream("Images/lock.png")));
		primarystage.show();
		
	}
	

}
