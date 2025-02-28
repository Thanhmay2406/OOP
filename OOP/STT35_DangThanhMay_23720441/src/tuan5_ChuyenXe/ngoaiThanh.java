package tuan5_ChuyenXe;

public class ngoaiThanh extends chuyenXe {
	private int soNgay;
	private String noiDen;
	
	public int getSoNgay() {
		return soNgay;
	}
	public void setSoNgay(int soNgay) {
		this.soNgay = soNgay;
	}
	public String getNoiDen() {
		return noiDen;
	}
	public void setNoiDen(String noiDen) {
		this.noiDen = noiDen;
	}
	
	public ngoaiThanh(int maSoChuyen, int soXe, String hoTenTaiXe, double doanhThu, int soNgay, String noiDen) {
		super(maSoChuyen, soXe, hoTenTaiXe, doanhThu);
		this.soNgay = soNgay;
		this.noiDen = noiDen;
	}
	@Override
	public String toString() {
		String ans = String.format("Ngoại thành\t Mã số chuyến: %d\t Họ tên tài xế: %s\t Số xe: %d\t Nơi đến: %s\t Số ngày đi được: %d\t Doanh thu: %f", this.maSoChuyen, this.hoTenTaiXe, this.soXe, this.noiDen, this.soNgay, this.doanhThu);
		return ans;
	}
}