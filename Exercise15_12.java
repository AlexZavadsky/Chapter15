package chapter15;
import javafx.application.*;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class Exercise15_12 extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	public void start (Stage primaryStage) {
		primaryStage.setTitle("Mouse inside circle?");
		
		Pane pane = new Pane();
		Circle c = new Circle(750, 500, 300);
		c.setFill(null);
		c.setStroke(Color.BLACK);
		Text message = new Text("");
		pane.getChildren().addAll(c, message);
		pane.requestFocus();
		pane.setOnMouseMoved(e -> {
			if (e.getSceneX() < c.getCenterX() - c.getRadius() || e.getSceneX() > c.getCenterX() + c.getRadius() 
			|| e.getSceneY() < c.getCenterY() - c.getRadius() || e.getSceneY() > c.getCenterY() + c.getRadius()) {
				message.setText("Mouse outside circle");
			}
			else {
				message.setText("Mouse inside circle");
			}
			message.setX(e.getSceneX());
			message.setY(e.getSceneY());
		});
		
		Scene scene = new Scene(pane, 1500, 1000);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public String getMessage (Circle c, Point2D mPos) {
		if (c.contains(mPos)) {
			return "Mouse inside circle";
		}
		else {
			return "Mouse outside circle";
		}
	}
}
