package com.gys.classmanager.controller;

import java.util.ArrayList;
import java.util.StringTokenizer;

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
		
		ArrayList<CalendarDto> calendarList; 
		if (memberdto.getTeacherNum() != 0) {
			calendarList=sqlSession.getMapper(CalendarDao.class).listCalendar(memberdto.getGrade(), memberdto.getClassNum());
		} 
		else{
			calendarList=sqlSession.getMapper(CalendarDao.class).listCalendar(memberdto.getStdtGrade(), memberdto.getStdtClassNum());
		}
	
		model.addAttribute("list", calendarList);
		
		return "calendar";
	}

	@RequestMapping(value = "/calendarInput")
	public String calendarInput( Model model, HttpServletRequest request,
			@RequestParam("content_") String content_) {
		String plan = request.getParameter("plan");
		String time1 = request.getParameter("time1");
		String time2 = request.getParameter("time2");
		String selectDate = request.getParameter("selectDate");
		StringTokenizer token = new StringTokenizer(selectDate,"-");
		String day="";
		String time="";
		content_+="("+plan+")";
		while(token.hasMoreTokens()){
			day=token.nextToken();
		}
		int intDay = Integer.parseInt(day);
		
		
		time= (time1!="") ? time1 +"시 ~ " + time2+"시" : "";
		

		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("userid");
		MemberDto memberdto = sqlSession.getMapper(memberDao.class).memberByID(id);
		
		
		if (memberdto.getTeacherNum() != 0) {
			sqlSession.getMapper(CalendarDao.class).inputCalendar(selectDate, time, content_, memberdto.getGrade(),
					memberdto.getClassNum(), intDay);
		}
		else{
			sqlSession.getMapper(CalendarDao.class).inputCalendar(selectDate, time, content_, memberdto.getStdtGrade(),
					memberdto.getStdtClassNum(), intDay);
		}
		return "redirect:calendar";
	}
	
	@RequestMapping(value = "/calendarDel")
	public String calendarDel( Model model, HttpServletRequest request,
			@RequestParam("idx") int idx) {

		sqlSession.getMapper(CalendarDao.class).deletePlan(idx);
		
		return "redirect:calendar";
	}

}
