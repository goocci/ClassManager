package com.gys.classmanager.dao;

import java.util.ArrayList;

import com.gys.classmanager.dto.BoardDto;
import com.gys.classmanager.dto.CalendarDto;
import com.gys.classmanager.dto.CommentDto;

	public interface CalendarDao {

		public ArrayList<CalendarDto> listCalendar(String grade, String classNum);
		

		public void inputCalendar(String selectDate, String time, String content, String grade, String classNum, int day);

		public void deletePlan(String date);
		

	}