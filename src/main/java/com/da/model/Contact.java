package com.da.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "contact")
@Entity
@Data
public class Contact implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "email")
    private String email;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

    @Column(name = "sdt")
    private String sdt;

    @Column(name = "status")
    private String status;

    @Column(name = "username")
    private String username;

    
}
