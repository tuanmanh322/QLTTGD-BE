package com.da.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "diem")
public class Diem implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

    @Column(name = "ma_diem")
    private String maDiem;

    @Column(name = "diemmieng")
    private Double diemmieng;

    @Column(name = "diem15p")
    private Double diem15p;

    @Column(name = "diem90p")
    private Double diem90p;

    @Column(name = "diemtb")
    private Double diemtb;
}
