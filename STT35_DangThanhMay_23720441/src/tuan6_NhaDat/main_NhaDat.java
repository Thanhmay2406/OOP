package tuan6_NhaDat;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class main_NhaDat {
	
	static list_GiaoDich arr = new list_GiaoDich();
	
	public static void main(String[] args) throws Exception {
		int choid = -1;
		do {
			menu();
			choid = new Scanner(System.in).nextInt();
			switch (choid) {
			case 1:
				nhapCung();
				break;
			case 2:
				nhapMem();
				break;
			case 3:
				print(0);
				break;
			case 4:
				print(1);
				break;
			case 5:
				print(2);
				break;
			case 6:
				count(0);
				break;
			case 7:
				count(1);
				break;
			case 8:
				count(2);
			case 9:
				avg(1);
				break;
			case 10:
				avg(2);
				break;
			case 11:
				del();
				break;
			}
		}
		while (choid > 0 && choid < 12);
		System.out.println("bye");
	}
	
	static void menu() {
		System.out.println("1. Nhap cung");
		System.out.println("2. Nhap mem");
		System.out.println("3. In danh sach giao dich");
		System.out.println("4. In danh sach giao dich dat");
		System.out.println("5. In danh sach giao dich nha");
		System.out.println("6. Tinh tong so luong giao dich");
		System.out.println("7. Tinh tong so luong giao dich dat");
		System.out.println("8. Tinh tong so luong giao dich nha");
		System.out.println("9. Tinh trung binh thanh tien cua giao dich dat");
		System.out.println("10. Tinh trung binh thanh tien cua giao dich nha");
		System.out.println("11. Xoa giao dich");
		System.out.println("12. Thoat");
	}
	
	static void nhapCung() throws Exception {
		arr.themGiaoDich(new giaoDichDat("001", new GregorianCalendar(2022, 5, 23), 5000, 600, "A"));
		arr.themGiaoDich(new giaoDichDat("002", new GregorianCalendar(2022, 7, 23), 4000, 600, "A"));
		arr.themGiaoDich(new giaoDichDat("003", new GregorianCalendar(2022, 6, 23), 6000, 600, "A"));
		arr.themGiaoDich(new giaoDichNha("004", new GregorianCalendar(2022, 5, 23), 70000, 400, "Cao cap", "3 Huynh Van Nghe"));
		arr.themGiaoDich(new giaoDichNha("005", new GregorianCalendar(2022, 10, 24), 6000, 300, "Thuong", "120 Phan Van Tri"));
		arr.themGiaoDich(new giaoDichNha("006", new GregorianCalendar(2022, 8, 25), 300000, 200, "Cao Cap", "3 Huynh Van Banh"));
	}
	
	static void nhapMem() throws Exception {
		System.out.println("Chọn loại giao dịch bạn muốn nhập:");
	    System.out.println("1. Giao dịch đất");
	    System.out.println("2. Giao dịch nhà");
	    
	    int choice = new Scanner(System.in).nextInt();

	    System.out.print("Nhập mã giao dịch: ");
	    String maGD = new Scanner(System.in).nextLine();

	    System.out.print("Nhập ngày giao dịch (YYYY MM DD): ");
	    int year = new Scanner(System.in).nextInt();
	    int month = new Scanner(System.in).nextInt();
	    int day = new Scanner(System.in).nextInt();

	    System.out.print("Nhập đơn giá: ");
	    double donGia = new Scanner(System.in).nextDouble();
	    
	    System.out.print("Nhập diện tích: ");
	    double dienTich = new Scanner(System.in).nextDouble();

	    if (choice == 1) {
	        System.out.print("Nhập loại đất (A/B/C): ");
	        String loaiDat = new Scanner(System.in).nextLine();
	        arr.themGiaoDich(new giaoDichDat(maGD, new GregorianCalendar(year, month - 1, day), donGia, dienTich, loaiDat));
	    } 
	    else if (choice == 2) {
	        System.out.print("Nhập loại nhà (Cao cấp/Thường): ");
	        String loaiNha = new Scanner(System.in).nextLine();
	        System.out.print("Nhập địa chỉ: ");
	        String diaChi = new Scanner(System.in).nextLine();
	        arr.themGiaoDich(new giaoDichNha(maGD, new GregorianCalendar(year, month - 1, day), donGia, dienTich, loaiNha, diaChi));
	    } 
	    else {
	        System.out.println("Lựa chọn không hợp lệ!");
	    }
	}
	
	static void xoaGiaoDich() throws Exception {
		String x;
		System.out.println("Nhap ma giao dich can xoa");
		x = new Scanner(System.in).nextLine();
		if (arr.xoaGiaoDich(x)) {
			System.out.println("Xoa thanh cong");
		}
		else {
			throw new Exception("Xoa that bai");
		}
	}
	
	static void inTieuDe() {
		for (int i=0 ; i<140 ; i++) {
			System.out.printf("-");
		}
		System.out.println();
		System.out.printf("|%-10s|%-20s|%-20s|%-20s|%-20s|%-20s|%-10s|%-10s|", "Ma GD", "Ngay GD", "Don gia", "Loai dat", "Loai nha", "Dia chi", "Dien tich", "Loai GD");
		System.out.println();
	}
	
	// in danh sach theo loai
	static void print(int type) {
		inTieuDe();
		for (giaoDich it : arr.getDS()) {
			if ((type == 1 && it instanceof giaoDichDat) || (type == 2 && it instanceof giaoDichNha) || (type == 0)) {
				System.out.println(it);
			}
		}
	}
	
	static void count(int type) {
		int x = arr.countGDD();
		int y = arr.countGDN();
		if (type == 0) {
			System.out.printf("so luong giao dich %d\n", x + y);
		}
		else if (type == 1) {
			System.out.printf("so luong giao dich dat %d\n", x);
		}
		else {
			System.out.printf("so luong giao dich nha %d\n", y);
		}
	}
	
	static void avg (int type) {
		if (type == 1) {
			System.out.printf("trung binh thanh tien cua giao dich dat %f\n", arr.avgThanhTien1());
		}
		else {
			System.out.printf("trung binh thanh tien cua giao dich nha %f\n", arr.avgThanhTien2());
		}
	}
	
	static void del () {
		System.out.println("nhap ma giao dich can xoa");
		String s = new Scanner(System.in).nextLine();
		if (arr.xoaGiaoDich(s) == true) {
			System.out.println("xoa thanh cong");
		}
		else {
			System.out.println("xoa that bai");
		}
	}
}