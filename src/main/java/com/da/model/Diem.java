package com.da.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "DIEM")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Diem {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ma_diem")
    private Integer maDiem;

    @Column(name = "ma_lop")
    private Integer maLop;

    @Column(name = "diemmieng")
    private Float diemMieng;

    @Column(name = "diem15p")
    private Float diem15P;

    @Column(name = "diem90p")
    private Float diem90P;

    @Column(name = "diemtb")
    private Float diemTB;

    @Column(name = "id_user")
    private Integer idUser;
}
