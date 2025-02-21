package tuan1_HinhChuNhat;

import java.util.Scanner;

public class kiemThu_HinhChuNhat {
	public static void main(String[] args) {
		double dai = nhapDouble("Nhập chiều dài: ");
		double rong = nhapDouble("Nhập chiều rộng: ");
		HinhChuNhat h1 = new HinhChuNhat(dai, rong);
		System.out.println(h1);
	}
	
	static double nhapDouble(String s) {
		double ans;
		Scanner sc = new Scanner(System.in);
		System.out.println(s);
		ans = sc.nextDouble();
		return ans;
	}
}
