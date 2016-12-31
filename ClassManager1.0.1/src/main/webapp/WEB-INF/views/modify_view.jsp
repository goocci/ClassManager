<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<br/>
		<br/>

			<!-- 1114_ form으로 묶어주고 action으로 페이지 넘겨줌 -->
			<form id="writeForm" action="modify?bIdx=${dto.idx}" method="POST">
				<div class="container">
					<div class=" col-md-10 col-sm-offset-0 col-md-offset-1"
						align="center">
						<table class="table table-striped table-hover" border="2">
							<tbody>
								<tr>
									<th width="100">말머리</th>
									<td><select id="selectbox" name="bCategory" title="말머리" style="width: 60px;">
											<option selected="selected" size="45">${dto.category}</option>
											<option>공부</option>
											<option>고민</option>
											<option>취미</option>
									</select></td>
								</tr>
								<tr>
									<th>작성자</th>
									<td><input type="text" name="bWriter" size="50" value =${dto.writer} readonly></td>
								</tr>
								<tr>
									<th>작성날짜</th>
									<td><input type="text" name="date" size="50" value=${dto.created_at} readonly ></td>
								</tr>
								<tr>
									<th>글 제목</th>
									<td><input type="text" name="bTitle" size="90" value=${dto.title}></td>
								</tr>
								<tr>
									<th>글 내용</th>									
									<td><textarea name="bContent" rows="10" cols="90">${dto.content}</textarea></td>
								</tr>
							</tbody>
						</table>

						<!-- 1114 글 수정,취소 버튼 추가 -->
						<div class="col-sm-12 controls" align="right">
							<input id="btn-write" type="submit" class="btn btn-primary" value="글수정" onclick="return writeCheck();"></input> 
							<a class="btn btn-primary" href="board_list"> 취소 </a>
						</div>

					</div>
				</div>
			</form>
		</div>
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
		<script src="<%=cp%>/resources/assets/js/bootstrap.min.js"></script>
	</div>

</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>