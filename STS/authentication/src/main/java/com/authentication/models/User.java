package com.authentication.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "users")
public class User {
//	MEMBERS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "Username required")
	@Size(min = 3, max = 30, message = "Username must be between 3 and 30 characters")
	private String userName;

	@NotEmpty(message = "Email required")
	@Email(message = "Please enter a valid email!")
	private String email;

	@NotEmpty(message = "Password required")
	@Size(min = 8, max = 128, message = "Password must be between 8 and 128 characters")
	private String password;

	@Transient
	@NotEmpty(message = "Must Confirm Password")
	@Size(min = 8, max = 128, message = "Confirm Password must be between 8 and 128 characters")
	private String confirm;

//	JOIN
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<BookModel> userBooks;

	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

//  CONSTRUCTORS
	public User() {
	}

	public User(Long id,
			@NotEmpty(message = "Username required") @Size(min = 3, max = 30, message = "Username must be between 3 and 30 characters") String userName,
			@NotEmpty(message = "Email required") @Email(message = "Please enter a valid email!") String email,
			@NotEmpty(message = "Password required") @Size(min = 8, max = 128, message = "Password must be between 8 and 128 characters") String password,
			@NotEmpty(message = "Must Confirm Password") @Size(min = 8, max = 128, message = "Confirm Password must be between 8 and 128 characters") String confirm,
			Date createdAt, Date updatedAt) {
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.confirm = confirm;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

//  PRECURSORS
	@PrePersist // always do something before we save an object
	protected void onCreate() {
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}

	@PreUpdate // do something before we save every time
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

//	GETTERS
	public Long getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getConfirm() {
		return confirm;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public List<BookModel> getUserBooks() {
		return userBooks;
	}

	// SETTERS
	public void setId(Long id) {
		this.id = id;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setUserBooks(List<BookModel> userBooks) {
		this.userBooks = userBooks;
	}
	

}
