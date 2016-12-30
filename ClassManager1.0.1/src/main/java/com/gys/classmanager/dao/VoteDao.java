package com.gys.classmanager.dao;

import java.util.ArrayList;

import com.gys.classmanager.dto.VoteDto;

public interface VoteDao {
	
	public void createVote1(String id, String topic, int count, String choice1, int scorech1);
	public void createVote2(String id, String topic, int count, String choice1, String choice2, int scorech1, int scorech2);
	public void createVote3(String id, String topic, int count, String choice1, String choice2, String choice3, int scorech1, int scorech2, int scorech3);
	public void createVote4(String id, String topic, int count, String choice1, String choice2, String choice3,String choice4, int scorech1, int scorech2, int scorech3, int scorech4);
	public void createVote5(String id, String topic, int count, String choice1, String choice2, String choice3,String choice4, String choice5, int scorech1, int scorech2, int scorech3, int scorech4, int scorech5);
	
	public VoteDto lastListVote();
	
	public VoteDto viewVote(int bIdx);
	
//	public ArrayList<VoteDto> ListVote();
	
	public void upScore1(int idx);
	public void upScore2(int idx);
	public void upScore3(int idx);
	public void upScore4(int idx);
	public void upScore5(int idx);

}
