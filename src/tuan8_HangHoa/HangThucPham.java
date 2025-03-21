package tuan8_HangHoa;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

class HangThucPham extends HangHoa {
    private String nhaCungCap;
    private Date ngaySanXuat;
    private Date ngayHetHan;

    public String getNhaCungCap() {
		return nhaCungCap;
	}

	public void setNhaCungCap(String nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}

	public Date getNgaySanXuat() {
		return ngaySanXuat;
	}

	public void setNgaySanXuat(Date ngaySanXuat) {
		this.ngaySanXuat = ngaySanXuat;
	}

	public Date getNgayHetHan() {
		return ngayHetHan;
	}

	public void setNgayHetHan(Date ngayHetHan) {
		this.ngayHetHan = ngayHetHan;
	}

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
    	Locale lc = new Locale("vi", "VN");
    	DateFormat df = DateFormat.getDateInstance(3, lc);
    	NumberFormat nf = NumberFormat.getCurrencyInstance(lc);
		String ans = String.format("|%-20s|%-20s|%-20f|%-20d|%-20s|%-20s|", this.maHang, this.tenHang, this.donGia, this.soLuongTon, df.format(getNgaySanXuat().getTime()), df.format(getNgayHetHan().getTime()));
		return ans;
	}
}