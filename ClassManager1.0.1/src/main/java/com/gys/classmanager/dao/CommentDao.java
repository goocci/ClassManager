package com.gys.classmanager.dao;

import java.util.ArrayList;

import com.gys.classmanager.dto.CommentDto;

public interface CommentDao {
	//댓글 가져오기 등록, 삭제 

	public ArrayList<CommentDto> listComment();
	
	public void writeComment(int cBoardIdx, String cWriter, String cContent);

	public void deleteComment(int cBoardIdx);
	
}
