package com.gys.classmanager.dto;

public class FileDto {
	private int idx;
	private int boardIdx;
	private String id;
	private String oName;
	private String fileName;
	private int fileSize;
	
	public FileDto() {
		// TODO Auto-generated constructor stub
	}
	public void FileDto(int idx, int boardIdx, String id, String oName, String fileName, int fileSize) {
		this.idx = idx;
		this.boardIdx = boardIdx;
		this.id = id;
		this.oName= oName;
		this.fileName = fileName;
		this.fileSize = fileSize;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getoName() {
		return oName;
	}
	public void setoName(String oName) {
		this.oName = oName;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getFileSize() {
		return fileSize;
	}
	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}
	
	

}
