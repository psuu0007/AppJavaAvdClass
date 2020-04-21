<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>

<body>

	<form action="ex22.jsp">
		1.숫자를 입력해주세요 <input id='yourNumber1' type="text">
		<br>
		2.숫자를 입력해주세요 <input id='yourNumber2' type="text">
		<br>
		<br>
		
		<div>
			<input type="button" onclick="nameFnc();" value="inputButton">
			<input type="submit" value="submitButton">
			<button onclick="nameFnc();">button태그</button>
		</div>
	</form>
	
	
	<div><a href="./ex38.jsp" style="text-decoration: none;">
		와우 나만의 버튼</a></div>
	
	
</body>
<script type="text/javascript">
	function nameFnc() {
		alert('신기하네');
	}
</script>

</html>