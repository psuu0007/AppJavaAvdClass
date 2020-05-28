<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
span{
	border: 1px solid black;
	margin-right: 30px;
}
</style>
<script type="text/javascript" src="./js/jquery-3.5.1.min.js"></script>

</head>

<body>
	

</body>

<script type="text/javascript">

	var jsonStr = '{"employees" : [' + 
	'{"firstName" : "John" , "lastName" : "Doe"},' + 
	'{"firstName" : "Anna" , "lastName" : "Smith"},' + 
	'{"firstName" : "Peter" , "lastName" : "Jones"}' + 
	']' + 
	'}';
	
// 	{"employees" : [
// 		{"firstName" : "John" , "lastName" : "Doe"},
// 		{"firstName" : "Anna" , "lastName" : "Smith"},
// 		{"firstName" : "Peter" , "lastName" : "Jones"}
// 		]
// 	}
	
	var jsonObj = JSON.parse(jsonStr);
	
// 	alert(jsonObj.employees);
	
	$.each(jsonObj, function(key, valueArr){
		
		alert('key: ' + key);
		alert('valueArr: ' + valueArr);
		
		$.each(valueArr, function(name, value){
			alert('name: ' + name + ', firstName: ' + value.firstName 
					+ ', lastName: ' + value.lastName);
		});
		
	});
	
	
	
	
</script>

</html>