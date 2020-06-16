package com.da.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "users_diem_map")
@Entity
@Data
public class UsersDiemMap implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

    @Column(name = "id_diem")
    private Integer idDiem;

    @Column(name = "id_user")
    private Integer idUser;

    
}
