package com.da.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DiemActionDTO {
    private Integer id;

    private String maDiem;

    private Integer maLop;

    private Float diemmieng;

    private Float diem15p;

    private Float diem90p;

    private Float diemtb;

    private Integer idUser;

    private String username;

    private String tenLop;

    private String kipDay;

    private Integer idLopOld;
}
