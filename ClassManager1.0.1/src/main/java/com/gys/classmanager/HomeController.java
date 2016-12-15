package com.gys.classmanager;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.google.gson.Gson;
import com.gys.classmanager.dao.MokTestDao;
import com.gys.classmanager.dao.SchoolTestDao;
import com.gys.classmanager.dto.MokTestDto;

/**
 * Handles requests for the application home page.
 */

@Controller
@SessionAttributes("userid")
public class HomeController {
	
	@Autowired
	private SqlSession sqlSession;
	

	@RequestMapping(value = "/header")
	public String header(Model model) {

		return "header";
	}

	@RequestMapping(value = "/footer")
	public String footer(Model model) {

		return "footer";
	}

	@RequestMapping(value = "/joinform")
	public String joinform(Model model) {

		return "joinform";
	}

	@RequestMapping(value = "/")
	public String index(Model model) {

		return "redirect:loginform";
	}

	@RequestMapping(value = "loginform")
	public String loginform(Model model) {

		return "loginform";
	}

	@RequestMapping(value = "/main")
	public String main(Model model) {

		return "main";
	}


	@RequestMapping(value = "/left")
	public String left(Model model) {

		return "left";
	}

	@RequestMapping(value = "/grade_input")
	public String grade_input(Model model) {

		return "grade_input";
	}

	@RequestMapping("/schooltest_input")
	public String schooltest_input(HttpSession session, HttpServletRequest request, Model model) {

		String stdtNum = (String) session.getAttribute("stdtNum");
		String stdtGrade = (String) session.getAttribute("grade");
		String stdtClassNum = (String) session.getAttribute("classNum");
		SchoolTestDao schooltestdao = sqlSession.getMapper(SchoolTestDao.class);
		schooltestdao.schooltest_input_Dao(request.getParameter("grade"), request.getParameter("semester"),
				request.getParameter("subject"), (Integer.parseInt(request.getParameter("schoolrate"))), stdtNum, stdtGrade, stdtClassNum);
		
		return "redirect:grade_input";
	}

	@RequestMapping("/moktest_input")
	public String moktest_input(HttpSession session, HttpServletRequest request) {

		String stdtNum = (String) session.getAttribute("stdtNum");
		String stdtGrade = (String) session.getAttribute("grade");
		String stdtClassNum = (String) session.getAttribute("classNum");
		MokTestDao moktestdao = sqlSession.getMapper(MokTestDao.class);
		moktestdao.moktest_input_Dao(request.getParameter("grade"), request.getParameter("month"),
				request.getParameter("subject"), (Integer.parseInt(request.getParameter("rate"))),
				(Integer.parseInt(request.getParameter("standard"))),
				(Integer.parseInt(request.getParameter("percent"))), stdtNum, stdtGrade, stdtClassNum);
		moktestdao.moktest_update1_Dao();
		moktestdao.moktest_update2_Dao();

		return "redirect:grade_input";
	}

	@RequestMapping(value = "/view_grade")
	public String view_grade(HttpSession session, Model model) {

		String stdtNum = (String) session.getAttribute("stdtNum");
		String stdtGrade = (String) session.getAttribute("grade");
		String stdtClassNum = (String) session.getAttribute("classNum");
		SchoolTestDao schooltestdao = sqlSession.getMapper(SchoolTestDao.class);
		model.addAttribute("schooltestlist", schooltestdao.schooltest_list_Dao(stdtNum, stdtGrade, stdtClassNum));
		MokTestDao moktestdao = sqlSession.getMapper(MokTestDao.class);
		model.addAttribute("moktestlist", moktestdao.moktest_list_Dao(stdtNum, stdtGrade, stdtClassNum));
		
		return "view_grade";
	}
	
	@RequestMapping(value = "/list_schooltest",  method = RequestMethod.GET, produces="text/plain;charset=UTF-8")
	public @ResponseBody String list_schooltest(HttpSession session, Model model) {

		String stdtNum = (String) session.getAttribute("stdtNum");
		String stdtGrade = (String) session.getAttribute("grade");
		String stdtClassNum = (String) session.getAttribute("classNum");
		Gson gson = new Gson();
		SchoolTestDao schooltestdao = sqlSession.getMapper(SchoolTestDao.class);
		List<String> list_schooltest = schooltestdao.schooltest_chart(stdtNum, stdtGrade, stdtClassNum);
		
		
		return gson.toJson(list_schooltest);
	}
	
	@RequestMapping(value = "/list_language",  method = RequestMethod.GET, produces="text/plain;charset=UTF-8")
	public @ResponseBody String list_language(HttpSession session, Model model) {
		
		String stdtNum = (String) session.getAttribute("stdtNum");
		String stdtGrade = (String) session.getAttribute("grade");
		String stdtClassNum = (String) session.getAttribute("classNum");
		
		MokTestDao moktestdao = sqlSession.getMapper(MokTestDao.class);
		
		Gson gson = new Gson();
		ArrayList<MokTestDto> list_language = moktestdao.moktest_chart_language(stdtNum, stdtGrade, stdtClassNum);
		
		return gson.toJson(list_language);
	}
	
	@RequestMapping(value = "/list_math",  method = RequestMethod.GET, produces="text/plain;charset=UTF-8")
	public @ResponseBody String list_math(HttpSession session, Model model) {
		
		String stdtNum = (String) session.getAttribute("stdtNum");
		String stdtGrade = (String) session.getAttribute("grade");
		String stdtClassNum = (String) session.getAttribute("classNum");
		
		MokTestDao moktestdao = sqlSession.getMapper(MokTestDao.class);
		
		Gson gson = new Gson();
		ArrayList<MokTestDto> list_math = moktestdao.moktest_chart_math(stdtNum, stdtGrade, stdtClassNum);
		
		return gson.toJson(list_math);
	}
	
	@RequestMapping(value = "/list_english",  method = RequestMethod.GET, produces="text/plain;charset=UTF-8")
	public @ResponseBody String list_english(HttpSession session, Model model) {

		String stdtNum = (String) session.getAttribute("stdtNum");
		String stdtGrade = (String) session.getAttribute("grade");
		String stdtClassNum = (String) session.getAttribute("classNum");
		
		MokTestDao moktestdao = sqlSession.getMapper(MokTestDao.class);

		Gson gson = new Gson();
		ArrayList<MokTestDto> list_english = moktestdao.moktest_chart_english(stdtNum, stdtGrade, stdtClassNum);
		
		return gson.toJson(list_english);
	}
	
	@RequestMapping(value = "/list_science",  method = RequestMethod.GET, produces="text/plain;charset=UTF-8")
	public @ResponseBody String list_science(HttpSession session, Model model) {

		String stdtNum = (String) session.getAttribute("stdtNum");
		String stdtGrade = (String) session.getAttribute("grade");
		String stdtClassNum = (String) session.getAttribute("classNum");
		
		MokTestDao moktestdao = sqlSession.getMapper(MokTestDao.class);

		Gson gson = new Gson();
		ArrayList<MokTestDto> list_science = moktestdao.moktest_chart_science(stdtNum, stdtGrade, stdtClassNum);
		
		return gson.toJson(list_science);
	}
	
	@RequestMapping(value = "/list_society",  method = RequestMethod.GET, produces="text/plain;charset=UTF-8")
	public @ResponseBody String list_society(HttpSession session, Model model) {

		String stdtNum = (String) session.getAttribute("stdtNum");
		String stdtGrade = (String) session.getAttribute("grade");
		String stdtClassNum = (String) session.getAttribute("classNum");
		
		MokTestDao moktestdao = sqlSession.getMapper(MokTestDao.class);

		Gson gson = new Gson();
		ArrayList<MokTestDto> list_society = moktestdao.moktest_chart_society(stdtNum, stdtGrade, stdtClassNum);
		
		return gson.toJson(list_society);
	}


}

