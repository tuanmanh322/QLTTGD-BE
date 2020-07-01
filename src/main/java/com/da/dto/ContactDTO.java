package com.da.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ContactDTO {
    private String email;

    private Integer id;

    private String sdt;

    private String status;

    private String username;
}
