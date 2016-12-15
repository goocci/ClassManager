package com.gys.classmanager.dao;

import java.util.ArrayList;
import java.util.List;

import com.gys.classmanager.dto.SchoolTestDto;

public interface SchoolTestDao {
	
	public ArrayList<SchoolTestDto> schooltest_list_Dao(String studentNum, String stdtGrade, String stdtClassNum);
	
	public List<String> schooltest_chart(String studentNum, String stdtGrade, String stdtClassNum);
	
	public void schooltest_input_Dao(String grade, String semester, String subject, int schoolrate, String studentNum, String stdtGrade, String stdtClassNum);
	
}