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
<title>ClassManager-cal</title>
</head>
<body>
	<c:if test="${isStudent eq true }">
		<jsp:include page="header2.jsp"></jsp:include>
	</c:if>
	<c:if test="${isStudent eq false }">
		<jsp:include page="header.jsp"></jsp:include>
	</c:if>
	<div id="body">

		<!-- Modal -->
		<div id="myModal" class="modal fade" role="dialog">
			<div class="modal-dialog">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">일정입력</h4>
					</div>
					<div class="modal-body">
						<label for="time1">시간 : </label> <input type="text" id="time1"
							style="width: 60px; text-align: center">~<input
							type="text" id="time2" style="width: 60px; text-align: center">
						<select name="AmPm" style="width: 60px;">
							<option>AM</option>
							<option>PM</option>
						</select><br><label for="content_">내 용 : </label> <input type="text" id="content_"
							style="width: 200px;">
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>

			</div>
		</div>
		<div id="dncalendar-container"></div>
		<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
		<script type="text/javascript"
			src="<%=cp%>/resources/assets/bootstrap/js/bootstrap.js"></script>
		<script src="<%=cp%>/resources/script/dncalendar.min.js"></script>
		<script type="text/javascript">
			var my_calendar = $("#dncalendar-container").dnCalendar({
				dataTitles : {
					defaultDate : 'default',
					today : 'Today'
				},
				notes : [ {
					"date" : "2016-12-25",
					"note" : [ "Merry Christmas 2016" , ", 선생님 생일" ],
				}, {
					"date" : "2016-12-31",
					"note" : [ "Happy New Year 2017" ]
				} ],
				showNotes : true,
				dayClick : function(date, view) {
					$('#myModal').modal({
						closeExisting : false
					});
				
				}
			});

			my_calendar.build();
		</script>
	</div>
</body>
</html>
