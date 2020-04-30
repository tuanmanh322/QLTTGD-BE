package com.da.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "NHATCHECKIN")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class NhatCheckin {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ma_the")
    private Integer idMaThe;

    @Column(name = "id_user")
    private Integer idUser;

    @Column(name = "thoigianvao")
    private Date thoiGianVao;

    @Column(name = "thoigianra")
    private Date thoiGianRa;

}
