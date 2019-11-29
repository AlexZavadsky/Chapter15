package chapter15;
import javafx.application.*;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class Exercise15_13 extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	public void start (Stage primaryStage) {
		primaryStage.setTitle("Inside rectangle?");
		
		Pane pane = new Pane();
		Rectangle r = new Rectangle(100, 60, 100, 40);
		r.setFill(Color.TRANSPARENT);
		r.setStroke(Color.BLACK);
		Text message = new Text("");
		pane.getChildren().addAll(r, message);
		Scene scene = new Scene(pane, 1000, 750);
		pane.requestFocus();
		pane.setOnMouseMoved(e -> {
			if (r.contains(new Point2D(e.getSceneX(), e.getSceneY()))) {
				message.setText("Mouse inside rectangle");
			}
			else {
				message.setText("Mouse outside rectangle");
			}
			message.setX(e.getSceneX());
			message.setY(e.getSceneY());
		});
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
}
