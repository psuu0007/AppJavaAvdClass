<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	/* 반갑습니다.
	안녕히가세요 */
	
	function greetFnc(greetTxt) {
		alert(greetTxt);
	}
</script>

</head>

<body>

	<input type="button" onclick="greetFnc('반갑습니다');" value="버튼1">
	<button onclick="greetFnc('안녕히가세요');">버튼2</button>

</body>
</html>