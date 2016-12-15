package com.gys.classmanager.dto;

public class MemberDto {
	
	int idx;
	String id;
	String pwd;
	String  name;
	String phoneNum;
	String address;
	String email;
	String grade;
	String classNum;
	int teacherNum;
	int studentNum;
	String profilePhoto;
	String stdtGrade;
	String stdtClassNum;
	
	public MemberDto(){
		
	}
	
	
	public MemberDto(int idx, String id, String pwd, String name, String phoneNum, String address, String email,
			String grade, String classNum, int teacherNum, int studentNum, String profilePhoto, String stdtGrade,
			String stdtClassNum) {
		super();
		this.idx = idx;
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.phoneNum = phoneNum;
		this.address = address;
		this.email = email;
		this.grade = grade;
		this.classNum = classNum;
		this.teacherNum = teacherNum;
		this.studentNum = studentNum;
		this.profilePhoto = profilePhoto;
		this.stdtGrade = stdtGrade;
		this.stdtClassNum = stdtClassNum;
	}
	public String getStdtGrade() {
		return stdtGrade;
	}
	public String getStdtClassNum() {
		return stdtClassNum;
	}
	public void setStdtGrade(String stdtGrade) {
		this.stdtGrade = stdtGrade;
	}
	public void setStdtClassNum(String stdtClassNum) {
		this.stdtClassNum = stdtClassNum;
	}
	public int getIdx() {
		return idx;
	}
	public String getId() {
		return id;
	}
	public String getPwd() {
		return pwd;
	}
	public String getName() {
		return name;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public String getAddress() {
		return address;
	}
	public String getEmail() {
		return email;
	}
	public String getGrade() {
		return grade;
	}
	public String getClassNum() {
		return classNum;
	}
	public int getTeacherNum() {
		return teacherNum;
	}
	public int getStudentNum() {
		return studentNum;
	}
	public String getProfilePhoto() {
		return profilePhoto;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}
	public void setTeacherNum(int teacherNum) {
		this.teacherNum = teacherNum;
	}
	public void setStudentNum(int studentNum) {
		this.studentNum = studentNum;
	}
	public void setProfilePhoto(String profilePhoto) {
		this.profilePhoto = profilePhoto;
	}
	
}
