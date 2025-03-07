package tuan6_NhaDat;

import java.util.ArrayList;
import java.util.List;

public class list_GiaoDich {
	
	ArrayList<giaoDich> ls;

	public list_GiaoDich() {
		ls = new ArrayList<giaoDich>(10);
	}
	
	public boolean themGiaoDich(giaoDich g) {
		if (ls.contains(g)) {
			return false;
		} else {
			return ls.add(g);
		}
	}
	
//	public void inGiaoDich() {
//		for (giaoDich g : ls) {
//			System.out.println(g);
//		}
//	}
	
//	public List<giaoDich> 
	
	public giaoDich timGiaoDich(String maGD) {
		for (giaoDich g: ls) {
			if (g.getMaGD().equalsIgnoreCase(maGD)) {
				return g;
			}
		}
		
		return null;
	}
	
	public double avgThanhTien() {
		double sum = 0;
		for (giaoDich g : ls) {
			if (g instanceof giaoDichDat) {
				sum += g.getThanhTien();
			}
		}
		
		return (double)sum / ls.size();
	}

	public int countGDD() {
		int count = 0;
		for (giaoDich g : ls) {
			if (g instanceof giaoDichDat) {
				count++;
			}
		}

		return count;
	}
	
	public int countGDN() {
		int count = 0;
		for (giaoDich g : ls) {
			if (g instanceof giaoDichNha) {
				count++;
			}
		}

		return count;
	}
	
	public boolean xoaGiaoDich(String maGD) {
		giaoDich g = timGiaoDich(maGD);

		if (g != null) {
			return ls.remove(g);
		} else {
			return false;
		}
	}
}
