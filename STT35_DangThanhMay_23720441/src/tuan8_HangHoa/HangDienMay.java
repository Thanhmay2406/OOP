package tuan8_HangHoa;

import java.text.NumberFormat;

class HangDienMay extends HangHoa {
    private int thoiGianBaoHanh;
    private double congSuat;
    private static final NumberFormat nf = NumberFormat.getInstance();

    public int getThoiGianBaoHanh() {
		return thoiGianBaoHanh;
	}

	public void setThoiGianBaoHanh(int thoiGianBaoHanh) {
		this.thoiGianBaoHanh = thoiGianBaoHanh;
	}

	public double getCongSuat() {
		return congSuat;
	}

	public void setCongSuat(double congSuat) {
		this.congSuat = congSuat;
	}

	public HangDienMay(String maHang, String tenHang, double donGia, int soLuongTon, int thoiGianBaoHanh, double congSuat) {
        super(maHang, tenHang, donGia, soLuongTon);
        this.thoiGianBaoHanh = thoiGianBaoHanh;
        this.congSuat = congSuat;
    }

    @Override
    public String danhGiaBanBuon() {
        if (soLuongTon < 3) {
            return "Bán được";
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
            String.valueOf(thoiGianBaoHanh), 
            nf.format(congSuat), 
            danhGiaBanBuon(), 
            "Hang DM");
    }
}
