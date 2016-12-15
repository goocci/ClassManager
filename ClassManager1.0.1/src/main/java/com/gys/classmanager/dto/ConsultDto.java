package com.gys.classmanager.dto;

public class ConsultDto {

	int idx;
	String category;
	String content;
	String consultTime;
	String id;
	
	public ConsultDto(){
		//dedault 생성자
	}
	
	public ConsultDto(int idx, String category, String content, String consultTime, String id) {
		super();
		this.idx = idx;
		this.category = category;
		this.content = content;
		this.consultTime = consultTime;
		this.id = id;
	}

	public int getIdx() {
		return idx;
	}

	public String getCategory() {
		return category;
	}



	public String getContent() {
		return content;
	}

	public String getConsultTime() {
		return consultTime;
	}

	public String getId() {
		return id;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public void setCategory(String category) {
		this.category = category;
	}


	public void setContent(String content) {
		this.content = content;
	}

	public void setConsultTime(String consultTime) {
		this.consultTime = consultTime;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
