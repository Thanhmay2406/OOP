package tuan4_CD;

public class CDList {
	private CD[] arr;
	int size, size_max;
	
	public CDList (int size) {
		super();
		this.size = 0;
		this.size_max = size;
		this.arr = new CD[size];
	}
	
	public CD getCD(int i) {
		return arr[i];
	}
	
	// tim kiem
	public int search (int x) {
		for (int i=0 ; i<size ; i++) {
			if (arr[i].getMaCD() == x) {
				return i;
			}
		}
		return -1;
	}
	
	// them cd
	public boolean add (CD x) {
		if (x.getMaCD() < 0 || x.getTuaCD() == "" || x.getSoBaiHat() < 0 || x.getGiaThanh() <= 0) {
			return false;
		}
		if (search(x.getMaCD()) != -1) {
			return false;
		}
		if (size == size_max) {
			return false;
		}
		arr[size] = x;
		size++;
		return true;
	}
	
	// to string
	public void to_string() {
		for (int i=0 ; i<size ; i++) {
			System.out.println(arr[i].toString());
		}
	}
	
	// xoa cd
	public boolean delete (int x) {
		int indx = search(x);
		if (indx == -1) {
			return false;
		}
		for (int i = indx ; i<size-1 ; i++) {
			arr[i] = arr[i+1];
		}
		size--;
		return true;
	}
	
	// tinh tong gia
	public double sum () {
		double ans = 0;
		for (int i=0 ; i<size ; i++) {
			ans += arr[i].getGiaThanh();
		}
		return ans;
	}
	
	// sap xep giam dan theo gia thanh
	public void sort() {
		for (int i=0 ; i<size ; i++) {
			int max_index = i;
			for (int j=i+1 ; j<size ; j++) {
				if (arr[max_index].getGiaThanh() < arr[j].getGiaThanh()) {
					max_index = j;
				}
			}
			CD temp = arr[i];
			arr[i] = arr[max_index];
			arr[max_index] = temp;
		}
	}
	
	// sap xep tang dan theo ma cd
	public void sort2() {
		for (int i=0 ; i<size ; i++) {
			int min_index = i;
			for (int j=i+1 ; j<size ; j++) {
				if (arr[min_index].getMaCD() > arr[j].getMaCD()) {
					min_index = j;
				}
			}
			CD temp = arr[i];
			arr[i] = arr[min_index];
			arr[min_index] = temp;
		}
	}
}