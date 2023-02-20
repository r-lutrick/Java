package com.authentication.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity; // @Entity: represents an entity model for our application
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue; // @GeneratedValue: sets this as an auto-incrementing value
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table; // @Table: sets this as a table in the database
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "books")
public class BookModel {
//	MEMBERS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 5, max = 200)
	private String title;
	
	@NotNull
	@Size(min = 5, max = 200)
	private String description;

	@NotNull
	@Size(min = 3, max = 40)
	private String language;
	
	@NotNull
	@Min(100)
	private Integer numberOfPages;
	
//	JOIN
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	
//  CREATED & UPDATED AT 
	@Column(updatable = false) // This will not allow the createdAt column to be updated after creation
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

//  CONSTRUCTORS
	public BookModel() {
	}

	public BookModel(String title, String description, String language, Integer numberOfPages) {
		this.title = title;
		this.description = description;
		this.language = language;
		this.numberOfPages = numberOfPages;
	}

//	PRECURSORS
	@PrePersist // always do something before we save an object
	protected void onCreate() {
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}

	@PreUpdate // do something before we save every time
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

//  GETTERS & SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Integer getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(Integer numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
