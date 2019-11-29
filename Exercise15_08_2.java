package chapter15;
import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.text.Text;
public class Exercise15_08_2 extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	public void start (Stage primaryStage) {
	primaryStage.setTitle("Display mouse coordinates on mouse press");
		
		Pane pane = new Pane();
		Text coordinates = new Text();
		pane.getChildren().add(coordinates);
		pane.setOnMouseDragged(e -> {
			coordinates.setText("(" + e.getSceneX() + ", " + e.getSceneY() + ")");
			coordinates.setX(e.getSceneX());
			coordinates.setY(e.getSceneY());
		});
		
		pane.setOnMouseReleased(e -> {
			coordinates.setText("");
			coordinates.setX(e.getSceneX());
			coordinates.setY(e.getSceneY());
		});
		pane.requestFocus();
		Scene scene = new Scene(pane, 1500, 1000);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
