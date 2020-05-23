package com.da.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginDTO {
    private String maThe;
    private String password;

    @JsonProperty
    private boolean rememberMe;
}
