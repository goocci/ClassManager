<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String cp = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- google fonts-->
<link href='http://fonts.googleapis.com/css?family=Leckerli+One|Metrophobic' rel='stylesheet' type='text/css'>

<link
	href="<%=cp%>/resources/assets/bootstrap/css/bootstrap-imageupload.min.css"
	rel="stylesheet">
<title>ClassManager</title>

<style>

/*	Basic
================*/
html,body{
  margin:0;
  padding:0;
  position:relative;
  height:100%;
}

*,*:after,*:before{
  box-sizing:border-box;
}

/*  PLACEHOLDER
----------------------*/
::-webkit-input-placeholder {color: #FFF;}
:-moz-placeholder {color:  #FFF;}
::-moz-placeholder {color:  #FFF;}
:-ms-input-placeholder {color:  #FFF;}

/*  SCROLLBAR
-------------------*/
::-webkit-scrollbar{
  width:0.2em;
  background:#e74c3c;
}
::-webkit-scrollbar-track{}
::-webkit-scrollbar-thumb{
  background:#fff;
}
::-webkit-scrollbar-thumb:window-inactive{
  background:#fff;
}


/*  SELECTION
-------------------*/
::selection{
  background:#999;
  color:#fff;
}
::-moz-selection{
  background:#999;
  color:#fff;
}

/* === Links Styles === */
a{
  text-decoration:underline;
  transition:0.25s;
  backface-visibility:hidden;
}
a:hover{
  text-decoration:none;
}
a:focus{
  outline:0;
  outline:0 auto -webkit-focus-ring-color;
  outline-offset:0;
}


/*	Layout
=======================*/
body{
  background:#ECECEC;
  overflow-X:hidden;
  font-size:13px;
  font-family: 'Metrophobic', sans-serif;
  font-weight:400;
}

.wrapper {
  margin: 5% auto;
  display: block;
  width: 96%;
  height: 100%;
  padding: 0;
}

.wrapper_inner{
  padding:0.2em;
  margin:0;
}
.gallery{}

.gallery_item {
  float: center;
  width: 24.59%;
  display: inline-block;
  margin: 0 auto;
  margin-right: 0.2em;
  margin-bottom:0.2em;
  padding: 0;
}

.gallery_item_preview {
  transition: all 0.5s ease;
}

.gallery_item_preview a {
  position: relative;
  display: inline-block;
  padding: 0.2em;
  background:#ECECEC;
  color: #333;
  text-decoration: none;
  overflow: hidden;
  transition: all 0.5s ease;
}
.gallery_item_preview a:hover {
  color: #777;
  transition: all 0.5s ease;
}
.gallery_item_preview a:before {
  content:"Click to view";
  position:absolute;
  top:0.5em;
  left:-30em;
  background-color:#fff;
  background-color:rgba(255,255,255,0.3);
  color:#000;
  padding:0.5em 1em;
  border-radius: 5px 0 0 0;
  transition:all 1s ease;
}
.gallery_item_preview a:hover:before {
  left:0.5em;
  transition:all 1s ease;
}
.gallery_item_preview a h3{
  font-family: 'Leckerli One', cursive;
}
.gallery_item_preview a img{
  display:block;
  width:100%;
  height:150px;
  border-radius:5px;
  transition: all 0.5s ease;
}
.gallery_item_full{
  display: none;
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  margin: auto;
  background-color:#fff;
  background-color:rgba(255,255,255,0.8);
  z-index: 100;
  overflow:hidden;
}
.gallery_item_full img {
  display: block;
  width: 100%;
}
.box{
  margin:auto;
  background:#ecf0f1;
  padding: 2em;
  display: block;
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  overflow:auto;
  width:50%;
  text-align:left;
}
.box h3{
  font-family: 'Leckerli One', cursive;
  color:#F88484;
}

.cl {
  position: absolute;
  top: 0.5em;
  right: 0.5em;
  color: #777;
  text-decoration: none;
  display: inline-block;
  font-size: 2em;
}
.cl:hover{
  color:#F88484;
}



.video {
  position: relative;
  padding-bottom: 56.25%;
  padding-top: 30px; height: 0; overflow: hidden;
}

.video iframe,
.video object,
.video embed {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
}

/*  list style
=============================*/
.icon_list {
  width: 30px;
  height: 30px;
  display: block;
  padding: 0.5em;
  text-decoration: none;
  line-height: 0.4em;
  background: #FFF;
  color: #838383;
  border: 1px solid #C2C2C2;
  box-shadow: 0 1px 1px #4B4B4B;
  border-radius: 4px;
  position: absolute;
  right: 0.3em;
  top: 0.3em;
  transition: all 0.5s ease;
}
.icon_list:hover {
  background: #4E4E4E;
  color: #FFF;
  border-color: #000;
  transition: all 0.5s ease;
}
.gallery_item_list {
  float: none !important;
  display: block !important;
  width: 50% !important;
  margin: auto;
  background: #ECECEC;
  margin-top: 0.5em;
  box-shadow: 0 1px 4px #838383;
  transition: all 0.5s ease;
}
.gallery_line {
  width: 130px !important;
  height: 100px !important;
  display: inline-block !important;
  float: left !important;
  margin-right: 1em !important;
  transition: all 0.5s ease;
}

/*	Simple animation
=======================*/
.efIn{animation:fx_in 0.65s 1 ease-in-out;}
.efOut{animation:fx_out 0.7s 1 ease-in-out;}

/*	Keyframes
==============*/
@keyframes fx_in{
  from{width:0;height:0;border-radius:100%;opacity:0;}
  50%{box-shadow:inset 0 0 0 0  #fff;}
  to{width:100%;height:100%;border-radius:0;opacity:1;}
}
@keyframes fx_out{
  from{width:100%;height:100%;border-radius:0;
    box-shadow:inset 0 0 0 0 #fff;opacity:1;}
  50%{box-shadow:inset 0 0 0 80em  #fff;}
  to{width:0;height:0;border-radius:100%;opacity:0;}
}


/* Large desktop */
@media (min-width: 980px){
  .gallery_item {width: 24.45%;}
  .gallery_item_preview a img{height:180px;}
  .box{width:60%;}
}
/* Portrait tablet to landscape and desktop */
@media (min-width: 768px) and (max-width: 979px) { 
  .gallery_item {width: 32.83%;}
  .gallery_item_preview a img{height:180px;}
  .box{width:70%;}
}
/* Landscape phone to portrait tablet */
@media (max-width: 767px) { 
  .gallery_item {width: 49.45%;}
  .gallery_item_preview a img{height:180px;}
  .box{margin: auto;background: #F8F8F8;padding: 4em 1em 1em 1em;width:80%;}
  .cl{top: 0;right: 0.5em;}
}
/* Landscape phones and down */
@media (max-width: 480px) { 
  .gallery_item {width: 100%;}
  .gallery_item_preview a img{height:200px;}
  .box{background: #F8F8F8;padding: 4em 1em 1em 1em;width:100%;}
  .cl{top: 0;right: 0.5em;}
  .gallery_item_list{width:100% !important;}
}
</style>

</head>
<body>
	<c:if test="${isStudent eq true }">
		<jsp:include page="header2.jsp"></jsp:include>
	</c:if>
	<c:if test="${isStudent eq false }">
		<jsp:include page="header.jsp"></jsp:include>
	</c:if>
	<div id="body">
	
		<div id="pciture" align="right" style="margin: 20px;">
			<button type="button" class="btn btn-success" data-toggle="modal"
				data-target="#upload">사진등록</button>
			<button type="button" class="btn btn-success" data-toggle="modal"
				data-target="#delete">사진삭제</button>
		</div>
		
		
		<!-- Gallery List -->
		<div class="wrapper">
		  <div class="wrapper_inner">
		    <!-- Gallery -->
		    <section class="gallery">
		    
		    <c:forEach items="${gallery}" var="dto">
		    
		      <!-- Gallery  item -->
		      <div class="gallery_item">
		        <!-- Gallery  item preview -->
		        <span class="gallery_item_preview">
		          <a href="#" data-js="${dto.idx}">
		            <img src="<%=cp%>/resources/assets/img/${dto.photoName}" alt="no image" /><span>
		            <h3 align="center">${dto.title}</h3>
		
		            </span></a>
		
		        </span>
		        <!-- Gallery  item full -->
		        <div data-lk="${dto.idx}" class="gallery_item_full">
		          <div class="box">
		            <img src="<%=cp%>/resources/assets/img/${dto.photoName}" alt="no image" />
		            <h3 align="center">${dto.title}</h3>
		          </div>
		        </div>
		      </div>
		      
		      </c:forEach>
		
		    </section>
		  </div>
		</div>
		<!-- Gallery List -->


		<!-- 사진등록 모달 -->

		<!-- line modal -->
		<form action="galleryInput" enctype="multipart/form-data"
			method="post">
			<div class="modal fade" id="upload" tabindex="-1" role="dialog"
				aria-labelledby="modalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">×</span><span class="sr-only">Close</span>
							</button>
							<h4 class="modal-title" id="lineModalLabel"
								style="padding-bottom: 0px;">사진 등록하기</h4>
						</div>
						<hr>
						<div class="modal-body">
							<h4>
								<label for="title" style="float: left;">Tilte: </label>
							</h4>
							&nbsp;&nbsp; <input type="text" name="title" id="title"
								placeholder="사진제목을 입력하세요" style="width: 300px;"> <br />
							<br />
							<!-- content goes here -->
							<div class="imageupload panel panel-default">
								<div class="panel-heading clearfix">
									<h3 class="panel-title pull-left">Upload Image</h3>
									<div class="btn-group pull-right"></div>
								</div>
								<div class="file-tab panel-body">
									<label class="btn btn-default btn-file"> <span>Browse</span>
										<!-- The file is stored here. --> <input type="file"
										name="imgFile">
									</label>
									<button type="button" class="btn btn-default">Remove</button>
								</div>
								<div class="url-tab panel-body">
									<div class="input-group">
										<input type="text" class="form-control"
											placeholder="Image URL">
										<div class="input-group-btn">
											<button type="button" class="btn btn-default">Submit</button>
										</div>
									</div>
									<button type="button" class="btn btn-default">Remove</button>
									<!-- The URL is stored here. -->
									<input type="hidden" name="image-url">
								</div>

							</div>
						</div>
						<div class="modal-footer">
							<div class="btn-group btn-group-justified" role="group"
								aria-label="group button">
								<div class="btn-group" role="group">
									<button type="button" class="btn btn-default"
										data-dismiss="modal" role="button">취소</button>
								</div>
								<div class="btn-group" role="group">
									<input type="submit" id="saveImage"
										class="btn btn-default btn-hover-green" data-action="save"
										role="button" value="저장"></input>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>

		<script src="//code.jquery.com/jquery-1.12.2.min.js"></script>

		<script type="text/javascript"
			src="<%=cp%>/resources/assets/bootstrap/js/bootstrap.js"></script>
		<script src="<%=cp%>/resources/script/preview-image.min.js"></script>
		<script src="<%=cp%>/resources/script/bootstrap-imageupload.js"></script>
	</div>
</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>