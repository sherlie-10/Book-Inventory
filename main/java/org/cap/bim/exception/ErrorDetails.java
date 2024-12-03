package org.cap.bim.exception;


import lombok.Data;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ErrorDetails {
	
	private String timestamp;
	private String message;
	private String description;
	
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	

}
