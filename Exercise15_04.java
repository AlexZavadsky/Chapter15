package chapter15;
import javafx.application.*;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.*;
import javafx.scene.text.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;
import java.net.MalformedURLException;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.TextField;
import java.util.ArrayList;
import java.util.Collections;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Text;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Polyline;

import java.util.Scanner;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
public class Exercise15_04 extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	public void start (Stage primaryStage) {
		primaryStage.setTitle("Simple calculator");
		VBox pane = new VBox(20);
		HBox infoPane = new HBox(10);
		HBox buttonPane = new HBox(10);
		Label num1 = new Label("Number 1:");
		Label num2 = new Label("Number 2: ");
		Label res = new Label("Result: ");
		TextField num1Field = new TextField();
		TextField num2Field = new TextField();
		TextField resField = new TextField();
		infoPane.getChildren().addAll(num1, num1Field, num2, num2Field, res, resField);
		infoPane.setAlignment(Pos.TOP_CENTER);
		Button btAdd = new Button("Add");
		Button btSubtract = new Button("Subtract");
		Button btMultiply = new Button("Multiply");
		Button btDivide = new Button("Divide");
		buttonPane.getChildren().addAll(btAdd, btSubtract, btMultiply, btDivide);
		buttonPane.setAlignment(Pos.BOTTOM_CENTER);
		pane.getChildren().addAll(infoPane, buttonPane);
		pane.setAlignment(Pos.CENTER);
		
		btAdd.setOnAction(e-> resField.setText((Double.parseDouble(num1Field.getText()) + Double.parseDouble(num2Field.getText()) + "")));
		btSubtract.setOnAction(e -> resField.setText((Double.parseDouble(num1Field.getText()) - Double.parseDouble(num2Field.getText()) + "")));
		btMultiply.setOnAction(e -> resField.setText((Double.parseDouble(num1Field.getText())*Double.parseDouble(num2Field.getText()) + "")));
		btDivide.setOnAction(e -> resField.setText((Double.parseDouble(num1Field.getText())/Double.parseDouble(num2Field.getText()) + "")));
		
		Scene scene = new Scene(pane, 1000, 750);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
}
