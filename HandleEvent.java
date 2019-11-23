package chapter15;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
public class HandleEvent extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	public void start (Stage primaryStage) {
		HBox pane = new HBox(10);
		pane.setAlignment(Pos.CENTER);
		Button btOK = new Button("OK");
		Button btCancel = new Button("Cancel");
		OKHandler handler1 = new OKHandler();
		btOK.setOnAction(handler1);
		CancelHandler handler2 = new CancelHandler();
		btCancel.setOnAction(handler2);
		pane.getChildren().addAll(btOK, btCancel);
		
		Scene scene = new Scene(pane);
		primaryStage.setTitle("HandleEvent"); 
		primaryStage.setScene(scene); 
		primaryStage.show(); 
	}
}
