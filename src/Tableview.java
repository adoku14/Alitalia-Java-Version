
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import model.Ticket;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;


public class Tableview {
	Connection conn=null;
	ResultSet rs=null;
	PreparedStatement pst=null;
	Statement smt;
	private TableView table = new TableView();
	private ObservableList<ObservableList> data;

	public Tableview(){
		
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
		
		final Label label = new Label("Ticket Order");
        label.setFont(new Font("Arial", 20));
        
        Update_Table();
        
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);
 
        Scene scene=new Scene(vbox,1250,400);
        primarystage.setTitle("TableView");
        primarystage.setScene(scene);
        primarystage.show();
        
		
	}
	public void Update_Table(){
		data = FXCollections.observableArrayList();
		try{
			String sql="Select * from ticket_bill1;";
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
	
	}
	
		
	}
}
