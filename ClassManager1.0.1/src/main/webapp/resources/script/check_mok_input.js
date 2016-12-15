
function checkmokinput() {
	if (isNaN(document.mok_input.standard.value) == true || isNaN(document.mok_input.percent.value) == true) {
		alert("숫자만 입력해주세요.");
		document.mok_input.standard.value = document.mok_input.standard.value;
		document.mok_input.percent.value = document.mok_input.percent.value;
		
		return false;
	}
}