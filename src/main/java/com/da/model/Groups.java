package com.da.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "groups")
@Data
public class Groups implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

    @Column(name = "id_group")
    private String idGroup;

    @Column(name = "name_group")
    private String nameGroup;

    @Column(name = "statuss")
    private String statuss;

    
}
