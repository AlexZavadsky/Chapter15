package chapter15;
import java.util.ArrayList;
import javafx.application.*;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
public class Exercise15_15 extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	public void start (Stage primaryStage) {
		primaryStage.setTitle("Add and remove points");
		Pane pane = new Pane();
		
		ArrayList<Circle> circleList = new ArrayList<>();
		Scene scene = new Scene(pane, 1500, 1000);		
		pane.requestFocus();
		pane.setOnMouseClicked(e -> {
			switch(e.getButton()) {
			case PRIMARY: 	Circle c = new Circle(e.getSceneX(), e.getSceneY(), 25);
							c.setFill(Color.TRANSPARENT);
							c.setStroke(Color.BLACK);
							circleList.add(c);
							pane.getChildren().clear();
							pane.getChildren().addAll(circleList);
							break;
			case SECONDARY: if (getCircleIndex(e.getSceneX(), e.getSceneY(), circleList) != -1) {
							circleList.remove(getCircleIndex(e.getSceneX(), e.getSceneY(), circleList));
							pane.getChildren().clear();
							pane.getChildren().addAll(circleList);
							break;
							}
			default: break;
			}
		});
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static int getCircleIndex (double mX, double mY, ArrayList<Circle> circleList) {
		for (int i = 0; i < circleList.size(); i++) {
			if (circleList.get(i).contains(new Point2D (mX, mY))) {
				return i;
			}
		}
		return -1;
	}
	
}
