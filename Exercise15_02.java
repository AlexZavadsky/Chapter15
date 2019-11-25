package chapter15;
import javafx.application.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.control.Button;
public class Exercise15_02 extends Application {
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	public void start (Stage primaryStage) {
		primaryStage.setTitle("Rotate a rectangle");
		
		
		Rectangle rect = new Rectangle();
		VBox pane = new VBox(100);
		pane.setAlignment(Pos.CENTER);
		Button btRotate = new Button("Rotate");
		pane.getChildren().addAll(rect, btRotate);
		Scene scene = new Scene(pane, 1500, 1000);
		rect.setX(scene.getWidth()/2 - 100);
		rect.setY(scene.getHeight()/2 - 100);
		rect.setWidth(300);
		rect.setHeight(150);
		rect.setFill(null);
		rect.setStroke(Color.BLACK);
		
		btRotate.setOnAction(e -> rect.setRotate(rect.getRotate() + 15));
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}
	
	
	
}
