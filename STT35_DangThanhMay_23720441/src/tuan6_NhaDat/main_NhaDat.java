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
			}
		}
		while (choid > 0 && choid < 12);
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
		int choid = -1;
		System.out.println("chon loai giao dich ban muon nhap");
		System.out.println("1. Giao dich dat");
		System.out.println("2. Giao dich nha");
		choid = new Scanner(System.in).nextInt();
		if (choid == 1) {
			
		}
		else if (choid == 2) {
			
		}
		else {
			throw new Exception("nhap khong hop le");
		}
	}
	
	static void test1() throws Exception {
		
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

	static void print1() {
		inTieuDe();
		for (giaoDich it : arr) {
			
		}
	}
	
//	public static void inTieuDe() {
//		for (int i = 1; i < 140; i++) {
//			System.out.printf("-");
//		}
//		System.out.println();
//		System.out.printf("|%-10s|%-20s|%-20s|%-20s|%-20s|%-20s|%-10s|%-10s|", "Ma GD", "Ngay GD", "Don gia", "Loai dat", "Loai nha", "Dia chi", "Dien tich", "Loai GD");
//		System.out.println();
//	}
//	
//    public static void main(String[] args) throws Exception {
//    	ListGiaoDich lsgd = new ListGiaoDich();
//    	// Tao giao dich dat
//    	GiaoDich gd1 = new GiaoDichDat("001", new GregorianCalendar(2022, 5, 23), 5000, 600, "A");
//    	GiaoDich gd2 = new GiaoDichDat("002", new GregorianCalendar(2022, 7, 23), 4000, 600, "A");
//    	GiaoDich gd3 = new GiaoDichDat("003", new GregorianCalendar(2022, 6, 23), 6000, 600, "A");
//    	
//    	// Tao giao dich nha
//    	GiaoDich gd4 = new GiaoDichNha("004", new GregorianCalendar(2022, 5, 23), 70000, 400, "Cao cap", "3 Huynh Van Nghe");
//    	GiaoDich gd5 = new GiaoDichNha("005", new GregorianCalendar(2022, 10, 24), 6000, 300, "Thuong", "120 Phan Van Tri");
//    	GiaoDich gd6 = new GiaoDichNha("006", new GregorianCalendar(2022, 8, 25), 300000, 200, "Cao Cap", "3 Huynh Van Banh");
//    	
//    	// Them cac giao dich vao list
//    	lsgd.themGiaoDich(gd1);
//    	lsgd.themGiaoDich(gd2);
//    	lsgd.themGiaoDich(gd3);
//    	lsgd.themGiaoDich(gd4);
//    	lsgd.themGiaoDich(gd5);
//    	lsgd.themGiaoDich(gd6);
//    	
//    	// Xoa giao dich co ma "006"
//    	lsgd.xoaGiaoDich("006");
//    	
//    	// In cac giao dich
//    	inTieuDe();
//    	lsgd.inGiaoDich();
//    	
//    	// In thanh tien trung binh, dem tong so luong cua tung loai
//    	System.out.println("Tong so giao dich dat: " + lsgd.countGDD());
//    	System.out.println("Tong so giao dich nha: " + lsgd.countGDN());
//    	System.out.println("Thanh tien trung binh cua giao dich dat la: " + lsgd.avgThanhTien());
//    }
}