
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Adminpage implements random{
	String Id;
	
	public Scene exe(Stage primarystage){
		
		ArrayList<TitledPane> tpanes = new ArrayList<TitledPane>();
		Accordion panes = new Accordion();
		panes.getStyleClass().add("titledpane");
		VBox admin=new VBox();
		admin.getStyleClass().add("greenbox");
		Button Change=new Button("Change Price");
		Tooltip tol=new Tooltip();
	       tol.setText("Press here to change the price");
	       tol.setStyle("-fx-font: 12 arial; -fx-base: Darkgreen;");
	       Change.setTooltip(tol);
		Change.getStyleClass().add("darkgreen");
		Button table=new Button("TableView");
		Tooltip tol1=new Tooltip();
	       tol1.setText("Click here to see ticket pre-order");
	       tol1.setStyle("-fx-font: 12 arial; -fx-base: Darkgreen;");
	       table.setTooltip(tol1);
		table.getStyleClass().add("whitebox");
		Button back=new Button("Back");
		back.getStyleClass().add("redbox");
		admin.getChildren().addAll(Change,table,back);
		
		VBox manage=new VBox();
		manage.getStyleClass().add("redbox");
		manage.setAlignment(Pos.CENTER);
		Button publish=new Button("Add Flights");
		Tooltip tol3=new Tooltip();
	       tol3.setText("Click here to add a new flight");
	       tol3.setStyle("-fx-font: 12 arial; -fx-base: Darkgreen;");
	       publish.setTooltip(tol3);
		manage.getChildren().add(publish);
		publish.setOnAction(e->{
			flight();
			primarystage.close();
		});
		
		
		table.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				new Tableview();
				
			}
			
		});
		
		Change.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				new ManageFlight();
				primarystage.close();
			}
			
		});
		
		back.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				primarystage.setScene(new StartPage().exe(primarystage));
			}
			
		});
		admin.setAlignment(Pos.CENTER);
		VBox.setMargin(Change, new Insets(0,0,10,0));
		VBox.setMargin(table, new Insets(0,0,10,0));
		TitledPane pane=new TitledPane("Administrator",admin);
		TitledPane pane1=new TitledPane("Manage Flights",manage);
		tpanes.add(pane);
		tpanes.add(pane1);
		panes.getPanes().addAll(tpanes);
		
		Scene scene=new Scene(panes,400,250);
		primarystage.setScene(scene);
		scene.getStylesheets().addAll(this.getClass().getResource("resources/style.css").toExternalForm());
		primarystage.setTitle("Administrator Page");
		return scene;
	}
	
	public void flight(){
		
		
		Stage stage=new Stage();
		HBox hbox=new HBox();
		VBox vbox=new VBox();
		GridPane grid=new GridPane();
		HBox hb=new HBox();
		random();
	ImageView image=new ImageView(new Image("Images/alitalia_logo_big.png"));
	hb.getChildren().add(image);
	hb.setAlignment(Pos.TOP_LEFT);
		ObservableList<String> From = 
        	    FXCollections.observableArrayList(
        	        "Tirane","Brussels","Berlin","Frankfurt","Madrid","Paris","London",
        	        "Milano","Monaco","Barcelona","New York","Chicago",
        	        "Sydney","Las Angeles","Miami");
		
		ObservableList<String> To = 
        	    FXCollections.observableArrayList(
        	        "Milano","Brussels","Berlin","Frankfurt","Madrid","Paris","London",
        	        "Tirane","Monaco","Barcelona","New York","Chicago",
        	       "Sydney","Las Angeles","Miami");

		Label depar=new Label("From");					ComboBox adult11=new ComboBox(From);
		Label arriv=new Label("To");	    			ComboBox adult12=new ComboBox(To);
		Label datede=new Label("departure date");		DatePicker adult13=new DatePicker();
		Label datearr=new Label("arrival date");		DatePicker adult14=new DatePicker();
		Label pri=new Label("Price");					TextField adult15=new TextField();
		
		adult13.setMinSize(200, 40);
		adult14.setMinSize(200, 40);
		
		adult11.setPromptText("Enter a departure airport");
		adult12.setPromptText("Enter a arrival airport");
		adult11.setMinSize(200,40);
		adult12.setMinSize(200,40);
		
		grid.addRow(1, depar,adult11,arriv,adult12);
		grid.addRow(2, datede,adult13,datearr,adult14);
		grid.addRow(3, pri, adult15);
		
		Button ok=new Button(" OK ");
		Button cancel=new Button("Cancel");
		ok.setOnAction(e->{
			PreparedStatement statement=null; 
	        PreparedStatement stmt=null; 
	        ResultSet resultSet=null;
	        
			 try{ 
				 
			        Class.forName("com.mysql.jdbc.Driver"); 
			        Connection connection=DriverManager.getConnection("jdbc:mysql://"+DatabaseConf.db_host+":3306/"+DatabaseConf.db_name, DatabaseConf.db_user, DatabaseConf.db_pass); 
			        statement=(PreparedStatement) 
			        connection.prepareStatement("INSERT INTO ticket_price (Id,fr,t,date1,date2,price) " + "VALUES (?,?,?,?,?,?)"); 
			        statement.setString(1, Id);
			        statement.setString(2, adult11.getSelectionModel().getSelectedItem().toString());
			         statement.setString(3,adult12.getSelectionModel().getSelectedItem().toString());
			         statement.setString(4,adult13.getValue().toString());
			         statement.setString(5,adult14.getValue().toString());
			         statement.setString(6,adult15.getText());
			         
				    
			        statement.executeUpdate();
			        statement.close();
			        connection.close();
			        JOptionPane.showMessageDialog(null, "Registration has been successful.");
			          stage.setScene(new Adminpage().exe(stage));
			        }
			         catch(Exception ex){ 
			            JOptionPane.showMessageDialog(null, ex.toString(), "Access denied",JOptionPane.ERROR_MESSAGE);
			            
			         }
		});
		
		cancel.setOnAction(e->{
			stage.setScene(new Adminpage().exe(stage));
		});
		grid.setAlignment(Pos.CENTER);
		grid.setVgap(10);
		grid.setHgap(10);
		grid.setPadding(new Insets(10,10,10,10));
		hbox.setPadding(new Insets(5, 5, 5, 5));
		hbox.setAlignment(Pos.CENTER);
		hbox.setMargin(ok, new Insets(0, 10, 0, 0));
		hbox.getChildren().addAll(ok,cancel);
		vbox.getChildren().addAll(hb,grid,hbox);
		vbox.setAlignment(Pos.TOP_CENTER);
		
		Scene sc=new Scene(vbox,600,300);
		stage.setTitle("Enter New Flight");
		sc.getStylesheets().addAll(this.getClass().getResource("resources/style.css").toExternalForm());
		stage.setScene(sc);
		stage.show();
		
	}
	public void random() {
		Random random=new Random();
		for(int i=0;i<1;i++){
			int rand=random.nextInt(10000);
			Id=Integer.toString(rand);
		}
		
	}

}
