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

<link
	href="<%=cp%>/resources/assets/bootstrap/css/bootstrap_join.min.css"
	rel="stylesheet">

<title>ClassManager</title>
</head>
<body>
	<div id="body">
		<div id="content">
			<label for="subject"><h6>상담주제 :</h6> </label>
			<input id="subject" type="text" value="${content.category }" readonly="readonly">
		
			<label for="date"><h6>상담일 :</h6> </label>
			<input id="date" type="text" value="${content.consultTime }" readonly="readonly"><br>
		
		
			<label for="textArea"><h6>내용 :</h6> </label><br>
			<textarea rows="6" cols="60" id="textArea"
			 style="border: solid 1px; resize: none; overflow-y: scroll;" readonly="readonly">${content.content }</textarea>
			<div align="right"><input type="button" class="btn btn-primary"
									onclick="window.close();" value="닫 기"></input></div>
			<script
				src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
			<script src="<%=cp%>/resources/assets/js/bootstrap.min.js"></script>
		</div>
	</div>
</body>
</html>