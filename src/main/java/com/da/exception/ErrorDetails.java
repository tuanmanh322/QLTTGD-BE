package com.da.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ErrorDetails {
	private Date timeStamp;
	private String errorCode;
	private String message;
	
}
