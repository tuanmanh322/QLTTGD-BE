package com.da.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "GROUPS_NHANVIEN")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class GroupNhanVien {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id_group")
    private String idGroups;


    @Column(name = "ma_nhanvien")
    private String idNhanVien;
}
