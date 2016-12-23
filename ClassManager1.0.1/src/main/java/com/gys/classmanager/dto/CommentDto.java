package com.gys.classmanager.dto;

public class CommentDto {
	private int idx;
	private int boardIdx;
	private String writer;
	private String id;
	private String content;
	
	public CommentDto() {
		// TODO Auto-generated constructor stub
	}
	
	public void bDto(int idx, int boardIdx, String writer, String id, String content) {
		this.idx = idx;
		this.boardIdx = boardIdx;
		this.writer = writer;
		this.content = content;
	}
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getBoardIdx() {
		return boardIdx;
	}
	public void setBoardIdx(int boardIdx) {
		this.boardIdx = boardIdx;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	

}
