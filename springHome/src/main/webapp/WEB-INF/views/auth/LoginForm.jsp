<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>로그인</title>

</head>

<body>
	<h2>사용자 로그인</h2>
	<form action="./loginCtr.do" method="post">
		이메일: 	<input type="text" name="email" value="dd"><br>
		암호: 	<input type="password" name="password" value="dd"><br>
				<input type="submit" value="로그인">
	</form>
	
	<div>
		<a href='./member/add.do'>신규 회원</a>
	</div>
</body>
</html>