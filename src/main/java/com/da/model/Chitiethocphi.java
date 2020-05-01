package com.da.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "chitiethocphi")
@Data
public class Chitiethocphi implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

    @Column(name = "tenhocphi")
    private String tenhocphi;

    @Column(name = "giatien")
    private BigDecimal giatien;

    @Column(name = "ngaythu")
    private Date ngaythu;

    @Column(name = "trangthai")
    private String trangthai;

    
}
