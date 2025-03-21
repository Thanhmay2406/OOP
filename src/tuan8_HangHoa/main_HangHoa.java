package tuan8_HangHoa;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;


public class main_HangHoa {
	static QuanLyHangHoa ls = new QuanLyHangHoa();
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
				del();
				break;
			case 4:
				fix();
				break;
			case 5:
				hienThiDanhSach();
				break;
			case 6:
				hienThiHangThucPhamKhoBan();
				break;
			}
		}
		while (choid > 0 && choid < 8);
		System.out.println("bye");
	}
	static void menu() {
		System.out.println("1. nhap cung");
		System.out.println("2. nhap mem");
		System.out.println("3. xoa hang hoa");
		System.out.println("4. sua don gia");
		System.out.println("5. hien thi danh sach");
		System.out.println("6. hien thi danh sach mat hang kho ban");
		System.out.println("7. thoat");
	}
	static void add1() {
		ls.themHangHoa(new HangDienMay("001", "001", 1, 1, 1, 1));
		ls.themHangHoa(new HangSanhSu("002", "002", 2, 2, "002", new Date(2022, 5, 23)));
	}
	static void add2() { // loading
		System.out.println("chon loai hang muon them");
		System.out.println("1. hang dien may");
		System.out.println("2. Hang sanh su");
		System.out.println("3. Hang thuc pham");
	}
	static void del() {
		String x;
		System.out.println("nhap ma hang muon xoa");
		x = new Scanner(System.in).nextLine();
		ls.xoaHangHoa(x);
	}
	static void fix() {
		String x;
		double y;
		System.out.println("nhap ma hang");
		x = new Scanner(System.in).nextLine();
		System.out.println("nhap gia tien moi");
		y = new Scanner(System.in).nextDouble();
	}
	static void hienThiDanhSach() {
		for (HangHoa hh : ls.getDanhSachHangHoa()) {
          System.out.println(hh);
      }
	}
	static void hienThiHangThucPhamKhoBan() {
		for (HangHoa hh : ls.getDanhSachHangHoa()) {
          if (hh instanceof HangThucPham && hh.danhGiaBanBuon().equals("kho ban")) {
              System.out.println(hh);
          }
      }
	}
}