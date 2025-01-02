package Tuan1.Bai1;

public class HinhChuNhat {
    private float chieuDai, chieuRong;

    public void setChiueDai(float chieuDai) {
        this.chieuDai = chieuDai;
    }

    public float getChieuDai() {
        return this.chieuDai;
    }

    public void setChieuRong(float chieuRong) {
        this.chieuRong = chieuRong;
    }

    public float getChieuRong() {
        return this.chieuRong;
    }

    public HinhChuNhat(float x, float y) {
        super();
        this.chieuDai = x;
        this.chieuRong = y;
    }

    public float chuVi() {
        return (this.chieuDai + this.chieuRong) * 2;
    }

    public float dienTich() {
        return this.chieuDai * this.chieuRong;
    }

    @Override
    public String toString() {
        return "HinhChuNhat{" +
                "chieuDai=" + chieuDai +
                ", chieuRong=" + chieuRong +
                ", chuVi=" + chuVi() +
                ", dienTich=" + dienTich() +
                '}';
    }
}