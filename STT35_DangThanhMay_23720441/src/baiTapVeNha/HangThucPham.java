package baiTapVeNha;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HangThucPham {
	
	private String maHang, tenHang;
    private double donGia;
    private Date ngaySanXuat, ngayHetHan;

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public HangThucPham(String maHang, String tenHang, double donGia, String ngaySanXuat, String ngayHetHan) throws Exception {
        if (maHang == null || maHang.trim().isEmpty()) {
            throw new Exception("Mã hàng không được để trống.");
        }
        this.maHang = maHang;

        setTenHang(tenHang);
        setDonGia(donGia);
        setNgaySanXuat(ngaySanXuat);
        setNgayHetHan(ngayHetHan);
    }

    public HangThucPham(String maHang) throws Exception {
        if (maHang == null || maHang.trim().isEmpty()) {
            throw new Exception("Mã hàng không được để trống.");
        }
        this.maHang = maHang;
        this.tenHang = "xxx";
        this.donGia = 0;
        this.ngaySanXuat = new Date();
        this.ngayHetHan = new Date();
    }

    public String getMaHang() {
        return maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        if (tenHang == null || tenHang.trim().isEmpty()) {
            this.tenHang = "xxx";
        } else {
            this.tenHang = tenHang;
        }
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        if (donGia < 0) {
            this.donGia = 0;
        } else {
            this.donGia = donGia;
        }
    }

    public Date getNgaySanXuat() {
        return ngaySanXuat;
    }

    public void setNgaySanXuat(String ngaySanXuat) throws ParseException {
        Date nsx = sdf.parse(ngaySanXuat);
        this.ngaySanXuat = nsx;
    }

    public Date getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(String ngayHetHan) throws ParseException {
        Date nhh = sdf.parse(ngayHetHan);
        if (nhh.before(this.ngaySanXuat)) {
            throw new IllegalArgumentException("Ngày hết hạn phải sau ngày sản xuất.");
        }
        this.ngayHetHan = nhh;
    }

    public boolean daHetHan() {
        Date today = new Date();
        return ngayHetHan.before(today);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-10s %-15s %-15.2f %-15s %-15s %-10s", 
            maHang, 
            tenHang, 
            donGia, 
            sdf.format(ngaySanXuat), 
            sdf.format(ngayHetHan), 
            daHetHan() ? "Hàng hết hạn" : ""));
        return sb.toString();
    }
}
