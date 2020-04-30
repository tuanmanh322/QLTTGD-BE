package com.da.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Ward")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Ward {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name_district")
    private String nameDistrict;

    @Column(name = "note")
    private String note;
}
