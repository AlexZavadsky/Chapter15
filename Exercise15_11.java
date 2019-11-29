package chapter15;
import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class Exercise15_11 extends Application {
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	public void start (Stage primaryStage) {
		primaryStage.setTitle("Move a circle using arrow keys");
		CirclePane ball = new CirclePane();
		Scene scene = new Scene(ball, 1500, 1000);
		ball.setBallX(scene.getWidth()/2);
		ball.setBallY(scene.getHeight()/2);
		ball.requestFocus();
		Text message = new Text();
		message.setX(scene.getWidth()/2 - 50);
		message.setY(30);
		ball.getChildren().add(message);
		ball.setOnKeyPressed(e -> {
			switch (e.getCode()) {
			case UP:	message.setText("");
						ball.moveUp();
						break;
			case DOWN: 	message.setText("");
						ball.moveDown();
						break;
			case LEFT: 	message.setText("");
						ball.moveLeft();
						break;
			case RIGHT: message.setText("");
						ball.moveRight();
						break;			
			default: 	message.setText("Use the arrow keys to move the ball");
			break;
			}
		});
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