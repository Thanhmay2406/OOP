package tuan2_SinhVien;

import java.util.Scanner;

public class kiemThu_SinhVien {
	static SinhVien sv1, sv2, sv3;
	public static void main(String[] args) {
		int choid = -1;
		do
		{
			menu();
			Scanner sc = new Scanner(System.in);
			choid = sc.nextInt();
			if (choid == 1) nhapCung();
			else if (choid == 2) sv3 = nhapMem();
			else if (choid == 3) out();
			else
			{
				System.out.println("kết thúc chương trình!!!");
				break;
			}
		}
		while (choid < 4);
	}
	static void menu()
	{
		System.out.println("\tchương trình quản lý sinh viên");
		System.out.println("\t1. nhập cứng");
		System.out.println("\t2. nhập mềm");
		System.out.println("\t3. in ra kết quả");
		System.out.println("\t4. thoát");
	}
	static SinhVien nhapMem()
	{
		int mssv = nhapInt("Nhập MSSV: ");
        String hoTen = nhapString("Nhập họ tên: ");
        float diemLT = nhapFloat("Nhập điểm lý thuyết: ");
        float diemTH = nhapFloat("Nhập điểm thực hành: ");
        return new SinhVien(mssv, hoTen, diemLT, diemTH);
	}
	
	static void nhapCung()
	{
		sv1 = new SinhVien(1,"sv1",10,10);
		sv2 = new SinhVien(2,"sv2",9,9);
	}
	
	static void out()
	{
		System.out.println("mssv \t họ tên \t điểm lý thuyết \t điểm thực hành");
		if (sv1 != null) System.out.println(sv1);
		if (sv2 != null) System.out.println(sv2);
		if (sv3 != null) System.out.println(sv3);
	}
	
	static String nhapString(String s)
	{
		Scanner sc = new Scanner(System.in);
		String ans;
		System.out.println(s);
		ans = sc.nextLine();
		return ans;
	}
	
	static int nhapInt (String s)
	{
		Scanner sc = new Scanner(System.in);
		int ans;
		System.out.println(s);
		ans = sc.nextInt();
		return ans;
	}
	
	static float nhapFloat (String s)
	{
		Scanner sc = new Scanner(System.in);
		float ans;
		System.out.println(s);
		ans = sc.nextFloat();
		return ans;
	}
}
