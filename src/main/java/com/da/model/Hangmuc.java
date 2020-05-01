package com.da.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "hangmuc")
@Data
public class Hangmuc implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

    @Column(name = "ma_hangmucbaiviet")
    private String maHangmucbaiviet;

    @Column(name = "tenhangmuc")
    private String tenhangmuc;

    @Column(name = "mota")
    private String mota;

    @Column(name = "ma_monhoc")
    private String maMonhoc;

    
}
