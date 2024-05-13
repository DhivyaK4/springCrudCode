package com.example.demo.exception;

import java.sql.Date;

public class Error {
	private Date timestamp;
	private String message;
	private String details;

	public Error(java.util.Date date, String message, String details) {
		super();
		this.timestamp = (Date) date;
		this.message = message;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}
}
