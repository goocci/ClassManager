<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	String cp = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="<%=cp%>/resources/assets/bootstrap/css/bootstrap_join.min.css" rel="stylesheet">

<title>Insert title here</title>
</head>
<body>
<c:if test="${isStudent eq true }">
<jsp:include page="header2.jsp"></jsp:include>
</c:if>
<c:if test="${isStudent eq false }">
<jsp:include page="header.jsp"></jsp:include>
</c:if>
	<div id="body">
		<div id="content">
			<div style="text-align: center">
				<h1>글</h1>
			</div>

			<!-- 1114_ form으로 묶어주고 action으로 페이지 넘겨줌 -->
						<div class="col-md-10 col-sm-offset-0 col-md-offset-1 " align="center" style="margin-bottom: 10px; margin-left:28%; ">
							<a class="btn btn-primary" href="modify_view?bIdx=${dto.idx}" style="margin-left: 10px"> 글 수정 </a> 
							<a class="btn btn-primary" href="deleteBoard?bIdx=${dto.idx}"> 글 삭제 </a>
							<a class="btn btn-primary" href="board_list"> 글 목록으로 가기 </a>
						</div>
			<div class="container">
				<div class=" col-md-10 col-sm-offset-0 col-md-offset-1">
					<div style="border-width: 2px; border-style: solid;" align="center" >
					
						<h4 align="left" style="margin-top:20px; margin-bottom: -12px; margin-left:20px; margin-right:20px " >[${dto.category}] ${dto.title} </h4>						
						<h6 align="right" style="margin-top:20px; margin-bottom: -12px; margin-left:20px; margin-right:20px " >${dto.writer} ${dto.created_at} </h6>	
							<hr style= "border:1px dashed gray;">
						<% pageContext.setAttribute("newLineChar", "\n"); %>
						<p align="left" style="margin-top: -5px; margin-left: 20px; margin-right:20px;font-size: 20px">${fn:replace(dto.content, newLineChar, '<br/>')}</p>
							<hr style="border: 1px solid gray;">

						<form action="writeComment?cBoardIdx=${dto.idx}" method="POST">
							<div align="left">
								<textarea
									style="margin-left: 20px; border-width: 2px; border-style: solid; width: 80%"
									rows="1" placeholder="댓글을 입력하세요" name="cContent"></textarea>
								<input id="btn-write" type="submit"
									class="btn btn-default btn-sm"
									style="margin-bottom: 28px; border-width: 1px; border-style: solid; background-color: gray;"
									value="댓글 등록" onclick="return writeCheck();"> </input>
							</div>
						</form>

						<c:forEach items="${comment_list}" var="comment">
							<p class="text-left">
								<label class="col-sm-2 control-label">${comment.writer}</label>${comment.content}
								<a class="btn btn-default btn-xs"
									href="deleteComment?bIdx=${dto.idx}&cBoardIdx=${comment.idx}"
									style="margin-bottom: 5px">x</a>
							</p>
						</c:forEach>

					</div>
				</div>
			</div>

			<script
				src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
			<script src="<%=cp%>/resources/assets/js/bootstrap.min.js"></script>
		</div>
	</div>
</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>