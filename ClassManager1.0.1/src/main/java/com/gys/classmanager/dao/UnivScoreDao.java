package com.gys.classmanager.dao;

import java.util.ArrayList;

import com.gys.classmanager.dto.UnivScoreDto;

public interface UnivScoreDao {
	
	public ArrayList<UnivScoreDto> univName_list_Dao(String univName);
	
	public ArrayList<UnivScoreDto> univMajor_score_Dao(String univName, String univMajor);

	public ArrayList<UnivScoreDto> univScore_chart(String univName, String univMajor);
	
}