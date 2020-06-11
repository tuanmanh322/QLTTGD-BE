package com.da.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class NotificationDTO {
    private Integer id;

    private Integer idThe;

    private Integer idAction;

    private Integer read;

    private String message;

    private LocalDateTime createdDate;
}
