<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="./js/jquery-3.5.1.min.js"></script>

<script type="text/javascript">
	// 	$(document).ready(function() {

	// 	});

	var numArr = new Array();

	for (var i = 0; i < 3; i++) {
		numArr[i] = i * 100;
	}
	
// 	$.each(object, function(index, item){   })
	
	$.each(numArr, function(i, num){
		alert(num);
	});
</script>

</head>

<body>

</body>

</html>