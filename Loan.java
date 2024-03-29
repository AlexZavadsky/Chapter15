package chapter15;

public class Loan {
	private double annualInterestRate;
	private int numberOfYears;
	private double loanAmount;
	private java.util.Date loanDate;
	public Loan() {
		this(2.5, 1, 1000);
		}
	public Loan(double annualInterestRate, int numberOfYears,
			double loanAmount) throws IllegalArgumentException {
			if (annualInterestRate>0 && numberOfYears>0 && loanAmount>0) {
				this.annualInterestRate = annualInterestRate;
				this.numberOfYears = numberOfYears;
				this.loanAmount = loanAmount;
				loanDate = new java.util.Date();
			}
			else {
				throw new IllegalArgumentException("The arguments must be more than zero");
			}
			
			}
			
			public double getAnnualInterestRate() {
			return annualInterestRate;
			}
			
			public void setAnnualInterestRate  (double annualInterestRate)
					throws IllegalArgumentException {
				if (annualInterestRate>0) {
					this.annualInterestRate = annualInterestRate;
				}
				else {
					throw new IllegalArgumentException("The argument must be more than zero");
				}
			}
			
			public int getNumberOfYears() {
			return numberOfYears;
			}
			
			public void setNumberOfYears (int numberOfYears) 
					throws IllegalArgumentException{
				if (numberOfYears>0) {
					this.numberOfYears = numberOfYears;
				}
				else {
					throw new IllegalArgumentException("The argument must be more than zero");
				}
			}
			
			public double getLoanAmount() {
			return loanAmount;
			}
			public void setLoanAmount(double loanAmount) 
					throws IllegalArgumentException{
				if (loanAmount>0) {
					this.loanAmount = loanAmount;
				}
				else {
					throw new IllegalArgumentException("The argument must be more than zero");
				}
			}
			
			public double getMonthlyPayment() {
			double monthlyInterestRate = annualInterestRate / 1200;
			double monthlyPayment = loanAmount * monthlyInterestRate / (1 -
			(1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
			return monthlyPayment;
			}
			
			public double getTotalPayment() {
			double totalPayment = getMonthlyPayment() * numberOfYears * 12;
			return totalPayment;
			}
			
			public java.util.Date getLoanDate() {
			return loanDate;
			}
			public String toString() {
				return "Loan of " + loanAmount + " provided on " + loanDate.toString() + 
						" for " + numberOfYears + " years at an annual interest rate of " 
						+ annualInterestRate;
						
			}
}
