package com.datn.qltccn.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ErrorDetails {
	private Date timeStamp;
	private String errorCode;
	private String message;
	
}
