package com.masai.webapp.example.exception;

import java.time.LocalDateTime;
import java.util.Objects;

public class ErrorDetails {

	private String error_message;
	private LocalDateTime error_time;
	private String uri_details;
	
	public ErrorDetails() {}

	public ErrorDetails(String error_message, LocalDateTime error_time, String uri_details) {
		super();
		this.error_message = error_message;
		this.error_time = error_time;
		this.uri_details = uri_details;
	}

	public String getError_message() {
		return error_message;
	}

	public void setError_message(String error_message) {
		this.error_message = error_message;
	}

	public LocalDateTime getError_time() {
		return error_time;
	}

	public void setError_time(LocalDateTime error_time) {
		this.error_time = error_time;
	}

	public String getUri_details() {
		return uri_details;
	}

	public void setUri_details(String uri_details) {
		this.uri_details = uri_details;
	}

	@Override
	public String toString() {
		return "ErrorDetails [error_message=" + error_message + ", error_time=" + error_time + ", uri_details="
				+ uri_details + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(error_message, error_time, uri_details);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ErrorDetails other = (ErrorDetails) obj;
		return Objects.equals(error_message, other.error_message) && Objects.equals(error_time, other.error_time)
				&& Objects.equals(uri_details, other.uri_details);
	}
	
	
	
}
