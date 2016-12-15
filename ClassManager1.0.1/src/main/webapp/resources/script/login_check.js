function loginCheck(){
   //이 문서에서      특정 태그에 있는     특정 태그의 값을 가져와라
   //가져온 값의 길이가 0이면  대화상자 열어서  값입력 요구 하자 그리고  userid 태그로
   //커서를 보내자!
     if(document.frm.userid.value.length == 0){
       alert("아이디를 넣어주세요");
       frm.userid.focus();
       return false;  //submit 하지 말 것!
     }
     //비번의 값이 null 이면  암호입력할 것
     if(document.frm.pwd.value == ""){  //빈 문자열
        alert("비밀번호는 반드시 넣어야 합니다.");
        frm.pwd.focus();
        return false;  //submit 하지 말 것!
     }
     //#5] login.jsp로 이동 -> 서블릿의 post로 간다.
     return true; //그렇다면 submit 해라!
}