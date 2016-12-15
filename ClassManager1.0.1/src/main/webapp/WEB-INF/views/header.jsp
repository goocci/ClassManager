<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String cp = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="<%=cp%>/resources/assets/bootstrap/css/bootstrap_join.min.css" rel="stylesheet">


<title>header</title>

</head>
<body>

	<nav class="navbar navbar-inverse" style="margin-bottom:0px;" id="header">
		<div class="container-fluid"> 
			<div class="navbar-header" style="padding-bottom: 33px;">
				<button class="navbar-toggle collapsed" type="button"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-2">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="main"><img 
							src="<%=cp%>/resources/assets/img/logo8.png"
							style="width: 120px;"alt="company"></a>
			</div>

			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-2" style="margin-top:20px; margin-bottom: 15px;">
				<ul class="nav navbar-nav" style="font-size: 23px">

					<li class="dropdown"><a href="student_list">학급관리</a>
					<li class="dropdown"><a href="board_list">게시판</a>
					<li class="dropdown"><a href="gallery">사진첩</a>
				</ul>

				<ul class="nav navbar-nav navbar-right" style="font-size: 17px;">
					<li><a href="join_modify">수정</a></li>
					<li><a href="logout">로그아웃</a></li>
				</ul>

				<p class="navbar-text navbar-right" style="font-size: 15px;">${tname} 선생님 | 담당학급: ${grade} ${classNum}</p>

			</div>
		</div>
	</nav>
</body>
</html>