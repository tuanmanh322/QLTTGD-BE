package com.da.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class CardDTO {
    private Integer id;


    private String maThe;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date ngaycap;


    private String password;


    private String trangthai;


    private String nameRole;
}
