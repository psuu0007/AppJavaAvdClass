<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function plusTenFnc() {
		var inputObj = document.getElementById('yourNumber1');
		var num = inputObj.value;

		var result = 0;

		result = Number(num) + 10;

		alert(result);

	}
</script>
</head>

<body>
	1.숫자를 입력해주세요
	<input id='yourNumber1' type="text" value="">
	2.숫자를 입력해주세요
	<input id='yourNumber2' type="text" value="">

	<div>
		<input type="button" value='+10 버튼' onclick="plusTenFnc();">
		<button>두 수를 더하는 버튼</button>
	</div>


</body>

</html>




