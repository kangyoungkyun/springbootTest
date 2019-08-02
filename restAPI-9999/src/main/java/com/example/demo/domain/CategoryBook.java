package com.example.demo.domain;


public class CategoryBook {

	

	 
	 private Long categoryno;
	 private String categoryname;
	 private Long no;
	 private String title;
	 
	 
	 
	public CategoryBook(Long categoryno, String categoryname, Long no, String title) {
		super();
		this.categoryno = categoryno;
		this.categoryname = categoryname;
		this.no = no;
		this.title = title;
	}
	
	public void setCategoryno(Long categoryno) {
		this.categoryno = categoryno;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getCategoryno() {
		return categoryno;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public Long getNo() {
		return no;
	}
	public String getTitle() {
		return title;
	}
	 
	 
}
