package com.da.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "LOP",schema = "dbo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Lop {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "ma_lop")
    private Integer maLop;
    
    
    @Column(name = "tenlop")
    private String tenLop;

    @Column(name = "siso")
    private Long siSo;

    @Column(name = "thoigianbatdau")
    private Date thoiGianBatDau;

    @Column(name = "thoigianketthuc")
    private Date thoiGianKetThuc;

    @Column(name = "diadiem")
    private String diaDiem;

    @Column(name = "ma_monhoc")
    private Integer idMonHoc;

}
