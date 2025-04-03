package tuan8_Luong;

public class SalariedEmployee extends Employee {
	private double luongHangNam;
	private int tuanLam;
	private int tuanNghi;
	public SalariedEmployee(String name, String ssn, double luongHangNam, int tuanLam, int tuanNghi) {
		super(name, ssn);
		this.luongHangNam = luongHangNam;
		this.tuanLam = tuanLam;
		this.tuanNghi = tuanNghi;
	}
	public double getLuongHangNam() {
		return luongHangNam;
	}
	public void setLuongHangNam(double luongHangNam) {
		this.luongHangNam = luongHangNam;
	}
	public int getTuanLam() {
		return tuanLam;
	}
	public void setTuanLam(int tuanLam) {
		this.tuanLam = tuanLam;
	}
	public int getTuanNghi() {
		return tuanNghi;
	}
	public void setTuanNghi(int tuanNghi) {
		this.tuanNghi = tuanNghi;
	}
	public double tinhLuongHangTuan() {
		return luongHangNam / tuanLam;
	}
	public int tinhSoNgayNghiPhep() {
		return tuanNghi * 5;
	}
	@Override
    public String toString() {
        return String.format("%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s",
                name, ssn, String.format("%.2f", tinhLuongHangTuan()), tinhSoNgayNghiPhep(),
                luongHangNam, tuanLam, tuanNghi, "-", "-");
    }
}