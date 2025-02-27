package tuan5_ChuyenXe;

import java.util.Scanner;

public class main_ChuyenXe {
	static list_ChuyenXe arr = new list_ChuyenXe();
	public static void main(String[] args) {
		int choid = -1;
		do {
			choid = new Scanner(System.in).nextInt();
			switch (choid) {
			case 1:
				add1();
				break;
			case 2:
				add2();
				break;
			case 3:
				delete();
				break;
			case 4:
				sum1();
				break;
			case 5:
				sum2();
				break;
			case 6:
				sum3();
				break;
			case 7:
				print();
				break;
			}
		}
		while (choid > 0 && choid < 8);
	}
	static void menu() {
		System.out.println("1. thêm (nhập cứng)");
		System.out.println("2. thêm (nhập mềm)");
		System.out.println("3. xóa theo má số xe");
		System.out.println("4. tính tổng doang thu");
		System.out.println("5. tính tổng doanh thu (nội thành)");
		System.out.println("6. tính tổng doanh thu (ngoại thành)");
		System.out.println("7. in danh sách chuyến xe");
		System.out.println("8. thoát");
	}
	
	static void add1 () {
		arr.them(new noiThanh(1, 1, "Nguyen Van A", 500000, 5, 120));
		arr.them(new ngoaiThanh(1, 1, "Nguyen Van B", 500000, 5, "ttt"));
	}
	
	static void add2() {
		int choid = -1;
		System.out.println("chọn loại chuyến xe muốn thêm");
		System.out.println("1. nội thành");
		System.out.println("2. ngoại thành");
		choid = new Scanner(System.in).nextInt();
		if (choid == 1) {
			int maSo, soXe, soTuyen;
			String name;
			double doanhThu, soKm;
//			int maSoChuyen, int soXe, String hoTenTaiXe, double doanhThu, int soTuyen, double soKm
			System.out.println("nhập mã số chuyến");
			maSo = new Scanner(System.in).nextInt();
			System.out.println("nhập số xe");
			soXe = new Scanner(System.in).nextInt();
			System.out.println("nhập họ tên tài xế");
			name = new Scanner(System.in).nextLine();
			System.out.println("nhập doanh thu");
			doanhThu =new Scanner(System.in).nextDouble();
			System.out.println("nhập số tuyến");
			soTuyen = new Scanner(System.in).nextInt();
			System.out.println("nhập số km");
			soKm = new Scanner(System.in).nextDouble();
			arr.them(new noiThanh(maSo, soXe, name, doanhThu, soTuyen, soKm));
		}
		else if (choid == 2) {
//			int maSoChuyen, int soXe, String hoTenTaiXe, double doanhThu, int soNgay, String noiDen
			int maSo, soXe, soNgay;
			String name, noiDen;
			double doanhThu, soKm;
			System.out.println("nhập mã số chuyến");
			maSo = new Scanner(System.in).nextInt();
			System.out.println("nhập số xe");
			soXe = new Scanner(System.in).nextInt();
			System.out.println("nhập họ tên tài xế");
			name = new Scanner(System.in).nextLine();
			System.out.println("nhập doanh thu");
			doanhThu =new Scanner(System.in).nextDouble();
			System.out.println("nhập số ngày đi");
			soNgay = new Scanner(System.in).nextInt();
			System.out.println("nhập nơi đến");
			noiDen = new Scanner(System.in).nextLine();
			arr.them(new ngoaiThanh(maSo, soXe, name, doanhThu, soNgay, noiDen));
		}
		else {
			System.out.println("nhập không hợp lệ");
		}
	}
	
	static void delete() {
		int x;
		System.out.println("nhập mã số xe");
		x = new Scanner(System.in).nextInt();
		arr.xoa(x);
	}
	
	static void sum1() {
		double ans = arr.tongDoanhThu();
		System.out.println(String.format("tổng doanh thu %f", ans));
	}
	
	static void sum2() {
		double ans = arr.tongDoanhThuNT();
		System.out.println(String.format("tổng doanh thu nội thành %f", ans));
	}
	
	static void sum3() {
		double ans = arr.tongDoanhThuNTT();
		System.out.println(String.format("tổng doanh thu ngoại thành %f", ans));
	}
	
	static void print() {
		arr.print();
	}
}