package com.da.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "chude")
public class Chude implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

    @Column(name = "ma_chude")
    private String maChude;

    @Column(name = "tenchude")
    private String tenchude;

    @Column(name = "noidung")
    private String noidung;

    
}
