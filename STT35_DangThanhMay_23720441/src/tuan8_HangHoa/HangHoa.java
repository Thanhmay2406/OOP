package tuan8_HangHoa;

import java.util.Date;

abstract class HangHoa {
    protected String maHang;
    protected String tenHang;
    protected double donGia;
    protected int soLuongTon;

    public HangHoa(String maHang, String tenHang, double donGia, int soLuongTon) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.donGia = donGia;
        this.soLuongTon = soLuongTon;
    }

    public abstract String danhGiaBanBuon();
    public abstract double tinhVAT();
}