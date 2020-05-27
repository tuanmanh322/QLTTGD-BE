package com.da.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DiemDTO extends BaseSearch{
    private Integer id;

    private String ma_diem;

    private float diemHS1;

    private float diemHS2;

    private float diemHS3;

    private float diemPlus;

    private String MaHocSinh;

    private String Name;

    private String MaLop;

    private String TenLop;
}
