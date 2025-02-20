package tuan4_CD;

public class CD {
	private int maCD, soBaiHat;
	private String tuaCD;
	private double giaThanh;
	
	public CD(int maCD, int soBaiHat, String tuaCD, double giaThanh) {
		super();
		this.maCD = maCD;
		this.soBaiHat = soBaiHat;
		this.tuaCD = tuaCD;
		this.giaThanh = giaThanh;
	}
	
	public CD() {
		super();
		this.maCD = 999999;
		this.soBaiHat = 0;
		this.tuaCD = "chưa xác định";
		this.giaThanh = 0;
	}
	
	public int getMaCD() {
		return maCD;
	}
	public void setMaCD(int maCD) {
		this.maCD = maCD;
	}
	public int getSoBaiHat() {
		return soBaiHat;
	}
	public void setSoBaiHat(int soBaiHat) {
		this.soBaiHat = soBaiHat;
	}
	public String getTuaCD() {
		return tuaCD;
	}
	public void setTuaCD(String tuaCD) {
		this.tuaCD = tuaCD;
	}
	public double getGiaThanh() {
		return giaThanh;
	}
	public void setGiaThanh(double giaThanh) {
		this.giaThanh = giaThanh;
	}
	
	@Override
	public String toString() {
//		return "CDList [maCD=" + maCD + ", soBaiHat=" + soBaiHat + ", tuaCD=" + tuaCD + ", giaThanh=" + giaThanh + "]";
		String ans = maCD + " " + soBaiHat + " " + tuaCD + " " + giaThanh;
		return ans;
	}
}
