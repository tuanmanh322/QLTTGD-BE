package com.da.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "BANGCAP")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class BangCap {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tenbangcap")
    private String tenBangCap;

    @Column(name = "ngaycap")
    private Date ngayCap;

    @Column(name = "ngayhethan")
    private Date ngayHetHan;

    @Column(name = "mota")
    private String moTa;

    @Column(name = "loaibangcap")
    private String loaiBangCap;


}
