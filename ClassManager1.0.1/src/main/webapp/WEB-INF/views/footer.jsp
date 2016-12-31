<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet">

<title>Insert title here</title>
</head>

<body>

	<footer class="footer-2 bg-color-2">

		<!-- main footer begin -->
		<div class="main-footer">
			<div class="container">
				<div class="row">
					<div class="col-md-12" style="text-align: center; height: 120px">
						<img class="logo-footer"
							src="<%=cp %>/resources/assets/img/logo10.png"
							alt="compact company" style="width: 300px;">
						<div class="footer-contact">
							<ul class="contact-info">
								<li><i class="fa fa-building-o"></i>379 5th Ave New York,
									United States <span>|</span></li>
								<li><i class="fa fa-phone"></i>+(112) 345 6879</li>
								<li><i class="fa fa-fax"></i>+(112) 345 8796 <span>|</span></li>
								<li><i class="fa fa-envelope"></i>contact@compact.com</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- main footer close -->

		<!-- sub footer begin -->
		<div class="sub-footer">
			<div class="container">
				<div class="row">
					<div class="col-md-12" style="text-align: center;">Copyright
						© 2016 Designed by JungIm Choi. All rights reserved.</div>
				</div>
			</div>
		</div>
		<!-- sub footer close -->

	</footer>

</body>
</html>