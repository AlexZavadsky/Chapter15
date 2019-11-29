package chapter15;
import java.util.ArrayList;
import javafx.application.*;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
public class Exercise15_17 extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	public void start (Stage primaryStage) {
		primaryStage.setTitle("Bounding rectangle");
		
		Pane pane = new Pane();
		
		Text instructions = new Text("Instructions: Left Click to Add, Right Click on Circle to remove");
		ArrayList<Circle> circleList = new ArrayList<>();
		Scene scene = new Scene(pane, 1500, 1000);
		instructions.setX(scene.getWidth()/2 - 200);
		instructions.setY(20);
		pane.getChildren().add(instructions);
		pane.setOnMouseClicked(e -> {
			switch(e.getButton()) {
			case PRIMARY: 	Circle c = new Circle(e.getSceneX(), e.getSceneY(), 25);
							c.setFill(Color.TRANSPARENT);
							c.setStroke(Color.BLACK);
							circleList.add(c);
							pane.getChildren().clear();
							pane.getChildren().addAll(circleList);
							pane.getChildren().add(instructions);
							pane.getChildren().add(getBoundBox(circleList));
							break;
			case SECONDARY: if (getCircleIndex(e.getSceneX(), e.getSceneY(), circleList) != -1) {
							circleList.remove(getCircleIndex(e.getSceneX(), e.getSceneY(), circleList));
							pane.getChildren().clear();
							pane.getChildren().addAll(circleList);
							pane.getChildren().add(instructions);
							pane.getChildren().add(getBoundBox(circleList));
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
	
	public static Rectangle getBoundBox (ArrayList<Circle> circleList) {
		if (circleList.size() == 0) {
			return null;
		}
		else {
			Circle top = circleList.get(0);
	        Circle bottom = circleList.get(0);
	        Circle right = circleList.get(0);
	        Circle left = circleList.get(0);
	        for (Circle c : circleList) {
	            if (c.getCenterX() < left.getCenterX()) left = c;
	            if (c.getCenterX() > right.getCenterX()) right = c;
	            if (c.getCenterY() > bottom.getCenterY()) bottom = c;
	            if (c.getCenterY() < top.getCenterY()) top = c;
	        }
	        
	        double width = right.getCenterX() - left.getCenterX() +  top.getRadius() * 2;
	        double height = bottom.getCenterY() - top.getCenterY() +  top.getRadius() * 2;
	        double centerX = (right.getCenterX() + left.getCenterX()) / 2;
	        double centerY = (top.getCenterY() + bottom.getCenterY()) / 2;

	        Rectangle rec = new Rectangle(centerX - width / 2, centerY - height / 2, width, height);
	        rec.setStroke(Color.BLACK);
	        rec.setFill(Color.TRANSPARENT);
	        return rec;
		}
	}
}
