package com.da.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "ROLES")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Roles {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id_role")
    private Integer idRoles;
    
    @Column(name = "name_role")
    private String roleName;

    @Column(name = "statuss")
    private String status;

}
