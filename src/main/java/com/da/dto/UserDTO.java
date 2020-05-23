package com.da.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class UserDTO {
    private Integer id;

    private String maThe;

    private Date ngaycap;

    private String password;

    private Boolean trangthai;

    private String maLoaithe;

    private Integer idRole;

    private String idUser;

    private String name;

    private String gioitinh;

    private Date ngaysinh;

    private Integer socmt;

    private String quoctich;

    private String quequan;

    private String noiohientai;

    private String hokhau;

    private String quatrinhlamviec;

    private String email;

    private Integer sodt;

    private Double luongcoban;

    private Integer maLop;

    private String role;

    private String tenLop;
}
