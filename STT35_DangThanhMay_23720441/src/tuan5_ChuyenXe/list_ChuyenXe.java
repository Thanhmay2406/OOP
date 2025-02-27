package tuan5_ChuyenXe;

import java.util.ArrayList;

public class list_ChuyenXe {
	private ArrayList<chuyenXe> arr;
	
	public list_ChuyenXe() {
		arr = new ArrayList<>();
	}
	
	public void them (chuyenXe x) {
		arr.add(x);
	}
	
	public void xoa (int x) {
		arr.removeIf(it -> it.getMaSoChuyen() == x);
	}
	
	public double tongDoanhThu() {
		double ans = 0;
		for (chuyenXe it : arr) {
			ans += (it.getDoanhThu());
		}
		return ans;
	}
	
	public double tongDoanhThuNT() {
		double ans = 0;
		for (chuyenXe it : arr) {
			if (it instanceof noiThanh) {
				ans += it.getDoanhThu();
			}
		}
		return ans;
	}
	
	public double tongDoanhThuNTT() {
		double ans = 0;
		for (chuyenXe it : arr) {
			if (it instanceof ngoaiThanh) {
				ans += it.getDoanhThu();
			}
		}
		return ans;
	}
	
	public void print() {
		for (chuyenXe it : arr) {
			System.out.println(it.toString());
		}
	}
}