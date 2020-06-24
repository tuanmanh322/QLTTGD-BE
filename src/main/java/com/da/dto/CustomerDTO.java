package com.da.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class CustomerDTO extends BaseSearch{
    private Integer id;

    private String maThe;

    private Date ngaycap;

    private Boolean trangthai;

    private String maLoaithe;

    private Integer idRole;

    private String username;

    private String sex;

    private Date birthday;

    private String email;
}
