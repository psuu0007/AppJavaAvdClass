<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	var danList = new Array(8);
	var resultList = new Array();
	var resultStr = '';
	var count = 0;
	var tab = '&nbsp;&nbsp;&nbsp;&nbsp;';

	// 단 입력
	for (var i = 2; i <= 9; i++) {
		danList[i - 2] = i;
	}

	//결과 입력
	for (var i = 1; i <= 9; i++) {
		for (var j = 0; j < danList.length; j++) {
			resultList[count++] = danList[j] * i;
		}
	}

	// 단 출력
	for (var i = 0; i < danList.length; i++) {
		resultStr += danList[i] + '단' + tab + tab;
	}
	resultStr += '<br/>';
	
	// 결과 출력
	count = 0;
	for (var i = 1; i <= 9; i++) {
		for (var j = 0; j < danList.length; j++) {
			resultStr += danList[j] + '*' + i + '=' + 
				resultList[count++] + tab;
		}
		resultStr += '<br/>';
	}

	document.write(resultStr);
</script>

</head>

<body>

	<button onclick="setGugudan();">입력</button>
	<button onclick="getGugudan();">출력</button>


</body>
</html>