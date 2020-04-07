<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>Text input fields</h2>

	<form>
		<label for="fname">First name:</label><br> 
		<input type="text"
			id="fname" name="fname" value="John"><br> 
		<label
			for="lname">Last name:</label><br> 
		<input type="text" id="lname"
			name="lname" value="Doe">
	</form>

	<p>Note that the form itself is not visible.</p>

	<p>Also note that the default width of text input fields is 20
		characters.</p>

</body>
</html>