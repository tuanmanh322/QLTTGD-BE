package com.da.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "nhatcheckin")
@Data
public class Nhatcheckin implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

    @Column(name = "ma_nhatky")
    private String maNhatky;

    @Column(name = "ma_the")
    private String maThe;

    @Column(name = "thoigianvao")
    private Date thoigianvao;

    @Column(name = "thoigianra")
    private Date thoigianra;

    
}
