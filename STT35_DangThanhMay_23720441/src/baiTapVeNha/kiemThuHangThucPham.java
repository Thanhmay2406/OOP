package baiTapVeNha;

import java.util.Scanner;

public class kiemThuHangThucPham {
	static int size = 0;
	static HangThucPham[] danhSachHang = new HangThucPham[1000];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int choid = 0;
		
		do
		{
			menu();
			choid = sc.nextInt();
			switch(choid)
			{
				case 1: nhapCung(); break;
				case 2: nhapMem(); break;
				case 3: inDanhSach(); break;
			}
		}
		while (choid < 4 && choid > 0);
		System.out.println("hẹn gặp lại");
//		sc.close();
	}
	
	static void menu()
	{
		System.out.println("CHƯƠNG TRÌNH QUẢN LÝ HÀNG THỰC PHẨM");
		System.out.println("1. Nhập cứng");
		System.out.println("2. Nhập mềm");
		System.out.println("3. In ra các hàng");
		System.out.println("4. Thoát");
	}
	
	static void nhapMem()
	{
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập thông tin đơn hàng");
        boolean valid = false;
        while(!valid)
        {
            try 
            {
                System.out.print("Nhập mã hàng: ");
                String maHang = sc.nextLine();

                System.out.print("Nhập tên hàng: ");
                String tenHang = sc.nextLine();

                System.out.print("Nhập đơn giá: ");
                double donGia = Double.parseDouble(sc.nextLine());

                System.out.print("Nhập ngày sản xuất (dd/MM/yyyy): ");
                String ngaySanXuat = sc.nextLine();

                System.out.print("Nhập ngày hết hạn (dd/MM/yyyy): ");
                String ngayHetHan = sc.nextLine();

                danhSachHang[size] = new HangThucPham(maHang, tenHang, donGia, ngaySanXuat, ngayHetHan);
                size++;
                valid = true;
            } 
            catch (Exception e) 
            {
                System.out.println("Lỗi khi nhập dữ liệu: " + e.getMessage());
            }
        }
//        sc.close();
	}
	
	static void nhapCung()
	{
		try
		{
			HangThucPham htp1 = new HangThucPham("001", "Gạo", 10000.1, "10/07/2018", "10/07/2018");
			danhSachHang[size] = htp1;
			size++;
		}
		catch (Exception e)
		{
			System.err.println("Lỗi: " + e.getMessage());
		}
	}
	
	static void inDanhSach()
	{
		try
		{
			System.out.printf("%-10s %-15s %-15s %-15s %-15s %-10s\n", 
	                "Mã Hàng", "Tên Hàng", "Đơn Giá", "Ngày Sản Xuất", "Ngày Hết Hạn", "Ghi Chú");
			for (int i=0 ; i<size ; i++)
			{
				System.out.println(danhSachHang[i]);
			}
		}
		catch (Exception e)
		{
			System.err.println("Lỗi: " + e.getMessage());
		}
	}
}