package com.gys.classmanager.dto;

public class VoteDto {
	
	private int idx;
	private int boardIdx;
	private String id;
	private String topic;
	private String choice1;
	private String choice2;
	private String choice3;
	private String choice4;
	private String choice5;
	private int scoreCh1;
	private int scoreCh2;
	private int scoreCh3;
	private int scoreCh4;
	private int scoreCh5;
	
	
	public VoteDto() {
		// TODO Auto-generated constructor stub
	}
	public VoteDto(int idx, int boardIdx, String id, String topic, String choice1, String choice2, String choice3,
			String choice4, String choice5, int scoreCh1, int scoreCh2, int scoreCh3, int scoreCh4, int scoreCh5) {
		this.idx = idx;
		this.boardIdx = boardIdx;
		this.id = id;
		this.topic = topic;
		this.choice1 = choice1;
		this.choice2 = choice2;
		this.choice3 = choice3;
		this.choice4 = choice4;
		this.choice5 = choice5;
		this.scoreCh1 = scoreCh1;
		this.scoreCh2 = scoreCh2;
		this.scoreCh3 = scoreCh3;
		this.scoreCh4 = scoreCh4;
		this.scoreCh5 = scoreCh5;
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
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getChoice1() {
		return choice1;
	}
	public void setChoice1(String choice1) {
		this.choice1 = choice1;
	}
	public String getChoice2() {
		return choice2;
	}
	public void setChoice2(String choice2) {
		this.choice2 = choice2;
	}
	public String getChoice3() {
		return choice3;
	}
	public void setChoice3(String choice3) {
		this.choice3 = choice3;
	}
	public String getChoice4() {
		return choice4;
	}
	public void setChoice4(String choice4) {
		this.choice4 = choice4;
	}
	public String getChoice5() {
		return choice5;
	}
	public void setChoice5(String choice5) {
		this.choice5 = choice5;
	}
	public int getScoreCh1() {
		return scoreCh1;
	}
	public void setScoreCh1(int scoreCh1) {
		this.scoreCh1 = scoreCh1;
	}
	public int getScoreCh2() {
		return scoreCh2;
	}
	public void setScoreCh2(int scoreCh2) {
		this.scoreCh2 = scoreCh2;
	}
	public int getScoreCh3() {
		return scoreCh3;
	}
	public void setScoreCh3(int scoreCh3) {
		this.scoreCh3 = scoreCh3;
	}
	public int getScoreCh4() {
		return scoreCh4;
	}
	public void setScoreCh4(int scoreCh4) {
		this.scoreCh4 = scoreCh4;
	}
	public int getScoreCh5() {
		return scoreCh5;
	}
	public void setScoreCh5(int scoreCh5) {
		this.scoreCh5 = scoreCh5;
	}
	
	
	

}
