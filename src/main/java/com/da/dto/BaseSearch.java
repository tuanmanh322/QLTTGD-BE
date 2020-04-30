package com.da.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public abstract class BaseSearch {
    private Long totalRecord;
    private Integer page;
    private Integer totalPage;
    private Integer pageSize;
    private List<OrderDTO> orderDTOS;
    private List<?> data;
}
