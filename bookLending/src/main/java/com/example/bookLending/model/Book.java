package com.example.bookLending.model;

public class Book {
	
	private Integer id;
	private String bookName;
	private String authorName;
	private String doa; //date of addition
	private String status; //stock or lent

	public Book(Integer id, String bookName, String authorName, String doa, String status) {
		this.id = id;
		this.bookName = bookName;
		this.authorName = authorName;
		this.doa = doa;
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getDoa() {
		return doa;
	}
	public void setDoa(String doa) {
		this.doa = doa;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Book [authorName=" + authorName + ", bookName=" + bookName + ", dateofaddition=" + doa + ", id=" + id + ", status="
				+ status + "]";
	}

	

}
