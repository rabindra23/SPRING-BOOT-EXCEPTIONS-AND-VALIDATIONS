package com.masai.webapp.example.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
public class Post {

	@Id
	private int pId;
	@Size(max=100,message= "{message.invalid}")
	private String message;
	@Past(message="{date.invalid}")
	private Date creationDate;
	private Date updationDate;
	@AssertTrue(message="{visibility}")
	private boolean isVisible;
	@Size(min=8,message="{username.invalid}")
	private String username;
	@Email(message="{email.invalid}")
	private String user_email;
	
	public Post() {}

	public Post(int pId, String message, Date creationDate, Date updationDate, boolean isVisible, String username,
			String user_email) {
		super();
		this.pId = pId;
		this.message = message;
		this.creationDate = creationDate;
		this.updationDate = updationDate;
		this.isVisible = isVisible;
		this.username = username;
		this.user_email = user_email;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getUpdationDate() {
		return updationDate;
	}

	public void setUpdationDate(Date updationDate) {
		this.updationDate = updationDate;
	}

	public boolean isVisible() {
		return isVisible;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	@Override
	public String toString() {
		return "Post [pId=" + pId + ", message=" + message + ", creationDate=" + creationDate + ", updationDate="
				+ updationDate + ", isVisible=" + isVisible + ", username=" + username + ", user_email=" + user_email
				+ "]";
	}
	
	
}
