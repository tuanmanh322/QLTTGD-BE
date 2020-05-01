package com.da.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "controls")
@Entity
@Data
public class Controls implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

    @Column(name = "id_controls")
    private String idControls;

    @Column(name = "name_controls")
    private String nameControls;

    @Column(name = "statuss")
    private String statuss;

    
}
