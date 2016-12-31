package com.gys.classmanager;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import com.gys.classmanager.dao.UnivScoreDao;
import com.gys.classmanager.dto.MokTestDto;
import com.gys.classmanager.dto.UnivScoreDto;

/**
 * Handles requests for the application home page.
 */

@Controller
@SessionAttributes("userid")
public class GradeController {

	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping(value = "/grade_input")
	public String grade_input(Model model) {

		return "grade_input";
	}
	
	@RequestMapping(value = "/analysis_grade")
	public String analysis_grade(Model model, HttpServletRequest request, HttpSession session) {

		session.removeAttribute("univName");
		session.removeAttribute("univMajor");
		session.removeAttribute("univId");

		return "analysis_grade";
	}

	@RequestMapping(value = "/search_univ_name")
	public String search_univ_name(Model model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		session.setAttribute("univName", request.getParameter("univName"));
		session.setAttribute("univMajor", request.getParameter("univMajor"));
		session.setAttribute("univId", request.getParameter("univId"));

		
		UnivScoreDao dao = sqlSession.getMapper(UnivScoreDao.class);
		ArrayList<UnivScoreDto> majorScorelist = dao.univMajor_score_Dao(request.getParameter("univName"), request.getParameter("univMajor"));
		int size = majorScorelist.size();
		
		model.addAttribute("univNamelist", dao.univName_list_Dao(request.getParameter("univName")));
		model.addAttribute("majorScorelist", majorScorelist);
		model.addAttribute("size", size);
		
		return "analysis_grade";
	}

	@RequestMapping(value = "/schooltest_input")
	public String schooltest_input(HttpSession session, HttpServletRequest request, Model model,
			HttpServletResponse res) {
		String stdtNum = (String) session.getAttribute("stdtNum");
		String stdtGrade = (String) session.getAttribute("grade");
		String stdtClassNum = (String) session.getAttribute("classNum");
		SchoolTestDao schooltestdao = sqlSession.getMapper(SchoolTestDao.class);

		// 강제적으로 에러 발생 !
		if (request.getParameter("subject").equals("")) {
			Integer.parseInt(request.getParameter("subject"));
		}

		schooltestdao.schooltest_input_Dao(request.getParameter("grade"), request.getParameter("semester"),
				request.getParameter("subject"), (Integer.parseInt(request.getParameter("schoolrate"))), stdtNum,
				stdtGrade, stdtClassNum);

		return "redirect:grade_input";
	}

	@RequestMapping("/moktest_input")
	public String moktest_input(HttpSession session, HttpServletRequest request) {

		String stdtNum = (String) session.getAttribute("stdtNum");
		String stdtGrade = (String) session.getAttribute("grade");
		String stdtClassNum = (String) session.getAttribute("classNum");
		MokTestDao moktestdao = sqlSession.getMapper(MokTestDao.class);
		moktestdao.moktest_input_Dao(request.getParameter("grade2"), request.getParameter("month"),
				request.getParameter("subject2"), (Integer.parseInt(request.getParameter("rate"))),
				(Integer.parseInt(request.getParameter("standard"))),
				(Integer.parseInt(request.getParameter("percent"))), stdtNum, stdtGrade, stdtClassNum);
		moktestdao.moktest_update1_Dao();
		moktestdao.moktest_update2_Dao();

		return "redirect:grade_input";
	}

	@RequestMapping("/deleteSchool")
	public String deleteSchool(HttpServletRequest request, Model model) {
		System.out.println("deleteSchool");

		SchoolTestDao dao = sqlSession.getMapper(SchoolTestDao.class);
		dao.deleteSchool(Integer.parseInt(request.getParameter("sIdx")));

		return "redirect:view_grade";
	}

	@RequestMapping("/deleteMok")
	public String deleteMok(HttpServletRequest request, Model model) {
		System.out.println("deleteMok");

		MokTestDao dao = sqlSession.getMapper(MokTestDao.class);
		dao.deleteMok(Integer.parseInt(request.getParameter("mIdx")));

		return "redirect:view_grade";
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

	@RequestMapping(value = "/list_schooltest", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String list_schooltest(HttpSession session, Model model) {

		String stdtNum = (String) session.getAttribute("stdtNum");
		String stdtGrade = (String) session.getAttribute("grade");
		String stdtClassNum = (String) session.getAttribute("classNum");
		Gson gson = new Gson();
		SchoolTestDao schooltestdao = sqlSession.getMapper(SchoolTestDao.class);
		List<String> list_schooltest = schooltestdao.schooltest_chart(stdtNum, stdtGrade, stdtClassNum);

		return gson.toJson(list_schooltest);
	}

	@RequestMapping(value = "/list_language", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String list_language(HttpSession session, Model model) {

		String stdtNum = (String) session.getAttribute("stdtNum");
		String stdtGrade = (String) session.getAttribute("grade");
		String stdtClassNum = (String) session.getAttribute("classNum");

		MokTestDao moktestdao = sqlSession.getMapper(MokTestDao.class);

		Gson gson = new Gson();
		ArrayList<MokTestDto> list_language = moktestdao.moktest_chart_language(stdtNum, stdtGrade, stdtClassNum);

		return gson.toJson(list_language);
	}

	@RequestMapping(value = "/list_math", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String list_math(HttpSession session, Model model) {

		String stdtNum = (String) session.getAttribute("stdtNum");
		String stdtGrade = (String) session.getAttribute("grade");
		String stdtClassNum = (String) session.getAttribute("classNum");

		MokTestDao moktestdao = sqlSession.getMapper(MokTestDao.class);

		Gson gson = new Gson();
		ArrayList<MokTestDto> list_math = moktestdao.moktest_chart_math(stdtNum, stdtGrade, stdtClassNum);

		return gson.toJson(list_math);
	}

	@RequestMapping(value = "/list_english", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String list_english(HttpSession session, Model model) {

		String stdtNum = (String) session.getAttribute("stdtNum");
		String stdtGrade = (String) session.getAttribute("grade");
		String stdtClassNum = (String) session.getAttribute("classNum");

		MokTestDao moktestdao = sqlSession.getMapper(MokTestDao.class);

		Gson gson = new Gson();
		ArrayList<MokTestDto> list_english = moktestdao.moktest_chart_english(stdtNum, stdtGrade, stdtClassNum);

		return gson.toJson(list_english);
	}

	@RequestMapping(value = "/list_science", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String list_science(HttpSession session, Model model) {

		String stdtNum = (String) session.getAttribute("stdtNum");
		String stdtGrade = (String) session.getAttribute("grade");
		String stdtClassNum = (String) session.getAttribute("classNum");

		MokTestDao moktestdao = sqlSession.getMapper(MokTestDao.class);

		Gson gson = new Gson();
		ArrayList<MokTestDto> list_science = moktestdao.moktest_chart_science(stdtNum, stdtGrade, stdtClassNum);

		return gson.toJson(list_science);
	}

	@RequestMapping(value = "/list_society", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String list_society(HttpSession session, Model model) {

		String stdtNum = (String) session.getAttribute("stdtNum");
		String stdtGrade = (String) session.getAttribute("grade");
		String stdtClassNum = (String) session.getAttribute("classNum");

		MokTestDao moktestdao = sqlSession.getMapper(MokTestDao.class);

		Gson gson = new Gson();
		ArrayList<MokTestDto> list_society = moktestdao.moktest_chart_society(stdtNum, stdtGrade, stdtClassNum);

		return gson.toJson(list_society);
	}

	@RequestMapping(value = "/UnivScore", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String UnivScore(HttpServletRequest request, Model model, HttpSession session) {

		String univName = (String) session.getAttribute("univName");
		String univMajor = (String) session.getAttribute("univMajor");
		String univId = (String) session.getAttribute("univId");

		UnivScoreDao dao = sqlSession.getMapper(UnivScoreDao.class);
		
		ArrayList<UnivScoreDto> majorScorelist = dao.univMajor_score_Dao(univName, univMajor);
		
		int size = majorScorelist.size();
		
		Gson gson = new Gson();
		ArrayList<UnivScoreDto> UnivScore1 = dao.univScore_chart1(univName, univMajor);
		ArrayList<UnivScoreDto> UnivScore2 = dao.univScore_chart2(univName, univMajor, univId);
		
		ArrayList<UnivScoreDto> UnivScore;
		
		if(size == 1){
			UnivScore = UnivScore1;
		} else{
			UnivScore = UnivScore2;
		}
		
		return gson.toJson(UnivScore);
	}

	@RequestMapping(value = "/MyScore", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String MyScore(HttpServletRequest request, Model model, HttpSession session) {

		String stdtNum = (String) session.getAttribute("stdtNum");
		String stdtGrade = (String) session.getAttribute("grade");
		String stdtClassNum = (String) session.getAttribute("classNum");

		MokTestDao moktestdao = sqlSession.getMapper(MokTestDao.class);

		ArrayList<MokTestDto> dto = moktestdao.moktest_list_Dao(stdtNum, stdtGrade, stdtClassNum);
		for (int i = 0; i < dto.size(); i++) {
			dto.get(i).setStandard(0);
			dto.get(i).setPercent(0);
			dto.get(i).setRate(0);
		}

		Gson gson = new Gson();

		String[] categoryArr = { "1학년 3월", "1학년 6월", "1학년 9월", "2학년 3월", "2학년 6월", "2학년 9월", "3학년 3월", "3학년 6월",
				"3학년 9월" };

		for (int j = 0; j < categoryArr.length; j++) {

			ArrayList<MokTestDto> MyScore = moktestdao.moktest_chart(stdtNum, stdtGrade, stdtClassNum, categoryArr[j]);

			double language_standard = 0;
			double math_standard = 0;
			double english_standard = 0;
			double science1_standard = 0;
			double science2_standard = 0;
			
			double language_percent = 0;
			double math_percent = 0;
			double english_percent = 0;
			double science1_percent = 0;
			double science2_percent = 0;
			
			double language_rate = 0;
			double math_rate = 0;
			double english_rate = 0;
			double science1_rate = 0;
			double science2_rate = 0;

			for (int i = 0; i < MyScore.size(); i++) {
				if (MyScore.get(i).getSubject().equals("언어")) {
					language_standard = MyScore.get(i).getStandard();
					language_percent = MyScore.get(i).getPercent();
					language_rate = MyScore.get(i).getRate();
					break;
				}
			}
			for (int i = 0; i < MyScore.size(); i++) {
				if (MyScore.get(i).getSubject().equals("수리")) {
					math_standard = MyScore.get(i).getStandard();
					math_percent = MyScore.get(i).getPercent();
					math_rate = MyScore.get(i).getRate();
					break;
				}
			}
			for (int i = 0; i < MyScore.size(); i++) {
				if (MyScore.get(i).getSubject().equals("외국어")) {
					english_standard = MyScore.get(i).getStandard();
					english_percent = MyScore.get(i).getPercent();
					english_rate = MyScore.get(i).getRate();
					break;
				}
			}
			for (int i = 0; i < MyScore.size(); i++) {
				if (!MyScore.get(i).getSubject().equals("언어") && !MyScore.get(i).getSubject().equals("수리")
						&& !MyScore.get(i).getSubject().equals("외국어")) {
					if (science1_standard == 0) {
						science1_standard = MyScore.get(i).getStandard();
						science1_percent = MyScore.get(i).getPercent();
						science1_rate = MyScore.get(i).getRate();
					} else {
						science2_standard = MyScore.get(i).getStandard();
						science2_percent = MyScore.get(i).getPercent();
						science2_rate = MyScore.get(i).getRate();
					}
				}
			}
			double totalStandard = language_standard + math_standard * 6 / 5 + english_standard + (science1_standard + science2_standard) * 4 / 5;
			double totalPercent = language_percent + math_percent + english_percent + (science1_percent + science2_percent)/2;
			double totalRate = (language_rate + math_rate + english_rate + science1_rate + science2_rate)/5;
			
			double s = Math.round(totalStandard * 100) / 100.0;
			double p = Math.round(totalPercent * 100) / 100.0;
			double r = Math.round(totalRate * 100) / 100.0;
			
			if(language_standard == 0 || math_standard == 0 || english_standard == 0 || science1_standard == 0 || science2_standard == 0){
	            break;
	        }
			
			dto.get(j).setStandard(s);
			dto.get(j).setPercent(p);
			dto.get(j).setRate(r);
		}
		return gson.toJson(dto);
	}
}



