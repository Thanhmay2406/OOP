package tuan4_NganHang;

public class Account 
{
	private long accountNumber; //số tài khoản
	private String name; //tên tài khoản
	private double balance; //số tiền
	private static final double RATE = 0.035; // hằng số lãi suất
	
	// get và set
	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	// constructor
	public Account() {
		this.accountNumber = 999999;
		this.name = "chưa xác định";
		this.balance = 50000;
	}

	public Account(long accountNumber, String name, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
	}

	public Account(long accountNumber, String name) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = 50000;
	}
	
	// hàm nạp tiền
	public boolean deposit(double amount) {
		if (amount > 0) {
			this.balance += amount;
			return true;
		}
		return false;
	}
	
	// hàm rút tiền
	public boolean withdraw(double amount, double fee) {
		if (amount > 0 && amount + fee <= this.balance) {
			this.balance -= amount;
			return true;
		}
		return false;
	}
	
	// hàm tính tiền lãi
	public double addInterest() {
		return this.balance + this.balance * RATE;
	}
	
	// ham chuyen khoan
	public boolean transfer (Account acc2, double amount) {
		if (withdraw(amount, 50000) == false) {
			return false;
		}
		if(acc2.deposit(amount) == false) {
			return false;
		}
		return true;
	}

	// hàm trả về chuỗi chứa thông tin
	@Override
	public String toString() {
		String ans = String.format("so tai khoan: %d\t ten: %s\t so tien: %ld", this.accountNumber, this.name, this.balance);
		return ans;
	}
}
