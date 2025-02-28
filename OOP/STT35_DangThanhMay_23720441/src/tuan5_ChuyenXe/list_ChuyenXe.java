package tuan5_ChuyenXe;

import java.util.ArrayList;

public class list_ChuyenXe {
	ArrayList <chuyenXe> arr;
	
	public list_ChuyenXe() {
		arr = new ArrayList<chuyenXe>();
	}
	
	public chuyenXe getval(int x) {
		return arr.get(x);
	}
	
	public void them (chuyenXe x) throws Exception {
		if (arr.contains(x) == false) {
			arr.add(x);
		}
		else {
			throw new Exception("ma chuyen xe khong trung");
		}
	}
	
	public chuyenXe timKiem (int x) {
		for (chuyenXe it : arr) {
			if (it.getMaSoChuyen() == x) {
				return it;
			}
		}
		return null;
	}
	
	public int timKiemViTri (int x) {
		chuyenXe ans = timKiem(x);
		if (ans == null) {
			return arr.indexOf(ans);
		}
		else {
			return -1;
		}
	}
	
	public ArrayList<noiThanh> getNoiThanh() {
		ArrayList<noiThanh> ans = new ArrayList<noiThanh>();
		for (chuyenXe it : arr) {
			if (it instanceof noiThanh) {
				ans.add((noiThanh)it);
			}
		}
		return ans;
	}
	
	public ArrayList<ngoaiThanh> getNgoaiThanh() {
		ArrayList<ngoaiThanh> ans = new ArrayList<ngoaiThanh>();
		for (chuyenXe it : arr) {
			if (it instanceof ngoaiThanh) {
				ans.add((ngoaiThanh)it);
			}
		}
		return ans;
	}
	public ArrayList<chuyenXe> getChuyenXe() {
		return arr;
	}
}