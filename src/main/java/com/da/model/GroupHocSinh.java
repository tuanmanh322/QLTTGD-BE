package com.da.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "GROUPS_HOCSINH")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class GroupHocSinh {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id_group")
    private String idGroups;


    @Column(name = "ma_hocsinh")
    private String idHocSinh;
}
