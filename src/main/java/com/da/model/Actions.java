package com.da.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "actions")
public class Actions implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

    @Column(name = "id_actions")
    private String idActions;

    @Column(name = "name_actions")
    private String nameActions;

    @Column(name = "statuss")
    private String statuss;

    
}
