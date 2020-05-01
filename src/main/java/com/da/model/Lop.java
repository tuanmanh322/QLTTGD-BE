package com.da.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Table(name = "lop")
@Data
@Entity
public class Lop implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

    @Column(name = "ma_lop")
    private String maLop;

    @Column(name = "tenlop")
    private String tenlop;

    @Column(name = "siso")
    private Integer siso;

    @Column(name = "thoigianbatdau")
    private LocalDate thoigianbatdau;

    @Column(name = "thoigianketthuc")
    private LocalDate thoigianketthuc;

    @Column(name = "diadiem")
    private String diadiem;

    @Column(name = "hocphi")
    private BigDecimal hocphi;

    @Column(name = "ma_monhoc")
    private String maMonhoc;

    
}
