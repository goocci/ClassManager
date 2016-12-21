package com.gys.classmanager.dao;

import java.util.ArrayList;

import com.gys.classmanager.dto.BoardDto;
import com.gys.classmanager.dto.CalendarDto;
import com.gys.classmanager.dto.CommentDto;

	public interface CalendarDao {

		public ArrayList<CalendarDto> listCalendar(String grade, String classNum);
		
		public ArrayList<CommentDto> listComment(int cBoardIdx);
		
		public void upHit(int bIdx);
		
		public BoardDto viewBoard(int bIdx);

		public void inputCalendar(String selectDate, String time, String content, String grade, String classNum);

		public void deleteBoard(String idx);
		
		public BoardDto modifyViewBoard(String idx);
		
		public void modifyBoard(String bCategory, String bTitle, String bContent, String idx);

	}