package com.gys.classmanager.dao;

import java.util.ArrayList;

import com.gys.classmanager.dto.ConsultDto;

public interface ConsultDao {
	public void consultInsert(String select, String comment, String consultdate, String id);
	public ArrayList<ConsultDto> listById(String id);
	public ConsultDto contentByIdx(int idx);
}