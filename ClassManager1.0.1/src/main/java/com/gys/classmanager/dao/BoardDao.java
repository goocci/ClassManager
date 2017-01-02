package com.gys.classmanager.dao;

import java.util.ArrayList;

import com.gys.classmanager.dto.BoardDto;
import com.gys.classmanager.dto.CommentDto;

	public interface BoardDao {

		public ArrayList<BoardDto> listBoard(String stdtGrade, String stdtClassNum);
		
		public ArrayList<CommentDto> listComment(int cBoardIdx);
		
		public void upHit(int bIdx);
		
		public BoardDto viewBoard(int bIdx);

		public void writeBoardPV(String bCategory, String bTitle, String bContent, String bWriter, String Id, int hit, String stdtGrade, String stdtClassNum, int teacherNum, String boardPhoto, int voteIdx);
		
		public void writeBoardP(String bCategory, String bTitle, String bContent, String bWriter, String Id, int hit, String stdtGrade, String stdtClassNum, int teacherNum, String boardPhoto);
		
		public void writeBoardV(String bCategory, String bTitle, String bContent, String bWriter, String Id, int hit, String stdtGrade, String stdtClassNum, int teacherNum, int voteIdx);

		public void writeBoard(String bCategory, String bTitle, String bContent, String bWriter, String Id, int hit, String stdtGrade, String stdtClassNum, int teacherNum);
	
		public void deleteBoard(String idx);
		
		public BoardDto modifyViewBoard(String idx);
		
		public void modifyBoard(String bCategory, String bTitle, String bContent, String idx);

	}