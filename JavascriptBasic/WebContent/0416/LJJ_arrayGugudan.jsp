<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table,tr,td{
		border: 1px solid black;
		border-collapse: collapse;  
	}
	td{
		width: 150px;
		text-align: center;
	}
</style>
</head>
<body>

</body>
<script type="text/javascript">
	//1. 2~9까지 들어있는 배열
	var danList = new Array();
		for (var i = 2; i < 10; i++) {
			danList[i - 2]= i;
		}
	// 2. 1 ~9까지 들어있는 배열
	var numList = new Array();
		for (var i = 1; i < 10; i++) {
			numList[i - 1]= i;
		}
	// 3. 2*1 ~ 9*9까지 들어있는 배열
	var formalList = new Array();
	var count = 0;
		for (var j = 0; j < numList.length; j++) {
			for (var i = 0; i < danList.length; i++) {
				formalList[count]= danList[i] + '*' + numList[j];
				count++;
			}
		}

	count = 0;
	
	
	document.write("<table>");
	document.write("<tr>");
	for (var i = 0; i < danList.length; i++) {
		document.write("<td>");
		document.write(danList[i] + "단");
		document.write("</td>");
	}
	document.write("</tr>");
	
	document.write("<tr>");
	for (var j = 0; j < numList.length; j++) {
		for (var i = 0; i < danList.length; i++) {
			document.write("<td>");
			document.write(formalList[count] + " = " + (danList[i] * numList[j]));
			count++;
		}
		document.write("<br>");
		document.write("</td>");
		document.write("</tr>");
	}
	document.write("</table>");
	
	
</script>
</html>