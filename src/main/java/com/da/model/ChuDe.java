package com.da.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "CHUDE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ChuDe {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tenchude")
    private String tenChuDe;

    @Column(name = "tieude")
    private String tieuDe;

    @Column(name = "noidung")
    private String noiDung;

    @Column(name = "luotxem")
    private Long luotXem;

    @Column(name = "luotthich")
    private Long luotThich;

    @Column(name = "ma_theloai")
    private Integer idTheLoai;
}
