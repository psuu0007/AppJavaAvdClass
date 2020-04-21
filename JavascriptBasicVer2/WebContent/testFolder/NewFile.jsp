<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>

<script type="text/javascript">
	var globalNum = 10;
	
	globalNum2 = 20;
	
	function numbering() {
		globalNum3 = 30;
		var localNum = 40;
		
		document.write('globalNum= ' + globalNum + "<br>");
		document.write('globalNum2= ' + globalNum2 + "<br>");
		document.write('globalNum3= ' + globalNum3 + "<br>");
		document.write('localNum= ' + localNum + "<br>");
		
	}
	
	numbering();
	
</script>

</head>
<body>

</body>
</html>