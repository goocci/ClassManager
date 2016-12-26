package com.gys.classmanager;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gys.classmanager.dao.ConsultDao;
import com.gys.classmanager.dao.memberDao;
import com.gys.classmanager.dto.MemberDto;

@Controller
@SessionAttributes("userid")
public class MemberController {

	// 회원가입 컨트롤러 시작
	@Autowired
	private SqlSession sqlSession;

	@RequestMapping(value = "/join")
	public String join(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
		memberDao dao = sqlSession.getMapper(memberDao.class);
		dao.memberInsert(request.getParameter("inputId"), request.getParameter("pwd"),
				request.getParameter("inputName"), request.getParameter("phone"), request.getParameter("addr"),
				request.getParameter("email"), request.getParameter("selectGrade"), request.getParameter("selectClass"),
				request.getParameter("teacherno"), request.getParameter("studentno"), request.getParameter("fileNmae"),
				request.getParameter("stdtGrade"), request.getParameter("stdtClass"));

		model.addAttribute("message", "정상적으로 가입되었습니다");
		return "loginform";
	}

	@RequestMapping("/uploadFile")
	@ResponseBody public String uploadFile(HttpServletRequest request, @RequestParam("imgFile") MultipartFile imgFile, Model model) {
		System.out.println("uploadFile");
		String savePath = "/Users/hanyoungsoo/Documents/workspace-sts-3.8.2.RELEASE/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/ClassManager1.0.1/resources/assets/img";
		String result="";
		String originalFilename = imgFile.getOriginalFilename(); // fileName.jpg
		String onlyFileName = originalFilename.substring(0, originalFilename.indexOf(".")); // fileName
		String extension = originalFilename.substring(originalFilename.indexOf(".")); // .jpg
		String rename = onlyFileName + "_" + getCurrentDayTime() + extension; // fileName_20150721-14-07-50.jpg
		String fullPath = savePath + "/" + rename;

		if (!imgFile.isEmpty()) {
			try {
				byte[] bytes = imgFile.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(fullPath)));
				stream.write(bytes);
				stream.close();
				result = rename;
			} catch (Exception e) {
			}
		}
		return result;
	}

	public String getCurrentDayTime() {
		long time = System.currentTimeMillis();
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyyMMdd-HH-mm-ss", Locale.KOREA);
		return dayTime.format(new Date(time));
	}

	@RequestMapping(value = "/idCheck")
	public String idCheck(HttpServletRequest request, Model model) {
		String id = request.getParameter("inputId");
		System.out.println(id);

		memberDao dao = sqlSession.getMapper(memberDao.class);
		MemberDto dto = dao.memberByID(id);

		model.addAttribute("member", dto);
		model.addAttribute("inputId", id);

		return "idCheckview";

	}

	@RequestMapping(value = "/loginCheck")
	public String loginCheck(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String id = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		memberDao dao = sqlSession.getMapper(memberDao.class);
		MemberDto dto = dao.memberByID(id);
		model.addAttribute("userid", id);

		if (dto == null) {
			model.addAttribute("message", "존재하지 않는 회원이네요");
			return "loginform";
		} else if (dto.getPwd().equals(pwd)) {
			if (dto.getTeacherNum() != 0) {
				session.setAttribute("tname", dto.getName());
				session.setAttribute("grade", dto.getGrade());
				session.setAttribute("classNum", dto.getClassNum());
				session.setAttribute("isStudent", false);
				session.setAttribute("teacherNum", dto.getTeacherNum());
				
			} else {
				session.setAttribute("sname", dto.getName());
				session.setAttribute("grade", dto.getStdtGrade());
				session.setAttribute("classNum", dto.getStdtClassNum());
				session.setAttribute("stdtNum", String.valueOf(dto.getStudentNum()));
				session.setAttribute("teacherNum", dto.getTeacherNum());
				session.setAttribute("isStudent", true);
			}
			return "main";

		}
		model.addAttribute("message", "비밀번호가 일치하지 않습니다.");
		return "loginform";

	}

	@RequestMapping(value = "/join_modify")
	public String join_modify(Model model, HttpSession session) {

		String id = (String) session.getAttribute("userid");
		memberDao dao = sqlSession.getMapper(memberDao.class);
		MemberDto dto = dao.memberByID(id);

		model.addAttribute("name", dto.getName());
		model.addAttribute("id", dto.getId());
		model.addAttribute("teacherno", dto.getTeacherNum());
		model.addAttribute("filename", dto.getProfilePhoto());

		return "join_modify";
	}
	
	
	
	@RequestMapping(value = "/join_modify2")
	public String join_modify2(Model model, HttpSession session) {

		String id = (String) session.getAttribute("userid");
		memberDao dao = sqlSession.getMapper(memberDao.class);
		MemberDto dto = dao.memberByID(id);

		model.addAttribute("name", dto.getName());
		model.addAttribute("id", dto.getId());
		model.addAttribute("studentno", dto.getStudentNum());
		model.addAttribute("filename", dto.getProfilePhoto());

		return "join_modify2";
	}

	@RequestMapping(value = "/student_list")
	public String student_list(Model model, HttpSession session) {
		String id = (String) session.getAttribute("userid");
		memberDao dao = sqlSession.getMapper(memberDao.class);
		MemberDto dto = dao.memberByID(id);

		model.addAttribute("stlist", dao.stdtByGradeClass(dto.getGrade(), dto.getClassNum()));

		return "student_list";
	}

	@RequestMapping(value = "/student_info")
	public String student_info(HttpServletRequest request, Model model) {
		String stdtGrade = request.getParameter("grade");
		String stdtClassNum = request.getParameter("classnum");
		String stdtNum = request.getParameter("stdtNum");
		String studentId = request.getParameter("studentId");
		String sestdtGrade = "";
		String sestdtClassNum =""; 
		String sestdtNum = "";
		String sestudentId = "";

		HttpSession session = request.getSession();
		memberDao dao = sqlSession.getMapper(memberDao.class);
		ConsultDao cdao = sqlSession.getMapper(ConsultDao.class);

		if (stdtGrade != null) {
			

			session.setAttribute("grade", stdtGrade);
			session.setAttribute("classnum", stdtClassNum);
			session.setAttribute("stdtNum", stdtNum);
			session.setAttribute("studentId", studentId);
			
			model.addAttribute("info", dao.stdtInfo(stdtGrade, stdtClassNum, stdtNum));
			model.addAttribute("conList", cdao.listById(studentId));
		} else {
			
			sestdtGrade= (String) session.getAttribute("grade");
			sestdtClassNum= (String)session.getAttribute("classnum");
			sestdtNum=(String) session.getAttribute("stdtNum");
			sestudentId=(String) session.getAttribute("studentId");	
			model.addAttribute("info", dao.stdtInfo(sestdtGrade, sestdtClassNum, sestdtNum));

			model.addAttribute("conList", cdao.listById(sestudentId));

		}

		return "student_info";
	}

	@RequestMapping(value = "/logout")
	public String logout(HttpSession session, Model model) {
		session.invalidate();
		model.addAttribute("message", "정상적으로 로그아웃 처리 되었습니다");

		return "loginform";
	}

	@RequestMapping(value = "/modify_confirm")
	public String modify_confirm(HttpServletRequest request, Model model) {
		String id = request.getParameter("inputId");
		String pwd = request.getParameter("pwd");
		String phone = request.getParameter("phone");
		String addr = request.getParameter("addr");
		String email = request.getParameter("email");
		String selectGrade = request.getParameter("selectGrade");
		String selectClass = request.getParameter("selectClass");
		String profilePhoto = request.getParameter("fileNmae");
		memberDao dao = sqlSession.getMapper(memberDao.class);

		dao.memberUpdate(id, pwd, phone, addr, email, selectGrade, selectClass, profilePhoto);

		return "loginform";
	}

	@RequestMapping(value = "/modify_confirm2")
	public String modify_confirm2(HttpServletRequest request, Model model) {
		String id = request.getParameter("inputId");
		String pwd = request.getParameter("pwd");
		String phone = request.getParameter("phone");
		String addr = request.getParameter("addr");
		String email = request.getParameter("email");
		String studentNum = request.getParameter("studentNum");
		String selectGrade = request.getParameter("selectGrade");
		String selectClass = request.getParameter("selectClass");
		String profilePhoto = request.getParameter("fileNmae");
		memberDao dao = sqlSession.getMapper(memberDao.class);

		dao.memberUpdate2(id, pwd, phone, addr, email, studentNum, profilePhoto, selectGrade, selectClass );

		return "loginform";
	}
	@RequestMapping(value = "/save_consult")
	public String save_consult(@RequestParam String select, @RequestParam String comment,
			@RequestParam String consultdate, HttpServletRequest request, Model model, RedirectAttributes redirect) {

		String stdtGrade = request.getParameter("grade");
		String stdtClassNum = request.getParameter("classnum");
		String stdtNum = request.getParameter("num");
		String studentId = request.getParameter("id");

		redirect.addAttribute("grade", stdtGrade);
		redirect.addAttribute("classnum", stdtClassNum);
		redirect.addAttribute("stdtNum", stdtNum);
		redirect.addAttribute("studentId", studentId);

		ConsultDao dao = sqlSession.getMapper(ConsultDao.class);
		dao.consultInsert(select, comment, consultdate, studentId);

		return "redirect:student_info";
	}
	
	@RequestMapping(value = "/consultcon")
	public String consultcon(@RequestParam int idx, HttpServletRequest request, Model model) {
	
		ConsultDao dao = sqlSession.getMapper(ConsultDao.class);
		model.addAttribute("content", dao.contentByIdx(idx));
		
		
		return "consultcon";
	}

}
