package com.da.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class DiemSearchDTO extends BaseSearch {
    private Integer id;
    private String maDiem;

    private Integer maLop;

    private Double diemMieng;

    private Double diem15p;

    private Double diem90p;

    private Double diemTB;

    private Integer idUser;

    private String userName;

    private Date ngaySinh;

    private String kipDay;

    private String lopHoc;

    private String maThe;

    private String tenLop;

    private Integer idLop;

    private String tenMonHoc;

    private Date ngayKhaiGiang;

    private Date ngayKetThuc;
}
