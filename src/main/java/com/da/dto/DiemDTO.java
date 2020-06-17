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

    private Double diemHS1;

    private Double diemHS2;

    private Double diemHS3;

    private Double diemPlus;

    private String MaHocSinh;

    private String Name;

    private Integer MaLop;

    private String TenLop;

    private Integer idUser;
}
