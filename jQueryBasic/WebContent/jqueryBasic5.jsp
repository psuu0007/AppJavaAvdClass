<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>


<script type="text/javascript" src='./jquery-3.5.1.min.js'></script>

<script type="text/javascript">
	
	$(document).ready(function() {
// 		$('#userInput').val('아하 이게 설마');
		
// 		alert($('#userInput').val());
// 		$('#userInput').css('font-size');
		var userInputObj = $('#userInput');
		
		alert(userInputObj.css('font-size'));
		alert(userInputObj.css('font-style'));
		
	});

</script>

</head>

<body>

	<input id='userInput' style="font-size: 20px; 
		font-style: italic;" type="text">
	
</body>

</html>