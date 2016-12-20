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
<link
	href="<%=cp%>/resources/assets/bootstrap/css/dncalendar-skin.min.css"
	rel="stylesheet">
<title>ClassManager</title>

<style>
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



		<div id="dncalendar-container">

		</div>






	
		<script src="//code.jquery.com/jquery-1.12.2.min.js"></script>
		<script src="<%=cp%>/resources/script/dncalendar.min.js"></script>
		<script type="text/javascript"
			src="<%=cp%>/resources/assets/bootstrap/js/bootstrap.js"></script>
		<script src="<%=cp%>/resources/script/bootstrap-imageupload.js"></script>
		
		<script type="text/javascript">
		var my_calendar = $("#dncalendar-container").dnCalendar({
		    dataTitles: { defaultDate: 'default', today : 'Today' },
		    notes: [
		      { "<a href=http:www.jqueryscript.net/time-clock/">date</a>": "2015-12-25", "note": ["Merry Christmas 2015"] },
		      { "date": "2015-12-31", "note": ["Happy New Year 2016"] }
		      ],
		    showNotes: true,
		});
		
		
		
		
		my_calendar.build();

		
		</script>
		
		
		
		
		
	</div>
</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>