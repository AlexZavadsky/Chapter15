package chapter15;
import javafx.application.*;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
public class Exercise15_05 extends Application {
	private TextField tfAnnualInterestRate = new TextField();
	private TextField tfNumberOfYears = new TextField();
	private TextField tfInvestmentAmount = new TextField();
	private TextField tfFutureValue = new TextField();
	private Button btCalculate = new Button("Calculate");
	public static void main(String[] args) {
		Application.launch(args);
	}

	public void start(Stage primaryStage) {
		primaryStage.setTitle("Investment calculator");
		GridPane gridPane = new GridPane();
		gridPane.setHgap(5);
		gridPane.setVgap(5);
		gridPane.add(new Label("Investment Amount:"), 0, 0);
		gridPane.add(tfInvestmentAmount, 1, 0);
		gridPane.add(new Label("Number of Years:"), 0, 1);
		gridPane.add(tfNumberOfYears, 1, 1);
		gridPane.add(new Label("Annual Interest Rate:"), 0, 2);
		gridPane.add(tfAnnualInterestRate, 1, 2);
		gridPane.add(new Label("Future Value:"), 0, 3);
		gridPane.add(tfFutureValue, 1, 3);
		gridPane.add(btCalculate, 1, 4);
		
		// Set properties for UI
		gridPane.setAlignment(Pos.CENTER);
		tfAnnualInterestRate.setAlignment(Pos.BOTTOM_RIGHT);
		tfNumberOfYears.setAlignment(Pos.BOTTOM_RIGHT);
		tfInvestmentAmount.setAlignment(Pos.BOTTOM_RIGHT);
		tfFutureValue.setAlignment(Pos.BOTTOM_RIGHT);
		tfFutureValue.setEditable(false);
		GridPane.setHalignment(btCalculate, HPos.RIGHT);
		
		// Process events
		btCalculate.setOnAction(e -> calculateFutureValue());
		
		// Create a scene and place it in the stage
		Scene scene = new Scene(gridPane, 400, 250);
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
		}
		
		private void calculateFutureValue() {
		
			// Get values from text fields
		double interest =
		Double.parseDouble(tfAnnualInterestRate.getText());
		int year = Integer.parseInt(tfNumberOfYears.getText());
		double investmentAmount =
		Double.parseDouble(tfInvestmentAmount.getText());
		
		// Create a loan object. Loan defined in Listing 10.2
		Investment inv = new Investment(interest, year, investmentAmount);
		
		// Display monthly payment and total payment
		tfFutureValue.setText(String.format("$%.2f",
		inv.getFutureValue()));
		}
		
	}

