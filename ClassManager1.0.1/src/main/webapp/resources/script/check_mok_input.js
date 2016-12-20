
function checkmokinput() {
	if (isNaN(document.mok_input.standard.value) == true || isNaN(document.mok_input.percent.value) == true) {
		alert("숫자만 입력해주세요.");
		document.mok_input.standard.value = document.mok_input.standard.value;
		document.mok_input.percent.value = document.mok_input.percent.value;
		
		return false;
	}
	if(document.mok_input.standard.value==""){
		alert('표준점수를 입력하세요 ')
		return false;
	}
	if(document.mok_input.percent.value==""){
		alert('백분위를 입력하세요 ')
		return false;
	}
	
	
}
function checkschoolinput() {
	if(document.school_input.subject.value==""){
		alert('과목을 입력하세요!')
		return false;
	}
}