package com.gys.classmanager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.gys.classmanager.dao.BoardDao;
import com.gys.classmanager.dto.BoardDto;

@Controller
@SessionAttributes("userid")
public class BoardController {
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping(value = "/board_list")
	public String board_list(Model model, HttpSession session) {
		String stdtGrade = (String) session.getAttribute("grade");
		String stdtClassNum = (String) session.getAttribute("classNum");
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		model.addAttribute("board_list", dao.listBoard(stdtGrade, stdtClassNum));
		return "board_list";
	}
	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		System.out.println("content_view()");
		
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		
		model.addAttribute("comment_list", dao.listComment(Integer.parseInt(request.getParameter("bIdx"))));
		dao.upHit(Integer.parseInt(request.getParameter("bIdx")));
		BoardDto dto = dao.viewBoard(Integer.parseInt(request.getParameter("bIdx")));
		
		model.addAttribute("dto",dto);	
		return "content_view";
	}
	
	@RequestMapping("/content_view_cm")
	public String content_view_cm(HttpServletRequest request, Model model) {
		System.out.println("content_view()");
		
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		
		model.addAttribute("comment_list", dao.listComment(Integer.parseInt(request.getParameter("bIdx"))));
		BoardDto dto = dao.viewBoard(Integer.parseInt(request.getParameter("bIdx")));
		
		model.addAttribute("dto",dto);	
		return "content_view";
	}
		
	@RequestMapping(value = "/write_view")
	public String write_view(Model model, HttpSession session) {
		
		String teachername = (String) session.getAttribute("tname");
		String writer;
		
		if (teachername != null) {
			writer = (String)session.getAttribute("tname");
		} else {
			writer = (String)session.getAttribute("sname");
		}
		
		model.addAttribute("writer", writer);

		return "write_view";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model, HttpSession session) {
		System.out.println("write()");
		
		String stdtGrade = (String) session.getAttribute("grade");
		String stdtClassNum = (String) session.getAttribute("classNum");
		int teacherNum = (Integer) session.getAttribute("teacherNum");
		
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		
		dao.writeBoard(request.getParameter("bCategory"), request.getParameter("bTitle"),
							request.getParameter("bContent"), request.getParameter("bWriter"), 1, stdtGrade, stdtClassNum, teacherNum);
		return "redirect:board_list";
	}
	
	@RequestMapping("/deleteBoard")
	public String deleteBoard(HttpServletRequest request, Model model) {
		System.out.println("deleteBoard()");
		
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		dao.deleteBoard(request.getParameter("bIdx"));			
		return "redirect:board_list";
	}
	
	@RequestMapping("/modify_view")
	public String modify_view(HttpServletRequest request, Model model) {
		System.out.println("modify_view()");
		
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		BoardDto dto = dao.modifyViewBoard(request.getParameter("bIdx"));
		model.addAttribute("dto",dto);	
		return "modify_view";
	}
	
	@RequestMapping("/modify")
	public String modify(HttpServletRequest request, Model model) {
		System.out.println("modify");
	
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		dao.modifyBoard(request.getParameter("bCategory"), request.getParameter("bTitle"), 
							  request.getParameter("bContent"), request.getParameter("bIdx"));	
		model.addAttribute("bIdx", request.getParameter("bIdx"));
		return "redirect:content_view_cm";
	}
	
}
