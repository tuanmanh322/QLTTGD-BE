package com.da.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "roles_control")
@Data
@Entity
public class RolesControl implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

    @Column(name = "id_roles")
    private String idRoles;

    @Column(name = "id_controls")
    private String idControls;

    
}
