package Tuan1.Bai2;

public class SinhVien {
    public int MSSV;
    public String hoTen;
    public float diemLT, diemTH;

    public SinhVien(){
        MSSV = 0;
        hoTen = "";
        diemLT = 0;
        diemTH = 0;
    }

    public SinhVien(int MSSV, String hoTen, float diemLT, float diemTH){
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

    public void xuat(){
        System.out.println("MSSV: " + MSSV);
        System.out.println("Ho ten: " + hoTen);
        System.out.println("Diem LT: " + diemLT);
        System.out.println("Diem TH: " + diemTH);
        System.out.println("Diem TB: " + tinhDiemTB());
    }
}
