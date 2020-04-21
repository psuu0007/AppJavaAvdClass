<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>

<body>

	1.숫자를 입력해주세요
	<input id='yourNumber1' type="text" value=""> 2.숫자를 입력해주세요
	<input id='yourNumber2' type="text" value="">

	<div>
		<input type="button" value="+10버튼" onclick="testFnc();">
		<!--       <button onclick="plusFnc();">두 수를 더하는 버튼</button> -->
	</div>
	<div id='resultTag' style="border: 1px solid black; font-size: 40px;">

	</div>

</body>
<script type="text/javascript">
	function testFnc() {
		var yourNumber1InputTag = document.getElementById('yourNumber1');

		var numval = yourNumber1InputTag.value;
		if (isNaN(numval) == true) {
			alert('숫자를 입력하세요');
			return;
		}

		var result = Number(numval) + 10;

		var resultTagDivTag = document.getElementById('resultTag');

		//       isNaN(????);  검증 not a number 맞니? true, false

		resultTagDivTag.innerHTML = result;
	}
</script>

</html>