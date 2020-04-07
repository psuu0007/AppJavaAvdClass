<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
	div{
		border: 1px solid black;
		margin: 10px;
	}
</style>

</head>

<body>

	<form action="" style="border: 1px solid green;">
		<div>
		<!-- text 타입 
			한 줄 글 입력 상자
			size 속성은 글상자의 가로길이
			maxlength 속성은 최대 글자 수
		-->
			아이디: <input type="text" size="24" 
				value="아하 여기가 저기구나">
		</div>
		<div>
		<!--
			password 타입
			비밀번호 입력 상자, 입력된 내용은 *?로 표시
		  -->
			비밀번호: <input type="password" size="8" maxlength="8"
				value="1234">
		</div>
		<div>
		<!-- radio 타입 
			라디오 버튼
			여러 선택지 중 하나만 선택 가능
			name값이 같아야 함
			value는 체크 시 실제 전송되는 값-->
			메일 수신여부:
			<input type="radio" value="y" name='receive'>예
			<input type="radio" value='n' name="receive">아니오
			<input type="radio" value='etc' name="Receive">보류
		</div>
		<div>
			<!-- checkbox 타입
				체크박스
				다중 선택 가능
				name값이 서로 다름 -->
			관심분야:
			<input type="checkbox" value="HTML" name="chk1"/>html
			<input type="checkbox" value="CSS" name="chk2"/>css
			<input type="checkbox" value="Javascript" name="chk3"/>
			Javascript			
		</div>
	</form>

</body>
</html>






