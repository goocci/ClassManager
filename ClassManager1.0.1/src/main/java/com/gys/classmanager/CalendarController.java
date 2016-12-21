package com.gys.classmanager;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.gys.classmanager.dao.CalendarDao;
import com.gys.classmanager.dao.memberDao;
import com.gys.classmanager.dto.CalendarDto;
import com.gys.classmanager.dto.MemberDto;

/**
 * Handles requests for the application home page.
 */

@Controller
@SessionAttributes("userid")
public class CalendarController {

	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping(value = "/calendar")
	public String calendar(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("userid");
		MemberDto memberdto = sqlSession.getMapper(memberDao.class).memberByID(id);
		
		ArrayList<CalendarDto> calendarList= sqlSession.getMapper(CalendarDao.class).listCalendar(memberdto.getGrade(), memberdto.getClassNum());
	
		model.addAttribute("list", calendarList);
		
		return "calendar";
	}

	@RequestMapping(value = "/calendarInput")
	public String gallery( Model model, HttpServletRequest request,@RequestParam("selectDate") String selectDate,
			@RequestParam("content_") String content_) {
		
		String time1 = request.getParameter("time1");
		String time2 = request.getParameter("time2");
		String AmPm = request.getParameter("AmPm");
		
		String time = " " + time1 + time2 + AmPm;	
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("userid");
		MemberDto memberdto = sqlSession.getMapper(memberDao.class).memberByID(id);
		
		sqlSession.getMapper(CalendarDao.class).inputCalendar(selectDate, time, content_, memberdto.getGrade(), memberdto.getClassNum());
		
		return "redirect:calendar";
	}


}