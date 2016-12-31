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

<title>Insert title here</title>
</head>
<c:if test="${isStudent eq true }">
	<jsp:include page="header2.jsp"></jsp:include>
</c:if>
<c:if test="${isStudent eq false }">
	<jsp:include page="header.jsp"></jsp:include>
</c:if>
<div id="body">
	<div id="content">
		<body>
		<br/>
		<br/>

			<!-- 1114_ form으로 묶어주고 action으로 페이지 넘겨줌 -->
			<form id="writeForm" name="writeForm" action="write" method="POST"
				, enctype="multipart/form-data">
				<div class="container">
					<div class=" col-md-10 col-sm-offset-0 col-md-offset-1"
						align="center">
						<table class="table table-striped table-hover" border="2">
							<tbody>
								<tr>
									<th width="100">말머리</th>
									<td><select id="selectbox" name="bCategory" title="말머리"
										style="width: 60px;">
											<option selected="selected" size="45"></option>
											<option>공부</option>
											<option>고민</option>
											<option>취미</option>
									</select></td>
								</tr>
								<tr>
									<th>작성자</th>
									<td><input type="text" name="bWriter" size="50"
										value=${writer } readonly></td>
								</tr>

								<tr>
									<th>글 제목</th>
									<td><input type="text" name="bTitle" size="90"></td>
								</tr>
								<tr>
									<th>글 내용 </br>

									</th>
									<td>
									<a class="btn btn-default btn-sm" style="background-color: gray; margin-bottom: 10px"
									    											data-toggle="modal" data-target="#myModal"> 투표 </a> 
									
									<a class="btn btn-default btn-sm" style="background-color: gray; margin-bottom: 10px"
										data-toggle="modal" data-target="#myModal22">파일 첨부</a></br> 
										<textarea name="bContent" rows="10" cols="90"></textarea></br> 
										<input type="file" name="boardFile" id="boardFile" style="float: left">
									 <input type="hidden" name="boardFileName" id="fileName" value=" "></input></td>
									 <input type="hidden" name="vIdx" id="vIdx" value=" "></input></td>
								</tr>
							</tbody>
						</table>
							<div id="progress">
											<div class="bar" style="width: 0%;"></div>
										</div>


						<!-- 1114 글 등록,취소 버튼 추가 -->
						<div class="col-sm-12 controls" align="right">
							<input id="btn-write" type="submit" class="btn btn-primary"
								value="글등록" onclick="return writeCheck"> </input> <a
								class="btn btn-primary" href="board_list"> 취소 </a>
						</div>
					</div>
				</div>
			</form>
						
			<!-- 투표 모달 -->
			<script src="<%=cp%>/resources/assets/bootstrap/js/bootstrap.min.js"></script>

			<form id="createVote" name = "createVote" method="post"  action="createVote"  role="form">
				<div id="myModal" class="modal fade">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header"  style="padding-bottom: 1px;">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
								<h4>투표</h4>
							</div>
							<div class="modal-body"  style="padding-top: 1px;">
								<div class="form-group" style="margin-top: 5%;">
									<label for="voteTitle" class="control-label col-md-2"><b>투표제목</b></label>
									<input type="text"  size ="40px" name="voteTitle" id="voteTitle" required="required" autofocus="autofocus"/>
								</div>
								
								<!--
								<div class="form-group">
									<label for="voteEndDate" class="control-label col-md-2"><b>마감일</b></label>
									<input type="text" size ="50px" id="voteEndDate" name="voteEndDate" required="required" maxlength="10" />
								</div>
								-->
								<div class="form-group">
									<label for="exampleContent" class="control-label col-md-2"><b>선택지</b></label>

									<input type="text" name="exampleContent1" required="required">

									<a class="btn icon-btn btn-success"
										onclick="javascript:fn_examplePlus($(this))"> <span
										class="glyphicon btn-glyphicon glyphicon-plus img-circle text-success"></span>Add
									</a>
								</div>
							</div>
							<div class="modal-footer">
					  			<Input Type="hidden" name="exampleSize" value="">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Close</button> 
								<button type="button" class="btn btn-primary"  name="btnSubmint" id="btnSubmit" onclick="fn_save()"> 등록하기</button>
								 <!-- ajax로 할때 버튼
								<button type="button" class="btn btn-primary"  name="btnSubmint" id="btnSubmit" > 등록하기</button>
								-->
							</div>
						</div>
					</div>
				</div>
			</form>

			<script
				src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
			<script src="<%=cp%>/resources/assets/bootstrap/js/bootstrap.min.js"></script>

			<!-- 모달 -->

			<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
			<script src="<%=cp%>/resources/script/jquery.fileupload.js"></script>

			<!-- 파일 업로드 -->
			<script type="text/javascript">
				$(document).ready(function() {
					$('#boardFile').fileupload({
						url : 'uploadfile',
						replaceFileInput: false,
						dataType : 'json',
						add : function(e, data) {
							var uploadFile = data.files[0];
							var isValid = true;
							if (!(/png|jpe?g|gif/i).test(uploadFile.name)) {
								alert('png, jpg, gif 만 가능합니다');
								isValid = false;
							} else if (uploadFile.size > 5000000) { // 5mb
								alert('파일 용량은 5메가를 초과할 수 없습니다.');
								isValid = false;
							}
							if (isValid) {
								data.submit();
							}
						},
						progressall: function(e,data) {
			                var progress = parseInt(data.loaded / data.total * 100, 10);
			                $('#progress .bar').css(
			                    'width',
			                    progress + '%'
			                );
			            },
						done : function(e, data) {
							alert('정상적으로 업로드 됐습니다');
							$('#fileName').attr('value', data.result.filename);

						},
						fail : function(e, data, result) {
							// data.errorThrown
							// data.textStatus;
							// data.jqXHR;
							alert(result);
							alert('서버와 통신 중 문제가 발생했습니다');
							foo = data;
						}
					});
				});
				 
				//투표 관련 
				var exampleSize = 1;

				$(document).ready(function() {

					$("#voteEndDate").datepicker({
						dateFormat : 'yy-mm-dd',
						changeMonth : true,
						changeYear : true,
						yearRange : "1980:2030"
					});

				});
				
				/*폼데이터로 넘길라고 했는데 examplesize에 따라서 매핑되는 것들이 달라져서 바로 함수 파라미터에서 받을수가없음
				$("#btnSubmit").click(function() {
					// var form = $('form')[0];
					//var formData = new FormData(form);
					var params = $("#createVote").serialize() + exampleSize;
					$.ajax({
						url : 'createVote',
						processData : false,
						contentType : false,
						data : params,
						type : 'POST',
						success : function(result) {

							document.writeForm.vIdx.value = result;
						}
					});
				});
				*/
				
				
				function fn_save() {
					if (confirm("등록하시겠습니까?")) {
				

						alert("투표가 생성되었습니다.");
						document.createVote.exampleSize.value=exampleSize;
						$("#createVote").submit();
					}
				}
				function fn_examplePlus(self) {
					if (exampleSize == 5) {
						alert("선택지는 최대5개까지만 작성할 수 있습니다.");
						return;
					}
					exampleSize += 1;
					var exampleHtml = "<div class='form-group' style='margin-left: 95px;''>"
							+ "<input  type='text' name='exampleContent" + exampleSize + "'' "+ "required='required'>"
							+ "<a class='btn icon-btn btn-danger' onclick='javascript:fn_exampleMinus($(this))'><span class='glyphicon btn-glyphicon glyphicon-trash img-circle text-danger'></span>Delete</a>"
							+ "</div>";

					self.parent().parent().append(exampleHtml);
				}

				function fn_exampleMinus(self) {
					self.parent().remove();

					exampleSize -= 1;

				}
			</script>

		</body>
	</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</html>