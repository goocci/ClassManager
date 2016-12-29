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
<link
	href="<%=cp%>/resources/assets/bootstrap/css/bootstrap-imageupload.min.css"
	rel="stylesheet">
<title>ClassManager</title>

<style>
* {
	margin: 0;
	padding: 0;
}

body {
	background-color: black;
}

.container {
	width: 100%;
	height: 100%;
}

.trans {
	transition: all 1s ease;
	-moz-transition: all 1s ease;
	-ms-transition: all 1s ease;
	-o-transition: all 1s ease;
	-webkit-transition: all 1s ease;
}

.top {
	display: flex;
	width: 80vw;
	height: 110vh;
	margin-top: 10vh;
	margin-left: auto;
	margin-right: auto;
	margin-bottom: 10vh;
}

.top ul {
	list-style: none;
	width: 100%;
	height: 100%;
	z-index: 1;
	box-sizing: border-box;
}

.top ul li {
	position: relative;
	float: left;
	width: 24%;
	height: 24%;
	overflow: hidden;
	margin-top: 1px;
	margin-left: 1px;
	margin-right: 1px;
	margin-bottom: 1px;
}

.top ul li::before {
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	background-color: #000;
	content: '';
	color: white;
	opacity: 0.4;
	text-align: center;
	box-sizing: border-box;
	pointer-events: none;
	transition: all 0.5s ease;
	-moz-transition: all 0.5s ease;
	-ms-transition: all 0.5s ease;
	-o-transition: all 0.5s ease;
	-webkit-transition: all 0.5s ease;
}

.top ul li:hover::before {
	opacity: 0;
	background-color: rgba(0, 0, 0, 0.90);
}

.top ul li img {
	width: 100%;
	height: auto;
	overflow: hidden;
}

.lightbox {
	position: fixed;
	width: 100%;
	height: 100%;
	text-align: center;
	top: 0;
	left: 0;
	background-color: rgba(0, 0, 0, 0.75);
	z-index: 999;
	opacity: 0;
	pointer-events: none;
}

.lightbox img {
	max-width: 90%;
	max-height: 80%;
	position: relative;
	top: -100%;
	/* Transition */
	transition: all 1s ease;
	-moz-transition: all 1s ease;
	-ms-transition: all 1s ease;
	-o-transition: all 1s ease;
	-webkit-transition: all 1s ease;
}

.lightbox:target {
	outline: none;
	top: 0;
	opacity: 1;
	pointer-events: auto;
	transition: all 1.2s ease;
	-moz-transition: all 1.2s ease;
	-ms-transition: all 1.2s ease;
	-o-transition: all 1.2s ease;
	-webkit-transition: all 1.2s ease;
}

.lightbox:target img {
	top: 0;
	top: 50%;
	transform: translateY(-50%);
	-moz-transform: translateY(-50%);
	-ms-transform: translateY(-50%);
	-o-transform: translateY(-50%);
	-webkit-transform: translateY(-50%);
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
				onclick="delgallery();">사진삭제</button>
		</div>

		<script type="text/javascript">
			function delgallery() {
				var idx;
				idx = prompt("삭제할 사진 번호를 입력하세요!");
				if (idx == null) {
					return ;
				}
			 	else if (isNaN(idx) === true) {
					return ;
				} 
				else {
					location.href = "gallerydel?idx=" + idx;
				}
			}
		</script>
		<script type="text/javascript">
			if ("${msg}" != "empty") {
				alert('${msg}');
			}
		</script>
		<div class="container">
			<div class="top">
				<ul>
					<c:forEach items="${gallery}" var="dto">
						<li><a href="#img_${dto.idx}" style="text-decoration: none"><span
								style="float: left">${dto.idx}</span>
							<h4 align="center">${dto.title}</h4> <img
								src="<%=cp%>/resources/assets/img/${dto.photoName}"
								alt="no image"></a></li>
						<a href="#_${dto.idx}" class="lightbox trans" id="img_${dto.idx}"><img
							src="<%=cp%>/resources/assets/img/${dto.photoName}"
							alt="no image"></a>
					</c:forEach>
				</ul>
			</div>
		</div>

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
									<label class="btn btn-default btn-file"> <span>browse</span>
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
									<input type="hidden" id="saveHidden" value=""> 
									<input type="hidden" id="saveImage" 
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
		<script src="<%=cp%>/resources/script/bootstrap-imageupload.js"></script>
		<script type="text/javascript">
			$('.imageupload').imageupload();
		</script>
	</div>
</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>