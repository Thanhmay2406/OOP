package tuan8_QuanLyPhongHoc;

import java.util.Scanner;
import java.util.List;

public class TestPhongHoc {
	public static Scanner sc = new Scanner(System.in);

    // Hàm nhập thông tin phòng lý thuyết
    public static PhongLyThuyet nhapPhongLyThuyet() {
        String maPhong, dayNha, temp;
        double dienTich;
        int soBongDen;
        System.out.printf("Nhap ma phong: ");
        maPhong = sc.next();
        System.out.printf("Nhap day nha: ");
        dayNha = sc.next();
        System.out.printf("Nhap dien tich: ");
        dienTich = sc.nextDouble();
        System.out.printf("Nhap so bong den: ");
        soBongDen = sc.nextInt();
        System.out.printf("Phong hoc co may chieu khong (Co/Khong): ");
        temp = sc.next();

        if (temp.equalsIgnoreCase("co")) {
            return new PhongLyThuyet(maPhong, dayNha, dienTich, soBongDen, true);
        } else {
            return new PhongLyThuyet(maPhong, dayNha, dienTich, soBongDen, false);
        }
    }

    // Hàm nhập thông tin phòng máy tính
    public static PhongMayTinh nhapPhongMayTinh() {
        String maPhong, dayNha;
        double dienTich;
        int soBongDen, soMayTinh;
        System.out.printf("Nhap ma phong: ");
        maPhong = sc.next();
        System.out.printf("Nhap day nha: ");
        dayNha = sc.next();
        System.out.printf("Nhap dien tich: ");
        dienTich = sc.nextDouble();
        System.out.printf("Nhap so bong den: ");
        soBongDen = sc.nextInt();
        System.out.printf("Nhap so may tinh: ");
        soMayTinh = sc.nextInt();

        return new PhongMayTinh(maPhong, dayNha, dienTich, soBongDen, soMayTinh);
    }

    // Hàm nhập thông tin phòng thí nghiệm
    public static PhongThiNghiem nhapPhongThiNghiem() {
        String maPhong, dayNha, chuyenNganh, temp;
        double dienTich, sucChua;
        int soBongDen;
        System.out.printf("Nhap ma phong: ");
        maPhong = sc.next();
        System.out.printf("Nhap day nha: ");
        dayNha = sc.next();
        System.out.printf("Nhap dien tich: ");
        dienTich = sc.nextDouble();
        System.out.printf("Nhap so bong den: ");
        soBongDen = sc.nextInt();
        System.out.printf("Nhap chuyen nganh: ");
        chuyenNganh = sc.next();
        System.out.printf("Nhap suc chua: ");
        sucChua = sc.nextDouble();
        System.out.printf("Phong hoc co bon rua hay khong (Co/Khong): ");
        temp = sc.next();

        if (temp.equalsIgnoreCase("co")) {
            return new PhongThiNghiem(maPhong, dayNha, dienTich, soBongDen, chuyenNganh, sucChua, true);
        } else {
            return new PhongThiNghiem(maPhong, dayNha, dienTich, soBongDen, chuyenNganh, sucChua, false);
        }
    }

    // Hàm 1: Thêm phòng học
    private static void themPhongHoc(DanhSachPhonghoc ds) throws Exception {
        int choice;
        do {
            System.out.println();
            System.out.println("Chon loai phong hoc muon them vao");
            System.out.println("1. Phong hoc ly thuyet");
            System.out.println("2. Phong may tinh");
            System.out.println("3. Phong thi nghiem");
            choice = sc.nextInt();
        } while (choice < 1 || choice > 3);

        if (choice == 1) {
            PhongLyThuyet plt = nhapPhongLyThuyet();
            ds.addPhonghoc(plt);
        } else if (choice == 2) {
            PhongMayTinh pmt = nhapPhongMayTinh();
            ds.addPhonghoc(pmt);
        } else {
            PhongThiNghiem ptn = nhapPhongThiNghiem();
            ds.addPhonghoc(ptn);
        }
        System.out.println("Them phong hoc thanh cong!");
    }

    // Hàm 2: Tìm kiếm phòng học theo mã phòng
    private static void timKiemPhongHoc(DanhSachPhonghoc ds) {
        System.out.println();
        System.out.printf("Nhap ma phong hoc can tim: ");
        String maPhong = sc.next();

        Phonghoc ph = ds.findPhonghoc(maPhong);

        if (ph != null) {
            System.out.println(ph);
        } else {
            System.err.println("Khong tim thay phong hoc");
        }
    }

    // Hàm 3: Lấy thông tin toàn bộ danh sách các phòng học
    private static void layThongTinDanhSach(DanhSachPhonghoc ds) {
        System.out.println(ds);
    }

    // Hàm 4: Lấy danh sách các phòng học đạt chuẩn
    private static void layPhongDatChuan(DanhSachPhonghoc ds) {
        List<Phonghoc> listDatChuan = ds.getPhongDatChuan();
        if (listDatChuan.isEmpty()) {
            System.out.println("Khong co phong hoc nao dat chuan!");
        } else {
            System.out.println("Danh sach phong hoc dat chuan:");
            System.out.printf("%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s\n", "Ma phong", "Day nha",
                    "Dien tich", "So bong", "May chieu", "So may tinh", "Chuyen nganh", "Suc chua", "Bon rua");
            for (Phonghoc ph : listDatChuan) {
                System.out.println(ph);
            }
        }
    }

    // Hàm 5: Sắp xếp tăng dần theo dãy nhà
    private static void sapXepTheoDayNha(DanhSachPhonghoc ds) {
        ds.sortByDayNha();
        System.out.println("Da sap xep tang dan theo day nha!");
        layThongTinDanhSach(ds);
    }

    // Hàm 6: Sắp xếp giảm dần theo diện tích
    private static void sapXepTheoDienTich(DanhSachPhonghoc ds) {
        ds.sortByDienTich();
        System.out.println("Da sap xep giam dan theo dien tich!");
        layThongTinDanhSach(ds);
    }

    // Hàm 7: Sắp xếp tăng dần theo số bóng đèn
    private static void sapXepTheoSoBongDen(DanhSachPhonghoc ds) {
        ds.sortBySoBongDen();
        System.out.println("Da sap xep tang dan theo so bong den!");
        layThongTinDanhSach(ds);
    }

    // Hàm 8: Cập nhật số máy tính theo mã phòng
    private static void capNhatSoMayTinh(DanhSachPhonghoc ds) throws Exception {
        System.out.printf("Nhap ma phong can cap nhat so may tinh: ");
        String maPhong = sc.next();
        System.out.printf("Nhap so may tinh moi: ");
        int soMayTinh = sc.nextInt();

        try {
            ds.updatePhongMayTinh(maPhong, soMayTinh);
            System.out.println("Cap nhat so may tinh thanh cong!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    // Hàm 9: Xóa một phòng học theo mã phòng
    private static void xoaPhongHoc(DanhSachPhonghoc ds) throws Exception {
        System.out.printf("Nhap ma phong can xoa: ");
        String maPhong = sc.next();

        try {
            ds.xoaPhonghoc(maPhong);
            System.out.println("Xoa phong hoc thanh cong!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    // Hàm 10: Tính tổng số phòng học
    private static void tinhTongSoPhongHoc(DanhSachPhonghoc ds) {
        System.out.println("Tong so phong hoc: " + ds.getSoPhonghoc());
    }

    // Hàm 11: Lấy danh sách phòng máy có 60 máy
    private static void layPhongMayCo60May(DanhSachPhonghoc ds) {
        List<PhongMayTinh> listPMT = ds.getPhongMT();
        if (listPMT.isEmpty()) {
            System.out.println("Khong co phong may tinh nao co 60 may!");
        } else {
            System.out.println("Danh sach phong may tinh co 60 may:");
            System.out.printf("%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s\n", "Ma phong", "Day nha",
                    "Dien tich", "So bong", "May chieu", "So may tinh", "Chuyen nganh", "Suc chua", "Bon rua");
            for (PhongMayTinh pmt : listPMT) {
                System.out.println(pmt);
            }
        }
    }

    // Hàm 0: Thoát chương trình
    private static void thoatChuongTrinh() {
        System.out.println("Thoat chuong trinh!");
        sc.close();
    }

    // Hàm main
    public static void main(String[] args) throws Exception {
        DanhSachPhonghoc ds = new DanhSachPhonghoc(10);
        int choice;

        do {
            do {
                System.out.println("1. Them phong hoc vao danh sach");
                System.out.println("2. Tim kiem phong hoc theo ma phong");
                System.out.println("3. Lay thong tin toan bo danh sach cac phong hoc");
                System.out.println("4. Lay danh sach cac phong hoc dat chuan");
                System.out.println("5. Sap xep tang dan theo day nha");
                System.out.println("6. Sap xep giam dan theo dien tich");
                System.out.println("7. Sap xep tang dan theo so bong den");
                System.out.println("8. Cap nhat so may tinh theo ma phong");
                System.out.println("9. Xoa mot phong hoc theo ma phong");
                System.out.println("10. Tinh tong so phong hoc");
                System.out.println("11. Lay danh sach phong may co 60 may");
                System.out.println("0. Thoat");
                System.out.println();

                System.out.printf("Nhap vao lua chon cua ban: ");
                choice = sc.nextInt();
            } while (choice < 0 || choice > 11);

            switch (choice) {
                case 1:
                    themPhongHoc(ds);
                    break;
                case 2:
                    timKiemPhongHoc(ds);
                    break;
                case 3:
                    layThongTinDanhSach(ds);
                    break;
                case 4:
                    layPhongDatChuan(ds);
                    break;
                case 5:
                    sapXepTheoDayNha(ds);
                    break;
                case 6:
                    sapXepTheoDienTich(ds);
                    break;
                case 7:
                    sapXepTheoSoBongDen(ds);
                    break;
                case 8:
                    capNhatSoMayTinh(ds);
                    break;
                case 9:
                    xoaPhongHoc(ds);
                    break;
                case 10:
                    tinhTongSoPhongHoc(ds);
                    break;
                case 11:
                    layPhongMayCo60May(ds);
                    break;
                case 0:
                    thoatChuongTrinh();
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
                    break;
            }
        } while (choice != 0);
    }
}
