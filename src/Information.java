	
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Random;



public class Information implements random {
	
	
	String from,to,rd,date1,date2,a,ch,type;
	String price;
	ToggleButton[][] matrix;
	int rand;
	String id;
	TextField tf,tf1,tf2,tf3,num,CVV,pr;
	DatePicker Date;
	ComboBox card;
	String plac;
	Connection conn=null;
	ResultSet rs=null;
	PreparedStatement pst=null;
	Statement smt;
	
	
	 
	public Information(String from, String to, String rd, String date1,
			String date2, String a, String ch,String type,String price) {
		super();
		this.from = from;
		this.to = to;
		this.rd = rd;
		this.date1 = date1;
		this.date2 = date2;
		this.a = a;
		this.ch = ch;
		this.price=price;
		this.type=type;
	}

	
	public Information(String from, String to, String rd, String date1,
			String a, String ch,String type,String price) {
		super();
		this.from = from;
		this.to = to;
		this.rd = rd;
		this.date1 = date1;
		this.a = a;
		this.ch = ch;
		this.price=price;
		this.type=type;
	}


	public Scene exe(Stage primarystage){
		
		HBox hb=new HBox();
		VBox vb=new VBox();
		HBox box=new HBox();
		HBox h=new HBox();
		HBox hbox=new HBox();
		GridPane grid=new GridPane();
		HBox sp=new HBox();
				
		random();
		ImageView image=new ImageView(new Image("images/alitalia_logo_big.png"));
		hb.getChildren().add(image);
		hb.setAlignment(Pos.TOP_LEFT);
		
		Text tx=new Text("Thank you for choosing us..");
		tx.setFill(Color.BLACK);
		tx.setFont(Font.font("Times new roman", FontWeight.BOLD, 20));
		box.getChildren().add(tx);
		box.setAlignment(Pos.CENTER);
		
		TextField cb=new TextField(from); 			Label l1=new Label("From: ");
		cb.setMinSize(170, 20);						Label l2=new Label("To : ");
		TextField cb1=new TextField(to);			Label l3=new Label("Selected: ");
		cb1.setMinSize(170, 20);    				Label l4=new Label("Departure: ");
		TextField datepicker=new TextField(date1);  Label l5=new Label("Arrival: ");
		TextField datepicker1=new TextField(date2); Label l6=new Label("Adults: ");
		TextField rd1=new TextField(rd);			Label l7=new Label("Children: ");
													
        TextField children=new TextField(ch);		    Label l9=new Label("Status");
        TextField adults=new TextField(a);        TextField l10=new TextField(type);
         pr=new TextField(price+" $");		    Label l11=new Label("Price");
       
        cb.setEditable(false);   		children.setEditable(false);		datepicker.setEditable(false);
        cb1.setEditable(false);			adults.setEditable(false);			datepicker1.setEditable(false);
        rd1.setEditable(false);			l10.setEditable(false);				pr.setEditable(false);
        
		Text tx1=new Text("Personal Information");
		tx1.setFill(Color.BLACK);
		tx1.setFont(Font.font("Times new roman", FontWeight.BOLD, 15));
		
		
		Text tx2=new Text("Card information");
		tx2.setFill(Color.BLACK);
		tx2.setFont(Font.font("Times new roman", FontWeight.BOLD, 15));
		
		
		Label lb=new Label("First Name");
		 tf=new TextField();
		tf.setFocusTraversable(true);
		tf.setPromptText("Enter your name");
		Label lb1=new Label("Surname");
		 tf1=new TextField();
		tf1.setPromptText("Enter your surname");
		Label lb2=new Label("Mobile Number");
		 tf2=new TextField();
		tf2.setPromptText("Enter your mobile number");
		Label lb3=new Label("Email");
		 tf3=new TextField();
		tf3.setPromptText("Enter your Email");
		
		Label  Card=new Label("Credit Card");
		 ObservableList<String> Credit = 
	        	    FXCollections.observableArrayList("Visa","MasterCard",
	        	    		"American Express","Visa Electron");
		 card=new ComboBox(Credit);
		card.setPromptText("Select your Credit Card");
		
		Label number=new Label("Card Number");
		 num=new TextField();
		num.setPromptText("Enter your Credit card number");
		Label date=new Label("Expiration date");
		 Date=new DatePicker();
		Date.setPromptText("Enter Expiration date");
		Label cvv=new Label("CVV Code");
		 CVV=new TextField();
		CVV.setPromptText("Enter CVV Code ");
		
		Label B=new Label("Adult 2");    
		Label C=new Label("Adult 3");	 
		Label D=new Label("Adult 4");	 
		Label E=new Label("Adult 5");	
		Label F=new Label("Adult 6");
		
		Label B1=new Label("Children 1");    
		Label C1=new Label("Children 2");	 
		Label D1=new Label("Children 3");	 
		Label E1=new Label("Children 4");	
		Label F1=new Label("Children 5");

		TextField adult1=new TextField();		
		TextField adult2=new TextField();	    
		TextField adult3=new TextField();		
		TextField adult4=new TextField();	
		TextField adult5=new TextField();		
		
		TextField Children1=new TextField();		
		TextField Children2=new TextField();	    
		TextField Children3=new TextField();		
		TextField Children4=new TextField();		
		TextField Children5=new TextField();		
		
if (a.equals("5")){
	F.setVisible(false)	;adult5.setVisible(false); 	
		}else if (a.equals("4")){
			E.setVisible(false);	adult4.setVisible(false); 	 
			F.setVisible(false);	adult5.setVisible(false); 	
		}else if (a.equals("3")){
			D.setVisible(false);	adult3.setVisible(false); 	
			E.setVisible(false);	adult4.setVisible(false); 	
			F.setVisible(false);adult5.setVisible(false); 	
		}else if (a.equals("2")){
			C.setVisible(false);	adult2.setVisible(false); 
			D.setVisible(false);	adult3.setVisible(false); 	
			E.setVisible(false);adult4.setVisible(false); 
			F.setVisible(false);adult5.setVisible(false); 	
		}else{
			B.setVisible(false);adult1.setVisible(false); 
			C.setVisible(false);adult2.setVisible(false); 	
			D.setVisible(false);adult3.setVisible(false);
			E.setVisible(false);adult4.setVisible(false); 	
			F.setVisible(false);adult5.setVisible(false); 	
		}
		
if (ch.equals("5")){
	
		}else if (ch.equals("4")){
			F1.setVisible(false);	Children5.setVisible(false); 	
		}else if (ch.equals("3")){
			E1.setVisible(false);	Children4.setVisible(false); 	
			F1.setVisible(false);   Children5.setVisible(false); 	
		}else if (ch.equals("2")){
			D1.setVisible(false);	Children3.setVisible(false); 	
			E1.setVisible(false);   Children4.setVisible(false); 	
			F1.setVisible(false);   Children5.setVisible(false); 	
		}else if (ch.equals("1")){
			C1.setVisible(false);   Children2.setVisible(false); 	
			D1.setVisible(false);   Children3.setVisible(false); 	
			E1.setVisible(false);   Children4.setVisible(false); 	
			F1.setVisible(false);   Children5.setVisible(false); 	
		}else{
		
			B1.setVisible(false);   Children1.setVisible(false); 	
			C1.setVisible(false);   Children2.setVisible(false); 	
			D1.setVisible(false);   Children3.setVisible(false); 	
			E1.setVisible(false);   Children4.setVisible(false); 	
			F1.setVisible(false);   Children5.setVisible(false); 	
		}
		tf2.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> arg0,String arg1, String newValue) {
			if(!isNumeric(newValue)){
				JOptionPane.showMessageDialog(null, "Only numbers are allowed");
			     tf2.setText("");
			} else {
			if(newValue.length() >= 12){
			     tf2.setText(newValue.substring(0, 12));
			}
			}
			}
			          });
	
		num.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> arg0,String arg1, String newValue) {
			if(!isNumeric(newValue)){
				JOptionPane.showMessageDialog(null, "Only numbers are allowed.Please Enter 16 number");
			      num.setText("");
			} else {
			if(newValue.length() >= 16){
			     num.setText(newValue.substring(0, 16));
			}
			}
			}
			          });
		
		CVV.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> arg0,String arg1, String newValue) {
			if(!isNumeric(newValue)){
				JOptionPane.showMessageDialog(null, "Only numbers are allowed. Please enter 3 numbers");
			     CVV.setText("");
			} else {
			if(newValue.length() >= 3){
			     CVV.setText(newValue.substring(0, 3));
			}
			}
			}
			          });
		
		grid.addRow(1, l1,cb,l2,cb1,l3,rd1);
        grid.addRow(2, l4,datepicker,l5,datepicker1,l6,adults);
        grid.addRow(3, l7,children,l9,l10,l11,pr);
        grid.addRow(4, tx1);
        grid.addRow(5, lb,tf,lb1,tf1,B,adult1);
        grid.addRow(6,lb2,tf2, lb3,tf3,C,adult2);
        grid.addRow(7, tx2);
        grid.addRow(8, Card,card,number,num,D,adult3);
        grid.addRow(9,date,Date, cvv,CVV,E,adult4);
        grid.addRow(12,B1,Children1,C1,Children2,F,adult5);
        grid.addRow(13,D1,Children3,E1,Children4,F1,Children5);
        grid.setVgap(8);
		grid.setHgap(8);
		grid.setPadding(new Insets(5,5,5,5));
		grid.setAlignment(Pos.CENTER);
		
		Button order=new Button("Pre-Order");
		order.getStyleClass().add("press");
		Button backup=new Button("Back");
		Tooltip tol=new Tooltip();
	       tol.setText("Back to the StartPage");
	       tol.setStyle("-fx-font: 12 arial; -fx-base: Darkgreen;");
	       backup.setTooltip(tol);
		backup.getStyleClass().add("press");
		sp.getChildren().addAll(order,backup);
		sp.setPadding(new Insets(10, 10, 10, 10));
		sp.setMargin(order, new Insets(0, 10, 0, 0));
		sp.setAlignment(Pos.CENTER);
		
		order.setOnAction(new EventHandler<ActionEvent>(){

			@Override
		public void handle(ActionEvent event) {
				matrix();
				primarystage.close();
			}
		});
		backup.setOnAction(e->{
			primarystage.setScene(new StartPage().exe(primarystage));
			primarystage.centerOnScreen();
		});
		
		
		//Color.ALICEBLUE
		vb.getChildren().addAll(hb,box,grid,sp);
		
		vb.setAlignment(Pos.TOP_CENTER);
		//pane.getChildren().addAll(vb);
		
		Scene scene=new Scene(vb,900,550);
		primarystage.setTitle("Information");
		primarystage.setScene(scene);
		scene.getStylesheets().addAll(this.getClass().getResource("resources/style.css").toExternalForm());
		primarystage.centerOnScreen();
		return scene;
		
		
	}
	private boolean isNumeric(String str) {
		return str.matches("-?\\d+(.\\d+)?");
		}
	
	public void matrix(){
		Stage mystage=new Stage();
		GridPane ma=new GridPane();
		StackPane st=new StackPane();
		VBox vbox=new VBox();
		
		int length = 9;
	    int width =9;
	    
	   
	   	matrix = new ToggleButton[width][length]; 
	   	boolean select=true; In zb=new In(0);
		for( int y = 0; y < length; y++)
	    {
	            for(int x = 0; x < width; x++)
	            {
	            	
	                matrix[x][y] = new ToggleButton();     
	                matrix[x][y].setText((x+1)+ " " + (y+1) );  
	                Label A=new Label("          ");
	                ma.add(matrix[x][y], x, y);
	                
	                ma.addColumn(0, A);
	                ma.getRowConstraints().add(new RowConstraints(25));     
	                ma.getRowConstraints().add(new RowConstraints(25));       
	                ma.getRowConstraints().add(new RowConstraints(25));     
	                ma.getRowConstraints().add(new RowConstraints(50));     
	                ma.getRowConstraints().add(new RowConstraints(5));     
	                ma.getRowConstraints().add(new RowConstraints(48));     
	                ma.getRowConstraints().add(new RowConstraints(25));     
	                ma.getRowConstraints().add(new RowConstraints(25));    
	                ma.getRowConstraints().add(new RowConstraints(25));     
	                
	                final int t1=x,t2=y; 
	                matrix[x][y].setOnMouseClicked(e-> {
	                	int l=zb.o+1;
	                	if(l<Integer.parseInt(a)) { 
	                		matrix[t1][t2].setStyle("-fx-base: #ff0000;");
	                	} else if(select ||l==Integer.parseInt(a)) {
		                	for(int  i = 0; i < length; i++)
		            	    {
		            	            for(int j =0; j < width; j++)
		            	            { 	
		            	            	if(t1==i&&j==t2){
		            	            		matrix[t1][t2].setStyle("-fx-base: #ff0000;");
		            	            	}
		            	            	else if(matrix[t1][t2].isSelected()){
		            	            		matrix[i][j].setDisable(true);
		            	          
		            	            	} else
		            	            		matrix[i][j].setDisable(false);
		            	            }
		            	    }
	                	} else {
	                		for(int  i = 0; i < length; i++)
		            	    {
		            	            for(int j =0; j < width; j++)
		            	            { 
		            	            	matrix[i][j].setDisable(false);
		            	            }
		            	    }
	                	}
	                	
	                	plac=t1+""+t2;
	                	System.out.println("Selected :"+plac);
	                });
	               
	                
	            }
	           
	     }
		 
		Button pre=new Button("Pre-Order");
		Tooltip tol=new Tooltip();
	       tol.setText("Pre-Order the ticket");
	       tol.setStyle("-fx-font: 12 arial; -fx-base: Darkgreen;");
	       pre.setTooltip(tol);
		pre.getStyleClass().add("press");
		pre.setOnAction(e ->{
			PreparedStatement statement=null; 
	        PreparedStatement stmt=null; 
	        ResultSet resultSet=null;
	        
			 try{ 
				 
			        Class.forName("com.mysql.jdbc.Driver"); 
			        Connection connection=DriverManager.getConnection("jdbc:mysql://"+DatabaseConf.db_host+":3306/"+DatabaseConf.db_name, DatabaseConf.db_user, DatabaseConf.db_pass); 
			        statement=(PreparedStatement) 
			        connection.prepareStatement("INSERT INTO ticket_bill1 (ID,firstname,surname,mobnumber,email,creditcard,cardnumber,date,cvv,departure,arrival,trip,depar,arriv,adult,child,status,place,Price) " + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"); 

			        statement.setString(1, id);
			         statement.setString(2,tf.getText());
			         statement.setString(3,tf1.getText());
			         statement.setString(4,tf2.getText());
			         statement.setString(5,tf3.getText());
			         statement.setObject(6,card.getSelectionModel().getSelectedItem());
			         statement.setString(7,num.getText());
			         statement.setObject(8,Date.getValue().toString());
			         statement.setString(9,CVV.getText());
			         statement.setString(10, from);
				     statement.setString(11, to);
				     statement.setString(12, rd);
				     statement.setString(13, date1);
				     statement.setString(14, date2);
				     statement.setString(15, a);
				     statement.setString(16, ch);
				     statement.setString(17, type);
				     statement.setString(18, plac);
				     statement.setString(19, price);
				    
			        statement.executeUpdate();
			        statement.close();
			        connection.close();
			        JOptionPane.showMessageDialog(null, "Registration has been successful.");
			          mystage.setScene(new StartPage().exe(mystage));
			        }
			         catch(Exception ex){ 
			            JOptionPane.showMessageDialog(null, ex.toString(), "Access denied",JOptionPane.ERROR_MESSAGE);
			         }
			 email();
			 
		});

		HBox hb=new HBox();
		HBox hbox=new HBox();
		Label select1=new Label();
		select1.setText("Choose your Seat!");
		select1.setId("actiontarget");
		select1.setFont(Font.font("Book Antiqua", FontWeight.BOLD, FontPosture.ITALIC, 20));
		
		ma.setAlignment(Pos.BOTTOM_CENTER);
		hb.setPadding(new Insets(10, 10, 10, 10));
		hb.setMargin(pre, new Insets(0, 10, 0, 0));
		hb.setAlignment(Pos.CENTER_RIGHT);
		hb.getChildren().add(pre);
		hbox.setPadding(new Insets(10, 10, 20, 10));
		hbox.setMargin(select1, new Insets(0, 10, 0, 0));
		hbox.setAlignment(Pos.CENTER);
		hbox.getChildren().add(select1);
		vbox.getChildren().addAll(hb,hbox,ma);
		//vbox.setAlignment(Pos.CENTER);
		
		Scene sc=new Scene(vbox,400,400);
		mystage.setTitle("Choose your place");
		mystage.setScene(sc);
		sc.getStylesheets().addAll(this.getClass().getResource("resources/style.css").toExternalForm());
		mystage.setResizable(false);
		mystage.show();
	}
	public void email(){
		  final String username = "alitaliaal@gmail.com";
			final String password = "unicit12";

			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");
	                Session session = Session.getInstance(props,
			  new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			  });
	                  try {

				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress("alitaliatickets@gmail.com"));
				message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(tf3.getText()));
				message.setSubject("Alitalia Ticket");
				message.setContent("<center><h1><b>Alitalia Ticket Information</h1></b>"
	                                + "<p><strong>Dear&nbsp;</strong>" + tf.getText()+" " + tf1.getText() +"</p>"
	                                + "<p><strong>We have received you Ticket Pre-Order.</strong></p>"
	                                + "<p><strong>Your Pre-Order Information:</strong></p>"
	                                + "<p><strong>First Name:&nbsp;</strong>" + tf.getText() +"</p>"
	                                + "<p><strong>Last Name:&nbsp;</strong>"  + tf1.getText() +"</p>"
	                                + "<p><strong>E-mail:&nbsp;</strong>"   + tf3.getText() +"</p>"
	                                + "<p><strong>Mob.Number:&nbsp;</strong>"  + tf2.getText() +"</p>"
	                                + "<p><strong>Departure:&nbsp;</strong>" + from+"</p>"
	                                + "<p><strong>Arrival:&nbsp;</strong>" + to+"</p>"
	                                + "<p><strong>Trip selected:&nbsp;</strong>" + rd+"</p>"
	                                + "<p><strong>DAte of departure:&nbsp;</strong>" + date1+"</p>"
	                                + "<p><strong>Date of Arrival:&nbsp;</strong>" + date2+"</p>"
	                                + "<p><strong>Price:&nbsp;</strong>" + pr.getText() + "</p>"
	                                 + "<p><strong>Seat Number &nbsp;</strong>" + plac +"</p>"
	                                + "<p><strong>Other Information</strong></p>"
	                                + "<p><strong>Adult:&nbsp;</strong>"   + a +"</p>"
	                                + "<p><strong>Children:&nbsp;</strong>"  + ch +"</p>"
	                                + "<p><strong>Status:&nbsp;</strong>"   + type +"</p>"
	                                + "<p><strong>Credit Card Information</strong></p>"
	                                + "<p><strong>Select Credit Card &nbsp;</strong>" + card.getSelectionModel().getSelectedItem().toString() +"</p>"
	                                + "<p><strong>Credit Card Number &nbsp;</strong>" + num.getText() +"</p>"
	                                + "<p><strong>Expiration Date &nbsp;</strong>" + Date.getValue().toString()  +"</p>"
	                                + "<p><strong>CVV Code &nbsp;</strong>" + CVV.getText() +"</p>"
	                               
	                                + "<p><h1><b>Thank for choosing ALITALIA!</h1></b></p></center>", "text/html");


				Transport.send(message);



	                        
	                JOptionPane.showMessageDialog(null, "   You will be contacted by the Mob.Number\n"
	                		+ "that you provided above to validate your order \n       "
	                		+ "      Your Mob.Number: " +
	                        tf2.getText());
				

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
	}
	
	public void random(){
		Random random=new Random();
		for(int i=0;i<1;i++){
			int rand=random.nextInt(10000);
			id=Integer.toString(rand);
		}
	}
}
		
	
class In{
	int o;
	In(int o){ this.o=o; }
	//In(String a) {this.b=a;}
	
}

