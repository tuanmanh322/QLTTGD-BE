package com.da.dto;

import lombok.*;

import java.util.Date;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiemToExcelDTO {

    private Integer id;
    private String maDiem;

    private Integer maLop;

    private Float diemMieng;

    private Float diem15p;

    private Float diem90p;

    private Float diemTB;

    private Integer idUser;

    private String userName;

    private Date ngaySinh;

    private String kipDay;

    private String lopHoc;

    private String maThe;

    private String tenLop;

    private Integer idLop;

    private String tenMonHoc;
}
