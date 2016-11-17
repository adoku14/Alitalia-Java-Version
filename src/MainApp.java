import javafx.application.Application;
import javafx.stage.Stage;


public class MainApp extends Application{
	
	public void start(Stage primarystage){
		primarystage.setScene(new StartPage().exe(primarystage));
		primarystage.show();
		System.out.println("Loading ...");
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
