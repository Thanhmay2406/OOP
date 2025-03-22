package tuan8_HangHoa;

import java.util.Date;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

class HangSanhSu extends HangHoa {
    private String nhaSanXuat;
    private Date ngayNhapKho;
    private static final NumberFormat nf = NumberFormat.getInstance();
    private static final SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

    public HangSanhSu(String maHang, String tenHang, double donGia, int soLuongTon, String nhaSanXuat, Date ngayNhapKho) {
        super(maHang, tenHang, donGia, soLuongTon);
        this.nhaSanXuat = nhaSanXuat;
        this.ngayNhapKho = ngayNhapKho;
    }

    @Override
    public String danhGiaBanBuon() {
        Date now = new Date();
        long diff = now.getTime() - ngayNhapKho.getTime();
        long diffDays = diff / (24 * 60 * 60 * 1000);
        if (soLuongTon > 50 && diffDays > 10) {
            return "Bán chậm";
        }
        return "Không đánh giá";
    }

    @Override
    public double tinhVAT() {
        return donGia * 0.1;
    }
    
    @Override
    public String toString() {
        return String.format("|%-10s|%-20s|%-20s|%-20s|%-20s|%-20s|%-10s|%-10s|", 
            getMaHang(), 
            getTenHang(), 
            nf.format(getDonGia()), 
            String.valueOf(getSoLuongTon()), 
            nhaSanXuat, 
            df.format(ngayNhapKho.getTime()), 
            danhGiaBanBuon(), 
            "Hang SS");
    }
}