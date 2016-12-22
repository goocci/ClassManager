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


<script src="https://www.amcharts.com/lib/3/amcharts.js"></script>
<script src="https://www.amcharts.com/lib/3/serial.js"></script>
<script src="https://www.amcharts.com/lib/3/themes/light.js"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/handsontable/0.20.2/handsontable.full.min.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/handsontable/0.20.2/handsontable.full.min.js"></script>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="<%=cp%>/resources/assets/bootstrap/css/bootstrap_join.min.css" rel="stylesheet">

<style>

.container {
    margin: 0 auto 25px;
    max-width: 550px;
    max-height: 150px;
    position: relative;
}

.container2 {
    margin: 0 auto 25px;
    max-width: 1000px;
    position: relative;
}

.container3 {
    margin: 0 auto 25px;
    max-width: 1500px;
    position: relative;
}

.searchform {
    display: -webkit-flex;
    display: -moz-flex;
    display: -ms-flexbox;
    display: flex;
    font-size: 20px;
    height: 60px;
    border-style: groove;
}

.search-field {
    -webkit-flex: 1 auto;
    -moz-flex: 1 auto;
    -ms-flex: 1 auto;
    flex: 1 auto;
    display: -webkit-flex;
    display: -moz-flex;
    display: -ms-flexbox;
    display: flex;
    min-width: 0;
}

.search-field__input {
    -moz-osx-font-smoothing: grayscale;
    -webkit-appearance: none;
    -webkit-font-smoothing: antialiased;
    border-radius: 7px 0 0 7px;
    border-right: 0;
    border: none;
    box-sizing: border-box;
    color: gray;

    -webkit-flex: 1;
    -moz-flex: 1;
    -ms-flex: 1;
    flex: 1;

    min-width: 0;
    outline: none;
    padding: 5px 20px;
    padding: 5px 20px;
}

.search-field__button {
    background-color: #fff;
    border-left: none;
    border-radius: 0 7px 7px 0;
    border: none;
    color: #999;
    cursor: pointer;
    display: inline-block;
    font-size: 14px;
    font-size: 26px;
    overflow: visible;
    padding: 3px 0 2px;

    -moz-flex: 0 0 30px;
    -ms-flex: 0 0 30px;
    -webkit-flex: 0 0 30px;
    flex: 0 0 30px;
    flex-basis: 80px;

    transition: background-color 0.2s;
    -webkit-transition: background-color 0.2s;
}

.search-field__button:hover {
        background-color: #f5f5f5;
        color: #e78733;
    }

    .search-field__button:active,
    .search-field__button:focus {
        outline: none;
    }

    .e-icon__alt {
        border: 0;
        clip: rect(0 0 0 0);
        height: 1px;
        margin: -1px;
        overflow: hidden;
        padding: 0;
        position: absolute;
        width: 1px;
    }
    

#chartdiv {
  width: 100%;
  height: 300px;
  border: 1px solid #ccc;
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

			<div class="container" align="center">
			  <form action="search_univ_name" class="searchform">
			  
				  <div class="search-field">
				    <input autocomplete="off" class="search-field__input" name="univName" placeholder="대학명을 입력하세요" type="search">
				  </div>
				  
				  <button class="search-field__button" type="submit">
				    <i class="fa fa-search" aria-hidden="true"><span class="e-icon__alt">Search</span></i>
				  </button>
			  
			  </form>
			  
			  <form action="search_univ_name">
			  
				  <c:forEach items="${univNamelist}" var="dto" begin="0" end="0">
				  <input type="radio" name="univName" value="${dto.name}" checked="checked" hidden="true"><h5 id="univName">${dto.name}</h5>
				  </c:forEach>
				  
				  <select name="univMajor" id="univMajor" style="width: 89%; height: 40px;">
				  	<c:forEach items="${univNamelist}" var="dto">
						<option>${dto.major}</option>
					</c:forEach>
				  </select>
				  
				  <button class="search-field__button" type="submit" style="width: 10%">
				    <i class="fa fa-search" aria-hidden="true"><span class="e-icon__alt">Search</span></i>
				  </button>
			  
			  </form>
			  
			</div>
			
			<div class="container2" align="center">
			<table class="table" id="grade1_table" style="width: 100%">
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
				          <th width="150px">반영 영역</th>
				        </tr>
				    </thead>
				    <tbody>
                           
						<c:forEach items="${majorScorelist}" var="dto">
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
		     </div>
		     <br/>
		     <br/>
			<div class="container3" style="width: 90%;">
				<div id="chartdiv"></div>
				<div id="data"></div>
			</div>
  
		</div>
	</div>
	
	<script type="text/javascript" src="<%=cp%>/resources/script/analysis_chart.js"></script>
	
</body>
<div id="foot">
	<jsp:include page="footer.jsp"></jsp:include>
</div>
</html>