package tuan8_HangHoa;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

public class QuanLyHangHoa {
    private ArrayList<HangHoa> danhSachHangHoa;
    private static final NumberFormat nf = NumberFormat.getInstance();
    private static final SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    private Scanner scanner;

    public QuanLyHangHoa() {
        danhSachHangHoa = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    
    
    public ArrayList<HangHoa> getDanhSachHangHoa() {
		return danhSachHangHoa;
	}

	public void setDanhSachHangHoa(ArrayList<HangHoa> danhSachHangHoa) {
		this.danhSachHangHoa = danhSachHangHoa;
	}



	public void themHangHoa(HangHoa hangHoa) {
        for (HangHoa hh : danhSachHangHoa) {
            if (hh.getMaHang().equals(hangHoa.getMaHang())) {
                System.out.println("Mã hàng " + hangHoa.getMaHang() + " đã tồn tại! Không thể thêm.");
                return;
            }
        }
        danhSachHangHoa.add(hangHoa);
        System.out.println("Thêm hàng hóa thành công!");
    }

    public void layThongTinTheoLoai(String loaiHang) {
        boolean found = false;
        System.out.println("Danh sách " + loaiHang + ":");
        for (HangHoa hh : danhSachHangHoa) {
            if ((loaiHang.equals("Hàng điện máy") && hh instanceof HangDienMay) ||
                (loaiHang.equals("Hàng sành sứ") && hh instanceof HangSanhSu) ||
                (loaiHang.equals("Hàng thực phẩm") && hh instanceof HangThucPham)) {
                System.out.println(hh.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không có " + loaiHang + " trong danh sách!");
        }
    }

    public HangHoa timKiemHangHoa(String maHang) {
        for (HangHoa hh : danhSachHangHoa) {
            if (hh.getMaHang().equals(maHang)) {
                return hh;
            }
        }
        return null;
    }

    public void sapXepTheoTenTangDan() {
        Collections.sort(danhSachHangHoa, new Comparator<HangHoa>() {
            @Override
            public int compare(HangHoa hh1, HangHoa hh2) {
                return hh1.getTenHang().compareTo(hh2.getTenHang());
            }
        });
        System.out.println("Đã sắp xếp theo tên hàng tăng dần!");
    }

    public void sapXepTheoSoLuongTonGiamDan() {
        Collections.sort(danhSachHangHoa, new Comparator<HangHoa>() {
            @Override
            public int compare(HangHoa hh1, HangHoa hh2) {
                return Integer.compare(hh2.getSoLuongTon(), hh1.getSoLuongTon());
            }
        });
        System.out.println("Đã sắp xếp theo số lượng tồn giảm dần!");
    }

    public void xoaHangHoa(String maHang) {
        HangHoa hh = timKiemHangHoa(maHang);
        if (hh != null) {
            danhSachHangHoa.remove(hh);
            System.out.println("Đã xóa hàng hóa có mã " + maHang + "!");
        } else {
            System.out.println("Không tìm thấy hàng hóa có mã " + maHang + "!");
        }
    }

    public void suaDonGia(String maHang, double donGiaMoi) {
        HangHoa hh = timKiemHangHoa(maHang);
        if (hh != null) {
            hh.setDonGia(donGiaMoi);
            System.out.println("Đã sửa đơn giá của hàng hóa có mã " + maHang + "!");
        } else {
            System.out.println("Không tìm thấy hàng hóa có mã " + maHang + "!");
        }
    }
}