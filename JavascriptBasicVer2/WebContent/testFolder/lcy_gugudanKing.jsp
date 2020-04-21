<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>



</head>

<body>

	<input id='putNumber' type='text'>
	<input id='putBtn' type='button' 
		onclick="setGugudan(danText.value); getGugudan();" value="구구단 계산">
	
	<div id='mainGugudan' onclick="test();">
	
	
	</div>

</body>

<script>

	var gugudanResultStr = '';
	var danText = document.getElementById('putNumber');
	var gugudanDiv = document.getElementById('mainGugudan');
	

	function blankFnc(num) {
		var blankStr = '';
		for (var i = 0; i < num; i++) {
			blankStr = blankStr + '&nbsp;';	
		}
		return blankStr;
	}
	
	function setGugudan(putNum) {
		gugudanResultStr = '';

		if (isNaN(putNum) || putNum == ''){
			return;
		}
		
		var result = 0;
		for (var i = 1; i <= 9; i++) {
			result = putNum * i;
			gugudanResultStr += putNum;
			gugudanResultStr += blankFnc(i);
			gugudanResultStr += '*';
			gugudanResultStr += blankFnc(i);
			gugudanResultStr += i;
			gugudanResultStr += blankFnc(i);
			gugudanResultStr += '=';
			gugudanResultStr += blankFnc(i);
			gugudanResultStr += result;
			gugudanResultStr += '<br/>';
		}
	}
	
	function getGugudan() {
		gugudanDiv.innerHTML = gugudanResultStr;
	}
	
	
</script>

</html>