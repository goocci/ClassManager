<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
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
         <div class="container">
            <div class="row">
               <div
                  class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad">
                  <div class="panel panel-info">
                     <div class="panel-heading">
                        <h3 class="panel-title">성적입력</h3>
                     </div>
                     <div class="panel-body" align="left">
                        <div class="form-group">
                           <div class="col-lg-10">
                              <div class="radio" align="center">
                                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                 <label> <input type="radio" name="test" value="1"
                                    onclick="div_OnOff(this.value,'con1', 'con2');" checked="checked"> 내 신
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    <input type="radio" name="test" value="2"
                                    onclick="div_OnOff(this.value,'con2', 'con1');"
                                    > 모의고사 
                              </div>
                           </div>
                        </div>
                        <br> <br>
                        <div id="con1" style="display:">
                           <form action="schooltest_input" method="post">
                              <div class="list-group">
                                 <span class="list-group-item">학년 : 
                                 <select class="selectpicker" name="grade">
                                       <option value="1학년">1학년</option>
                                       <option value="2학년">2학년</option>
                                       <option value="3학년">3학년</option>
                                 </select> 
                                 &nbsp;&nbsp; 
                                 <select class="selectpicker" name="semester">
                                       <option value="1학기" >1학기</option>
                                       <option value="2학기" >2학기</option>
                                 </select> <br> <br> 과목 :&nbsp;
                                 <input type="text" id="subject" name="subject" required="required">
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 내신 : 
                                 <select class="selectpicker" name="schoolrate">
                                       <option>1</option>
                                       <option>2</option>
                                       <option>3</option>
                                       <option>4</option>
                                       <option>5</option>
                                       <option>6</option>
                                       <option>7</option>
                                       <option>8</option>
                                       <option>9</option>
                                 </select>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<input
                                    type="submit" class="btn btn-primary btn" value="저장" />
                                 </span>
                              </div>
                           </form>
                        </div>

                        <div id="con2" style="display: none">
                           <form action="moktest_input" method="get" name="mok_input">
                              <div class="list-group">
                                 <span class="list-group-item">학년 : <select
                                    class="selectpicker" name="grade">
                                       <option value="1학년">1학년</option>
                                       <option value="2학년">2학년</option>
                                       <option value="3학년">3학년</option>
                                 </select> &nbsp; <select class="selectpicker" name="month">
                                       <option value="3월">3월</option>
                                       <option value="6월">6월</option>
                                       <option value="9월">9월</option>
                                 </select> <br> 영역 :&nbsp;<select class="selectpicker" name="subject">
                                       <option value="언어">언어</option>
                                       <option value="수리">수리</option>
                                       <option value="외국어">외국어</option>
                                       <option value="물리1">물리1</option>
                                       <option value="물리2">물리2</option>
                                       <option value="화학1">화학1</option>
                                       <option value="화학2">화학2</option>
                                       <option value="생물1">생물1</option>
                                       <option value="생물2">생물2</option>
                                       <option value="지구과학1">지구과학1</option>
                                       <option value="지구과학2">지구과학2</option>
                                       <option value="한국사">한국사</option>
                                       <option value="경제">경제</option>
                                       <option value="동아시아사">동아시아사</option>
                                       <option value="법과정치">법과정치</option>
                                       <option value="사회문화">사회문화</option>
                                       <option value="생활과윤리">생활과윤리</option>
                                       <option value="세계사">세계사</option>
                                       <option value="세계지리">세계지리</option>
                                       <option value="윤리와사상">윤리와사상</option>
                                       <option value="한국지리">한국지리</option>
                                 </select>
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;등급 : <select
                                    class="selectpicker" name="rate">
                                       <option>1</option>
                                       <option>2</option>
                                       <option>3</option>
                                       <option>4</option>
                                       <option>5</option>
                                       <option>6</option>
                                       <option>7</option>
                                       <option>8</option>
                                       <option>9</option>
                                 </select><br> 표준점수 :<input type="text" id="standard"
                                    name="standard" required="required">백분위 :<input
                                    type="text" id="percent" name="percent"
                                    required="required"> &nbsp; <input type="submit"
                                    class="btn btn-primary btn" value="저장" onclick="return checkmokinput();" />
                                 </span>
                              </div>
                           </form>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
            <!--영수 수정 모달 페이지 달력 11.14   -->

            <script
               src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
            <script type="text/javascript"
               src="<%=cp%>/resources/assets/bootstrap/js/bootstrap.min.js"></script>
            <script type="text/javascript"
               src="<%=cp%>/resources/assets/bootstrap/js/bootstrap-datepicker.js"></script>
            <script type="text/javascript"
               src="<%=cp%>/resources/assets/bootstrap/js/bootstrap-select.min.js"></script>
            <script type="text/javascript"
               src="<%=cp%>/resources/script/join.js"></script>
            <script type="text/javascript" src="<%=cp%>/resources/script/check_mok_input.js"></script>
         </div>
      </div>
   </div>
</body>
<div id="foot">
   <jsp:include page="footer.jsp"></jsp:include>
</div>
</html>