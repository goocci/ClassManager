package com.gys.classmanager.dao;

import java.util.ArrayList;

import com.gys.classmanager.dto.MemberDto;

public interface memberDao {
		public void memberInsert(String id, String pwd, String name, String phoneNum, String address, String email, String grade, String classNum, String teacherNum, String studentNum, String filename,String stdtGrade, String stdtClass);
		public MemberDto memberByID(String id);
		public ArrayList<MemberDto> stdtByGradeClass(String grade, String classNum);
		public MemberDto stdtInfo(String stdtGrade, String stdtClass, String studentNum);
		public void memberUpdate(String id, String pwd, String phone, String addr, String email, String selectGrade, String selectClass,String profilePhoto);
		public void memberUpdate2(String id, String pwd, String phone, String addr, String email,String studentNum, String profilePhoto, String selectGrade,String selectClass);
	}