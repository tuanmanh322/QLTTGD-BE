package com.da.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "PROVINCE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Province {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name_province")
    private String nameProvince;

    @Column(name = "note")
    private String note;


}
