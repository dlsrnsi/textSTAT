package textSTAT;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class textSTAT extends Application{

	
	public void start(Stage primaryStage){
		Parent root;
		Scene scene;
		try{
			root= FXMLLoader.load(getClass().getResource("Controller.fxml"));
		}
		catch(Exception e){
			e.printStackTrace();
			return;
		}
		scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
		primaryStage.show();
		primaryStage.setTitle("textSTAT");
	}
	
	public static void main(String[] args){
		launch(args);
	}
}
