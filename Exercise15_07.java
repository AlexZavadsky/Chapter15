package chapter15;
import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
public class Exercise15_07 extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	public void start (Stage primaryStage) {
		primaryStage.setTitle("Change colour using mouse");
		
		Pane pane = new Pane();
		Circle c = new Circle();
		pane.getChildren().add(c);
		Scene scene = new Scene(pane, 500, 250);
		c.setCenterX(scene.getWidth()/2);
		c.setCenterY(scene.getHeight()/2);
		c.setRadius(Math.min(scene.getHeight()/3, scene.getWidth()/3));
		c.setFill(Color.WHITE);
		c.setStroke(Color.BLACK);
		
		c.setOnMousePressed(e -> c.setFill(Color.BLACK));
		c.setOnMouseReleased(e -> c.setFill(Color.WHITE));
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
