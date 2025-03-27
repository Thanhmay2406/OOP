package tuan8_HangHoa;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class main_HangHoa {
	private static final SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        QuanLyHangHoa qlhh = new QuanLyHangHoa();

        while (true) {
            System.out.println("\n=== MENU QUẢN LÝ HÀNG HÓA ===");
            System.out.println("1. Thêm hàng hóa");
            System.out.println("2. Hiển thị toàn bộ danh sách hàng hóa");
            System.out.println("3. Hiển thị danh sách hàng hóa theo loại");
            System.out.println("4. Tìm kiếm hàng hóa theo mã hàng");
            System.out.println("5. Sắp xếp hàng hóa theo tên tăng dần");
            System.out.println("6. Sắp xếp hàng hóa theo số lượng tồn giảm dần");
            System.out.println("7. Hiển thị hàng thực phẩm khó bán");
            System.out.println("8. Xóa hàng hóa theo mã hàng");
            System.out.println("9. Sửa đơn giá của hàng hóa theo mã hàng");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Xóa bộ đệm

            switch (choice) {
                case 1:
                    themHangHoa(qlhh);
                    break;
                case 2:
                    hienThiDanhSach(qlhh);
                    break;
                case 3:
                    hienThiTheoLoai(qlhh);
                    break;
                case 4:
                    timKiemHangHoa(qlhh);
                    break;
                case 5:
                    sapXepTheoTen(qlhh);
                    break;
                case 6:
                    sapXepTheoSoLuongTon(qlhh);
                    break;
                case 7:
                    hienThiHangThucPhamKhoBan(qlhh);
                    break;
                case 8:
                    xoaHangHoa(qlhh);
                    break;
                case 9:
                    suaDonGia(qlhh);
                    break;
                case 0:
                    thoatChuongTrinh();
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    // Hàm 1: Thêm hàng hóa
    private static void themHangHoa(QuanLyHangHoa qlhh) {
        System.out.println("Chọn loại hàng hóa (1: Điện máy, 2: Sành sứ, 3: Thực phẩm): ");
        int loaiHang = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nhập mã hàng: ");
        String maHang = scanner.nextLine();
        System.out.print("Nhập tên hàng: ");
        String tenHang = scanner.nextLine();
        System.out.print("Nhập đơn giá: ");
        double donGia = scanner.nextDouble();
        System.out.print("Nhập số lượng tồn: ");
        int soLuongTon = scanner.nextInt();
        scanner.nextLine();

        if (loaiHang == 1) { // Hàng điện máy
            System.out.print("Nhập thời gian bảo hành (tháng): ");
            int thoiGianBaoHanh = scanner.nextInt();
            System.out.print("Nhập công suất (kW): ");
            double congSuat = scanner.nextDouble();
            HangDienMay hdm = new HangDienMay(maHang, tenHang, donGia, soLuongTon, thoiGianBaoHanh, congSuat);
            qlhh.themHangHoa(hdm);
        } else if (loaiHang == 2) { // Hàng sành sứ
            System.out.print("Nhập nhà sản xuất: ");
            String nhaSanXuat = scanner.nextLine();
            System.out.print("Nhập ngày nhập kho (dd/MM/yyyy): ");
            String ngayNhapKhoStr = scanner.nextLine();
            try {
                Date ngayNhapKho = df.parse(ngayNhapKhoStr);
                HangSanhSu hss = new HangSanhSu(maHang, tenHang, donGia, soLuongTon, nhaSanXuat, ngayNhapKho);
                qlhh.themHangHoa(hss);
            } catch (ParseException e) {
                System.out.println("Ngày nhập kho không hợp lệ!");
            }
        } else if (loaiHang == 3) { // Hàng thực phẩm
            System.out.print("Nhập nhà cung cấp: ");
            String nhaCungCap = scanner.nextLine();
            System.out.print("Nhập ngày sản xuất (dd/MM/yyyy): ");
            String ngaySanXuatStr = scanner.nextLine();
            System.out.print("Nhập ngày hết hạn (dd/MM/yyyy): ");
            String ngayHetHanStr = scanner.nextLine();
            try {
                Date ngaySanXuat = df.parse(ngaySanXuatStr);
                Date ngayHetHan = df.parse(ngayHetHanStr);
                HangThucPham htp = new HangThucPham(maHang, tenHang, donGia, soLuongTon, nhaCungCap, ngaySanXuat, ngayHetHan);
                qlhh.themHangHoa(htp);
            } catch (ParseException e) {
                System.out.println("Ngày không hợp lệ!");
            }
        } else {
            System.out.println("Loại hàng không hợp lệ!");
        }
    }

    // Hàm 2: Hiển thị toàn bộ danh sách
    private static void hienThiDanhSach(QuanLyHangHoa qlhh) {
//        qlhh.layThongTinDanhSach();
    	if (qlhh.getDanhSachHangHoa().isEmpty()) {
            System.out.println("Danh sách hàng hóa trống!");
            return;
        }
        System.out.println("Danh sách hàng hóa:");
        for (HangHoa hh : qlhh.getDanhSachHangHoa()) {
            System.out.println(hh.toString());
        }
    }

    // Hàm 3: Hiển thị danh sách theo loại
    private static void hienThiTheoLoai(QuanLyHangHoa qlhh) {
        System.out.println("Chọn loại hàng hóa (1: Điện máy, 2: Sành sứ, 3: Thực phẩm): ");
        int loai = scanner.nextInt();
        if (loai == 1) {
            qlhh.layThongTinTheoLoai("Hàng điện máy");
        } else if (loai == 2) {
            qlhh.layThongTinTheoLoai("Hàng sành sứ");
        } else if (loai == 3) {
            qlhh.layThongTinTheoLoai("Hàng thực phẩm");
        } else {
            System.out.println("Loại hàng không hợp lệ!");
        }
    }

    // Hàm 4: Tìm kiếm hàng hóa theo mã
    private static void timKiemHangHoa(QuanLyHangHoa qlhh) {
        System.out.print("Nhập mã hàng cần tìm: ");
        String maTim = scanner.nextLine();
        HangHoa hh = qlhh.timKiemHangHoa(maTim);
        if (hh != null) {
            System.out.println("Hàng hóa tìm thấy: " + hh.toString());
        } else {
            System.out.println("Không tìm thấy hàng hóa có mã " + maTim + "!");
        }
    }

    // Hàm 5: Sắp xếp theo tên tăng dần
    private static void sapXepTheoTen(QuanLyHangHoa qlhh) {
        qlhh.sapXepTheoTenTangDan();
//        qlhh.layThongTinDanhSach();
        hienThiDanhSach(qlhh);
    }

    // Hàm 6: Sắp xếp theo số lượng tồn giảm dần
    private static void sapXepTheoSoLuongTon(QuanLyHangHoa qlhh) {
        qlhh.sapXepTheoSoLuongTonGiamDan();
//        qlhh.layThongTinDanhSach();
        hienThiDanhSach(qlhh);
    }

    // Hàm 7: Hiển thị hàng thực phẩm khó bán
    private static void hienThiHangThucPhamKhoBan(QuanLyHangHoa qlhh) {
//        qlhh.layHangThucPhamKhoBan();
    	boolean found = false;
        System.out.println("Danh sách hàng thực phẩm khó bán:");
        for (HangHoa hh : qlhh.getDanhSachHangHoa()) {
            if (hh instanceof HangThucPham && hh.danhGiaBanBuon().equals("Khó bán")) {
                System.out.println(hh.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không có hàng thực phẩm khó bán!");
        }
    }

    // Hàm 8: Xóa hàng hóa theo mã
    private static void xoaHangHoa(QuanLyHangHoa qlhh) {
        System.out.print("Nhập mã hàng cần xóa: ");
        String maXoa = scanner.nextLine();
        qlhh.xoaHangHoa(maXoa);
    }

    // Hàm 9: Sửa đơn giá của hàng hóa
    private static void suaDonGia(QuanLyHangHoa qlhh) {
        System.out.print("Nhập mã hàng cần sửa đơn giá: ");
        String maSua = scanner.nextLine();
        System.out.print("Nhập đơn giá mới: ");
        double donGiaMoi = scanner.nextDouble();
        qlhh.suaDonGia(maSua, donGiaMoi);
    }

    // Hàm 0: Thoát chương trình
    private static void thoatChuongTrinh() {
        System.out.println("Thoát chương trình!");
        scanner.close();
    }
}