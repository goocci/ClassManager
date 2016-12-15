<%@ page language="java" contentType="text/html"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%	String cp = request.getContextPath(); %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=0">
<!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="<%=cp%>/resources/assets/bootstrap/css/bootstrap_join.min.css"
	rel="stylesheet">
<title>ClassManager</title>

</head>
<body>
	<div id="wrapper2" align="center" style="width: 700px;">
		<fieldset>
			<legend>정보 수정</legend>
			<div align="center">
				<form name="uploadForm" method="post" action="updateFile"
					enctype="multipart/form-data">
					<div class="form-group">
						<div class="row">
							<div class="profile-header-container">
								<div class="profile-header-img">
									<img class="img-circle"
										src="<%=cp %>/resources/assets/img/${filename }" />
									<!-- badge -->
									<div class="rank-label-container">
										<span class="label label-default rank-label">profile</span>
									</div>
									<div align="right">
										<input type="file" name="imgFile">
									</div>
									<input type="submit" value="사진등록">${resultMsg }
								</div>
							</div>
						</div>
					</div>

				</form>


				<form class="form-horizontal" method="post" action="modify_confirm2" name="frm">

					<div class="form-group">
						<label class="col-lg-2 control-label" for="inputId">아이디 </label>
						<div class="col-lg-10">
							<div style="float: left; width: 100%;">
								<input class="form-control" id="inputId" type="text"
									name="inputId" value="${id}" readonly="readonly" />
							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-2 control-label" for="inputPassword">비밀번호</label>
						<div class="col-lg-10">
							<input class="form-control" id="inputPassword" type="password"
								name="pwd" placeholder="비밀번호">
						</div>
					</div>

					<div class="form-group">
						<label class="col-lg-2 control-label" for="inputPassword2">비밀번호
							확인</label>
						<div class="col-lg-10">
							<input class="form-control" id="inputPassword2" type="password"
								name="pwd_check" placeholder="비밀번호 확인">
						</div>
					</div>

					<div class="form-group">
						<label class="col-lg-2 control-label" for="inputName">이름</label>
						<div class="col-lg-10">
							<input class="form-control" id="inputName" type="text"
								name="inputName" value="${name}" readonly="readonly">
						</div>
					</div>

					<div class="form-group">
						<label class="col-lg-2 control-label" for="inputPhoneNum">전화번호</label>
						<div class="col-lg-10">
							<input class="form-control" id="inputPhoneNum" type="text"
								name="phone" placeholder="전화번호">
						</div>
					</div>

					<div class="form-group">
						<label class="col-lg-2 control-label" for="inputAddress">주소</label>
						<div class="col-lg-10">
							<input class="form-control" id="inputAddress" type="text"
								name="addr" placeholder="주소">
						</div>
					</div>

					<div class="form-group">
						<label class="col-lg-2 control-label" for="inputEmail">이메일</label>
						<div class="col-lg-10">
							<input class="form-control" id="email" type="text" name="email"
								placeholder="abc@abcd.com">
						</div>
					</div>

					<div class="form-group">
						<label class="col-lg-2 control-label" for="inputStudentNum">번호</label>
						<div class="col-lg-10">
							<div style="float: left; width: 100%;">
								<input class="form-control" id="studentNum" type="text"
									name="studentNum" placeholder="번호" />
							</div>
							<div></div>
						</div>
					</div>

					<div class="form-group">
						<label class="col-lg-2 control-label" for="selectGrade">학년</label>
						<div class="col-lg-10">
							<select class="form-control" id="selectGrade" name="selectGrade">
								<option value="1학년">1학년</option>
								<option value="2학년">2학년</option>
								<option value="3학년">3학년</option>
							</select>
						</div>
					</div>

					<div class="form-group">
						<label class="col-lg-2 control-label" for="selectClass">
							반</label>
						<div class="col-lg-10">
							<select class="form-control" id="selectClass" name="selectClass">
								<option value="1반">1반</option>
								<option value="2반">2반</option>
								<option value="3반">3반</option>
								<option value="4반">4반</option>
								<option value="5반">5반</option>
								<option value="6반">6반</option>
								<option value="7반">7반</option>
								<option value="8반">8반</option>
								<option value="9반">9반</option>
								<option value="10반">10반</option>
							</select>
						</div>
					</div>

					<c:if test="${filename != null}">
						<input type="hidden" name="fileNmae" id="fileName"
							value="${filename}">
					</c:if>
					<c:if test="${filename == null}">
						<input type="hidden" name="fileNmae" id="fileName"
							value="default.PNG">
					</c:if>

					<div class="form-group">
						<div class="col-lg-10 col-lg-offset-2">
							<input class="btn btn-primary" type="submit"
								onclick="return joinCheck();" value="수 정">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
								class="btn btn-primary" type="reset" value="초기화"></input>
						</div>
					</div>
				</form>

			</div>

			<script
				src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
			<script type="text/javascript" src="<%=cp%>/resources/script/join.js"></script>
			<script src="<%=cp%>/resources/assets/bootstrap/js/bootstrap.min.js"></script>
		</fieldset>
	</div>
</body>
</html>