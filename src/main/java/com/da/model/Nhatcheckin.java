package com.da.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

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
    private Integer maThe;

    @Column(name = "status")
    private String status;

    @Column(name = "thoigianvao")
    private LocalDateTime thoigianvao;

    @Column(name = "id_lop")
    private Integer idLop;

}
