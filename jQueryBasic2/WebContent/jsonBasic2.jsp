<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="./js/jquery-3.5.1.min.js"></script>

<script type="text/javascript">
	
	var jsonStr = '{"firstName" : "John", "lastName" : "Smith"}';
	
	var jsonObj = JSON.parse(jsonStr);
	
	alert(jsonObj.firstName);
	alert(jsonObj.lastName);
	
	
</script>

</head>

<body>


</body>

</html>