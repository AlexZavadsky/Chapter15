package chapter15;
import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.text.Text;
public class Exercise15_06 extends Application {
	boolean isFun = true;
	public static void main(String[] args) {
		Application.launch(args);
	}

	public void start (Stage primaryStage) {
		primaryStage.setTitle("Alternate two messages");
		
		Text t1 = new Text("Java is fun");
		
		Pane pane = new Pane();
		pane.getChildren().add(t1);
		
		Scene scene = new Scene(pane, 500, 250);
		
		t1.setX(scene.getWidth()/2  - 20);
		t1.setY(scene.getHeight()/2 - 2);
	
		t1.setOnMouseClicked(e -> {
			if (isFun) {
				t1.setText("Java is powerful");
				isFun = !isFun;
			}
			
			else {
				t1.setText("Java is fun");
				isFun = !isFun;
			}
		});
		t1.requestFocus();
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
