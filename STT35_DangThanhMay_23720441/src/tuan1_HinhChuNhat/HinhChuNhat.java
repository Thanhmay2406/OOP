package tuan1_HinhChuNhat;

public class HinhChuNhat {
	 private double dai, rong;

	public HinhChuNhat(double dai, double rong) {
		this.dai = dai;
		this.rong = rong;
	}

	public double getDai() {
		return dai;
	}

	public void setDai(double dai) {
		this.dai = dai;
	}

	public double getRong() {
		return rong;
	}

	public void setRong(double rong) {
		this.rong = rong;
	}
	
	public double chuVi() {
		return (this.dai + this.rong) * 2;
	}
	
	public double dienTich() {
		return this.dai * this.rong;
	}

	@Override
	public String toString() {
		String ans = String.format("chiều dài: %.2f\t chiều rộng: %.2f\tchu vi: %.2f\t diện tích: %.2f", getDai(), getRong(), chuVi(), dienTich());
		return ans;
	}
}
