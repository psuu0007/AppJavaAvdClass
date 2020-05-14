<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이찬양</title>


</head>

<body>
</body>

<script type="text/javascript">
	//    1. 2~9까지 들어있는 배열
	var danList = new Array();
	for (var i = 0; i < 8; i++) {
		danList[i] = i + 2;
	}
	//    2. 1 ~9까지 들어있는 배열
	var numList = new Array();
	for (var i = 0; i < 9; i++) {
		numList[i] = i + 1;
	}

	//    3. 2*1 ~ 9*9까지 들어있는 배열
	var count = 0;
	
	var formalList = new Array();
	for (var i = 0; i < danList.length; i++) {
		for (var n = 0; n < numList.length; n++) {
			formalList[count] = danList[i] * numList[n];
			count++;
		}
	}
	
	
	//출력
	count = 0;
	for (var i = 0; i < danList.length; i++) {
		document.write(danList[i] + '단 ');
		for (var n = 0; n < numList.length; n++) {
			document.write(danList[i] + ' * ' + 
					numList[n] + ' = ' + formalList[count] + '  ');
			count++;
		}
		document.write('<br>');
	}
	
</script>

</html>


