package chapter15;
import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.text.Text;
public class Exercise15_10 extends Application {
	private String txtContent = new String();
	public static void main(String[] args) {
		Application.launch(args);
	}

	public void start (Stage primaryStage) {
		primaryStage.setTitle("Enter and display a string");
		
		Pane pane = new Pane();
		Text txt = new Text();
		Scene scene = new Scene(pane, 1000, 750);
		txt.setX(scene.getWidth()/2 - 100);
		txt.setY(scene.getHeight()/2);
		pane.getChildren().add(txt);
		pane.requestFocus();
		pane.setOnKeyTyped(e -> {
			 txtContent+=e.getCharacter();
		});
		
		pane.setOnKeyPressed(e -> {
			switch(e.getCode()) {
			case ENTER: txt.setText(txtContent);
						txtContent = "";
						break;
			default: break;
			}
		});
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
