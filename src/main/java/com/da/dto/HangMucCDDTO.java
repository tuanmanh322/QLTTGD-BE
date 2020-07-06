package com.da.dto;

import com.da.model.Chude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class HangMucCDDTO {

    private Integer idHM;

    private String tenHM;

    private List<Chude> chudes;
}
