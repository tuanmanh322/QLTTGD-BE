package com.da.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "CONTROLS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Control {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name_controls")
    private String nameControl;

    @Column(name = "statuss")
    private String status;
}
