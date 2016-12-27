package com.gys.classmanager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gys.classmanager.dao.VoteDao;
import com.gys.classmanager.dto.VoteDto;


@Controller
public class VoteController {
	
	@Autowired
	private SqlSession sqlSession;

	@RequestMapping("/createVote")
	public String createVote(HttpServletRequest request, Model model, HttpSession session) {
		System.out.println("createVote()");
		
		
		int idx;
		int exampleSize = Integer.parseInt (request.getParameter("exampleSize"));
		String id = (String)session.getAttribute("userid");
		String topic = request.getParameter("voteTitle");
		
		VoteDao dao = sqlSession.getMapper(VoteDao.class);
		
	
		
		if(exampleSize==1){
			
			String choice1 = request.getParameter("exampleContent1");
			dao.createVote1( id, topic, choice1, 0);	
			VoteDto dto = dao.lastListVote();
			idx = dto.getIdx();
			
		}else if(exampleSize==2){
			
			String choice1 = request.getParameter("exampleContent1");
			String choice2 = request.getParameter("exampleContent2");
			dao.createVote2( id, topic, choice1, choice2, 0, 0);	
			VoteDto dto = dao.lastListVote();
			idx = dto.getIdx();
			
		}else if(exampleSize==3){
			
			String choice1 = request.getParameter("exampleContent1");
			String choice2 = request.getParameter("exampleContent2");
			String choice3 = request.getParameter("exampleContent3");
			dao.createVote3( id, topic, choice1, choice2, choice3 , 0 , 0 , 0);	
			VoteDto dto = dao.lastListVote();
			idx = dto.getIdx();
			
		}else if(exampleSize==4){
			
			String choice1 = request.getParameter("exampleContent1");
			String choice2 = request.getParameter("exampleContent2");
			String choice3 = request.getParameter("exampleContent3");
			String choice4 = request.getParameter("exampleContent4");
			dao.createVote4( id, topic, choice1, choice2, choice3, choice4, 0 , 0, 0, 0);	
			VoteDto dto = dao.lastListVote();
			idx = dto.getIdx();
			
		}else{
			
			String choice1 = request.getParameter("exampleContent1");
			String choice2 = request.getParameter("exampleContent2");
			String choice3 = request.getParameter("exampleContent3");
			String choice4 = request.getParameter("exampleContent4");
			String choice5 = request.getParameter("exampleContent5");
			dao.createVote5( id, topic, choice1, choice2, choice3, choice4, choice5, 0, 0, 0, 0, 0);	
			VoteDto dto = dao.lastListVote();
			idx = dto.getIdx();
			
		}
		
		model.addAttribute("vIdx", idx);
		
		return "redirect:write_view";
	}
}
