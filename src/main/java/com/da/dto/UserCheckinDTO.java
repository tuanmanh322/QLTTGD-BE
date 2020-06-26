package com.da.dto;


import com.da.model.Lop;
import com.da.model.Nhatcheckin;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class UserCheckinDTO {
    private Integer idThe;

    private String maThe;

    private String userName;

    private List<Lop> lopList;

    private List<Nhatcheckin> nhatcheckins;
}
