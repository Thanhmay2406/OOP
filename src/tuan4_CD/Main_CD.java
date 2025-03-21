package tuan4_CD;

import java.util.Scanner;

public class Main_CD {
	static CDList arr;
	public static void main(String[] args) {
		int n;
		System.out.println("nhập số lượng phần tử tối đa của danh sách : ");
		n = new Scanner(System.in).nextInt();
		arr = new CDList(n);
		int choid = -1;
		do {
			menu();
			choid = new Scanner(System.in).nextInt();
			switch (choid) {
			case 1:
				add();
				break;
			case 2:
				arr.to_string();
				break;
			case 3:
				countSize();
				break;
			case 4:
				delete();
				break;
			case 5:
				calSum();
				break;
			case 6:
				search();
				break;
			case 7:
				arr.sort();
				break;
			case 8:
				arr.sort2();
				break;
			}
		}
		while (choid >= 1 && choid <= 8);
		System.out.println("good bye");
	}
	
	static void menu() {
		System.out.println("1. thêm CD");
		System.out.println("2. in toàn bộ CD");
		System.out.println("3. tính số lượng trong danh sách");
		System.out.println("4. xóa CD");
		System.out.println("5. tính tổng giá");
		System.out.println("6. tìm kiếm");
		System.out.println("7. sắp xếp giảm dần theo giá thành");
		System.out.println("8. sắp xếp tăng dần theo mã CD");
		System.out.println("9. thoát");
	}
	
	static void add() {
		CD x = new CD();
		System.out.println("nhập thông tin CD");
		System.out.println("nhập mã CD: ");
		x.setMaCD(new Scanner(System.in).nextInt());
		System.out.println("nhập tựa CD: ");
		x.setTuaCD(new Scanner(System.in).nextLine());
		System.out.println("nhập số bài hát");
		x.setSoBaiHat(new Scanner(System.in).nextInt());
		System.out.println("nhập giá thành");
		x.setGiaThanh(new Scanner(System.in).nextDouble());
		if(arr.add(x) == false) {
			System.out.println("thêm thất bại");
		}
		else {
			System.out.println("thêm thành công");
		}
	}
	
	static void countSize() {
		System.out.println("số lượng: " + arr.size);
	}
	
	static void delete() {
		int x;
		System.out.println("nhập mã CD cần xóa");
		x = new Scanner(System.in).nextInt();
		if (arr.delete(x) == false) {
			System.out.println("xóa thất bại");
		}
		else {
			System.out.println("xóa thành công");
		}
	}
	
	static void calSum() {
		System.out.println("tổng giá thành: " + arr.sum());
	}
	
	static void search() {
		int x;
		System.out.println("nhập mã CD cần tìm");
		x = new Scanner(System.in).nextInt();
		if (arr.search(x) == -1) {
			System.out.println("không tìm thấy");
			return;
		}
		System.out.println(arr.getCD(arr.search(x)).toString());
	}
}