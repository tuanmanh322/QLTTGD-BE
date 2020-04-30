package com.da.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TRINHDOCHUYENMON")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class TrinhDoChuyenMon {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tentrinhdochuyenmon")
    private String tenTrinhDoCM;

    @Column(name = "loaitrinhdonchuyenmon")
    private String loaiTrinhDoCM;

    @Column(name = "ngaycap")
    private Date ngayCap;

    @Column(name = "ngayhethan")
    private Date ngayHetHan;

    @Column(name = "mota")
    private String moTa;

}
