package com.gys.classmanager.dao;

import java.util.ArrayList;
import com.gys.classmanager.dto.GalleryDto;

public interface GalleyDao {

		public void upload(String id, String grade, String classNum, String stdtGrade , String stdtClassNum, String photoName, String title);
		public ArrayList<GalleryDto> listPhoto(String grade, String classNum);
	}