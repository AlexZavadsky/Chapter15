package chapter15;
import javafx.application.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
public class Exercise15_01 extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	public void start(Stage primaryStage) {
		primaryStage.setTitle("Pick four cards");
		Random4CardsPane cardsPane = new Random4CardsPane();
		cardsPane.setAlignment(Pos.CENTER);
		Button btRefresh = new Button("Refresh");
		VBox pane = new VBox(10);
		pane.getChildren().addAll(cardsPane, btRefresh);
		
		Scene scene = new Scene(pane, 1500, 1000);
		pane.setAlignment(Pos.CENTER);
		
		btRefresh.setOnAction(e -> cardsPane.displayCards());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
