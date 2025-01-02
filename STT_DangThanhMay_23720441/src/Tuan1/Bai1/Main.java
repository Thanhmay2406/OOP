package Tuan1.Bai1;

import Tuan1.Bai1.HinhChuNhat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter length: ");
        float chieuDai = sc.nextFloat();

        System.out.print("Enter width: ");
        float chieuRong = sc.nextFloat();

        HinhChuNhat h1 = new HinhChuNhat(chieuDai, chieuRong);
        System.out.println(h1);
    }
}