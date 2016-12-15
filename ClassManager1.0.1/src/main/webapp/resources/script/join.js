function teacherCheck() {
	if (document.frm.teacherno.value.length == 0) {
		alert("교번을 입력하세요");
		frm.teacherno.focus();
	}
	
	if(document.frm.teacherno.value=='1234'){
		alert("유효한번호입니다");
		document.frm.retNum.value = document.frm.teacherno.value;
	}
	else{
		alert("승인되지 않은 번호입니다.")
	}
	
	
}


//#10] join.jsp 중복체크) - 쿼리로 id등을 url 전송!
function idCheck() {
	if (document.frm.inputId.value.length == 0) {
		alert('아이디를 입력해 주세요');
		frm.inputId.focus();
		return;
	}
	// 윈도우 창을 열어서 버튼을 눌렀을때 id값을 db에 점검하러 보내야한다.
	// id값과 db에 점검하는 파일 등에 대한 내용을 하나의 문자열로 만들어 놓자
	var url = "idCheck?inputId=" + document.frm.inputId.value;

	// 윈도우창 불러오기(이동할 주소, "", "윈도우 창에 대한 설정값");

	// #11] Id 상태를 점검하기 위해서 IdCheckServlet.doGet으로 이동한다.
	window.open(url, "_blank_1",
		"toolbar=no, menubar=no, scrollbars=yes, resizable=no,"
		+ "width=450, height=200");
}

// #14번] idCheck.jsp 에서 사용 버튼 누를 때 이 스크립트로 이동한다.
// 자바스크립트에서 매개변수 만들때... String a; int b 자바스크립트에서는
// 매개변수 만들때 변수이름만 쓰면 된다 (타입을 쓰지 않는다)
function idOk(userid) {
	// 이 문서 대입 받아온 value(매개변수)값을 가져와서..
	opener.frm.inputId.value = document.frm.inputId.value;
	// 지금 현재 열려있는 창에 id 표시 해라!

	// document 객체는 frm의 reid를 찾아서 값을 가져 온 후...
	// (중복체크) 검증하는 창
	opener.frm.reid.value = document.frm.inputId.value;
	// window.open 으로 열려 있는 창에 값을 대입해준다.

	// 값 대입이 끝난 후,,
	// 열려 있는 창을 닫아라!!
	self.close(); // 창을 닫게 되면(idCheck.jsp에서) 브라우저에서 진행 중인,
	// 회원 입력 양식을 계속 진행하게 된다.
	// 자연스럽게 join.jsp 로 다시 이동하게 된다.
	// #15] 여러 항목을 입력하다가..
	// join.jsp의 submit에게 joinCheck() 를
	// 걸어 두자! 그래서 아래 함수로 오게된다.

}

// 그후 idCheck.jsp 에서 다시 스크립트 파일로 이동한다.
// #15] 아이디~필수 데이터 유효성 검토를 해야한다.
function joinCheck() {
	if (document.frm.inputId.value.length == 0) {
		alert('아이디를 입력해 주세요');
		frm.inputId.focus();
		return false;
	}
	// 아이디는 4글자 이상이어야 한다.
	if (document.frm.inputId.value.length < 4) {
		alert('아이디는 4글자 이상 써 주세요');
		// document.frm.userid.value="";
		frm.inputId.focus();
		return false;
	}
	// 암호는 반드시 입력해야한다.
	if (document.frm.pwd.value == "") {
		alert('암호는 반드시 입력해야 합니다');
		// document.frm.userid.value="";
		frm.pwd.focus();
		return false;
	}
	// 암호 중복 체크
	if (document.frm.pwd.value != document.frm.pwd_check.value) {
		alert('암호가 일치하지 않습니다');
		frm.pwd_check.focus();
		return false;
	}
	// 이름
	if (document.frm.inputName.value.length == 0) {
		alert('이름을 써 주세요');
		frm.inputName.focus();
		return false;
	}
	if (document.frm.phone.value.length == 0) {
		alert('전화번호를 입력해 주세요');
		frm.phone.focus();
		return false;
	}
	if (document.frm.addr.value.length == 0) {
		alert('주소를 입력해 주세요');
		frm.addr.focus();
		return false;
	}

	if (document.frm.email.value.length == 0) {
		alert('이메일 주소를 입력해 주세요');
		frm.email.focus();
		return false;
	}

	var email = document.frm.email.value;
	var regex = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;

	if (regex.test(email) === false) {
		alert("잘못된 이메일 형식입니다.");
		return false;
	}

	if (document.frm.teacherno.value.length == 0) {
		alert('선생님 교번을 입력하세요');
		frm.teacherno.focus();
		return false;
	}

	if (document.frm.studentno.value.length == 0) {
		alert('학생 번호를 입력하세요');
		frm.email.focus();
		return false;
	}

	// 중복 체크 여부 - reid 의 value
	// 그 아이디가 db에 겹치는지 체크한다.
	// idOk() 함수에서 사용하겠다라고 하면 reid에 값을 넣어놨기 때문에...
	if (document.frm.reid.value.length == 0) {
	alert("아이디 중복체크 해주세요");
		return false;
	}

	if (document.frm.retNum.value.length == 0) {
		alert("교번 체크를 해주세요");
		return false;
	}
	// 위에 있는 모든 상황이 아닐때는 submit 이 진행된다.
	return true;
}

function div_OnOff(v, id1, id2) {
	// 라디오 버튼 value 값 조건 비교

	if (v == "1") {
		document.getElementById(id2).style.display = "none";
		document.getElementById(id1).style.display = ""; // 보여줌
		document.frm.studentno.value = "0";
		document.frm.teacherno.value = "";
		document.frm.retNum.value ="";
	}
	if (v == "2") {
		document.getElementById(id2).style.display = "none";
		document.getElementById(id1).style.display = ""; // 보여줌
		document.frm.teacherno.value = "0";
		document.frm.studentno.value = "";
		document.frm.retNum.value ="true";
	}
}