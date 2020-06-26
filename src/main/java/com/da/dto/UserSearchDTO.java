package com.da.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserSearchDTO extends BaseSearch {
    private Integer idThe;

    private String maThe;

    private String createDate;

    private Integer idRole;

    private String active;

    private String userName;

    private String emailUser;

    private String sex;



}
