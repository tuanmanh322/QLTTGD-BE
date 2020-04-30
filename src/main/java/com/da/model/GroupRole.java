package com.da.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "GROUPS_ROLE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class GroupRole {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id_roles")
    private Integer idRoles;

    @Column(name = "id_group")
    private Integer idGroup;

}
