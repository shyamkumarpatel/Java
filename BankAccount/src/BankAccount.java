
public class BankAccount {
	private double checkingBalance = 0.0;
	private double savingsBalance = 0.0;
	private static int numberOfAccountsCreated = 0;
	private static double totalAssetsUnderManagement = 0.0;
	
	public BankAccount(){
		numberOfAccountsCreated++;
	}
	
	public double getCheckingBalance() {
		return checkingBalance;
	}
	public double getSavingsBalance() {
		return savingsBalance;
	}
	public static double getTotalAssetsUnderManagement() {
		return totalAssetsUnderManagement;
	}
	public static int getNumberOfAccountsCreated() {
		return numberOfAccountsCreated;
	}


	private void setCheckingBalance(double checkingBalance) {
		this.checkingBalance = checkingBalance;
	}


	private void setSavingsBalance(double savingsBalance) {
		this.savingsBalance = savingsBalance;
	}

	private static void setTotalAssetsUnderManagement(double totalAmountOfMoney) {
		BankAccount.totalAssetsUnderManagement = totalAmountOfMoney;
	}
	
	public void makeDeposite(String account, double amount){
		if(account.equals("Checking")){
			setCheckingBalance(amount + getCheckingBalance());
			setTotalAssetsUnderManagement(amount + getTotalAssetsUnderManagement());
		}
		else if(account.equals("Savings")){
			setSavingsBalance(amount + getSavingsBalance());
			setTotalAssetsUnderManagement(amount + getTotalAssetsUnderManagement());
		}
	}
	
	public void makeWithdrawal(String account, double amount){
		if(account.equals("Checking")){
			if(getCheckingBalance() >= amount) {
				setCheckingBalance(getCheckingBalance() - amount);
				setTotalAssetsUnderManagement(getTotalAssetsUnderManagement() - amount);
			}
			else {
				System.out.println("Insufficient funds: Checking balance $" + getCheckingBalance());
			}
		}
		else if(account.equals("Savings")){
			if(getSavingsBalance() >= amount) {
				setSavingsBalance(getSavingsBalance() - amount);
				setTotalAssetsUnderManagement(getTotalAssetsUnderManagement() - amount);
			}
			else {
				System.out.println("Insufficient funds: Saving balance $"+getSavingsBalance());
			}
		}
	}
	
	public double totalCheckingSavingsBalance(){
		return getSavingsBalance() + getSavingsBalance();
	}
	
}
