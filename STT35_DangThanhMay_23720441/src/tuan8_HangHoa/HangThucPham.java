package tuan8_HangHoa;

import java.util.Date;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

class HangThucPham extends HangHoa {
    private String nhaCungCap;
    private Date ngaySanXuat;
    private Date ngayHetHan;
    private static final NumberFormat nf = NumberFormat.getInstance();
    private static final SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

    public HangThucPham(String maHang, String tenHang, double donGia, int soLuongTon, String nhaCungCap, Date ngaySanXuat, Date ngayHetHan) {
        super(maHang, tenHang, donGia, soLuongTon);
        this.nhaCungCap = nhaCungCap;
        this.ngaySanXuat = ngaySanXuat;
        this.ngayHetHan = ngayHetHan;
    }

    @Override
    public String danhGiaBanBuon() {
        Date now = new Date();
        if (soLuongTon > 0 && ngayHetHan.before(now)) {
            return "Khó bán";
        }
        return "Không đánh giá";
    }

    @Override
    public double tinhVAT() {
        return donGia * 0.05;
    }
    
    @Override
    public String toString() {
        return String.format("|%-10s|%-20s|%-20s|%-20s|%-20s|%-20s|%-10s|%-10s|", 
            getMaHang(), 
            getTenHang(), 
            nf.format(getDonGia()), 
            String.valueOf(getSoLuongTon()), 
            nhaCungCap, 
            df.format(ngaySanXuat.getTime()), 
            df.format(ngayHetHan.getTime()), 
            danhGiaBanBuon());
    }
}