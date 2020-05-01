package com.da.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

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
    private LocalDate ngaycap;

    @Column(name = "trangthai")
    private String trangthai;

    @Column(name = "ma_loaithe")
    private String maLoaithe;

    
}
