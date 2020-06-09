package com.da.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Table(name = "baiviet")
public class Baiviet implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

    @Column(name = "ma_baiviet")
    private String maBaiviet;

    @Column(name = "noidung")
    private String noidung;

    @Column(name = "luotthich")
    private Integer luotthich;

    @Column(name = "luotkhongthich")
    private Integer luotkhongthich;

    @Column(name = "ma_chude")
    private Integer ma_chude;

    @Column(name = "id_the")
    private Integer idThe;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "title")
    private String title;

    @Column(name = "image_path")
    private String imageBV;

    @Column(name = "trangthai")
    private Boolean trangthai;
}
