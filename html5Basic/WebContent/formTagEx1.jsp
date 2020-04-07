<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="">
		<!-- textarea 
		열과 행의 수를 지정할 수 있다
		여러 줄로 도니 텍스트 상자를 생성하는 태그
	-->
		<textarea rows="4" cols="100">박성욱</textarea>

		<h2>The select Element</h2>

		<p>The select element defines a drop-down list:</p>

	</form>

	<form action="">
		<label for="cars">Choose a car:</label> 
		<select id="cars" name="cars">
			<option value="saab">세브</option>
			<option value="volvo">볼보</option>
			<option value="fiat">Fiat</option>
			<option value="audi">Audi</option>
			<option value="jilju" selected>Jilju</option>
		</select> 
		<input type="submit">
	</form>

</body>
</html>