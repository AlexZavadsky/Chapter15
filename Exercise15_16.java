package chapter15;
import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
public class Exercise15_16 extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	public void start (Stage primaryStage) {
		primaryStage.setTitle("Two movable vertices and their distance");
		Pane pane = new Pane();
		StackPane container = new StackPane();
		Circle c1 = new Circle(40, 40, 10);
		Circle c2 = new Circle(120, 150, 10);
		c1.setFill(Color.WHITE);
		c2.setFill(Color.WHITE);
		c1.setStroke(Color.BLACK);
		c2.setStroke(Color.BLACK);
		Line connection  = new Line();
		connection.startXProperty().bind(c1.centerXProperty());
		connection.startYProperty().bind(c1.centerYProperty());
		connection.endXProperty().bind(c2.centerXProperty());
		connection.endYProperty().bind(c2.centerYProperty());
		int distance = (int) (Math.sqrt((c2.getCenterX() - c1.getCenterX())*(c2.getCenterX() - c1.getCenterX()) + (c2.getCenterY() - c1.getCenterY())*(c2.getCenterY() - c1.getCenterY())));
		Text distanceTxt = new Text(distance + "");
		distanceTxt.xProperty().bind(c1.centerXProperty().divide(2).add(c2.centerXProperty().divide(2)));
		distanceTxt.yProperty().bind(c1.centerYProperty().divide(2).add(c2.centerYProperty().divide(2)));
		pane.getChildren().addAll(connection, distanceTxt, c1, c2);
		container.getChildren().add(pane);
		Scene scene = new Scene(container, 1000, 750);
		c1.setOnMouseDragged(e -> {
			c1.setCenterX(e.getSceneX());
			c1.setCenterY(e.getSceneY());			
			distanceTxt.setText((int) (Math.sqrt((c2.getCenterX() - c1.getCenterX())*(c2.getCenterX() - c1.getCenterX()) + (c2.getCenterY() - c1.getCenterY())*(c2.getCenterY() - c1.getCenterY()))) + "");
		});
		c2.setOnMouseDragged(e -> {
			c2.setCenterX(e.getSceneX());
			c2.setCenterY(e.getSceneY());
			distanceTxt.setText((int) (Math.sqrt((c2.getCenterX() - c1.getCenterX())*(c2.getCenterX() - c1.getCenterX()) + (c2.getCenterY() - c1.getCenterY())*(c2.getCenterY() - c1.getCenterY()))) + "");
		});
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
