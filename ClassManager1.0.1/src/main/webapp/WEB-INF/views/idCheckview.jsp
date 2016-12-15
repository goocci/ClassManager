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

<title>ClassManager</title>
</head>
<body>


	<h4>아이디 중복 확인</h4>
	<form action="idCheck" method="get" name="frm">
		아이디 <input type="text" name="inputId" value="${inputId }"> <input
			type="submit" value="중복체크"><br>
		<c:if test="${member.id !=null }">
			<script type="text/javascript">
         <%--window.open이 창을 열어 놓은 상태(메모리에) --%>
         <%--그 창에 접근 해서 value값을 빈칸으로 만든다. --%>
         opener.document.frm.inputId.value="";
      </script>
      ${member.id }는 이미 사용 중인 아이디 입니다.
   </c:if>
		<c:if test="${member.id==null }">
      입력하신 아이디는 사용 가능한 id입니다.                  
      <input type="button" value="사용" class="cancel"
				onclick="idOk('${member.id}')">
			<%--14번] 창닫으러 가자!--%>
		</c:if>

	</form>
	<script type="text/javascript" src="<%=cp%>/resources/script/join.js"></script>
</body>
</html>