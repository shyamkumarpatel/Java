
public class BankAccountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount acc = new BankAccount();
		System.out.print("Number of Accounts Created:  ");
		System.out.println(BankAccount.getNumberOfAccountsCreated());

		BankAccount acc2 = new BankAccount();
		System.out.print("Number of Accounts Created:  ");
		System.out.println(BankAccount.getNumberOfAccountsCreated());
		
		System.out.print("Amount of Money in Checking: ");
		System.out.println(acc.getCheckingBalance());

		System.out.print("Amount of Money in Savings:  ");
		System.out.println(acc.getSavingsBalance());

		System.out.println("\nDeposite $420.94 in Checking.");
		acc.makeDeposite("Checking", 420.94);
		System.out.print("Amount of Money in Checking: ");
		System.out.println(acc.getCheckingBalance());


		System.out.println("\nDeposite $500.30 in Savings:  ");
		acc.makeDeposite("Savings", 500.30);
		System.out.print("Amount of Money in Savings:  ");
		System.out.println(acc.getSavingsBalance());
		
		System.out.println("\nWithdrawal $500 in Checking.");
		acc.makeWithdrawal("Checking", 500.00);
		System.out.print("Amount of Money in Checking: ");
		System.out.println(acc.getCheckingBalance());
		
		System.out.print("\nTotal amount of Money in Savings and Checking:  ");
		System.out.println(acc.totalCheckingSavingsBalance());
		
		System.out.print("\nTotal cash assets under management:  ");
		System.out.println(BankAccount.getTotalAssetsUnderManagement());

		acc2.makeDeposite("Checking", 2.32);
		System.out.print("\nTotal cash assets under management:  ");
		System.out.println(BankAccount.getTotalAssetsUnderManagement());
	}

}
