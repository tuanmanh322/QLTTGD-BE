package com.da.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class LopHocRequestDTO extends BaseSearch{

    private Integer idULM;

    private String username;

    private String maThe;

    private String maLop;

    private String tenLop;

    private String kipDay;

    private Date startDate;

    private Date endDate;

    private Integer siSo;

    private Double hocPhi;

    private Integer active;
}
