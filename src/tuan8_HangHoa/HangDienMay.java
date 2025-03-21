package tuan8_HangHoa;

class HangDienMay extends HangHoa {
    private int thoiGianBaoHanh;
    private double congSuat;

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
		String ans = String.format("|%-20s|%-20s|%-20f|%-20d|%-20d|%-20f|", this.maHang, this.tenHang, this.donGia, this.soLuongTon, this.thoiGianBaoHanh, this.congSuat);
		return ans;
	}
}
