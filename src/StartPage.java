
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

















import javax.swing.JOptionPane;

















import model.Ticket;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialogs;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.util.StringConverter;


public class StartPage {
	
	 ComboBox cb,cb1,ad,ch,type;
	 RadioButton rd1,rd2;
	 Button bt1,bt2,bt3;
	 DatePicker datepicker;
	 DatePicker datepicker1;
	 TextField datet,datet1;
	 int a,b,c,e;
	 double d;
	 double price;
	 Connection conn=null;
		ResultSet rs=null;
		PreparedStatement pst=null;
		Statement smt;
		
	
	
	
	public Scene exe(Stage primarystage){
		Pane pane =new Pane();
		VBox vb=new VBox();
		HBox hb=new HBox();
		HBox h=new HBox();
		HBox h1=new HBox();
		HBox h2=new HBox();
		GridPane gp=new GridPane();
		GridPane grid=new GridPane();
		BorderPane bp=new BorderPane();
	
		
		gp.setVgap(8);
		gp.setHgap(8);
		gp.setPadding(new Insets(20,20,20,20));
		
		grid.setVgap(8);
		grid.setHgap(8);
		grid.setPadding(new Insets(20,20,20,20));
		
		
			MenuBar menu=new MenuBar();
			menu.getStyleClass().add("bluebox");
			Menu File=new Menu("File");
			Menu Help=new Menu("Help");
			MenuItem list=new MenuItem("Administrator");
			MenuItem search=new MenuItem("Search");
			MenuItem exit=new MenuItem("Exit");
			File.getItems().addAll(list,search,exit);
			MenuItem help=new MenuItem("Help");
			Help.getItems().add(help);
			menu.getMenus().addAll(File,Help);
			//hb.getChildren().add(menu);
			bp.setTop(menu);
			
			list.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent event) {
					new Login();
					primarystage.close();
					
				}
				
			});
			search.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent event) {
					new Informationticket();
					
					
				}
				
			});
			exit.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent event) {
					System.exit(0);
					
				}
				
			});
			
			help.setOnAction(e->{
				webpage();
			});
		
			 
			
		
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	        Date date = new Date();
	        String sDate=sdf.format(date);
	        SimpleDateFormat sfd=new SimpleDateFormat ("H:mm");
	        Date time = new Date();
	        String sTimer = sfd.format(time);
	     
	        TextField tf=new TextField();
	        tf.setFocusTraversable(false);
	        tf.setText(sDate);
	        
	        TextField tf1=new TextField();
	        tf1.setFocusTraversable(false);
	        tf1.setText(sTimer);
	        
	        Text tx1=new Text("Date:");
	        tx1.setFont(Font.font("ALGERIAN", FontWeight.BOLD,FontPosture.ITALIC, 17));
	        tx1.setFill(Color.BLACK);
	        Text tx2=new Text("Time:");
	        tx2.setFont(Font.font("ALGERIAN", FontWeight.BOLD,FontPosture.ITALIC, 17));
	        tx2.setFill(Color.BLACK);
	        grid.add(tx1, 42, 0);
	        grid.add(tx2, 42, 1);
	        grid.add(tf, 43, 0);
	        grid.add(tf1, 43, 1);
	        
	        ImageView image=new ImageView(new Image("Images/flight-tickets-1.jpg"));
	        image.setFitHeight(520);
	        image.setFitWidth(860);
	        
	        ImageView image1=new ImageView(new Image("Images/alitalia_logo_big.png"));
	        vb.getChildren().add(image1);
	        vb.setTranslateY(25);
	        
	        
	        ObservableList<String> From = 
	        	    FXCollections.observableArrayList(
	        	        "Tirane","Brussels","Berlin","Frankfurt","Madrid","Paris","London",
	        	        "Milano","Monaco","Barcelona","New York","Chicago",
	        	        "Sydney","Las Angeles","Miami");
	         cb=new ComboBox(From);
	        cb.setMinSize(200,40);
	        cb.setPromptText("Enter a departure airport");
	        cb.getSelectionModel().select(0);
	        cb.setFocusTraversable(true);
	        
	        ObservableList<String> To = 
	        	    FXCollections.observableArrayList(
	        	        "Milano","Brussels","Berlin","Frankfurt","Madrid","Paris","London",
	        	        "Tirane","Monaco","Barcelona","New York","Chicago",
	        	       "Sydney","Las Angeles","Miami");
	         cb1=new ComboBox(To);
	        cb1.setPromptText("Enter a arrival airport");
	        cb1.setMinSize(200,40);
	        cb1.getSelectionModel().select(0);
	        
	        
	        Text tx3=new Text("From");
	        tx3.setFont(Font.font("ALGERIAN", FontWeight.BOLD,FontPosture.ITALIC, 15));
	        tx3.setFill(Color.BLACK);
	        Text tx4=new Text("To");
	        tx4.setFont(Font.font("ALGERIAN", FontWeight.BOLD,FontPosture.ITALIC, 15));
	        tx4.setFill(Color.BLACK);
	        gp.add(tx3, 15, 14);
	        gp.add(tx4, 16, 14);
	        gp.add(cb, 15, 15);
	        gp.add(cb1, 16, 15);
	        
	        ToggleGroup tg=new ToggleGroup();
	         rd1=new RadioButton("Round Trip     ");
	        rd1.setTextFill(Color.BLACK);
	         rd2=new RadioButton(" One-way");
	        rd2.setTextFill(Color.BLACK);
	        rd1.setToggleGroup(tg);
	        rd2.setToggleGroup(tg);
	        h1.getChildren().addAll(rd1,rd2);
	        
	        gp.add(h1, 15, 17);
	        
	         datet=new TextField();
	         datet.setMaxSize(200, 30);
	        datet.setVisible(false);
	        datet.setEditable(false);
	        datet.setId("text");
	         datet1=new TextField();
	        datet1.setVisible(false);
	        datet1.setEditable(false);
	        datet1.setId("text");
	        datet1.setMaxSize(200, 30);
	        gp.add(datet, 15, 19);
	        gp.add(datet1, 16, 19);
	       
	       
	         datepicker=new DatePicker();
	        datepicker.setPromptText("Enter a departure date");
	        datepicker.setShowWeekNumbers(true);
	        gp.add(datepicker,15 , 20);
	        datepicker.setMinSize(200, 40);
	       
	         datepicker1=new DatePicker();
	         datepicker1.setShowWeekNumbers(true);
	        datepicker1.setPromptText("Enter a return date");
	        datepicker1.setMinSize(200, 40);
	        gp.add(datepicker1,16 , 20);
	        
	        rd2.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent event) {
					datepicker1.setVisible(false);
					datet1.setVisible(false);
					
				}
	        	
	        });
	        rd1.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent event) {
					datepicker1.setVisible(true);
					
				}
	        	
	        });
	       
	        
	        Text adult=new Text("Adult         ");
	        adult.setFill(Color.BLACK);
	        adult.setFont(Font.font("ALGERIAN", FontPosture.ITALIC, 15));
	        ObservableList<String> list1 = FXCollections.observableArrayList(
	        		"1","2","3","4","5"
	        	    );
	         ad=new ComboBox(list1);
	         ad.getSelectionModel().select(0);
	        
	        
	        Text children=new Text("     Children     ");
	       children.setFont(Font.font("ALGERIAN", FontPosture.ITALIC, 15));
	        children.setFill(Color.BLACK);
	        ObservableList<String> list2 = FXCollections.observableArrayList(
        	       "0", "1","2","3","4","5"
        	    );
	         ch=new ComboBox(list2);
	         ch.getSelectionModel().select(0);
	       
	         
	        	         
	        ObservableList<String> list4 = FXCollections.observableArrayList(
        	        "Economic Class","Bussines Flexible");
	         type=new ComboBox(list4);
	         type.getSelectionModel().select(0);
	         type.setPromptText("Set your status");
	        Label Type=new Label("    Select   ");
	        Type.setFont(Font.font("ALGERIAN", FontPosture.ITALIC, 15));
	        
	        h.getChildren().addAll(adult,ad,children,ch);
	        h2.getChildren().addAll( Type,type);
	        gp.add(h, 15, 24);
	        gp.add(h2, 16, 24);
	        
	         bt1=new Button("Continue");
	        bt1.getStyleClass().add("press");
	       Tooltip tol=new Tooltip();
	       tol.setText("Continue to the next Page");
	       tol.setStyle("-fx-font: 12 arial; -fx-base: Darkgreen;");
	       bt1.setTooltip(tol);
	         bt2=new Button(" Find ");
	         Tooltip tol1=new Tooltip();
		       tol1.setText("Search for flights");
		       tol1.setStyle("-fx-font: 12 arial; -fx-base: Darkgreen;");
		       bt2.setTooltip(tol1);
	       bt2.getStyleClass().add("press");
	        bt3=new Button("Cancel");
	       bt3.getStyleClass().add("press");
	       Tooltip tol2=new Tooltip();
	       tol2.setText("Refresh the Page");
	       tol2.setStyle("-fx-font: 12 arial; -fx-base: Darkgreen;");
	       bt3.setTooltip(tol2);
	       bt3.setVisible(false);
	        grid.add(bt1,39, 45);
	        grid.add(bt2, 40, 45);
	        grid.add(bt3, 41, 45);
	        
	        bt1.setOnAction(new EventHandler<ActionEvent>(){
	        	
				@Override
				public void handle(ActionEvent event) {
					
			        Price();
			        setprice();
			        primarystage.close();
			       
			        	
				}});
	        
	        bt2.setOnAction(e->{
	        	try
	    	    {
	    	        java.lang.Class .forName("com.mysql.jdbc.Driver");
	    	        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/alitalia","root",""); 
	    	    }
	    	    catch(Exception e1)
	    	    {
	    	     System.out.println(e1.getMessage());
	    	    }
	        	
	        	try{
		            int flag=0;
		           String sql="Select * from ticket_price;";
		           smt=conn.createStatement();
		           rs=smt.executeQuery(sql);
		           String depar = cb.getSelectionModel().getSelectedItem().toString();
		           String arriv=cb1.getSelectionModel().getSelectedItem().toString();
		           
		           
		           while(rs.next())
		           {
		               if(depar.equals(rs.getString(2)) && arriv.equals(rs.getString(3)) )
		               {
		                   flag=1;
		                   break;
		               }
		           }
		           

		           if(flag==1 && depar.equals(rs.getString(2)))
		           {
		        	   find();
		        	   		bt3.setVisible(true);
		        	   		datet.setVisible(true);
		        	   		datet1.setVisible(true);
		        	   		datepicker.setVisible(false);
		        	   		datepicker1.setVisible(false);
		        	   		cb.setValue((rs.getString(2)));
		                   cb1.setValue(rs.getString(3));
		                   datet.setText(rs.getString(4));
		                   datet1.setText(rs.getString(5));
		                   
		           }else
		           JOptionPane.showMessageDialog(null, "The flight was not found");
		       }
		       catch(Exception ex){
		           JOptionPane.showMessageDialog(null, "Enter Correct Data ", "Acces Denied",JOptionPane.ERROR_MESSAGE);
		       }

	        });
	        bt3.setOnAction(e->{
	        	primarystage.setScene(new StartPage().exe(primarystage));
	        });
	         
	        
	        pane.getChildren().add(image);
	        pane.getChildren().add(grid);
	        pane.getChildren().add(hb);
	        pane.getChildren().add(vb);
	        pane.getChildren().add(gp);
	       // pane.getChildren().add(bp);
	        
	        bp.setCenter(pane);
	        
	        Scene scene=new Scene(bp,840,530);
	        primarystage.setTitle("MainPage");
	        primarystage.centerOnScreen();
	        scene.getStylesheets().addAll(this.getClass().getResource("resources/style.css").toExternalForm());
	        primarystage.setResizable(false);
	       return scene;
		
	}
	
	public void Price(){
		aer();
		if(cb.getSelectionModel().getSelectedItem().equals("Tirane")&& cb1.getSelectionModel().getSelectedItem().equals("Milano"))
		{
			a=70;
		}else if(cb.getSelectionModel().getSelectedItem().equals("Tirane")&& cb1.getSelectionModel().getSelectedItem().equals("Brussels"))
		{
			a=120;
		}else if(cb.getSelectionModel().getSelectedItem().equals("Tirane")&& cb1.getSelectionModel().getSelectedItem().equals("Berlin"))
		{
			a=140;
		}else if(cb.getSelectionModel().getSelectedItem().equals("Tirane")&& cb1.getSelectionModel().getSelectedItem().equals("Frankfurt"))
		{
			a=130;
		}else if(cb.getSelectionModel().getSelectedItem().equals("Tirane")&& cb1.getSelectionModel().getSelectedItem().equals("Paris"))
		{
			a=160;
		}else if(cb.getSelectionModel().getSelectedItem().equals("Tirane")&& cb1.getSelectionModel().getSelectedItem().equals("London"))
		{
			a=200;
		}else if(cb.getSelectionModel().getSelectedItem().equals("Milano")&& cb1.getSelectionModel().getSelectedItem().equals("London"))
		{
			a=170;
		}else if(cb.getSelectionModel().getSelectedItem().equals("Milano")&& cb1.getSelectionModel().getSelectedItem().equals("Paris"))
		{
			a=80;
		}else if(cb.getSelectionModel().getSelectedItem().equals("Milano")&& cb1.getSelectionModel().getSelectedItem().equals("Brussels"))
		{
			a=120;
		}else if(cb.getSelectionModel().getSelectedItem().equals("Milano")&& cb1.getSelectionModel().getSelectedItem().equals("Frankfurt"))
		{
			a=110;
		}else if(cb.getSelectionModel().getSelectedItem().equals("Paris")&& cb1.getSelectionModel().getSelectedItem().equals("London"))
		{
			a=100;
		}else if(cb.getSelectionModel().getSelectedItem().equals("Paris")&& cb1.getSelectionModel().getSelectedItem().equals("Milano"))
		{
			a=70;
		}else if(cb.getSelectionModel().getSelectedItem().equals("Paris")&& cb1.getSelectionModel().getSelectedItem().equals("Barcelona"))
		{
			a=100;
		}else if(cb.getSelectionModel().getSelectedItem().equals("Paris")&& cb1.getSelectionModel().getSelectedItem().equals("Chicago"))
		{
			a=900;
		}else if(cb.getSelectionModel().getSelectedItem().equals("Tirane")&& cb1.getSelectionModel().getSelectedItem().equals("Barcelona"))
		{
			a=250;
		}else if(cb.getSelectionModel().getSelectedItem().equals("Tirane")&& cb1.getSelectionModel().getSelectedItem().equals("Las Angeles"))
		{
			a=2000;
		}else if(cb.getSelectionModel().getSelectedItem().equals("Tirane")&& cb1.getSelectionModel().getSelectedItem().equals("Chicago"))
		{
			a=1200;
		}else if(cb.getSelectionModel().getSelectedItem().equals("Tirane")&& cb1.getSelectionModel().getSelectedItem().equals("New York"))
		{
			a=1400;
		}else if(cb.getSelectionModel().getSelectedItem().equals("Tirane")&& cb1.getSelectionModel().getSelectedItem().equals("Sydney"))
		{
			a=1500;
		}else{
			a=200;
		}
			price=(a+b+c+e)*d;
			Double.toString(price);
		System.out.println(price);
	
	}
	public void aer(){
		if(ad.getSelectionModel().getSelectedItem().toString().equals("1")){
			b=50;
		}else if(ad.getSelectionModel().getSelectedItem().toString().equals("2")){
			b=100;
		}else if(ad.getSelectionModel().getSelectedItem().toString().equals("3")){
			b=150;
		}else if(ad.getSelectionModel().getSelectedItem().toString().equals("4")){
			b=200;
		}else if(ad.getSelectionModel().getSelectedItem().toString().equals("5")){
			b=250;
		}else if(ad.getSelectionModel().getSelectedItem().toString().equals("6")){
			b=300;
		}
		
		if (ch.getSelectionModel().getSelectedItem().toString().equals("0")){
			c=0;
		}else if(ch.getSelectionModel().getSelectedItem().toString().equals("1")){
			c=25;
		}else if(ch.getSelectionModel().getSelectedItem().toString().equals("2")){
			c=50;
		}else if(ch.getSelectionModel().getSelectedItem().toString().equals("3")){
		c=75;
		}else if(ch.getSelectionModel().getSelectedItem().toString().equals("4")){
			c=100;
		}else if(ch.getSelectionModel().getSelectedItem().toString().equals("5")){
			c=125;
		}else if(ch.getSelectionModel().getSelectedItem().toString().equals("5")){
			c=150;
		}
		
		if(rd1.isSelected()){
			d=1.4;
		}else if(rd2.isSelected()){
			d=1;
		}
		
		if(type.getSelectionModel().getSelectedItem().toString().equals("Economic Class")){
			e=20;
		}else if(type.getSelectionModel().getSelectedItem().toString().equals("Bussines Flexible"))
			e=200;
	}
	
	public void setprice(){
		
		Stage newstage=new Stage();
		VBox vb=new VBox();
		StackPane sp=new StackPane();
		Text info=new Text(cb.getSelectionModel().getSelectedItem().toString() +" - " +cb1.getSelectionModel().getSelectedItem().toString() +"\n Price: " +price);
		info.setFill(Color.BLACK);
		info.setFont(Font.font("Times new Roman", FontWeight.BOLD, 17));;
		vb.setAlignment(Pos.CENTER);
		
		Button press=new Button("Press");
		press.getStyleClass().add("press");
		press.setOnAction(e->{
			
			if(datet.isVisible()){
				if(rd1.isSelected()){
				newstage.setScene(new Information((String)cb.getSelectionModel().getSelectedItem(),
						(String)cb1.getSelectionModel().getSelectedItem(),rd1.getText(),
						datet.getText(),datet1.getText(),
						(String)ad.getSelectionModel().getSelectedItem(),
						(String)ch.getSelectionModel().getSelectedItem(),
						(String)type.getSelectionModel().getSelectedItem(),Double.toString(price)).exe(newstage));
				
				
				}else{
				newstage.setScene(new Information((String)cb.getSelectionModel().getSelectedItem(),
						(String)cb1.getSelectionModel().getSelectedItem(),rd2.getText(),
						datet.getText(),
						(String)ad.getSelectionModel().getSelectedItem(),
						(String)ch.getSelectionModel().getSelectedItem(),
						(String)type.getSelectionModel().getSelectedItem(),Double.toString(price)).exe(newstage));
					}
				}
		else{
			if(rd1.isSelected()){
				newstage.setScene(new Information((String)cb.getSelectionModel().getSelectedItem(),
						(String)cb1.getSelectionModel().getSelectedItem(),rd1.getText(),
						datepicker.getValue().toString(),datepicker1.getValue().toString(),
						(String)ad.getSelectionModel().getSelectedItem(),
						(String)ch.getSelectionModel().getSelectedItem(),
						(String)type.getSelectionModel().getSelectedItem(),Double.toString(price)).exe(newstage));
				
				
				}else{
				newstage.setScene(new Information((String)cb.getSelectionModel().getSelectedItem(),
						(String)cb1.getSelectionModel().getSelectedItem(),rd2.getText(),
						datepicker.getValue().toString(),
						(String)ad.getSelectionModel().getSelectedItem(),
						(String)ch.getSelectionModel().getSelectedItem(),
						(String)type.getSelectionModel().getSelectedItem(),Double.toString(price)).exe(newstage));
				}
		}
	
		});
		sp.getChildren().add(press);
		sp.setAlignment(Pos.CENTER);
		vb.getChildren().addAll(info,sp);
		Scene sc=new Scene(vb,300,100);
		newstage.setTitle("Price information");
		sc.getStylesheets().addAll(this.getClass().getResource("resources/style.css").toExternalForm());
		newstage.setScene(sc);
		newstage.show();
		
    	}
	public void find(){
		Stage newstage1=new Stage();
		VBox vb=new VBox();
		StackPane sp=new StackPane();
		
		Text info=new Text("The Filght Was Found: \n "
   			+"\n" +cb.getSelectionModel().getSelectedItem().toString() +" - " +cb1.getSelectionModel().getSelectedItem().toString());
		info.setFill(Color.BLACK);
		info.setFont(Font.font("Times new Roman", FontWeight.BOLD,FontPosture.REGULAR ,17));;
		
		vb.setAlignment(Pos.CENTER);
		
		Button press=new Button("Ok");
		press.getStyleClass().add("press");
		press.setOnAction(e->{
			newstage1.close();
		});
		sp.getChildren().add(press);
		sp.setAlignment(Pos.CENTER);
		vb.getChildren().addAll(info,sp);
		Scene sc=new Scene(vb,320,150);
		newstage1.setTitle(" Flights ");
		sc.getStylesheets().addAll(this.getClass().getResource("resources/style.css").toExternalForm());
		newstage1.setScene(sc);
		newstage1.show();
		
	}
	public void webpage(){
		Stage mystage=new Stage();
		Pane pane =new Pane();
		WebView browser = new WebView();
		browser.setMaxSize(900, 800);
		WebEngine webEngine = browser.getEngine();
		webEngine.load("http://www.alitalia.com/en_en/Informazioni-Supporto/supporto/index.html");
		
		pane.getChildren().add(browser);
		
		Scene mainscene=new Scene(pane,800,600);
		mystage.setScene(mainscene);
		mystage.setTitle("WebHelp");
		mystage.show();
	}
}
		
		
	
		
	
	
	
	

