package chapter15;
import javafx.application.*;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class Exercise15_14 extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	public void start (Stage primaryStage) {
		primaryStage.setTitle("Inside polygon?");
		
		Pane pane = new Pane();
		Polygon p = new Polygon(40, 20, 70, 40, 60, 80, 45, 45, 20, 60);
		p.setFill(Color.TRANSPARENT);
		p.setStroke(Color.BLACK);
		Text message = new Text("");
		pane.getChildren().addAll(p, message);
		Scene scene = new Scene(pane, 1000, 750);
		pane.requestFocus();
		pane.setOnMouseMoved(e -> {
			if (p.contains(new Point2D(e.getSceneX(), e.getSceneY()))) {
				message.setText("Mouse inside polygon");
			}
			else {
				message.setText("Mouse outside polygon");
			}
			message.setX(e.getSceneX());
			message.setY(e.getSceneY());
		});
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
