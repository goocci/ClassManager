package com.gys.classmanager.dao;

import java.util.ArrayList;

import com.gys.classmanager.dto.CommentDto;

public interface CommentDao {
	//��� �������� ���, ���� 

	public ArrayList<CommentDto> listComment();
	
	public void writeComment(int cBoardIdx, String cWriter, String cId, String cContent);

	public void deleteComment(int cBoardIdx);
	
}
