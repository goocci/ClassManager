package com.gys.classmanager.dao;

import java.util.ArrayList;

import com.gys.classmanager.dto.UnivScoreDto;

public interface UnivScoreDao {
	
	public ArrayList<UnivScoreDto> univName_list_Dao(String univName);
	
	public ArrayList<UnivScoreDto> univMajor_score_Dao(String univName, String univMajor);

	public ArrayList<UnivScoreDto> univScore_chart1(String univName, String univMajor);
	
	public ArrayList<UnivScoreDto> univScore_chart2(String univName, String univMajor, String UnivId);

	public ArrayList<UnivScoreDto> univId_list_Dao(String univId);
	
}