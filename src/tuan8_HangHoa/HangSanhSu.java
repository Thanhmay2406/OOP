package tuan8_HangHoa;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

class HangSanhSu extends HangHoa {
    private String nhaSanXuat;
    private Date ngayNhapKho;

    public String getNhaSanXuat() {
		return nhaSanXuat;
	}

	public void setNhaSanXuat(String nhaSanXuat) {
		this.nhaSanXuat = nhaSanXuat;
	}

	public Date getNgayNhapKho() {
		return ngayNhapKho;
	}

	public void setNgayNhapKho(Date ngayNhapKho) {
		this.ngayNhapKho = ngayNhapKho;
	}

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
    	Locale lc = new Locale("vi", "VN");
    	DateFormat df = DateFormat.getDateInstance(3, lc);
    	NumberFormat nf = NumberFormat.getCurrencyInstance(lc);
		String ans = String.format("|%-20s|%-20s|%-20f|%-20d|%-20s|%-20s|", this.maHang, this.tenHang, this.donGia, this.soLuongTon, this.nhaSanXuat, df.format(getNgayNhapKho().getTime()));
		return ans;
	}
}