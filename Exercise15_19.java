package chapter15;
import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
public class Exercise15_19 extends Application {
	private int counter = 1;
	long startTime = System.currentTimeMillis();
	public static void main(String[] args) {
		Application.launch(args);
	}

	public void start (Stage primaryStage) {
		primaryStage.setTitle("Hand-eye coordination");
		
		Pane pane = new Pane();
		Circle c = new Circle();
		c.setFill(getRandColor());
		c.setStroke(Color.BLACK);
		pane.getChildren().add(c);
		Scene scene = new Scene(pane, 1500, 1000);
		c.setRadius(50);
		c.setCenterX(50 + Math.random()*(scene.getWidth() - 100));
		c.setCenterY(50 + Math.random()*(scene.getHeight() - 100));
		Text result = new Text();
		result.setX(scene.getWidth()/2 - 100);
		result.setY(20);
		pane.getChildren().add(result);
		c.setOnMouseClicked(e -> {
			if (counter == 20) {
				long endTime = System.currentTimeMillis();
				pane.getChildren().remove(c);
				result.setText("Time spent is " + (endTime - startTime) + " milliseconds");
			}
			c.setCenterX(50 + Math.random()*(scene.getWidth() - 100));
			c.setCenterY(50 + Math.random()*(scene.getHeight() - 100));
			c.setFill(getRandColor());
			c.setStroke(Color.BLACK);
			counter++;
		});
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static Color getRandColor() {
		return new Color(Math.random(), Math.random(), Math.random(), Math.random());
	}
}
