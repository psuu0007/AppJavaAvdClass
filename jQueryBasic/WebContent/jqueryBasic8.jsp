<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
.item{
	color: lime;
}

.getBack{
	border: 5px solid black;
}
</style>

<script type="text/javascript" src='./jquery-3.5.1.min.js'></script>

<script type="text/javascript">
	
	$(document).ready(function() {
		$('h1').addClass('item');
		$('h1').addClass('getBack');
	});

</script>

</head>

<body>
	<h1>Header-1</h1>
	<h1>Header-2</h1>
	<h1>Header-3</h1>
	
</body>

</html>