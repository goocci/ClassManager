package com.gys.classmanager.dao;

import java.util.ArrayList;
import com.gys.classmanager.dto.MokTestDto;

	public interface MokTestDao {

		public ArrayList<MokTestDto> moktest_list_Dao(String studentNum, String stdtGrade, String stdtClassNum);

		public void moktest_input_Dao(String grade, String month, String subject, int rate, int standard, int percent, String studentNum, String stdtGrade, String stdtClassNum);

		public void moktest_update1_Dao();
		public void moktest_update2_Dao();
		
		public ArrayList<MokTestDto> moktest_chart_language(String studentNum, String stdtGrade, String stdtClassNum);
		public ArrayList<MokTestDto> moktest_chart_math(String studentNum, String stdtGrade, String stdtClassNum);
		public ArrayList<MokTestDto> moktest_chart_english(String studentNum, String stdtGrade, String stdtClassNum);
		public ArrayList<MokTestDto> moktest_chart_science(String studentNum, String stdtGrade, String stdtClassNum);
		public ArrayList<MokTestDto> moktest_chart_society(String studentNum, String stdtGrade, String stdtClassNum);
	}