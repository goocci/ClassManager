package com.gys.classmanager;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.gys.classmanager.dao.GalleyDao;
import com.gys.classmanager.dao.MokTestDao;
import com.gys.classmanager.dao.SchoolTestDao;
import com.gys.classmanager.dao.memberDao;
import com.gys.classmanager.dto.MemberDto;
import com.gys.classmanager.dto.MokTestDto;

/**
 * Handles requests for the application home page.
 */

@Controller
@SessionAttributes("userid")
public class GalleryController {
	
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping(value = "/gallery")
	public String gallery(HttpSession session, Model model){
		
		String id = (String)session.getAttribute("userid");
		MemberDto dto = sqlSession.getMapper(memberDao.class).memberByID(id);
		String grade;
		String classNum;
		if(dto.getTeacherNum()!=0){
			grade = dto.getGrade();
			classNum = dto.getClassNum();
		}
		else{
			grade = dto.getStdtGrade();
			classNum = dto.getStdtClassNum();
		}
		
	
		model.addAttribute("gallery", sqlSession.getMapper(GalleyDao.class).listPhoto(grade, classNum));
	
		return "gallery";
	}
	
	
	@RequestMapping(value = "/galleryInput")
	public String galleryInput(HttpServletRequest request, @RequestParam("imgFile") MultipartFile imgFile, @RequestParam("title") String title, Model model,
	HttpSession session) {
		
		String savePath = "/Users/hanyoungsoo/Documents/workspace-sts-3.8.2.RELEASE/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/ClassManager1.0.1/resources/assets/img";
		// String savePath = request.getRealPath("folderName");

		String originalFilename = imgFile.getOriginalFilename(); // fileName.jpg
		String onlyFileName = originalFilename.substring(0, originalFilename.indexOf(".")); // fileName
		String extension = originalFilename.substring(originalFilename.indexOf(".")); // .jpg

		String rename = onlyFileName + "_" + getCurrentDayTime() + extension; // fileName_20150721-14-07-50.jpg
		String fullPath = savePath + "/" + rename;
		System.out.println(rename);

		if (!imgFile.isEmpty()) {
			try {
				byte[] bytes = imgFile.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(fullPath)));
				stream.write(bytes);
				stream.close();
				model.addAttribute("resultMsg", "파일 업로드 성공");
				model.addAttribute("filename", rename);
			} catch (Exception e) {
				model.addAttribute("resultMsg", "파일을 업로드하는 데에 실패했습니다.");
			}
		} else {
			model.addAttribute("resultMsg", "업로드할 파일을 선택해주시기 바랍니다.");
		}
		
		String id = (String)session.getAttribute("userid");
		MemberDto dto = sqlSession.getMapper(memberDao.class).memberByID(id);
		
		if(dto.getTeacherNum()!=0){
		sqlSession.getMapper(GalleyDao.class).upload(dto.getId(), dto.getGrade(), dto.getClassNum(), dto.getStdtGrade(), dto.getStdtClassNum(), rename, title);
		}
			
		System.out.println("리다이렉트 전");
		return "redirect:gallery";
	}
	
	

	public String getCurrentDayTime() {
		long time = System.currentTimeMillis();
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyyMMdd-HH-mm-ss", Locale.KOREA);
		return dayTime.format(new Date(time));
	}


}

