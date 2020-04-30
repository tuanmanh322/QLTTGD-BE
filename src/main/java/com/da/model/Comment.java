package com.da.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "COMMENT")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Comment {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "noidung")
    private String noiDung;

    @Column(name = "luotthich")
    private Long luotThich;

    @Column(name = "ma_baiviet")
    private Integer maBaiViet;
}
