package com.gys.classmanager.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

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
import com.mysql.jdbc.BlobFromLocator;


@Controller
public class VoteController {
	
	@Autowired
	private SqlSession sqlSession;

	@RequestMapping("/createVote")
	@ResponseBody public String createVote(HttpServletRequest request, Model model, HttpSession session) {
		System.out.println("createVote()");
		
		
		int idx;
		int exampleSize = Integer.parseInt (request.getParameter("exampleSize"));
		System.out.println(exampleSize);
		String id = (String)session.getAttribute("userid");
		String topic = request.getParameter("voteTitle");
		
		VoteDao dao = sqlSession.getMapper(VoteDao.class);
		
	
		
		if(exampleSize==1){
			
			String choice1 = request.getParameter("exampleContent1");
			dao.createVote1( id, topic, 1, choice1, 0);
			VoteDto dto = dao.lastListVote();
			idx = dto.getIdx();
	
			
		}else if(exampleSize==2){
			
			String choice1 = request.getParameter("exampleContent1");
			String choice2 = request.getParameter("exampleContent2");
			dao.createVote2( id, topic, 2, choice1, choice2, 0, 0);	
			VoteDto dto = dao.lastListVote();
			idx = dto.getIdx();
			
			System.out.println(choice1);
			System.out.println(choice2);

			
		}else if(exampleSize==3){
			
			String choice1 = request.getParameter("exampleContent1");
			String choice2 = request.getParameter("exampleContent2");
			String choice3 = request.getParameter("exampleContent3");
			dao.createVote3( id, topic, 3, choice1, choice2, choice3 , 0 , 0 , 0);	
			VoteDto dto = dao.lastListVote();
			idx = dto.getIdx();
	
		}else if(exampleSize==4){
			
			String choice1 = request.getParameter("exampleContent1");
			String choice2 = request.getParameter("exampleContent2");
			String choice3 = request.getParameter("exampleContent3");
			String choice4 = request.getParameter("exampleContent4");
			dao.createVote4( id, topic, 4, choice1, choice2, choice3, choice4, 0 , 0, 0, 0);	
			VoteDto dto = dao.lastListVote();
			idx = dto.getIdx();
		
			
		}else{
			
			String choice1 = request.getParameter("exampleContent1");
			String choice2 = request.getParameter("exampleContent2");
			String choice3 = request.getParameter("exampleContent3");
			String choice4 = request.getParameter("exampleContent4");
			String choice5 = request.getParameter("exampleContent5");
			dao.createVote5( id, topic, 5, choice1, choice2, choice3, choice4, choice5, 0, 0, 0, 0, 0);	
			VoteDto dto = dao.lastListVote();
			idx = dto.getIdx();

			
		}
		
		String idxx = String.valueOf(idx);
		model.addAttribute("vIdx", idxx);
		
		return idxx;
	}
	
	public List<Map<String, Object>> voteList(int voteIdx){
		VoteDao vdao = sqlSession.getMapper(VoteDao.class);
		VoteDto vdto = vdao.viewVote(voteIdx);
		int count = vdto.getCount();
		//ArrayList<String> choiceArray = new ArrayList<String>();
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		Map<String,Object> map = new HashMap<String,Object>();
		
	
		
		if(count==1){

			Map<String,Object> map1 = new HashMap<String,Object>();
			map1.put("choice", vdto.getChoice1());
			map1.put("score", vdto.getScoreCh1());

			list.add(map1);
			
		}else if(count==2){

			Map<String,Object> map1 = new HashMap<String,Object>();
			map1.put("choice", vdto.getChoice1());
			map1.put("score", vdto.getScoreCh1());
			Map<String,Object> map2 = new HashMap<String,Object>();
			map2.put("choice", vdto.getChoice2());
			map2.put("score", vdto.getScoreCh2());

			
			list.add(map1);
			list.add(map2);
			
		}else if(count==3){

			
			Map<String,Object> map1 = new HashMap<String,Object>();
			map1.put("choice", vdto.getChoice1());
			map1.put("score", vdto.getScoreCh1());
			Map<String,Object> map2 = new HashMap<String,Object>();
			map2.put("choice", vdto.getChoice2());
			map2.put("score", vdto.getScoreCh2());
			Map<String,Object> map3 = new HashMap<String,Object>();
			map3.put("choice", vdto.getChoice3());
			map3.put("score", vdto.getScoreCh3());
			
			
			list.add(map1);
			list.add(map2);
			list.add(map3);
			
		}else if(count==4){

			
			Map<String,Object> map1 = new HashMap<String,Object>();
			map1.put("choice", vdto.getChoice1());
			map1.put("score", vdto.getScoreCh1());
			Map<String,Object> map2 = new HashMap<String,Object>();
			map2.put("choice", vdto.getChoice2());
			map2.put("score", vdto.getScoreCh2());
			Map<String,Object> map3 = new HashMap<String,Object>();
			map3.put("choice", vdto.getChoice3());
			map3.put("score", vdto.getScoreCh3());
			Map<String,Object> map4 = new HashMap<String,Object>();
			map4.put("choice", vdto.getChoice4());
			map4.put("score", vdto.getScoreCh4());

			list.add(map1);
			list.add(map2);
			list.add(map3);
			list.add(map4);
			
		}else {

			Map<String,Object> map1 = new HashMap<String,Object>();
			map1.put("choice", vdto.getChoice1());
			map1.put("score", vdto.getScoreCh1());
			Map<String,Object> map2 = new HashMap<String,Object>();
			map2.put("choice", vdto.getChoice2());
			map2.put("score", vdto.getScoreCh2());
			Map<String,Object> map3 = new HashMap<String,Object>();
			map3.put("choice", vdto.getChoice3());
			map3.put("score", vdto.getScoreCh3());
			Map<String,Object> map4 = new HashMap<String,Object>();
			map4.put("choice", vdto.getChoice4());
			map4.put("score", vdto.getScoreCh4());
			Map<String,Object> map5 = new HashMap<String,Object>();
			map5.put("choice", vdto.getChoice5());
			map5.put("score", vdto.getScoreCh5());
			
			list.add(map1);
			list.add(map2);
			list.add(map3);
			list.add(map4);
			list.add(map5);
			
		}

		return list;	
	}
	
	@RequestMapping("/vote")
	public String vote(HttpServletRequest request, Model model, HttpSession session) {
		String id = (String)session.getAttribute("userid");
		System.out.println("vote()");
		int vIdx = Integer.parseInt (request.getParameter("vIdx"));
		String count = request.getParameter("exampleNo");
		model.addAttribute("bIdx", request.getParameter("bIdx"));
		VoteDao vdao = sqlSession.getMapper(VoteDao.class);
		
		sqlSession.getMapper(VoteDao.class).updatepId(vIdx,"");
		String pids= vdao.viewVote(vIdx).getpId();
		StringTokenizer token = new StringTokenizer(pids,",");
		
	
		boolean toggle = true ; 
		if(count.equals("0")){				
			while(token.hasMoreElements()){
				if(token.nextToken().equals(id)){
					System.out.println("이미 등록한 사용자입니다.!");
					toggle = false;
				}
			}
			if (toggle) {
				vdao.upScore1(vIdx);
				String pid = "," + id;
				sqlSession.getMapper(VoteDao.class).updatepId(vIdx, pid);
			}
	
		}else if(count.equals("1")) {
			while(token.hasMoreElements()){
				if(token.nextToken().equals(id)){
					System.out.println("이미 등록한 사용자입니다.!");
					toggle = false;
				}
			}
			if (toggle) {
				vdao.upScore2(vIdx);
				String pid = "," + id;
				sqlSession.getMapper(VoteDao.class).updatepId(vIdx, pid);
			}
		}else if(count.equals("2")){
			while(token.hasMoreElements()){
				if(token.nextToken().equals(id)){
					System.out.println("이미 등록한 사용자입니다.!");
					toggle = false;
				}
			}
			if (toggle) {
				vdao.upScore3(vIdx);
				String pid = "," + id;
				sqlSession.getMapper(VoteDao.class).updatepId(vIdx, pid);
			}
		}else if(count.equals("3")){
			while(token.hasMoreElements()){
				if(token.nextToken().equals(id)){
					System.out.println("이미 등록한 사용자입니다.!");
					toggle = false;
				}
			}
			if (toggle) {
				vdao.upScore4(vIdx);
				String pid = "," + id;
				sqlSession.getMapper(VoteDao.class).updatepId(vIdx, pid);
			}
		}else{
			vdao.upScore5(vIdx);
			while(token.hasMoreElements()){
				if(token.nextToken().equals(id)){
					System.out.println("이미 등록한 사용자입니다.!");
					toggle = false;
				}
			}
			if (toggle) {
				vdao.upScore5(vIdx);
				String pid = "," + id;
				sqlSession.getMapper(VoteDao.class).updatepId(vIdx, pid);
			}
		}
		return "redirect:content_view_cm";
	}
}
