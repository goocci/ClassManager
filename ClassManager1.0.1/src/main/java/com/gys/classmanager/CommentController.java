package com.gys.classmanager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gys.classmanager.dao.BoardDao;
import com.gys.classmanager.dao.CommentDao;

@Controller
public class CommentController {
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping("/writeComment")
	public String write(HttpServletRequest request, Model model, HttpSession session) {
		System.out.println("write()");
		
		String teachername = (String) session.getAttribute("tname");
		String writer;
		
		if (teachername != null) {
			writer = (String)session.getAttribute("tname");
		} else {
			writer = (String)session.getAttribute("sname");
		}
		
		CommentDao dao = sqlSession.getMapper(CommentDao.class);
		dao.writeComment(Integer.parseInt(request.getParameter("cBoardIdx")), writer,
							request.getParameter("cContent"));	
		model.addAttribute("bIdx", request.getParameter("cBoardIdx"));
		return "redirect:content_view_cm";
	}
	
	@RequestMapping("/deleteComment")
	public String deleteComment(HttpServletRequest request, Model model) {
		System.out.println("deleteComment");
		
		CommentDao dao = sqlSession.getMapper(CommentDao.class);
		dao.deleteComment(Integer.parseInt(request.getParameter("cBoardIdx")));
		
		model.addAttribute("bIdx", request.getParameter("bIdx"));
		return "redirect:content_view";
	}

}
