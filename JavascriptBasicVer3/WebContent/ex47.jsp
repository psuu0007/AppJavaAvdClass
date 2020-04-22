<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	window.onload = function() {
		var pwfindObj = document.getElementsByTagName('div')[0];
		var pw2findObj = pwfindObj.getElementsByTagName('input');
		var btnfindObj = pwfindObj.getElementsByTagName('button');
		var resultObj = document.getElementsByTagName('textarea');

		pwfindObj.style.border = '1px solid black';

		btnfindObj[0].addEventListener('click', pwfindFnc, false);

	}

	function pwfindFnc() {
		var pwfindObj = document.getElementsByTagName('div')[0];
		var pw2findObj = pwfindObj.getElementsByTagName('input');
		var resultObj = document.getElementsByTagName('textarea');

		resultObj[0].innerHTML = pw2findObj[0].value;

	}
</script>

</head>

<body>

	<!--    비밀번호를 입력한 후 비밀번호 찾기 버튼을 클릭하면
   텍스트에어리어에 비밀번호가 나타난다 -->
	<div>
		<input id='pw' type="password">
		<button>비밀번호 찾기</button>
	</div>

	<textarea rows="2" cols="12"></textarea>
</body>
</html>