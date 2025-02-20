package tuan3_Xe;

import java.util.Scanner;

public class kiemThu_Xe {
    static Xe xe1, xe2, xe3;

    public static void main(String[] args) {
        int choid = -1;
        do {
            menu();
            Scanner sc = new Scanner(System.in);
            try {
                choid = sc.nextInt();
                if (choid == 1) xe1 = inp();
                else if (choid == 2) xe2 = inp();
                else if (choid == 3) xe3 = inp();
                else if (choid == 4) out();
                else {
                    System.out.println("Thoát");
                    break;
                }
            } catch (Exception e) {
                System.out.println("Lỗi nhập dữ liệu. Vui lòng nhập lại.");
                sc.nextLine();
            }
        } while (choid < 6);
    }

    static float nhapFloat(String s) {
        Scanner sc = new Scanner(System.in);
        float ans = -1;
        boolean valid = false;
        while (!valid) {
            try {
                System.out.println(s);
                ans = sc.nextFloat();
                if (ans >= 0) {
                    valid = true;
                } else {
                    System.out.println("Giá trị phải lớn hơn hoặc bằng 0. Vui lòng nhập lại.");
                }
            } catch (Exception e) {
                System.out.println("Lỗi, vui lòng nhập một số thực hợp lệ.");
                sc.nextLine();
            }
        }
        return ans;
    }

    static String nhapString(String s) {
        Scanner sc = new Scanner(System.in);
        String ans = "";
        boolean valid = false;
        while (!valid) {
            try {
                System.out.println(s);
                ans = sc.nextLine();
                valid = true;
            } catch (Exception e) {
                System.out.println("Lỗi nhập chuỗi. Vui lòng thử lại.");
            }
        }
        return ans;
    }

    static int nhapInt(String s) {
        Scanner sc = new Scanner(System.in);
        int ans = -1;
        boolean valid = false;
        while (!valid) {
            try {
                System.out.println(s);
                ans = sc.nextInt();
                if (ans >= 0) {
                    valid = true;
                } else {
                    System.out.println("Giá trị phải lớn hơn hoặc bằng 0. Vui lòng nhập lại.");
                }
            } catch (Exception e) {
                System.out.println("Lỗi, vui lòng nhập một số nguyên hợp lệ.");
                sc.nextLine();
            }
        }
        return ans;
    }

    static void menu() {
        System.out.println("\tChương trình xe");
        System.out.println("\t1. Nhập xe 1");
        System.out.println("\t2. Nhập xe 2");
        System.out.println("\t3. Nhập xe 3");
        System.out.println("\t4. In ra kết quả");
        System.out.println("\t5. Thoát");
    }

    static Xe inp() {
        String ten, loai;
        int dungTich;
        float gia;
        ten = nhapString("Nhập tên chủ xe:");
        loai = nhapString("Nhập loại xe:");
        dungTich = nhapInt("Nhập dung tích:");
        gia = nhapFloat("Nhập giá:");
        return new Xe(ten, loai, dungTich, gia);
    }

    static void out() {
        System.out.println("Tên chủ xe \t Loại xe \t Dung tích \t Trị giá \t Thuế");
        if (xe1 != null) System.out.println(xe1);
        if (xe2 != null) System.out.println(xe2);
        if (xe3 != null) System.out.println(xe3);
    }
}
