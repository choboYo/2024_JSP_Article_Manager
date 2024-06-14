<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <script>
    	function spaceCheck() {
    		let pw1 =  document.getElementById("pw1").value;
    	if(pw1 == " ") {
    			alert("공백은 사용할 수 없는 비밀번호입니다.");
    			return false;
    		}
    		return true;
    	}
    
    </script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
	<h2>회원 가입</h2>
	
	<form action="doJoin" method="post" onsubmit="return spaceCheck();">
		<div>
			<div>아이디 : <input type="text" name="loginId" placeholder="아이디를 입력해주세요"/></div>
			<div>비밀번호 : <input type="text" name="loginPw" placeholder="비밀번호를 입력해주세요" required id ="pw1" /></div>
			<div>비밀번호 확인 : <input type="text" name="loginPwChk" placeholder="비밀번호 확인을 입력해주세요"/></div>
			<div>이름 : <input type="text" name="name" placeholder="이름을 입력해주세요"/></div>
		</div>
		<div>
			<button>가입</button>
			<a href="../home/main">취소</a>
		</div>
	</form>
</body>
</html>