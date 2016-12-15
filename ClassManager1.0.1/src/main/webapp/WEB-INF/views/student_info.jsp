<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<link href="<%=cp%>/resources/assets/bootstrap/css/datepicker3.css"
	rel="stylesheet">
<link
	href="<%=cp%>/resources/assets/bootstrap/css/bootstrap-select.min.css"
	rel="stylesheet">
<title>ClassManager</title>


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
			<jsp:include page="left.jsp" flush="true"></jsp:include>
			<div class="container">
				<div class="row">
					<div
						class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad">

						<div class="panel panel-info" style="width: 500px;" align="left">
							<div class="panel-heading">
								<h3 class="panel-title">${info.name}</h3>
							</div>
							<div class="panel-body">
								<div class="row">
									<div class="col-md-3 col-lg-3 " align="center">
										<img alt="User Pic"
											src="<%=cp%>/resources/assets/img/${info.profilePhoto}"
											class="img-circle img-responsive">
									</div>

									<div class=" col-md-9 col-lg-9 ">
										<table class="table table-user-information">
											<tbody>
												<tr>
													<td width="60px">학 년 :</td>
													<td>${info.stdtGrade}</td>
												</tr>
												<tr>
													<td>학 급 :</td>
													<td>${info.stdtClassNum}</td>
												</tr>
												<tr>
												<tr>
													<td>주 소 :</td>
													<td>${info.address }</td>
												</tr>
												<tr>
													<td>연락처 :</td>
													<td>${info.phoneNum}</td>
												</tr>
												<tr>
													<td>Email</td>
													<td><a href="mailto:${info.email }">${info.email }</a></td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
							</div>
							<div class="panel-footer">
								<h4>
									상담기록 &nbsp;<a class="btn btn-primary btn-sm"
										data-toggle="modal" data-target="#myModal">등록하기</a>
								</h4>

								<table class="table table-striped table-hover" id="consult">
									<thead>
										<tr>
											<th width="120">상담내용</th>
											<th width="70">상담일</th>
											<th width="50">구분</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${conList}" var="dto">
											<tr class="active">
												<td><a onclick="viewConsultContents(${dto.idx});"
													style="color: blue;">${dto.content}</a></td>
												<td>${dto.consultTime}</td>
												<td>${dto.category}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<div align="center"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!--영수 수정 모달 페이지 달력 11.14   -->



			<form action="save_consult" name="frm" method="post">
				<div id="myModal" class="modal fade">
					<div class="modal-dialog">

						<div class="modal-content">
							<div class="modal-header">
								<h4>상담내용 입력하기</h4>
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
							</div>
							<div class="modal-body">
								<label for="select">상담주제: </label> <select class="selectpicker"
									id="select" name="select" multiple title="선택하세요">
									<option value="이성문제">이성문제</option>
									<option value="성적문제">성적문제</option>
									<option value="가족문제">가족문제</option>
									<option value="개인문제">개인문제</option>
								</select> <br> <label for="dateRangePicker">상담일:</label>
								<div class="input-group input-append date" id="dateRangePicker">
									<div>
										<span class="glyphicon glyphicon-calendar"></span> <input
											type='text' name="consultdate" class="form-control" /> <span
											class="input-group-addon"> </span>
									</div>
								</div>
								<label for="comment">내 용:</label>
								<textarea placeholder="내용을 입력해주세요" class="form-control" rows="5"
									cols="40" id="comment" name="comment"
									style="border: solid 1px; resize: none; overflow-y: scroll;"></textarea>
								<input type="hidden" name="grade" value="${info.stdtGrade}" />
								<input type="hidden" name="classnum"
									value="${info.stdtClassNum}" /> <input type="hidden"
									name="num" value="${info.studentNum}" /> <input type="hidden"
									name="id" value="${info.id}" />
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Close</button>
								<input type="submit" class="btn btn-primary" value="저장하기"></input>
							</div>
						</div>
					</div>
				</div>
			</form>


			<div id="myModal2" class="modal fade">
				<div class="modal-dialog">

					<div class="modal-content">
						<div class="modal-header">
							<h4></h4>
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
						</div>
						<div class="modal-body">
							<label for="select">상담주제: </label> <select class="selectpicker"
								id="select" name="select" multiple title="선택하세요">
								<option value="이성문제">이성문제</option>
								<option value="성적문제">성적문제</option>
								<option value="가족문제">가족문제</option>
								<option value="개인문제">개인문제</option>
							</select> <br> <label for="dateRangePicker">상담일:</label>
							<div class="input-group input-append date" id="dateRangePicker">
								<div>
									<span class="glyphicon glyphicon-calendar"></span> <input
										type='text' name="consultdate" class="form-control" /> <span
										class="input-group-addon"> </span>
								</div>
							</div>
							<label for="comment">내 용:</label>
							<textarea placeholder="내용을 입력해주세요" class="form-control" rows="5"
								cols="40" id="comment" name="comment"></textarea>
							<input type="hidden" name="grade" value="${info.stdtGrade}" /> <input
								type="hidden" name="classnum" value="${info.stdtClassNum}" /> <input
								type="hidden" name="num" value="${info.studentNum}" /> <input
								type="hidden" name="id" value="${info.id}" />
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
							<input type="submit" class="btn btn-primary" value="저장하기"></input>
						</div>
					</div>
				</div>
			</div>

			<script
				src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
			<script type="text/javascript"
				src="<%=cp%>/resources/assets/bootstrap/js/bootstrap-datepicker.js"></script>
			<script type="text/javascript"
				src="<%=cp%>/resources/assets/bootstrap/js/bootstrap-select.min.js"></script>
			<script src="<%=cp%>/resources/assets/bootstrap/js/bootstrap.min.js"></script>
			<script type="text/javascript"
				src="<%=cp%>/resources/script/view_ConsultCon.js"></script>
			<script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
			<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
			<script type="text/javascript"
				src="<%=cp%>/resources/script/jquery.simplePagination.js"></script>

		</div>
	</div>
</body>
<div id="foot">
	<jsp:include page="footer.jsp"></jsp:include>
</div>
</html>