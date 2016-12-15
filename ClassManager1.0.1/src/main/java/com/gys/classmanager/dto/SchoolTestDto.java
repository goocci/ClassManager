package com.gys.classmanager.dto;

public class SchoolTestDto {
	
	private int idx;
	public String grade;
	public String semester;
	private String subject;
	public int schoolrate;
	public int studentNum;
	private String stdtGrade;
	private String stdtClassNum;
	
	public SchoolTestDto() {
		// TODO Auto-generated constructor stub
	}
	
	public SchoolTestDto(int idx, String grade, String semester, String subject, int schoolrate, int studentNum, String stdtGrade, String stdtClassNum) {
		this.idx = idx;
		this.grade = grade;
		this.semester = semester;
		this.subject = subject;
		this.schoolrate = schoolrate;
		this.studentNum = studentNum;
		this.stdtGrade = stdtGrade;
		this.stdtClassNum = stdtClassNum;
		
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getSchoolrate() {
		return schoolrate;
	}

	public void setSchoolrate(int schoolrate) {
		this.schoolrate = schoolrate;
	}

	public int getStudentNum() {
		return studentNum;
	}

	public void setStudentNum(int studentNum) {
		this.studentNum = studentNum;
	}
	public String getStdtGrade() {
		return stdtGrade;
	}

	public void setStdtGrade(String stdtGrade) {
		this.stdtGrade = stdtGrade;
	}

	public String getStdtClassNum() {
		return stdtClassNum;
	}

	public void setStdtClassNum(String stdtClassNum) {
		this.stdtClassNum = stdtClassNum;
	}
	
}
