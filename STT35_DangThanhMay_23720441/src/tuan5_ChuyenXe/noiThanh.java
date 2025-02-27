package tuan5_ChuyenXe;

public class noiThanh extends chuyenXe {
	private int soTuyen;
	private double soKm;
	
	public int getSoTuyen() {
		return soTuyen;
	}
	public void setSoTuyen(int soTuyen) {
		this.soTuyen = soTuyen;
	}
	public double getSoKm() {
		return soKm;
	}
	public void setSoKm(double soKm) {
		this.soKm = soKm;
	}
	
	public noiThanh(int maSoChuyen, int soXe, String hoTenTaiXe, double doanhThu, int soTuyen, double soKm) {
		super(maSoChuyen, soXe, hoTenTaiXe, doanhThu);
		this.soTuyen = soTuyen;
		this.soKm = soKm;
	}
	@Override
	public String toString() {
		String ans = String.format("Nội thành\t Mã số chuyến: %d\t Họ tên tài xế: %s\t Số xe: %d\t Số tuyến: %d\t Số km đi được: %f\t Doanh thu: %f", this.maSoChuyen, this.hoTenTaiXe, this.soXe, this.soTuyen, this.soKm, this.doanhThu);
		return ans;
	}
}