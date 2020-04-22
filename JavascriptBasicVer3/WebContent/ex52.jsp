<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	/* 윈도우 실행시 */
	window.onload = function() {
		 
		var inputId = prompt('게임아이디를 입력해주세요');
		/* input태그에 아이디가 뜸 */

		//alert(inputId);
		var inputIdObj = document.getElementById('inputId');
		inputIdObj.value = inputId;

	}

	function clickBtn() {
		var inputIdObj = document.getElementById('inputId');
		var userId = inputIdObj.value;

		var checkId = confirm('아이디 ' + userId + '를 만들까요?');

		/* 확인하면 input태그가 테두리 생김 , 취소하면 아이디 사라짐 */
		/* 확정하면 테두리 원래대로 */
		if (checkId == true) {
			inputIdObj.style.border = '3px solid yellow';
		} else {
			inputIdObj.value = '';
			inputIdObj.style.border = '';
		}
	}
</script>

</head>

<body>

	<input id='inputId' type="text" value="">

	<input type="button" value="아이디생성" onclick="clickBtn();">

</body>
</html>