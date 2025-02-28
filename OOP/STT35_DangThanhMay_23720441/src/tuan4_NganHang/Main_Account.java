package tuan4_NganHang;

import java.util.Scanner;

public class Main_Account {
	static Array_Account arr = new Array_Account();
	static Account me = null;
	public static void main(String[] args) {
		// thêm dữ liệu mặc định
		arr.addAccount1(new Account(1,"admin", 999999999));
		arr.addAccount1(new Account(72354,"Ted Murphy", 100000));
		arr.addAccount1(new Account(69713, "Jane Smith", 40000));
		arr.addAccount1(new Account(93757, "Edward Demsey", 700000));
		
		int option = -1;
		do {
			menu();
			option = new Scanner(System.in).nextInt();
			switch (option) {
			case 0:
				signIn();
				break;
			case 1: 
				deposit();
				break;
			case 2: 
				withdraw();
				break;
			case 3: 
				transfer();
				break;
			case 4:
				addAccount();
				break;
			case 5:
				deleteAccount();
				break;
			case 6:
				signOut();
				break;
			case 7:
				print();
				break;
			}
		}
		while (option <= 7 && option >= 0);
		System.out.println("kết thúc chương trình");
	}
	
	static void menu() {
		System.out.println("0. đăng nhập");
		System.out.println("1. nạp tiền");
		System.out.println("2. rút tiền");
		System.out.println("3. chuyển tiền");
		System.out.println("4. Thêm tài khoản");
		System.out.println("5. xóa tài khoản");
		System.out.println("6. đăng xuất");
		System.out.println("7. in danh sách tài khoản");
		System.out.println("8. thoát");
	}
	
	static void signIn () {
		long stk;
		System.out.println("nhập số tài khoản của bạn");
		stk = new Scanner(System.in).nextLong();
		int indx = arr.search(stk);
		if (indx == -1) {
			System.out.println("số tài khoản chưa tồn tại");
			return;
		}
		me = arr.getAccount(indx);
		System.out.println("Đăng nhập thành công");
	}
	
	static void deposit () {
		if (me == null) {
			System.out.println("chưa đăng nhập");
			return;
		}
		double amount;
		System.out.println("nhập số tiền muốn nạp: ");
		amount = new Scanner(System.in).nextDouble();
		if (me.deposit(amount) == false) {
			System.out.println("nạp tiền thất bại");
		}
		else {
			System.out.println("nạp tiền thành công");
		}
	}
	
	static void withdraw() {
		if (me == null) {
			System.out.println("chưa đăng nhập");
			return;
		}
		double amount;
		System.out.println("nhập số tiền muốn rút: ");
		amount = new Scanner(System.in).nextDouble();
		if (me.withdraw(amount, 50000) == false) {
			System.out.println("rút tiền thất bại");
		}
		else {
			System.out.println("rút tiền thành công");
		}
	}
	
	static void transfer () {
		if (me == null) {
			System.out.println("chưa đăng nhập");
			return;
		}
		long stk;
		System.out.println("nhập số tài khoản muốn chuyển: ");
		stk = new Scanner(System.in).nextLong();
		int indx = arr.search(stk);
		if (indx == -1) {
			System.out.println("số tài khoản không tồn tại");
			return;
		}
		Account acc = arr.getAccount(indx);
		double amount;
		System.out.println("nhập số tiền muốn chuyển: ");
		amount = new Scanner(System.in).nextDouble();
		if (arr.transfer(acc, amount) == false) {
			System.out.println("chuyển tiền thất bại");
		}
		else {
			System.out.println("chuyển tiền thành công");
		}
	}
	
	static void addAccount() {
		if (me == null) {
			System.out.println("chưa đăng nhập");
			return;
		}
		if (me.getAccountNumber() != 1) {
			System.out.println("bạn không phải là admin");
			return;
		}
		long stk;
		System.out.println("nhập số tài khoản muốn thêm");
		stk = new Scanner(System.in).nextLong();
		if (arr.search(stk) != -1) {
			System.out.println("số tài khoản đã tồn tại");
			return;
		}
		String name;
		System.out.println("nhập tên");
		name = new Scanner(System.in).nextLine();
		double amount;
		System.out.println("nhập số tiền: ");
		amount = new Scanner(System.in).nextDouble();
		arr.addAccount(new Account(stk, name, amount + 50000));
	}
	
	static void deleteAccount() {
		if (me == null) {
			System.out.println("chưa đăng nhập");
			return;
		}
		if (me.getAccountNumber() != 1) {
			System.out.println("bạn không phải là admin");
			return;
		}
		long stk;
		System.out.println("nhập số tài khoản muốn xóa");
		stk = new Scanner(System.in).nextLong();
		if (arr.deleteAccount(stk) == false) {
			System.out.println("xóa thất bại");
		}
		else {
			System.out.println("xóa thành công");
		}
	}
	static void signOut() {
		me = null;
	}
	static void print() {
		if (me == null) {
			System.out.println("chưa đăng nhập");
			return;
		}
		if (me.getAccountNumber() != 1) {
			System.out.println("bạn không phải là admin");
			return;
		}
		for (int i=0 ; i<arr.getSize() ; i++) {
			System.out.println(arr.getAccount(i).toString());
		}
	}
}