package tuan4_NganHang;

public class Array_Account {
	private Account[] arr;
	private int size;
	
	// get
	public Account getAccount (int indx) {
		return arr[indx];
	}
	
	public int getSize() {
		return size;
	}
	
	// constructor
	public Array_Account() {
		super();
		this.arr = new Account[(int)1e6+1];
		this.size = 0;
	}
	
	// hàm tìm kiếm vị trí số tài khoản trong mảng
	public int search(long accountNumber) {
		for (int i=0 ; i<size ; i++) {
			if (arr[i].getAccountNumber() == accountNumber) {
				return i;
			}
		}
		return -1;
	}
	
	// hàm thêm tài khoản
	public boolean addAccount(Account x) {
		if (search(x.getAccountNumber()) != -1) {
			return false;
		}
		arr[size] = x;
		size++;
		return true;
	}
	
	public void addAccount1 (Account x) {
		if (search(x.getAccountNumber()) != -1) {
			return;
		}
		arr[size] = x;
		size++;
	}
	
	// hàm xóa tài khoản theo số tài khoản
	public boolean deleteAccount(long x) {
		int indx = search(x);
		if (indx == -1) {
			return false;
		}
		for (int i=indx ; i<size-1 ; i++) {
			arr[i] = arr[i+1];
		}
		size--;
		return true;
	}
	
	// hàm chuyển tiền
	public boolean transfer(Account acc1, Account acc2, double amount) {
		if (search(acc2.getAccountNumber()) == -1) {
			return false;
		}
		// rút tiền acc1
		if (acc1.withdraw(amount, 50000) == false) {
			return false;
		}
		// nạp tiền acc2
		if (acc2.deposit(amount) == false) {
			acc1.setBalance(amount + acc1.getBalance());
			return false;
		}
		return true;
	}
}
