<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset= UTF-8">
<title>차정경</title>
</head>

<body id='body_id'>

</body>

<script type="text/javascript">
	//1. 2~9까지 들어있는 배열
	var danList = new Array();

	for (var i = 2; i <= 9; i++) {
		danList[i - 2] = i;
	}

	// 2. 1 ~9까지 들어있는 배열
	var numList = new Array();

	for (var i = 1; i <= 9; i++) {
		numList[i - 1] = i;
	}
	// 3. 2*1 ~ 9*9까지 들어있는 배열 -> 문자열로 들어가야함
	var formalList = new Array();

	var idx = 0;
	for (var i = 2; i <= 9; i++) {
		for (var j = 1; j <= 9; j++) {
			formalList[idx] = danList[i - 2] + '*' + numList[j - 1];
			idx++;
		}
	}
	//출력
	idx = 0;
	var result = document.getElementById('body_id');
	for (var i = 0; i <= 9; i++) {
		for (var j = 0; j <= 9; j++) {
			result.innerHTML += formalList[idx] + '='
					+ (danList[i - 2] * numList[j - 1]) + ' ';
			idx++;
		}
		result.innerHTML += '<br/>';
	}
</script>

</html>