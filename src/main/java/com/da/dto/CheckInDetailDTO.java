package com.da.dto;

import com.da.model.Nhatcheckin;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


@Getter
@Setter
@ToString
public class CheckInDetailDTO {
    private String userName;

    private String maThe;

    private Integer idRole;

    private List<Nhatcheckin> nhatcheckins;
}
