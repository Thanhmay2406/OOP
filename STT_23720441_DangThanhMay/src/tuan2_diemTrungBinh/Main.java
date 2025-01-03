package tuan2_diemTrungBinh;

import java.util.Scanner;

public class Main {
	static void menu()
	{
		System.out.println("1. nhap mem");
		System.out.println("2. nhap cung");
		System.out.println("3. xuat");
		System.out.println("4. thoat");
	}
	
	public static void main(String[] args)
    {
		diemTrungBinh sv1 = new diemTrungBinh(0, "A", 10, 10);
		diemTrungBinh sv2 = new diemTrungBinh(1, "B", 9, 9);
		diemTrungBinh sv3 = new diemTrungBinh(2, "C", 8, 8);
		diemTrungBinh sv4 = new diemTrungBinh(3, "D", 7, 7);
//        System.out.println(sv1);
//        System.out.println(sv2);
//        System.out.println(sv3);
//        System.out.println(sv4);
		int choid = 0;
		menu();
		Scanner sc = new Scanner(System.in);
		do
		{
			choid = sc.nextInt();
			switch(choid)
			{
				case 1:
					
			}
		}
		while (choid < 4);
    }
}
