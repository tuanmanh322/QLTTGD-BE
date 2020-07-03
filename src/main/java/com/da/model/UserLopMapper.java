package com.da.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "user_lop_mapper")
public class UserLopMapper implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

    @Column(name = "id_lop")
    private Integer idLop;

    @Column(name = "id_user")
    private Integer idUser;

    @Column(name = "trangthai")
    private Boolean active;

    @Column(name = "is_teach")
    private Boolean isTeach;
}
