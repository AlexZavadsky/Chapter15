package chapter15;
import javafx.application.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.control.Button;
public class Exercise15_03 extends Application {
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	public void start(Stage primaryStage) {
		primaryStage.setTitle("Move the ball");
		BorderPane pane = new BorderPane();
		Button btLeft = new Button("Left");
		Button btRight = new Button("Right");
		Button btUp = new Button("Up");
		Button btDown = new Button("Down");
		
		HBox buttonPane = new HBox(10);
		buttonPane.getChildren().addAll(btLeft, btRight, btUp, btDown);
		CirclePane ball = new CirclePane();
		
		buttonPane.setAlignment(Pos.BOTTOM_CENTER);
		pane.setBottom(buttonPane);
		pane.setCenter(ball);
		
		
		
		Scene scene = new Scene(pane, 1500, 1000);
		btLeft.setOnAction(e -> { 
			if (ball.getBallX() - ball.getBallRadius() > 0) {
				ball.moveLeft();
			}			
		});
		btRight.setOnAction(e -> {
			if (ball.getBallX() + ball.getBallRadius() < scene.getWidth()) {
				ball.moveRight();
			}
		});
		btUp.setOnAction(e -> {
			if (ball.getBallY() - ball.getBallRadius() > 0) {
				ball.moveUp();
			}
		});
		btDown.setOnAction(e -> {
			if (ball.getBallY() + ball.getBallRadius() < scene.getHeight() - 50) {
				ball.moveDown();
			}
		});
		ball.setBallX(scene.getWidth()/2);
		ball.setBallY(scene.getHeight()/2);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	class CirclePane extends Pane {
		private Circle c = new Circle(100);
		
		public CirclePane() {
			getChildren().add(c);
			c.setFill(null);
			c.setStroke(Color.BLACK);
		}
		
		public void moveLeft() {
			c.setCenterX(c.getCenterX() - 10);
		}
		
		public void moveRight() {
			c.setCenterX(c.getCenterX() + 10);
		}
		
		public void moveUp() {
			c.setCenterY(c.getCenterY() - 10);
		}
		
		public void moveDown() {
			c.setCenterY(c.getCenterY() + 10);
		}
		
		public void setBallX(double x) {
			c.setCenterX(x);
		}
		
		public void setBallY(double y) {
			c.setCenterY(y);
		}
		
		public double getBallX() {
			return c.getCenterX();
		}
		public double getBallY() {
			return c.getCenterY();
		}
		
		public double getBallRadius() {
			return c.getRadius();
		}
		public void setBallRadius(double radius) { 
			c.setRadius(radius);
		}
	}
}
