package com.da.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "THE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class The {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ma_the")
    private Integer maThe;

    @Column(name="password")
    private String password;
    
    @Column(name = "trangthai")
    private Boolean trangThai;

    @Column(name = "ngaycap")
    private Date ngayCap;

    @Column(name = "ma_loaithe")
    private Integer idLoaiThe;
}
