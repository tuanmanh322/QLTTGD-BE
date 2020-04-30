package com.da.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "ROLES_ACTION")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class RoleAction {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id_roles")
    private Integer idRoles;

    @Column(name = "id_action")
    private Integer idAction;

}
