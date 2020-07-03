package com.da.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MonHocSearchDTO extends BaseSearch{
    private Integer id;

    private String maMonHoc;

    private String tenMonHoc;

}
