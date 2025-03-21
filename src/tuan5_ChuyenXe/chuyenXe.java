package tuan5_ChuyenXe;

import java.util.Objects;

public class chuyenXe {
	protected int maSoChuyen, soXe;
	protected String hoTenTaiXe;
	protected double doanhThu;
	
	public int getMaSoChuyen() {
		return maSoChuyen;
	}
	public void setMaSoChuyen(int maSoChuyen) {
		this.maSoChuyen = maSoChuyen;
	}
	public int getSoXe() {
		return soXe;
	}
	public void setSoXe(int soXe) {
		this.soXe = soXe;
	}
	public String getHoTenTaiXe() {
		return hoTenTaiXe;
	}
	public void setHoTenTaiXe(String hoTenTaiXe) {
		this.hoTenTaiXe = hoTenTaiXe;
	}
	public double getDoanhThu() {
		return doanhThu;
	}
	public void setDoanhThu(double doanhThu) {
		this.doanhThu = doanhThu;
	}
	
	public chuyenXe(int maSoChuyen, int soXe, String hoTenTaiXe, double doanhThu) {
		super();
		this.maSoChuyen = maSoChuyen;
		this.soXe = soXe;
		this.hoTenTaiXe = hoTenTaiXe;
		this.doanhThu = doanhThu;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maSoChuyen);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		chuyenXe other = (chuyenXe) obj;
		return maSoChuyen == other.maSoChuyen;
	}
	
}
