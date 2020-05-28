<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="./js/jquery-3.5.1.min.js"></script>

<script type="text/javascript">
	
	'"kindFindKey" : [{"kind" : "과일"}, {"kind" : "도구"}]'
	
	var jsonStr = '{"employees" : ' +
		'[{"firstName" : "John", "lastName" : "Smith"},' +
		'{"firstName" : "성욱", "lastName" : "박"}]}'; 
	
	var jsonObj = JSON.parse(jsonStr);
	
	document.write(jsonObj.employees[0].lastName 
			+ jsonObj.employees[0].firstName);
	document.write('<br>');
	document.write(jsonObj.employees[1].lastName 
			+ jsonObj.employees[1].firstName);
	
</script>

</head>

<body>


</body>

</html>