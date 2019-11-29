package chapter15;
import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
public class Exercise15_20 extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	public void start (Stage primaryStage) {
		primaryStage.setTitle("Compute angles");
		
		Circle[] vertices = new Circle[3];
		for (int i = 0; i<vertices.length; i++) {
			vertices[i] = new Circle();
			vertices[i].setFill(Color.BLACK);
			vertices[i].setRadius(5);
			vertices[i].setStroke(Color.BLACK);
		}
		
		Line[] edges = new Line[3];
		for (int i = 0; i<vertices.length; i++) {
			edges[i] = new Line();
		}
		
		Pane pane = new Pane();
		pane.getChildren().addAll(vertices);
		pane.getChildren().addAll(edges);
		
		Scene scene = new Scene(pane, 1500, 1000);
		
		for (Circle e: vertices) {
			e.setCenterX(5 + Math.random()*(scene.getWidth() - 10));
			e.setCenterY(5 + Math.random()*(scene.getHeight() - 10));
		}
		
		edges[0].startXProperty().bind(vertices[0].centerXProperty());
		edges[0].startYProperty().bind(vertices[0].centerYProperty());
		edges[0].endXProperty().bind(vertices[1].centerXProperty());
		edges[0].endYProperty().bind(vertices[1].centerYProperty());
		
		edges[1].startXProperty().bind(vertices[1].centerXProperty());
		edges[1].startYProperty().bind(vertices[1].centerYProperty());
		edges[1].endXProperty().bind(vertices[2].centerXProperty());
		edges[1].endYProperty().bind(vertices[2].centerYProperty());
		
		edges[2].startXProperty().bind(vertices[2].centerXProperty());
		edges[2].startYProperty().bind(vertices[2].centerYProperty());
		edges[2].endXProperty().bind(vertices[0].centerXProperty());
		edges[2].endYProperty().bind(vertices[0].centerYProperty());
		
		Text[] anglesTxt = new Text[3];
		for (int i = 0; i<anglesTxt.length; i++) {
			anglesTxt[i] = new Text(String.format("%.2f", getAngles(edges)[i]));
			anglesTxt[i].xProperty().bind(vertices[i].centerXProperty().add(15));
			anglesTxt[i].yProperty().bind(vertices[i].centerYProperty());
		}
		pane.getChildren().addAll(anglesTxt);
		
		vertices[0].setOnMouseDragged(e -> {
			vertices[0].setCenterX(e.getSceneX());
			vertices[0].setCenterY(e.getSceneY());
			for (int i  = 0; i<anglesTxt.length; i++) {
				anglesTxt[i].setText(String.format("%.2f", getAngles(edges)[i]));
			}
		});
		
		vertices[1].setOnMouseDragged(e -> {
			vertices[1].setCenterX(e.getSceneX());
			vertices[1].setCenterY(e.getSceneY());
			for (int i  = 0; i<anglesTxt.length; i++) {
				anglesTxt[i].setText(String.format("%.2f", getAngles(edges)[i]));
			}
		});
		
		vertices[2].setOnMouseDragged(e -> {
			vertices[2].setCenterX(e.getSceneX());
			vertices[2].setCenterY(e.getSceneY());
			for (int i  = 0; i<anglesTxt.length; i++) {
				anglesTxt[i].setText(String.format("%.2f", getAngles(edges)[i]));
			}
		});
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		
	}
	
	public static double[] getAngles (Line[] edges) {
		double x1 = edges[0].getStartX();
		double y1 = edges[0].getStartY();
		double x2 = edges[1].getStartX();
		double y2 = edges[1].getStartY();
		double x3 = edges[2].getStartX();
		double y3 = edges[2].getStartY();
		
		double a = Math.sqrt((x2 - x3) * (x2 - x3)
					+ (y2 - y3) * (y2 - y3));
		double b = Math.sqrt((x1 - x3) * (x1 - x3)
					+ (y1 - y3) * (y1 - y3));
		double c = Math.sqrt((x1 - x2) * (x1 - x2)
					+ (y1 - y2) * (y1 - y2));
				
		double[] angles = new double[3];
		
		angles[0] = Math.toDegrees(Math.acos((a * a - b * b - c * c)
				/ (-2 * b * c)));
		angles[1] = Math.toDegrees(Math.acos((b * b - a * a - c * c)
				/ (-2 * a * c)));
		angles[2] = Math.toDegrees(Math.acos((c * c - b * b - a * a)
				/ (-2 * a * b)));
		
		
		
		return angles;
	}
}
