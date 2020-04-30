package com.da.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "ACTIONS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Actions {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name_actions")
    private String actionName;

    @Column(name = "statuss")
    private String status;

}
