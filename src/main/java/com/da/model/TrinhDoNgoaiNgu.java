package com.da.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TRINHDONGOAINGU")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class TrinhDoNgoaiNgu {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tentrinhdongoaingu")
    private String tenTrinhDo;

    @Column(name = "loaitrinhdongoaingu")
    private String loaiTrinhDo;

    @Column(name = "ngaycap")
    private Date ngayCap;

    @Column(name = "ngayhethan")
    private Date ngayHetHan;

    @Column(name = "mota")
    private String moTa;


}
