package com.da.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "HANGMUCBAIVIET")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class HangMucBaiViet {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tenhangmuc")
    private String temHangMuc;

    @Column(name = "mota")
    private String moTa;

    @Column(name = "ma_monhoc")
    private Integer idMonHoc;
}
