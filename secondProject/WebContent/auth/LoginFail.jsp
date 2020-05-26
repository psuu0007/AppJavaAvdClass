<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Refresh" content="1;url=./login">

<title>로그인 실패</title>
</head>
<style type="text/css">
#failText {
	font-size: 20px;
	font-weight: bold;
}
</style>

<body>
	<jsp:include page="/Header.jsp" />

	<p id="failText">
		이메일 또는 암호가 맞지 않습니다!<br> 잠시 후에 다시 로그인 화면으로 갑니다.
	</p>

	<img src='../img/loginFailImg.png' alt="나보다 약한자의 말은 듣지 않는다">
	
		<jsp:include page="/Tail.jsp" />
</body>
</html>