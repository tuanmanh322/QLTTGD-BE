package com.da.common;

public class ParseDiemTB {
    public static Double diemTB(Double diemmieng, Double diem15p, Double diem90p) {
        return ((diemmieng + diem15p) + diem90p * 2) / 4;
    }
}
