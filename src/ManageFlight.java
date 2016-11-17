
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

import javax.swing.JOptionPane;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;


public class ManageFlight {
	
	Connection conn=null;
	ResultSet rs=null;
	PreparedStatement pst=null;
	Statement smt;
	private TableView table = new TableView();
	private ObservableList<ObservableList> data;
	
	
	public ManageFlight(){
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
		
		Update_Table();
		
        label.setFont(new Font("Arial", 20));
		
		 VBox vbox = new VBox();
		 HBox hbox=new HBox();
		 Button change=new Button("Change Price");
		 change.setOnAction(e->{
			 setPrice();
		 });
		 Button back=new Button("Back");
		 back.setOnAction(e->{
			 primarystage.setScene(new Adminpage().exe(primarystage));
		 });
		 hbox.getChildren().addAll(change,back);
		 hbox.setPadding(new Insets(5, 5, 5, 5));
		 hbox.setAlignment(Pos.CENTER);
		 hbox.setMargin(change, new Insets(0, 10, 0, 0));
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table,hbox);
 
        Scene scene=new Scene(vbox,400,300);
        primarystage.setTitle("TableView");
        primarystage.setScene(scene);
        primarystage.show();
		
	}
	
	public void Update_Table(){
		data = FXCollections.observableArrayList();
		try{
			String sql="Select * from ticket_price;";
	           smt=conn.createStatement();
	           rs=smt.executeQuery(sql);
	           
	           for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
	        	   
	           //We are using non property style for making dynamic table
	        	   
	            final int j = i;               
	        	   
	            TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
	        	   
	            col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                   
	        	   
	        	 public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {                                                                                             
	        	   
	             return new SimpleStringProperty(param.getValue().get(j).toString());                       
	        	   
	        	            }                   
	        	   
	        	       });

	                table.getColumns().addAll(col); 
	           }      
		
		while(rs.next()){
		ObservableList<String> row = FXCollections.observableArrayList();
        for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
            //Iterate Column
            row.add(rs.getString(i));
        }
       
        data.add(row);
        
    
		table.setItems(data);
    
		}
		}
catch(Exception e)
{
      e.printStackTrace();
     System.out.println(e);
	}
	
		
	}
	
	public void setPrice()
	{
		try
	    {
	        java.lang.Class .forName("com.mysql.jdbc.Driver");
	        conn = DriverManager.getConnection("jdbc:mysql://"+DatabaseConf.db_host+":3306/"+DatabaseConf.db_name, DatabaseConf.db_user, DatabaseConf.db_pass); 
	    }
	    catch(Exception e)
	    {
	     System.out.println(e.getMessage());
	    }

		
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		
		Button set = new Button("Set price");
		Button cancel = new Button("Cancel");
		
		TextField salary = new TextField();
		TextField id=new TextField();
		
		HBox hb = new HBox(set, cancel);
		VBox vb = new VBox(salary, hb);
		hb.setAlignment(Pos.CENTER);
		vb.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(vb);
		stage.setScene(scene);
		stage.show();
		
		set.setOnAction(e -> {
			try{
	            int flag=0;
	           String sql="Select * from ticket_price;";
	           smt=conn.createStatement();
	           rs=smt.executeQuery(sql);
	           String chan=salary.getText();
	           
	           rs.updateString("price", chan);
	           rs.updateRow();
	           JOptionPane.showMessageDialog(null, "Updated");

	       }
	       catch(Exception ex){
	           JOptionPane.showMessageDialog(null, "Enter Correct Data ", "Acces Denied",JOptionPane.ERROR_MESSAGE);
	       }
			
		});
		
		cancel.setOnAction(e -> {
			stage.close();
		});
	}
}


