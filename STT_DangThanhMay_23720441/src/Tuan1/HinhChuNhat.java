package Tuan1;

import java.util.Scanner;

public class HinhChuNhat {
    private double chieuDai, chieuRong;

    public HinhChuNhat(double chieuDai, double chieuRong) {
        this.chieuDai = chieuDai;
        this.chieuRong = chieuRong;
    }

    public double getChieuDai() {
        return chieuDai;
    }

    public void setChieuDai(double chieuDai) {
        this.chieuDai = chieuDai;
    }

    public double getChieuRong() {
        return chieuRong;
    }

    public void setChieuRong(double chieuRong) {
        this.chieuRong = chieuRong;
    }

    public double chuVi() {
        return (this.getChieuDai() + this.getChieuRong()) * 2;
    }

    public double dienTich() {
        return this.getChieuDai() * this.getChieuRong();
    }

    @Override
    public String toString() {
        return String.format("Chieu dai: %.2f, Chieu rong: %.2f, Chu vi: %.2f, Dien tich: %.2f",
                              getChieuDai(), getChieuRong(), chuVi(), dienTich());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap chieu dai: ");
        double a = sc.nextDouble();
        System.out.print("Nhap chieu rong: ");
        double b = sc.nextDouble();

        HinhChuNhat h1 = new HinhChuNhat(a, b);
        System.out.println("Hinh chu nhat 1: " + h1);
    }
}
