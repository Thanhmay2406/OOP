package tuan2_diemTrungBinh;

public class diemTrungBinh {
    public int MSSV;
    public String hoTen;
    public float diemLT, diemTH;

    public diemTrungBinh(){
        MSSV = 0;
        hoTen = "";
        diemLT = 0;
        diemTH = 0;
    }

    public diemTrungBinh(int MSSV, String hoTen, float diemLT, float diemTH){
        this.MSSV = MSSV;
        this.hoTen = hoTen;
        this.diemLT = diemLT;
        this.diemTH = diemTH;
    }

    public void setMSSV(int MSSV){
        this.MSSV = MSSV;
    }

    public int getMSSV(){
        return MSSV;
    }

    public void setHoTen(String hoTen){
        this.hoTen = hoTen;
    }

    public String getHoTen(){
        return hoTen;
    }

    public void setDiemLT(float diemLT){
        this.diemLT = diemLT;
    }

    public float getDiemLT(){
        return diemLT;
    }

    public void setDiemTH(float diemTH){
        this.diemTH = diemTH;
    }

    public float getDiemTH(){
        return diemTH;
    }

    public float tinhDiemTB(){
        return (diemLT + diemTH) / 2;
    }
    
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	String ans = String.format("%d %s %.2f %.2f %.2f", MSSV, hoTen, diemLT, diemTH, tinhDiemTB());
    	return ans;
    }
}
