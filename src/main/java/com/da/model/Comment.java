package com.da.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Table(name = "comment")
@Entity
@Data
public class Comment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

    @Column(name = "ma_comment")
    private String maComment;

    @Column(name = "noidung")
    private String noidung;

    @Column(name = "luotthich")
    private Integer luotthich;

    @Column(name = "loutkhongthich")
    private Integer loutkhongthich;

    @Column(name = "id_user")
    private Integer idUser;

    @Column(name = "id_baiviet")
    private Integer idBaiViet;

    @Column(name = "created_date")
    private LocalDateTime commentDate;

    @Column(name = "image_path")
    private String imageCM;
}
