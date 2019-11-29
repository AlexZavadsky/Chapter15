package chapter15;

public class Investment {
	private double annualInterestRate;
	private int numberOfYears;
	private double investmentAmount;
	private java.util.Date investmentDate;
	public Investment() {
		this(2.5, 1, 1000);
		}
	public Investment(double annualInterestRate, int numberOfYears,
			double investmentAmount) throws IllegalArgumentException {
			if (annualInterestRate>0 && numberOfYears>0 && investmentAmount>0) {
				this.annualInterestRate = annualInterestRate;
				this.numberOfYears = numberOfYears;
				this.investmentAmount = investmentAmount;
				investmentDate = new java.util.Date();
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
			
			public double getInvestmentAmount() {
			return investmentAmount;
			}
			public void setInvestmentAmount(double investmentAmount) 
					throws IllegalArgumentException{
				if (investmentAmount>0) {
					this.investmentAmount = investmentAmount;
				}
				else {
					throw new IllegalArgumentException("The argument must be more than zero");
				}
			}
			
			public double getFutureValue() {
			double monthlyInterestRate = annualInterestRate / 1200;
			double futureValue = investmentAmount* Math.pow(1 + monthlyInterestRate, numberOfYears*12);
			return futureValue;
			}
			
						
			public java.util.Date getInvestmentDate() {
			return investmentDate ;
			}
			public String toString() {
				return "Amount of " + investmentAmount + " invested on " + investmentDate.toString() + 
						" for " + numberOfYears + " years at an annual interest rate of " 
						+ annualInterestRate;
						
			}
}
