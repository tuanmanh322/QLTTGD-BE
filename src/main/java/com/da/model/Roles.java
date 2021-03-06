package com.da.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Table(name = "roles")
@Entity
public class Roles implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

    @Column(name = "id_role")
    private String idRole;

    @Column(name = "name_role")
    private String nameRole;

    @Column(name = "statuss")
    private String statuss;

    
}
