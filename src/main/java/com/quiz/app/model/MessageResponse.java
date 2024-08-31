package com.quiz.app.model;

public class MessageResponse {

	private Integer code;
	
	private String message;

	
	public MessageResponse() {
		super();
	}

	public MessageResponse(Integer code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "MessageResponse [code=" + code + ", message=" + message + "]";
	}
	
	
}
