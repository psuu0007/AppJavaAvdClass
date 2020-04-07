<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>

	<form action="" style="border: 1px solid black;">
		<div>
		<!-- text 타입 
			한 줄 글 입력 상자
			size 속성은 글상자의 가로길이
			maxlength 속성은 최대 글자 수
		-->
			아이디: <input type="text" size="24" maxlength="8">
		</div>
		<div>
		<!--
			password 타입
			비밀번호 입력 상자, 입력된 내용은 *?로 표시
		  -->
			비밀번호: <input type="password" size="8" maxlength="8">
		</div>
	</form>

</body>
</html>