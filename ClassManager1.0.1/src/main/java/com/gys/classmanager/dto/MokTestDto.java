package com.gys.classmanager.dto;

public class MokTestDto {

	private int idx;
	private String grade;
	private String month;
	private String subject;
	private int rate;
	private int standard;
	private int percent;
	private int studentNum;
	private String stdtGrade;
	private String stdtClassNum;
	private String grademonth;
	private String grademonthsubject;
	
	public MokTestDto() {
		// TODO Auto-generated constructor stub
	}
	
	public MokTestDto(int idx, String grade, String month, String subject, int rate, int standard, int percent, int studentNum, String stdtGrade, String stdtClassNum, String grademonth, String grademonthsubject) {
		
		this.idx = idx;
		this.grade = grade;
		this.month = month;
		this.subject = subject;
		this.rate = rate;
		this.standard = standard;
		this.percent = percent;
		this.studentNum = studentNum;
		this.stdtGrade = stdtGrade;
		this.stdtClassNum = stdtClassNum;
		this.grademonth = grademonth;
		this.grademonthsubject = grademonthsubject;
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

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public int getStandard() {
		return standard;
	}

	public void setStandard(int standard) {
		this.standard = standard;
	}

	public int getPercent() {
		return percent;
	}

	public void setPercent(int percent) {
		this.percent = percent;
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

	public String getGrademonth() {
		return grademonth;
	}

	public void setGrademonth(String grademonth) {
		this.grademonth = grademonth;
	}

	public String getGrademonthsubject() {
		return grademonthsubject;
	}

	public void setGrademonthsubject(String grademonthsubject) {
		this.grademonthsubject = grademonthsubject;
	}

	
	
	
	
}
