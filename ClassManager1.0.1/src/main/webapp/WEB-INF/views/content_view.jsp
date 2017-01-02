<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	String cp = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="<%=cp%>/resources/assets/bootstrap/css/bootstrap_join.min.css" rel="stylesheet">

<style type="text/css">

.chart div {
  font: 10px sans-serif;
  background-color: #6ab7f2;
  text-align: right;
  padding: 3px;
  margin: 1px;
  color: white;
}

</style>

<title>Insert title here</title>
</head>
<body>
<c:if test="${isStudent eq true }">
<jsp:include page="header2.jsp"></jsp:include>
</c:if>
<c:if test="${isStudent eq false }">
<jsp:include page="header.jsp"></jsp:include>
</c:if>
	<div id="body">
		<div id="content">
		<br/>
		<br/>

			<!-- 1114_ form으로 묶어주고 action으로 페이지 넘겨줌 -->
						<div class="col-md-10 col-sm-offset-0 col-md-offset-1 " align="center" style="margin-bottom: 10px; margin-left:28%; ">
							<c:if test="${dto.id eq useridd}">
							<a class="btn btn-primary" href="modify_view?bIdx=${dto.idx}" style="margin-left: 10px"> 글 수정 </a> 
							<a class="btn btn-primary" href="deleteBoard?bIdx=${dto.idx}"> 글 삭제 </a>
							</c:if>
							<a class="btn btn-primary" href="board_list"> 글 목록으로 가기 </a>
						</div>
			<div class="container">
				<div class=" col-md-10 col-sm-offset-0 col-md-offset-1">
					<div style="border-width: 2px; border-style: solid;" align="center" >
					
						<h4 align="left" style="margin-top:20px; margin-bottom: -12px; margin-left:20px; margin-right:20px " >[${dto.category}] ${dto.title} </h4>						
						<h6 align="right" style="margin-top:20px; margin-bottom: -12px; margin-left:20px; margin-right:20px " >${dto.writer} ${dto.created_at} </h6>	
							<hr style= "border:1px dashed gray;">
							
							
						<!-- 첨부 파일이 있다면 -->
						<c:if test="${dto.boardPhoto != null}">	
						<div align="right" style="margin-right:20px">
						<h5 style="font-weight:bold; margin-bottom: -2px">[첨부파일]</h5>
						<a href="filedown?fileName=${dto.boardPhoto}">${dto.boardPhoto}</a>
						</div>
						</c:if>
						<!-- 투표를 등록했다면 -->
						<c:if test="${choice_list != null}">	
						<div class="panel panel-info"  >
								<div class="panel-heading">
									<h3 class="panel-title" style="font-weight: bold;">  주제 : ${vdto.topic} </h3>
								</div>
								<div class="panel-body">
									<ul class="list-group">
										<c:forEach items="${choice_list}" var="list" varStatus="status">
										<li class="list-group-item">
											<div class="radio">
												<label> <input name="rdoBtn" type="radio" name="optionsRadios" value=${status.index}> ${list.choice} </label>
												<label >투표수 : ${list.score} </label>
												<br/>
												<br/>
												<div class="chart" align="left" style="margin-left: 30%">
  													<div style="width: ${list.score}vw;">${list.score}</div>
  												</div>
											</div>
										</li>
										</c:forEach>
									</ul>
								</div>
								<div class="panel-footer ">
									<button type="button" id="voteBtn" class="btn btn-primary btn-lg">Vote</button>
								</div>
							</div>
						</c:if>
						
						<!-- 글 내용 -->
						<% pageContext.setAttribute("newLineChar", "\n"); %>
						<p align="left" style="margin-top: -5px; margin-left: 20px; margin-right:20px;font-size: 20px">${fn:replace(dto.content, newLineChar, '<br/>')}</p>
							<hr style="border: 1px solid gray;">

						<form action="writeComment?cBoardIdx=${dto.idx}" method="POST">
							<div align="left">
								<textarea
									style="margin-left: 20px; border-width: 2px; border-style: solid; width: 80%"
									rows="1" placeholder="댓글을 입력하세요" name="cContent"></textarea>
								<input id="btn-write" type="submit"
									class="btn btn-default btn-sm"
									style="margin-bottom: 28px; border-width: 1px; border-style: solid; background-color: gray;"
									value="댓글 등록" onclick="return writeCheck();"> 
							</div>
						</form>

						<c:forEach items="${comment_list}" var="comment">
							<p class="text-left">
								<label class="col-sm-2 control-label">${comment.writer}</label>${comment.content}
								<c:if test="${comment.id eq useridd}">
								<a class="btn btn-default btn-xs"
									href="deleteComment?bIdx=${dto.idx}&cBoardIdx=${comment.idx}"
									style="margin-bottom: 5px">x</a>
								</c:if>
							</p>
						</c:forEach>
					</div>
				</div>
			</div>

			<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
			
				<script type="text/javascript">
  				  $(document).ready(function() {
   				 	var vIdx = ${vdto.idx};

      				  $("#voteBtn").click(function(){
       				 	var exampleNo = $(":input[name='rdoBtn']:checked").val();

       				 	if(exampleNo == undefined){
      				  		alert("항목을 선택해주세요.");
      				  		return false;
        						location.href = "vote?vIdx=" + vIdx + "&exampleNo=" + exampleNo + "&bIdx=" + ${dto.idx};
      				  	}
       				 });
  				  });

    			</script>
    			
		</div>
	</div>
</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>