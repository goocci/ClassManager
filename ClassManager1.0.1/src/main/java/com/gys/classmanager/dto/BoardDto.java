package com.gys.classmanager.dto;

public class BoardDto {

	private int idx;
	private String category;
	private String title;
	private String content;
	private String created_at;
	private String writer;
	private int hit;
	private String id;
	private String stdtGrade;
	private String stdtClassNum;
	private int teacherNum;
	private String boardPhoto;
	private int voteIdx;
	
	public BoardDto() {
		// TODO Auto-generated constructor stub
	}
	
	public BoardDto(int idx, String category, String title, String content, String created_at, String writer, String id, int hit, String stdtGrade, String stdtClassNum, int teacherNum, String boardPhoto, int voteIdx) {
		this.idx = idx;
		this.category = category;
		this.title = title;
		this.content = content;
		this.created_at = created_at;
		this.writer = writer;
		this.id = id;
		this.hit = hit;
		this.stdtGrade = stdtGrade;
		this.stdtClassNum = stdtClassNum;
		this.teacherNum = teacherNum;
		this.boardPhoto = boardPhoto;
		this.voteIdx = voteIdx;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
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

	public int getTeacherNum() {
		return teacherNum;
	}

	public void setTeacherNum(int teacherNum) {
		this.teacherNum = teacherNum;
	}
	
	public String getBoardPhoto() {
		return boardPhoto;
	}

	public void setBoardPhoto(String boardPhoto) {
		this.boardPhoto = boardPhoto;
	}

	public int getVoteIdx() {
		return voteIdx;
	}

	public void setVoteIdx(int voteIdx) {
		this.voteIdx = voteIdx;
	}
	
	
	
}
