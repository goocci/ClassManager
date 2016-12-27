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
import javax.swing.plaf.synth.SynthStyle;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.gys.classmanager.dao.GalleyDao;
import com.gys.classmanager.dao.MokTestDao;
import com.gys.classmanager.dao.SchoolTestDao;
import com.gys.classmanager.dao.memberDao;
import com.gys.classmanager.dto.GalleryDto;
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
	public String gallery(HttpSession session, Model model, HttpServletRequest request) {

		String id = (String) session.getAttribute("userid");
		MemberDto dto = sqlSession.getMapper(memberDao.class).memberByID(id);
		String grade;
		String classNum;
		String msg= request.getParameter("msg");
		if (dto.getTeacherNum() != 0) {
			grade = dto.getGrade();
			classNum = dto.getClassNum();
		} else {
			grade = dto.getStdtGrade();
			classNum = dto.getStdtClassNum();
		}
		
		model.addAttribute("gallery", sqlSession.getMapper(GalleyDao.class).listPhoto(grade, classNum));
		if (msg == null) {
			model.addAttribute("msg", "empty");
		} else {
			model.addAttribute("msg", msg);
		}
		return "gallery";
	}

	@RequestMapping(value = "/gallerydel")
	public String gallerydel(HttpSession session, Model model, @RequestParam("idx") int idx) {
		System.out.println(idx);
		System.out.println("gallerydel()");
		String loginid = (String) session.getAttribute("userid");
		GalleryDto dto = sqlSession.getMapper(GalleyDao.class).selectPhoto(idx);
		if (dto == null) {
			model.addAttribute("msg", "게시되지 않은 사진 번호입니다");
		} else if (dto.getId().equals(loginid)) {
			sqlSession.getMapper(GalleyDao.class).galleryDel(idx);
			model.addAttribute("msg", "삭제되었습니다");
		} else {
			model.addAttribute("msg", "게시자가 아니라 삭제가 안돼요~");
		}

		return "redirect:gallery";
	}

	@RequestMapping(value = "/galleryInput")
	public String galleryInput(HttpServletRequest request, @RequestParam("imgFile") MultipartFile imgFile,
			@RequestParam("title") String title, Model model, HttpSession session) {

		String savePath =  "C:\\Users\\인영\\dev\\ws_sts\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\ClassManager1.0.1\\resources\\assets\\img";
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

		String id = (String) session.getAttribute("userid");
		MemberDto dto = sqlSession.getMapper(memberDao.class).memberByID(id);

		if (dto.getTeacherNum() != 0) {
			sqlSession.getMapper(GalleyDao.class).upload(dto.getId(), dto.getGrade(), dto.getClassNum(),
					dto.getStdtGrade(), dto.getStdtClassNum(), rename, title);
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
