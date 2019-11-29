package chapter15;
import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
public class Exercise15_18 extends Application {

	public static void main(String[] args) {
		Application.launch(args); 
	}

	public void start (Stage primaryStage) {
		primaryStage.setTitle("Move rectangle with mouse");
		
		Pane pane = new Pane();
		Rectangle rec = new Rectangle();
		pane.getChildren().add(rec);
		Scene scene = new Scene(pane, 1500, 1000);
		rec.setWidth(200);
		rec.setHeight(150);
		rec.setX(scene.getWidth()/2 - rec.getWidth()/2);
		rec.setY(scene.getHeight()/2 - rec.getHeight()/2);
		rec.setFill(Color.TRANSPARENT);
		rec.setStroke(Color.BLACK);
		rec.setOnMouseDragged(e -> {
			rec.setX(e.getSceneX() - rec.getWidth()/2);
			rec.setY(e.getSceneY() - rec.getHeight()/2);
		});
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
}
