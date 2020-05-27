package com.da.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class CheckInDTO extends BaseSearch{
    private int Id;

    private String MaNhatKy;

    private String MaThe;

    private String Thoigianvao;

    private String MaLop;

    private String TenThe;

    private String TenLop;

    private String tenHocSinh;
}
