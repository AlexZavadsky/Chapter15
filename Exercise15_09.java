package chapter15;
import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.shape.Polyline;
public class Exercise15_09 extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	public void start (Stage primaryStage) {
		primaryStage.setTitle("Draw lines using arrow keys");
		
		Pane pane = new Pane();
		Polyline line = new Polyline();
		
		pane.getChildren().add(line);
		Scene scene = new Scene(pane, 1000, 750);
		line.getPoints().add(scene.getWidth()/2);
		line.getPoints().add(scene.getHeight()/2);
		Text message = new Text();
		message.setX(scene.getWidth()/2 - 50);
		message.setY(30);
		pane.getChildren().add(message);
		pane.requestFocus();
		pane.setOnKeyPressed(e -> {
			double x;
			double y;
			switch (e.getCode()) {
			case UP:	message.setText("");
						x = line.getPoints().get(line.getPoints().size()-2);
						y = line.getPoints().get(line.getPoints().size()-1);
						line.getPoints().add(x);
						line.getPoints().add(y - 10);
						break;
			case DOWN: 	message.setText("");
						x = line.getPoints().get(line.getPoints().size()-2);
						y = line.getPoints().get(line.getPoints().size()-1);
						line.getPoints().add(x);
						line.getPoints().add(y + 10);
						break;
			case RIGHT:	message.setText("");
						x = line.getPoints().get(line.getPoints().size()-2);
						y = line.getPoints().get(line.getPoints().size()-1);
						line.getPoints().add(x + 10);
						line.getPoints().add(y);
						break;
			case LEFT:  message.setText("");
						x = line.getPoints().get(line.getPoints().size()-2);
						y = line.getPoints().get(line.getPoints().size()-1);
						line.getPoints().add(x - 10);
						line.getPoints().add(y);
						break;
			default: 	message.setText("Use the arrow keys");
						break;
						
			}
		});
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
