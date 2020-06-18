package com.da.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "users")
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

    @Column(name = "id_user")
    private String idUser;

    @Column(name = "name")
    private String name;

    @Column(name = "gioitinh")
    private String gioitinh;

    @Column(name = "ngaysinh")
    private Date ngaysinh;

    @Column(name = "socmt")
    private Integer socmt;

    @Column(name = "quoctich")
    private String quoctich;

    @Column(name = "quequan")
    private String quequan;

    @Column(name = "noiohientai")
    private String noiohientai;

    @Column(name = "hokhau")
    private String hokhau;

    @Column(name = "quatrinhlamviec")
    private String quatrinhlamviec;

    @Column(name = "email")
    private String email;

    @Column(name = "sodt")
    private String sodt;

    @Column(name = "luongcoban")
    private Double luongcoban;

    @Column(name = "ma_the")
    private Integer maThe;

    @Column(name = "ma_lop")
    private Integer maLop;

    @Column(name = "image_path")
    private String imagePath;

    @Column(name = "is_teacher")
    private Boolean isTeacher;
}
