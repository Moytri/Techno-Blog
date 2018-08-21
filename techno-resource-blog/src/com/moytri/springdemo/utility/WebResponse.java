package com.moytri.springdemo.utility;

import java.util.UUID;

public class WebResponse {

	private String status;
	private String message;
	private UUID id;
	private Object data;
	
	public WebResponse() {

	}

	public WebResponse(String status, String message, Object data) {
		this.status = status;
		this.message = message;
		this.data = data;
	}
	

	public WebResponse(String status, String message, UUID id, Object data) {
		this.status = status;
		this.message = message;
		this.id = id;
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "WebResponse [status=" + status + ", message=" + message + ", id=" + id + ", data=" + data + "]";
	}
		
}
