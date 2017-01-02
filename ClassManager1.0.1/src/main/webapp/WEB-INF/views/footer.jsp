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
	
<style type="text/css">

/* Footer 2 */
footer.bg-color-2 {
  background: #f8f8f8;
  color: #666666;
}
footer.footer-2 .logo-footer {
  margin-bottom: 35px;
}
footer.footer-2 .social-icons-2 {
  margin-top: 20px;
}
footer.footer-2 .social-icons-2 a {
  display: inline-block;
  text-decoration: none;
  outline: none;
  text-align: center;
  font-size: 15px;
  width: 36px;
  height: 36px;
  line-height: 36px;
  background: transparent;
  color: #888888;
  margin-right: 5px;
  border: 1px solid #e6e6e6;
  -webkit-transition: 0.3s;
  transition: 0.3s;
  border-radius: 50%;
  -webkit-border-radius: 50%;
  -moz-border-radius: 50%;
}
footer.footer-2 .social-icons-2 a:hover {
  background: #29b6f6;
  border-color: #29b6f6;
  color: #ffffff;
}
footer.footer-2 .social-icons-2 a.facebook:hover {
  background-color: #02549F;
  border-color: #02549F;
}
footer.footer-2 .social-icons-2 a.vk:hover {
  background-color: #4C75A3;
  border-color: #4C75A3;
}
footer.footer-2 .social-icons-2 a.vimeo:hover {
  background-color: #1AB7EA;
  border-color: #1AB7EA;
}
footer.footer-2 .social-icons-2 a.tumblr:hover {
  background-color: #35465D;
  border-color: #35465D;
}
footer.footer-2 .social-icons-2 a.twitter:hover {
  background-color: #00ACED;
  border-color: #00ACED;
}
footer.footer-2 .social-icons-2 a.behance:hover {
  background-color: #1769FF;
  border-color: #1769FF;
}
footer.footer-2 .social-icons-2 a.instagram:hover {
  background-color: #DDCCBA;
  border-color: #DDCCBA;
}
footer.footer-2 .social-icons-2 a.pinterest:hover {
  background-color: #CD2129;
  border-color: #CD2129;
}
footer.footer-2 .social-icons-2 a.flickr:hover {
  background-color: #FF0084;
  border-color: #FF0084;
}
footer.footer-2 .social-icons-2 a.dribbble:hover {
  background-color: #EA4C89;
  border-color: #EA4C89;
}
footer.footer-2 .social-icons-2 a.google:hover {
  background-color: #D11516;
  border-color: #D11516;
}
footer.footer-2 .social-icons-2 a.youtube:hover {
  background-color: #E12A27;
  border-color: #E12A27;
}
footer.footer-2 .social-icons-2 a.linkedin:hover {
  background-color: #006699;
  border-color: #006699;
}
footer.footer-2 .social-icons-2 a.skype:hover {
  background-color: #00A7E5;
  border-color: #00A7E5;
}
footer.footer-2 .footer-contact {
  margin-top: 20px;
  margin-bottom: 35px;
}
footer.footer-2 .footer-contact ul {
  list-style: none;
  margin: 0px;
  padding: 0px;
  max-width: 450px;
  display: inline-block;
}
footer.footer-2 .footer-contact ul li {
  display: inline-block;
  margin-left: 15px;
  margin-bottom: 5px;
}
footer.footer-2 .footer-contact ul li .fa {
  margin-right: 5px;
}
footer.footer-2 .footer-contact ul li span {
  display: inline-block;
  margin-left: 15px;
}
footer.footer-2 .sub-footer {
  border-top: 1px solid rgba(0, 0, 0, 0.06);
}
footer.bg-color-1 {
  background: #042433;
  color: #999999;
}
footer .main-footer {
  padding: 50px 0px 50px 0px;
}
footer .main-footer .widget-title {
  color: #ffffff;
  margin-bottom: 35px;
  margin-top: 25px;
}
footer .main-footer .widget-inner ul {
  list-style: none;
  margin: 0px;
  padding: 0px;
}
footer .main-footer .widget-inner ul li {
  margin-bottom: 10px;
  padding-left: 10px;
  position: relative;
}
footer .main-footer .widget-inner ul li:before {
  font-family: 'FontAwesome';
  display: inline-block;
  font-size: 13px;
  content: "\f105";
  color: #e5e5e5;
  position: absolute;
  left: 0px;
  top: 0px;
}
footer .main-footer .widget-inner ul li a {
  color: #e5e5e5;
  text-decoration: none;
  -webkit-transition: .5s;
  transition: .5s;
}
footer .main-footer .widget-inner ul li a:hover {
  color: #29b6f6;
}
footer .main-footer .widget-inner .logo-footer {
  display: inline-block;
  margin-bottom: 35px;
}
footer .main-footer .widget-inner .social-icons {
  margin-top: 20px;
}
footer .main-footer .widget-inner .social-icons a {
  display: inline-block;
  text-decoration: none;
  outline: none;
  text-align: center;
  font-size: 15px;
  width: 36px;
  height: 36px;
  line-height: 36px;
  color: #ffffff;
  margin-right: 10px;
  float: left;
  -webkit-transition: 0.3s;
  transition: 0.3s;
  border-radius: 50%;
  -webkit-border-radius: 50%;
  -moz-border-radius: 50%;
}
footer .sub-footer {
  padding: 30px 0px;
  border-top: 1px solid rgba(255, 255, 255, 0.08);
}

</style>

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