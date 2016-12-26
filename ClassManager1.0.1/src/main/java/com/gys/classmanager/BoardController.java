package com.gys.classmanager;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.gys.classmanager.dao.BoardDao;
import com.gys.classmanager.dto.BoardDto;

@Controller
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
	public String content_view(HttpServletRequest request, Model model, HttpSession session) {
		System.out.println("content_view()");
		
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		
		model.addAttribute("comment_list", dao.listComment(Integer.parseInt(request.getParameter("bIdx"))));
		dao.upHit(Integer.parseInt(request.getParameter("bIdx")));
		BoardDto dto = dao.viewBoard(Integer.parseInt(request.getParameter("bIdx")));
		
		String id = (String)session.getAttribute("userid");
		
		model.addAttribute("useridd", id);
		model.addAttribute("dto",dto);	
		return "content_view";
	}
	
	@RequestMapping("/content_view_cm")
	public String content_view_cm(HttpServletRequest request, Model model, HttpSession session) {
		System.out.println("content_view()");
		
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		
		model.addAttribute("comment_list", dao.listComment(Integer.parseInt(request.getParameter("bIdx"))));
		BoardDto dto = dao.viewBoard(Integer.parseInt(request.getParameter("bIdx")));
		
		String id = (String)session.getAttribute("userid");
		
		model.addAttribute("useridd", id);
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
		String id = (String)session.getAttribute("userid");
		
		String boardFileName= (String) request.getParameter("boardFileName");
		System.out.println(boardFileName);
		
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		
		if (boardFileName != null) {
			dao.writeBoardP(request.getParameter("bCategory"), request.getParameter("bTitle"),
					request.getParameter("bContent"), request.getParameter("bWriter"), id, 1, stdtGrade, stdtClassNum, teacherNum, boardFileName);
		} else {
			dao.writeBoard(request.getParameter("bCategory"), request.getParameter("bTitle"),
					request.getParameter("bContent"), request.getParameter("bWriter"), id, 1, stdtGrade, stdtClassNum, teacherNum);
		}
		
		return "redirect:board_list";
	}
	
	@RequestMapping("/uploadfile")
	@ResponseBody
	public String uploadfile(HttpServletRequest request, @RequestParam("boardFile") MultipartFile boardFile, Model model, HttpSession session) {
		System.out.println("uploadfile()");
		
		System.out.println("uploadPhoto");
		String savePath = "C:\\Users\\인영\\dev\\ws_sts\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\ClassManager1.0.1\\resources\\assets\\img";

		String originalFilename = boardFile.getOriginalFilename(); // fileName.jpg
		String onlyFileName = originalFilename.substring(0, originalFilename.indexOf(".")); // fileName
		String extension = originalFilename.substring(originalFilename.indexOf(".")); // .jpg

		String rename = onlyFileName + "_" + getCurrentDayTime() + extension; // fileName_20150721-14-07-50.jpg
		String fullPath = savePath + "\\" + rename;
		System.out.println(rename);

		if (!boardFile.isEmpty()) {
			try {
				byte[] bytes = boardFile.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(fullPath)));
				stream.write(bytes);
				stream.close();
				model.addAttribute("resultMsg", "파일 업로드 성공");
				model.addAttribute("photoname", rename);
			} catch (Exception e) {
				model.addAttribute("resultMsg", "파일을 업로드하는 데에 실패했습니다.");
			}
		} else {
			model.addAttribute("resultMsg", "업로드할 파일을 선택해주시기 바랍니다.");
		}
		return rename;
	}
	
	private String getCurrentDayTime() {
		long time = System.currentTimeMillis();
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyyMMdd-HH-mm-ss", Locale.KOREA);
		return dayTime.format(new Date(time));
	}
	
	@RequestMapping("/filedown")//URL호출
	@ResponseBody
	public void getFile(@RequestParam Map<String,Object> map, HttpServletResponse response) throws Exception {
		
		System.out.println("filedown 들어왔음");
	     
	    //String filePath = (String) map.get("filePath"); //파일 전체경로(파일명도 포함)
	    //String oriFileName = (String) map.get("oriFileName"); //파일 원본 경로
	    
	    //System.out.println(filePath);
	    //System.out.println(oriFileName);
		
		String filePath = "C:\\Users\\인영\\dev\\ws_sts\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\ClassManager1.0.1\\resources\\assets\\img\\cheoyoung_20161224-17-15-09.PNG";
		String fileName = "cheoyoung.PNG";
	     /*
	    //String docName = URLEncoder.encode(oriFileName,"UTF-8").replaceAll("\\+", "%20"); //한글파일명 깨지지 않도록
		String docName = new String(oriFileName.getBytes("UTF-8"), "ISO-8859-1");
	    //response.setHeader("Content-Disposition", "attachment;filename=" + docName + ";");
		response.setHeader("Content-Disposition", "attachment; filename=\"" + oriFileName + "\"");
	    response.setContentType("application/octet-stream");
	 
	    File down_file = new File(filePath); //파일 생성
	    FileInputStream fileIn = new FileInputStream(down_file); //파일 읽어오기
	    ByteStreams.copy(fileIn, response.getOutputStream());
	    response.flushBuffer();
	    */
		
		/*
	    byte fileByte[] = FileUtils.readFileToByteArray(new File(filePath));
	    
	    System.out.println(fileByte);
	     
	    response.setContentType("application/octet-stream");
	    response.setContentLength(fileByte.length);
	    response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(oriFileName,"UTF-8")+"\";");
	    response.setHeader("Content-Transfer-Encoding", "binary");
	    response.getOutputStream().write(fileByte);
	     
	    response.getOutputStream().flush();
	    response.getOutputStream().close();
	    */
		

		 //응답 헤더의 Content-Type을 세팅한다. 
		 response.setContentType("application/x-msdownload"); 
		 //위 세팅으로 안될 경우에 사용.
		 //response.setContentType("application/octet-stream");
		 
		 
		 //Content-Disposition 세팅하기위해 file 이름을 변환한다.
		 String convName1 = 
		  java.net.URLEncoder.encode(new String(fileName .getBytes("8859_1"), "euc-kr"),"UTF-8");


		 //Content-Disposition 헤더에 파일 이름 세팅. 
		// response.setHeader("Content-Disposition", "attachment;filename=" + convName1 + ";");
		 //위 세팅으로 안될 경우에 사용.
		 response.setHeader("Content-Disposition","attachment;fileName=\""+convName1+"\";");
		 

		 // 폴더에 있는 파일 가져오기 위해 다른 방법으로 변환
		 String  convName2 = new String(fileName .getBytes("8859_1"), "euc-kr");
		 File file = new File(filePath);

		 

		 // 사용자에게 보내주기 위해 스트림객체 생성
		 byte b[] = new byte[(int)file.length()];    
		 System.out.println(b);
		 System.out.println(file.isFile());
		 if (file.length() > 0 && file.isFile()) // 0byte이상이고, 해당 파일이 존재할 경우
		 {
		   BufferedInputStream fin = new BufferedInputStream(new FileInputStream(file));

		   // 인풋객체생성
		   BufferedOutputStream outs = new BufferedOutputStream(response.getOutputStream());

		   // 응답객체생성
		 
		   
		  int read = 0;
		  try {
		   while ((read = fin.read(b)) != -1){
		       outs.write(b,0,read);
		   }
		   outs.close();
		   fin.close();
		  } catch (Exception e) {
		   System.out.println("download error : " + e.getMessage()); 
		  } finally {
		   if(outs!=null) outs.close();
		   if(fin!=null) fin.close();
		  }
		 }
	 
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
