package com.da.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "LOAITHE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class LoaiThe {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tenloaithe")
    private String tenLoaiThe;

}
