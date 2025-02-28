package tuan3_Xe;

public class Xe {
	private String ten, loai;
	private int dungTich;
	private float gia;
	
	
	
	public Xe(String ten, String loai, int dungTich, float gia) {
		super();
		this.ten = ten;
		this.loai = loai;
		this.dungTich = dungTich;
		this.gia = gia;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getLoai() {
		return loai;
	}
	public void setLoai(String loai) {
		this.loai = loai;
	}
	public int getDungTich() {
		return dungTich;
	}
	public void setDungTich(int dungTich) {
		this.dungTich = dungTich;
	}
	public float getGia() {
		return gia;
	}
	public void setGia(float gia) {
		this.gia = gia;
	}
	
	public float thue()
	{
		float ans = 0;
		if (dungTich < 100)
		{
			ans = this.gia * 1 / 100;
		}
		else if (dungTich >= 100 && dungTich <= 200)
		{
			ans = this.gia * 3 / 100;
		}
		else
		{
			ans = this.gia * 5 / 100;
		}
		return ans;
	}
	@Override
	public String toString() {
		return String.format("%s \t %s \t %d \t %f \t %f", getTen(), getLoai(), getDungTich(), getGia(), thue());
	}
	
	
}
