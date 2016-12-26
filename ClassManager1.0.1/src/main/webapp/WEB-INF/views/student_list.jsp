<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<title>Insert title here</title>
</head>
<c:if test="${isStudent eq true }">
<jsp:include page="header2.jsp"></jsp:include>
</c:if>
<c:if test="${isStudent eq false }">
<jsp:include page="header.jsp"></jsp:include>
</c:if>
<body>
	<div id="body">
		<div id="content">

	<br/>
			<div class="container">
				<div class="row">
					<c:forEach items="${stlist}" var="dto">
						<a class="col-sm-2"
							href="student_info?grade=${dto.stdtGrade}&classnum=${dto.stdtClassNum}&stdtNum=${dto.studentNum}&studentId=${dto.id}">
							<div class="card" style="margin-bottom: 20%; margin-left: 1%; height: 210px;" >
								<canvas class="header-bg" width="250" height="70"
									id="header-blur"></canvas>
								<div class="avatar">
									<img src="<%=cp%>/resources/assets/img/${dto.profilePhoto}" />
								</div>
								<div>
									<h6>${dto.studentNum}</h6>
									<h4>${dto.name}</h4>
								</div>
							</div>
						</a>
					</c:forEach>
				</div>
			</div>

			<script
				src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
			<%-- <script src="<%=cp%>/resources/assets/js/bootstrap.min.js"></script> --%>
		</div>
	</div>
</body>
<div id="foot">
	<jsp:include page="footer.jsp"></jsp:include>
</div>

</html>