package tuan6_NhaDat;

import java.util.ArrayList;
import java.util.List;

public class list_GiaoDich {
	
	ArrayList <giaoDich> ls;

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
	
	public ArrayList<giaoDich> getDS() {
		return ls;
	}
	
	public giaoDich timGiaoDich(String maGD) {
		for (giaoDich g: ls) {
			if (g.getMaGD().equalsIgnoreCase(maGD)) {
				return g;
			}
		}
		
		return null;
	}
	
	public double avgThanhTien1() {
		double sum = 0;
		for (giaoDich g : ls) {
			if (g instanceof giaoDichDat) {
				sum += g.getThanhTien();
			}
		}
		
		return (double)sum / ls.size();
	}
	
	public double avgThanhTien2() {
		double sum = 0;
		for (giaoDich g : ls) {
			if (g instanceof giaoDichNha) {
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
