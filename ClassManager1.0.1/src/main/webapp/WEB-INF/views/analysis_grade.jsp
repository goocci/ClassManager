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

<style>

.search-container{
  width: 490px;
  display: block;
  margin: 0 auto;
}

input#search-bar{
  margin: 0 auto;
  width: 100%;
  height: 45px;
  padding: 0 20px;
  font-size: 1rem;
  border: 1px solid #D0CFCE;
  outline: none;
  &:focus{
    border: 1px solid #008ABF;
    transition: 0.35s ease;
    color: #008ABF;
    &::-webkit-input-placeholder{
      transition: opacity 0.45s ease; 
  	  opacity: 0;
     }
    &::-moz-placeholder {
      transition: opacity 0.45s ease; 
  	  opacity: 0;
     }
    &:-ms-placeholder {
     transition: opacity 0.45s ease; 
  	 opacity: 0;
     }    
   }
 }

.search-icon{
  position: relative;
  float: right;
  width: 75px;
  height: 75px;
  top: -62px;
  right: -15px;
}

</style>

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
			
  <form class="search-container" action="search_univ_name">
    <input type="text" id="search-bar" name="univName" placeholder="대학명을 입력하세요" />
    <input id="search" type="button" class="btn btn-default btn" value="검색"/>
  </form>
  
  
  <form>
  <select name="univMajor" id="univMajor" >
  	<c:forEach items="${univNamelist}" var="dto">
		<option>${dto.major}</option>
	</c:forEach>
  </select>
  </form>
                  				<%-- <div class="table-responsive">
                     				<table class="table" id="grade1_table" style="width: 70%">
                        				<thead>
				                           <tr>
				                              <th>학교</th>
				                              <th>학과</th>
				                              <th>계열</th>
				                              <th>모집군</th>
				                              <th>활용 지표</th>
				                              <th>표준점수</th>
				                              <th>백분위</th>
				                              <th>등급</th>
				                              <th>반영 영역</th>
				                           </tr>
				                        </thead>
				                        <tbody>
                           
						                     <c:forEach items="${univscorelist}" var="dto">
						                     <tr>
						                        <td>${dto.name}</td>
						                        <td>${dto.major}</td>
						                        <td>${dto.kyeyoel}</td>
						                        <td>${dto.mojibgun}</td>
						                        <td>${dto.index}</td>
						                        <td>${dto.standard}</td>
						                        <td>${dto.percent}</td>
						                        <td>${dto.rate}</td>
						                        <td>${dto.banyoungSubject}</td>       
											 <tr>
						                     </c:forEach>
                    
                        			    </tbody>
                     			    </table>
                  			   </div> --%>
			
				
		</div>
	</div>
	
	<script type="text/javascript" src="<%=cp%>/resources/script/grade_chart.js"></script>
	<script type="text/javascript" src="<%=cp%>/resources/script/alert_event.js"></script>
	
</body>
<div id="foot">
	<jsp:include page="footer.jsp"></jsp:include>
</div>
</html>