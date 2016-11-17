
import javax.swing.JOptionPane;









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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;



public class Informationticket  {
	Connection conn=null;
	ResultSet rs=null;
	PreparedStatement pst=null;
	Statement smt;
	
	
	

	public Informationticket(){
		Stage primarystage=new Stage();
		try
	    {
	        java.lang.Class .forName("com.mysql.jdbc.Driver");
	        conn = DriverManager.getConnection("jdbc:mysql://"+DatabaseConf.db_host+":3306/"+DatabaseConf.db_name, DatabaseConf.db_user, DatabaseConf.db_pass); 
	    }
	    catch(Exception e)
	    {
	     System.out.println(e.getMessage());
	    }

		Pane pane=new Pane();
		HBox hb=new HBox();
		HBox box=new HBox();
		VBox vb=new VBox();
		GridPane grid=new GridPane();
		StackPane sp=new StackPane();
		
		ImageView image=new ImageView(new Image("Images/alitalia_logo_big.png"));
		hb.getChildren().add(image);
		hb.setAlignment(Pos.TOP_LEFT);
		
		Text tx=new Text("Thank you for choosing us..");
		tx.setFill(Color.BLACK);
		tx.setFont(Font.font("Times new roman", FontWeight.BOLD, 20));
		box.getChildren().add(tx);
		box.setAlignment(Pos.CENTER);
		
		TextField cb=new TextField(""); 			Label l1=new Label("From: ");
		cb.setMinSize(170, 20);						Label l2=new Label("To : ");
		TextField cb1=new TextField("");			Label l3=new Label("Selected: ");
		cb1.setMinSize(170, 20);    				Label l4=new Label("Departure: ");
		TextField datepicker=new TextField(""); 	 Label l5=new Label("Arrival: ");
		TextField datepicker1=new TextField(""); 	Label l6=new Label("Adults: ");
		TextField rd1=new TextField("");			Label l7=new Label("Children: ");
		TextField adults=new TextField("");		Label l9=new Label("Status");
        TextField children=new TextField("");			TextField l10=new TextField("");
        cb.setEditable(false);   		children.setEditable(false);		datepicker.setEditable(false);
        cb1.setEditable(false);			adults.setEditable(false);			datepicker1.setEditable(false);
        rd1.setEditable(false);			l10.setEditable(false);
        
		Text tx1=new Text("Personal Information");
		tx1.setFill(Color.BLACK);
		tx1.setFont(Font.font("Times new roman", FontWeight.BOLD, 15));
		
		Text tx2=new Text("Credit Card information");
		tx2.setFill(Color.BLACK);
		tx2.setFont(Font.font("Times new roman", FontWeight.BOLD, 15));
		
		Label lb=new Label("First Name");
		TextField tf=new TextField();
		tf.setEditable(false);
		Label lb1=new Label("Surname");
		TextField tf1=new TextField();
		tf1.setEditable(false);
		Label lb2=new Label("Mobile Number");
		TextField tf2=new TextField();
		tf2.setEditable(false);
		Label lb3=new Label("Email");
		TextField tf3=new TextField();
		tf3.setEditable(false);
		
		Label  Card=new Label("Credit Card");
		
		TextField card=new TextField();
		card.setEditable(false);
		
		Label number=new Label("Card Number");
		TextField num=new TextField();
		num.setEditable(false);
		Label date=new Label("Expiration date");
		TextField Date=new TextField();
		Date.setEditable(false);
		Label cvv=new Label("CVV Code");
		TextField CVV=new TextField();
		CVV.setEditable(false);
		Label ne=new Label("ID");
		TextField en=new TextField();
		en.setPromptText("Enter the Id to Search");
		Label l11=new Label("Price  ");
		TextField pr=new TextField();
		pr.setEditable(false);
		Label l12=new Label("Seat Nr");
		TextField place=new TextField();
		place.setEditable(false);
		
		grid.addRow(1,ne,en);
		grid.addRow(2, l1,cb,l2,cb1,l7,children);
        grid.addRow(3, l4,datepicker,l5,datepicker1,l6,adults);
        grid.addRow(4,l3,rd1 ,l9,l10,l11,pr);
        grid.addRow(5, tx1);
        grid.addRow(6, lb,tf,lb1,tf1,l12,place);
        grid.addRow(7,lb2,tf2, lb3,tf3);
        grid.addRow(8, tx2);
        grid.addRow(9, Card,card,number,num);
        grid.addRow(10,date,Date, cvv,CVV);
        grid.setVgap(10);
		grid.setHgap(10);
		grid.setPadding(new Insets(10,10,10,10));
		grid.setAlignment(Pos.CENTER);
		
		Button search=new Button("Search");
		search.setFont(Font.font("Verdana", FontWeight.NORMAL, 21));
		search.getStyleClass().add("cancel");
		sp.getChildren().add(search);
		sp.setAlignment(Pos.CENTER);
		
		search.setOnAction(new EventHandler<ActionEvent>(){

			@Override
		public void handle(ActionEvent event) {
				try{
		            int flag=0;
		           String sql="Select * from ticket_bill1;";
		           smt=conn.createStatement();
		           rs=smt.executeQuery(sql);
		           String ID = en.getText();
		           
		           
		           while(rs.next())
		           {
		               if(ID.equals(rs.getString(1)) )
		               {
		                   flag=1;
		                   break;
		               }
		           }
		           

		           if(flag==1 && ID.equals(rs.getString(1)))
		           {
		        	   		tf.setText(rs.getString(2));
		                   tf1.setText(rs.getString(3));
		                   tf2.setText(rs.getString(4));
		                   tf3.setText(rs.getString(5));
		                   card.setText(rs.getString(6));
		                   num.setText(rs.getString(7));
		                   Date.setText(rs.getString(8));
		                   CVV.setText(rs.getString(9));
		                   cb.setText(rs.getString(10));
		                   cb1.setText(rs.getString(11));
		                   datepicker.setText(rs.getString(13));
		                   datepicker1.setText(rs.getString(14));
		                   rd1.setText(rs.getString(12));
		                   children.setText(rs.getString(15));
		                   adults.setText(rs.getString(16));
		                   l10.setText(rs.getString(17));
		                   place.setText(rs.getString(18));
		                   pr.setText(rs.getString(19));
		           }else
		           JOptionPane.showMessageDialog(null, "Id was not found");
		           
		       }
		       catch(Exception ex){
		           JOptionPane.showMessageDialog(null, "Enter Correct Data ", "Acces Denied",JOptionPane.ERROR_MESSAGE);
		       }
				
			}
		});
		
		vb.getChildren().addAll(hb,box,grid,sp);
		
		Scene scene=new Scene(vb,820,520);
		primarystage.setTitle("Information");
		primarystage.setScene(scene);
		scene.getStylesheets().addAll(this.getClass().getResource("resources/style.css").toExternalForm());
		primarystage.show();
		
		
		
	}
		
	}


