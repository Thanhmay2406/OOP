package tuan5_ChuyenXe;

import java.util.Scanner;
import java.util.ArrayList;

public class main_ChuyenXe {
	static list_ChuyenXe arr = new list_ChuyenXe();
	public static void main(String[] args) throws Exception {
		int choid = -1;
		do {
			menu();
			choid = new Scanner(System.in).nextInt();
			switch (choid) {
			case 1:
				add1();
				break;
			case 2:
				add2();
				break;
			case 3:
				search();
				break;
			case 4:
				print(1);
				break;
			case 5:
				print(2);
				break;
			case 6:
				print(0);
				break;
			case 7:
				delete();
				break;
			case 8:
				doanhThu(0);
				break;
			case 9:
				doanhThu(1);
				break;
			case 10:
				doanhThu(2);
				break;
			case 11:
				sort();
				break;
			}
		}
		while (choid > 0 && choid < 12);
		System.out.println("ket thuc chuong trinh");
	}
	static void menu() {
		System.out.println("1. thêm (nhập cứng)");
		System.out.println("2. thêm (nhập mềm)");
		System.out.println("3. tim kiem");
		System.out.println("4. in danh sach chuyen xe noi thanh");
		System.out.println("5. in danh sach chuyen xe ngoai thanh");
		System.out.println("6. in danh sach chuyen xe");
		System.out.println("7. xoa chuyen xe");
		System.out.println("8. tinh tong doanh thu chuyen xe");
		System.out.println("9. tinh tong doanh thu noi thanh");
		System.out.println("10. tinh tong doanh thu ngoai thanh");
		System.out.println("11. sap xep theo ma so chuyen");
		System.out.println("12. thoat");
	}
	
	static void add1 () throws Exception {
		arr.them(new noiThanh(1, 1, "Nguyen Van A", 500000, 5, 120));
		arr.them(new ngoaiThanh(1, 1, "Nguyen Van B", 500000, 5, "ttt"));
	}
	
	static void add2() throws Exception {
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
	
	static void search() throws Exception {
		int x;
		System.out.println("nhap ma so xe can tim kiem");
		x = new Scanner(System.in).nextInt();
		if (arr.timKiemViTri(x) == -1) {
			throw new Exception("khong tim thay");
		}
		else {
			System.out.println(arr.getval(x).toString());
		}
	}
	
	static void print(int type) {
		for (chuyenXe it : arr.getChuyenXe()) {
			if ((type == 1 && it instanceof noiThanh) || (type == 2 && it instanceof ngoaiThanh) || type == 0) {
				System.out.println(it);
			}
		}
	}
	
	static void delete() {
		int x;
		System.out.println("nhập mã số xe");
		x = new Scanner(System.in).nextInt();
		arr.xoa(x);
	}
	
	static void doanhThu (int type) {
		if (type == 0) {
			System.out.printf("tong doanh thu %f\n", arr.getDoanhThu());
		}
		else if (type == 1) {
			System.out.printf("tong doanh thu noi thanh %f\n", arr.getDoanhThuNoiThanh());
		}
		else {
			System.out.printf("tong doanh thu ngoai thanh %f\n", arr.getDoanhThuNgoaiThanh());
		}
	}
	
	static void sort() {
		arr.sort();
	}
	
}