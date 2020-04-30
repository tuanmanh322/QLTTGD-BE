package com.da.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "BAIVIET")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class BaiViet {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "noidung")
    private String noiDung;

    @Column(name = "luotthich")
    private Long luotThich;

    @Column(name = "id_chude")
    private Integer idChuDe;
}
