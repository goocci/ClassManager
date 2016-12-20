
function checkmokinput() {
	if (isNaN(document.mok_input.standard.value) == true || isNaN(document.mok_input.percent.value) == true) {
		alert("숫자만 입력해주세요.");
		document.mok_input.standard.value = document.mok_input.standard.value;
		document.mok_input.percent.value = document.mok_input.percent.value;
		
		return false;
	}
}

function delete_event(){
	if (confirm("정말 삭제하시겠습니까?") == true){    //확인
	    return true;
	}else{   //취소
	    return false;
	}
}