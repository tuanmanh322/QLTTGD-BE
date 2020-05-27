package com.da.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Table(name = "repcomment")
@Entity
public class Repcomment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

    @Column(name = "ma_repcomment")
    private String maRepcomment;

    @Column(name = "noidung")
    private String noidung;

    @Column(name = "luotthich")
    private Integer luotthich;

    @Column(name = "luotkhongthich")
    private Integer luotkhongthich;

    @Column(name = "id_comment")
    private Integer idComment;

    @Column(name = "id_user")
    private Integer idUser;
    
}
