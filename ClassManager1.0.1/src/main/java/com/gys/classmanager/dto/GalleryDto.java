package com.gys.classmanager.dto;

public class GalleryDto {

	int idx;
	String id;
	String grade;
	String classNum;
	String stdtGrade;
	String stdtClassNum;
	String photoName;
	String title;
	
	public GalleryDto(){}


	public GalleryDto(int idx, String id, String grade, String classNum, String stdtGrade,
			String stdtClassNum, String photoName, String title) {
		super();
		this.idx = idx;
		this.id = id;
		this.grade = grade;
		this.classNum = classNum;
		this.stdtGrade = stdtGrade;
		this.stdtClassNum = stdtClassNum;
		this.photoName = photoName;
		this.title = title;
	}


	public int getIdx() {
		return idx;
	}


	public String getId() {
		return id;
	}


	public String getGrade() {
		return grade;
	}


	public String getClassNum() {
		return classNum;
	}


	public String getStdtGrade() {
		return stdtGrade;
	}


	public String getStdtClassNum() {
		return stdtClassNum;
	}


	public String getPhotoName() {
		return photoName;
	}


	public String getTitle() {
		return title;
	}


	public void setIdx(int idx) {
		this.idx = idx;
	}


	public void setId(String id) {
		this.id = id;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}


	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}


	public void setStdtGrade(String stdtGrade) {
		this.stdtGrade = stdtGrade;
	}


	public void setStdtClassNum(String stdtClassNum) {
		this.stdtClassNum = stdtClassNum;
	}


	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}


	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
}
