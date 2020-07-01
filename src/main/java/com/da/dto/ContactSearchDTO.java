package com.da.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ContactSearchDTO extends BaseSearch {
    private String email;

    private Integer id;

    private String sdt;

    private String status;

    private String username;
}
