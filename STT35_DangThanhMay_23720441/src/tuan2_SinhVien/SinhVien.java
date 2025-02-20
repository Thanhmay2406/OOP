package tuan2_SinhVien;

public class SinhVien {
	private int maSV;
	private String hoTen;
	private float diemLT, diemTH;
	
	public SinhVien(int x, String y, float l, float t) {
//		super();
		this.maSV = x;
		this.hoTen = y;
		this.diemLT = l;
		this.diemTH = t;
	}
	public int getMaSV() {
		return maSV;
	}
	public void setMaSV(int maSV) {
		this.maSV = maSV;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public float getDiemLT() {
		return diemLT;
	}
	public void setDiemLT(float diemLT) {
		this.diemLT = diemLT;
	}
	public float getDiemTH() {
		return diemTH;
	}
	public void setDiemTH(float diemTH) {
		this.diemTH = diemTH;
	}
	public float diemTB()
	{
		return (this.diemLT + this.diemTH)/2;
	}
	@Override
	public String toString() {
		return String.format("%d\t%s\t%.2f\t\t%.2f", getMaSV(), getHoTen(), getDiemLT(), getDiemTH(), diemTB());
	}
}
