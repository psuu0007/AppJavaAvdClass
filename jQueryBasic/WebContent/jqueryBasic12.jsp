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
		$('div').remove(); // 객체 제거

	});
</script>

</head>

<body>
	<div id='parentTag' style="border: 1px solid red;">
		<h1 id='child1' style="border: 1px solid green;">Header-0</h1>
		<br>
		<h1 id='child2' style="border: 1px solid blue;">Header-1</h1>
	</div>
	
	<!-- 	<h1>Header-0</h1> -->
	<!-- 	<h1>Header-1</h1> -->
	<!-- 	<h1>Header-2</h1> -->

</body>

</html>