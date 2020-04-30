package com.da.model;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "USERS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Users implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "id_user")
    private Integer idUser;

    @Column(name = "name")
    private String name;

    @Column(name = "gioitinh")
    private Boolean gioiTinh;

    @Column(name = "ngaysinh")
    private Date ngaySinh;

    @Column(name = "socmt")
    private String soCMT;

    @Column(name = "quoctich")
    private String quocTich;

    @Column(name = "quequan")
    private String queQuan;

    @Column(name = "noiohientai")
    private String noiOHienTai;

    @Column(name = "hokhau")
    private String hoKhau;

    @Column(name = "quatrinhlamviec")
    private String quaTrinhLamViec;

    @Column(name = "email")
    private String email;

    @Column(name = "sodt")
    private String soDT;

    @Column(name = "luongcoban")
    private Float luongCoBan;

    @Column(name = "id_the")
    private Integer idThe;

    @Column(name = "id_lop")
    private Integer idLop;

}
