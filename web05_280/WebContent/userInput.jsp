<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>

</head>

<body>

   <h2>JSP 계산기</h2>

	<form action="./NewFile.jsp" method="get">
		<input type="text" name="v1" size="4" value="">
		<select name="op">
			<option value="+">+</option>
			<option value="-">-</option>
		</select>
		<input type="text" name="v2" size="4" value="">
		<input type="submit" value="=">
	</form>

</body>

</html>

