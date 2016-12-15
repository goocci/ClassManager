function viewConsultContents(idx){
	
	// 윈도우 창을 열어서 버튼을 눌렀을때 id값을 db에 점검하러 보내야한다.
		// id값과 db에 점검하는 파일 등에 대한 내용을 하나의 문자열로 만들어 놓자
		var url = "consultcon?idx=" + idx;

		// 윈도우창 불러오기(이동할 주소, "", "윈도우 창에 대한 설정값");

		// #11] Id 상태를 점검하기 위해서 IdCheckServlet.doGet으로 이동한다.
		window.open(url, "_blank_1",
			"toolbar=no, menubar=no, scrollbars=yes, resizable=no,top=300,left=300,"
			+ "width=500, height=340");
	
}