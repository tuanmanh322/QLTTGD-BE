package com.da.common;

public class ParseDiemTB {
    public static Float diemTB(Float diemmieng, Float diem15p, Float diem90p) {
        return ((diemmieng + diem15p) + diem90p * 2) / 4;
    }
}
