<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String cp = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
<script type="text/javascript" src="<%=cp%>/resources/script/Chart.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="<%=cp%>/resources/assets/bootstrap/css/bootstrap_join.min.css" rel="stylesheet">

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
			<c:if test="${isStudent eq true }">
			<jsp:include page="left2.jsp" flush="true"></jsp:include>
			</c:if>
			<c:if test="${isStudent eq false }">
			<jsp:include page="left.jsp" flush="true"></jsp:include>
			</c:if>
			<br/>
			<div id="wrapper2" align="center">

				<!-- 내신 -->
				<h2>내신 성적표</h2>
				<br />
				<div class="container">
				
					<div class="col-sm-4">
						<pre class="pre-scrollable" style="white-space: nowrap;">
                  			<h4>1학년</h4>
                  				<div class="table-responsive">
                     				<table class="table" id="grade1_table">
                        				<thead>
				                           <tr>
				                              <th>학기</th>
				                              <th>과목명</th>
				                              <th>등급</th>
				                              <th>삭제</th>
				                           </tr>
				                        </thead>
				                        <tbody>
                           
						                     <c:forEach items="${schooltestlist}" var="dto">
						                     <c:if test="${dto.grade eq '1학년'}">
						                     <tr>
						                        <td>${dto.semester}</td>
						                        <td>${dto.subject}</td>
						                        <td>${dto.schoolrate}</td>
						                        <td><a class="btn btn-default btn-xs" href="deleteSchool?sIdx=${dto.idx}" style="margin-bottom: 5px" onclick="return delete_event();">x</a></td>                                    
											 <tr>
											 </c:if>
						                     </c:forEach>
                    
                        			    </tbody>
                     			    </table>
                  			   </div>
                  		</pre>
					</div>

					<div class="col-sm-4">
						<pre class="pre-scrollable" style="white-space: nowrap;">
                  			<h4>2학년</h4>
                  				<div class="table-responsive">
                     				<table class="table">
				                        <thead>
				                           <tr>
				                              <th>학기</th>
				                              <th>과목명</th>
				                              <th>등급</th>
				                              <th>삭제</th>
				                           </tr>
				                        </thead>
				                        <tbody>
                           
                            				<c:forEach items="${schooltestlist}" var="dto">
					                     	<c:if test="${dto.grade eq '2학년'}">
					                     	<tr>
					                        <td>${dto.semester}</td>
					                        <td>${dto.subject}</td>
					                        <td>${dto.schoolrate}</td>
					                        <td><a class="btn btn-default btn-xs" href="deleteSchool?sIdx=${dto.idx}" style="margin-bottom: 5px" onclick="return delete_event();">x</a></td>
										 	<tr>
										 	</c:if>
					                     	</c:forEach>
                           
                        				</tbody>
                     				</table>
                  				</div>
                  		</pre>
					</div>

					<div class="col-sm-4">
						<pre class="pre-scrollable" style="white-space: nowrap;">
                  			<h4>3학년</h4>
                  				<div class="table-responsive">
                     				<table class="table">
				                        <thead>
				                           <tr>
				                              <th>학기</th>
				                              <th>과목명</th>
				                              <th>등급</th>
				                              <th>삭제</th>
				                           </tr>
				                        </thead>
				                        <tbody>
                           
                            				<c:forEach items="${schooltestlist}" var="dto">
					                     	<c:if test="${dto.grade eq '3학년'}">
					                     	<tr>
					                        <td>${dto.semester}</td>
					                        <td>${dto.subject}</td>
					                        <td>${dto.schoolrate}</td>
					                        <td><a class="btn btn-default btn-xs" href="deleteSchool?sIdx=${dto.idx}" style="margin-bottom: 5px" onclick="return delete_event();">x</a></td>
										 	<tr>
										 	</c:if>
					                     	</c:forEach>
                           
                        				</tbody>
                     				</table>
                  				</div>
                  		</pre>
					</div>
					
				</div>
				<div style="width: 95%;">
					<canvas id="school_grade" width="1000" height="300" class="well"></canvas>
				</div>
				<!-- 선긋기 -->
				<hr style="color: red; background-color: black; height: 1px; border: none" width=95% />

				<!-- 모의고사 -->
				<h2>모의고사 성적표</h2>
				<br />
				<div class="container">

					<div id="wrapper2">
						<br>
						<table style="width: 1000px; text-align: center; margin-left: 50px;">
							<tr>
								<td>
								<pre class="pre-scrollable" style="white-space: nowrap; width: 450px; height: 340px;">
                  					<h4>언어</h4>
                  						<div class="table-responsive">
                    						 <table class="table" style="text-align: left;">
						                        <thead>
						                           <tr>
						                              <th>구분</th>
						                              <th>표준점수</th>
						                              <th>백분위</th>
						                              <th>등급</th>
						                              <th>삭제</th>
						                           </tr>
						                        </thead>
						                        <tbody>
                           
								                     <c:forEach items="${moktestlist}" var="dto">
								                     <c:if test="${dto.subject eq '언어'}">
								                     <tr>
								                        <td>${dto.grade}&nbsp;${dto.month}</td>
								                        <td>${dto.standard}</td>
								                        <td>${dto.percent}</td>
								                        <td>${dto.rate}</td>
								                        <td><a class="btn btn-default btn-xs" href="deleteMok?mIdx=${dto.idx}&sIdx=" style="margin-bottom: 5px" onclick="return delete_event();">x</a></td>
													 <tr>
													 </c:if>
								                     </c:forEach>
                           
                        						</tbody>
                     						</table>
                  						</div>
                  				</pre>
                  				</td>

								<td>
								<div style="width: 90%;">
									<canvas id="language_stdd" height="260" width="350" class="well"></canvas>
								</div>
								</td>
							</tr>
							
							<tr>
								<td>
								<div style="width: 90%;">
									<canvas id="language_pct" width="350" height="260" class="well"></canvas>
								</div>
								</td>
								<td>
								<div style="width: 90%;">
									<canvas id="language_rate" width="350" height="260" class="well"></canvas>
								</div>
								</td>
							</tr>

						</table>
					</div>



					<div id="wrapper2">
						<br>
						<table style="width: 1000px; text-align: center; margin-left: 50px;">
							<tr>
								<td>
								<pre class="pre-scrollable" style="white-space: nowrap; width: 450px; height: 340px;">
                  					<h4>수리</h4>
                  						<div class="table-responsive">
                    						 <table class="table" style="text-align: left;">
						                        <thead>
						                           <tr>
						                              <th>구분</th>
						                              <th>표준점수</th>
						                              <th>백분위</th>
						                              <th>등급</th>
						                              <th>삭제</th>
						                           </tr>
						                        </thead>
						                        <tbody>
                           
								                     <c:forEach items="${moktestlist}" var="dto">
								                     <c:if test="${dto.subject eq '수리'}">
								                     <tr>
								                        <td>${dto.grade}&nbsp;${dto.month}</td>
								                        <td>${dto.standard}</td>
								                        <td>${dto.percent}</td>
								                        <td>${dto.rate}</td>
								                        <td><a class="btn btn-default btn-xs" href="deleteMok?mIdx=${dto.idx}&sIdx=" style="margin-bottom: 5px" onclick="return delete_event();">x</a></td>
													 <tr>
													 </c:if>
								                     </c:forEach>
                           
                        						</tbody>
                     						</table>
                  						</div>
                  				</pre>
                  				</td>

								<td>
								<div style="width: 90%;">
									<canvas id="math_stdd" height="260" width="350" class="well"></canvas>
								</div>
								</td>
							</tr>
							
							<tr>
								<td>
								<div style="width: 90%;">
									<canvas id="math_pct" width="350" height="260" class="well"></canvas>
								</div>
								</td>
								<td>
								<div style="width: 90%;">
									<canvas id="math_rate" width="350" height="260" class="well"></canvas>
								</div>
								</td>
							</tr>

						</table>
					</div>





					<div id="wrapper2">
						<br>
						<table style="width: 1000px; text-align: center; margin-left: 50px;">
							<tr>
								<td>
								<pre class="pre-scrollable" style="white-space: nowrap; width: 450px; height: 340px;">
                  					<h4>외국어</h4>
                  						<div class="table-responsive">
                    						 <table class="table" style="text-align: left;">
						                        <thead>
						                           <tr>
						                              <th>구분</th>
						                              <th>표준점수</th>
						                              <th>백분위</th>
						                              <th>등급</th>
						                              <th>삭제</th>
						                           </tr>
						                        </thead>
						                        <tbody>
                           
								                     <c:forEach items="${moktestlist}" var="dto">
								                     <c:if test="${dto.subject eq '외국어'}">
								                     <tr>
								                        <td>${dto.grade}&nbsp;${dto.month}</td>
								                        <td>${dto.standard}</td>
								                        <td>${dto.percent}</td>
								                        <td>${dto.rate}</td>
								                        <td><a class="btn btn-default btn-xs" href="deleteMok?mIdx=${dto.idx}&sIdx=" style="margin-bottom: 5px" onclick="return delete_event();">x</a></td>
													 <tr>
													 </c:if>
								                     </c:forEach>
                           
                        						</tbody>
                     						</table>
                  						</div>
                  				</pre>
                  				</td>

								<td>
								<div style="width: 90%;">
									<canvas id="english_stdd" height="260" width="350" class="well"></canvas>
								</div>
								</td>
							</tr>
							
							<tr>
								<td>
								<div style="width: 90%;">
									<canvas id="english_pct" width="350" height="260" class="well"></canvas>
								</div>
								</td>
								<td>
								<div style="width: 90%;">
									<canvas id="english_rate" width="350" height="260" class="well"></canvas>
								</div>
								</td>
							</tr>

						</table>
					</div>


					<div id="wrapper2">
						<br>
						<table style="width: 1000px; text-align: center; margin-left: 50px;">
							<tr>
								<td>
								<pre class="pre-scrollable" style="white-space: nowrap; width: 450px; height: 340px;">
                      				<h4>과학탐구</h4>
                  						<div class="table-responsive">
						                     <table class="table">
						                        <thead>
						                           <tr>
						                              <th width="140">구분</th>
						                              <th>표준점수</th>
						                              <th>백분위</th>
						                              <th>등급</th>
						                              <th>삭제</th>
						                           </tr>
						                        </thead>
						                        <tbody>
                           
								                     <c:forEach items="${moktestlist}" var="dto">
								                     <c:if test="${dto.subject eq '물리1' 
											                     || dto.subject eq '물리2' 
											                     || dto.subject eq '화학1' 
											                     || dto.subject eq '화학2' 
											                     || dto.subject eq '생물1' 
											                     || dto.subject eq '생물2' 
											                     || dto.subject eq '지구과학1' 
											                     || dto.subject eq '지구과학2'}">
								                     <tr>
								                        <td>${dto.grademonthsubject}</td>
								                        <td>${dto.standard}</td>
								                        <td>${dto.percent}</td>
								                        <td>${dto.rate}</td>
								                        <td><a class="btn btn-default btn-xs" href="deleteMok?mIdx=${dto.idx}&sIdx=" style="margin-bottom: 5px" onclick="return delete_event();">x</a></td>
													 <tr>
								  					 </c:if>   
								                     </c:forEach>
								                           
								                </tbody>
                     						</table>
                  						</div>
                  				</pre>
                  				</td>
								
								<td>
								<div style="width: 90%;">
									<canvas id="science_stdd" height="260" width="350" class="well"></canvas>
								</div>
								</td>
							</tr>
							
							<tr>
								<td>
								<div style="width: 90%;">
									<canvas id="science_pct" width="350" height="260" class="well"></canvas>
								</div>
								</td>
								<td>
								<div style="width: 90%;">
									<canvas id="science_rate" width="350" height="260" class="well"></canvas>
								</div>
								</td>
							</tr>

						</table>
					</div>


					<div id="wrapper2">
						<br>
						<table style="width: 1000px; text-align: center; margin-left: 50px;">
							<tr>
								<td>
								<pre class="pre-scrollable" style="white-space: nowrap; width: 450px; height: 340px;">
                      				<h4>사회탐구</h4>
                  						<div class="table-responsive">
						                     <table class="table">
						                        <thead>
						                           <tr>
						                              <th width="140">구분</th>
						                              <th>표준점수</th>
						                              <th>백분위</th>
						                              <th>등급</th>
						                              <th>삭제</th>
						                           </tr>
						                        </thead>
						                        <tbody>
                           
								                     <c:forEach items="${moktestlist}" var="dto">
								                     <c:if test="${dto.subject eq '한국사' 
									                              || dto.subject eq '경제' 
									                              || dto.subject eq '동아시아사' 
									                              || dto.subject eq '법과정치' 
									                              || dto.subject eq '사회문화' 
									                              || dto.subject eq '생활과윤리' 
									                              || dto.subject eq '세계사' 
									                              || dto.subject eq '세계지리' 
									                              || dto.subject eq '윤리와사상' 
									                              || dto.subject eq '한국지리'}">
								                     <tr>
								                        <td>${dto.grademonthsubject}</td>
								                        <td>${dto.standard}</td>
								                        <td>${dto.percent}</td>
								                        <td>${dto.rate}</td>
								                        <td><a class="btn btn-default btn-xs" href="deleteMok?mIdx=${dto.idx}&sIdx=" style="margin-bottom: 5px" onclick="return delete_event();">x</a></td>
													 <tr>
								  					 </c:if>   
								                     </c:forEach>
								                           
								                </tbody>
                     						</table>
                  						</div>
                  				</pre>
                  				</td>
								
								<td>
								<div style="width: 90%;">
									<canvas id="society_stdd" height="260" width="350" class="well"></canvas>
								</div>
								</td>
							</tr>
							
							<tr>
								<td>
								<div style="width: 90%;">
									<canvas id="society_pct" width="350" height="260" class="well"></canvas>
								</div>
								</td>
								<td>
								<div style="width: 90%;">
									<canvas id="society_rate" width="350" height="260" class="well"></canvas>
								</div>
								</td>
							</tr>

						</table>
					</div>
					<br/>

				</div>
			</div>
		</div>
	</div>
	<br/>
	<script type="text/javascript" src="<%=cp%>/resources/script/grade_chart.js"></script>
	<script type="text/javascript" src="<%=cp%>/resources/script/alert_event.js"></script>
	
</body>
<div id="foot">
	<jsp:include page="footer.jsp"></jsp:include>
</div>
</html>