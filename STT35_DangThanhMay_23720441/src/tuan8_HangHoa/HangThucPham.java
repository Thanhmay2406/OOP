package tuan8_HangHoa;

import java.util.Date;

class HangThucPham extends HangHoa {
    private String nhaCungCap;
    private Date ngaySanXuat;
    private Date ngayHetHan;

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
}