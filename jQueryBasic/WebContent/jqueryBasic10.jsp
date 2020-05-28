<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">

</style>

<script type="text/javascript" src='./jquery-3.5.1.min.js'></script>

<script type="text/javascript">
	
	$(document).ready(function() {
		
// 		for (var i = 0; i < 3; i++) {
// 			$('div').html('<h1>Header-' + i + '</h1>');
// 		}
		
// 		var divLength = $('div').length;
// 		for (var i = 0; i < divLength; i++) {
// 			$('div').html('<h1>Header-' + i + '</h1>');
// 		}
		
		
		$('div').html(function(index){
			return '<h1>Header-' + index + '</h1>';
		});

	});
	
// 	$(selector).html(value);
// 	$(selector).html(function(index){
		
// 	});
	
</script>

</head>

<body>
	
<!-- 	<h1>Header-0</h1> -->
	
	<div></div>
	<div></div>
	<div></div>
	
<!-- 	<div><h1>Header-0</h1></div> -->
<!-- 	<div><h1>Header-1</h1></div> -->
<!-- 	<div><h1>Header-2</h1></div> -->
	
</body>

</html>