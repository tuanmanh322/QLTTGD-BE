package com.da.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "the")
public class The implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

    @Column(name = "ma_the")
    private String maThe;

    @Column(name = "ngaycap")
    private Date ngaycap;

    @Column(name = "password")
    private String password;

    @Column(name = "trangthai")
    private Boolean trangthai;

    @Column(name = "ma_loaithe")
    private String maLoaithe;

    
}
