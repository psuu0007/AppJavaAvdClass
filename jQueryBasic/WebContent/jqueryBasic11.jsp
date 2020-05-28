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

		$('h1').html(function(index, data) {
			// 			alert(index + "   :   " + data);
			return data + '-' + index;
		});

	});
</script>

</head>

<body>
	<div>
		<h1>Header</h1>
	</div>
	<div>
		<h1>Header</h1>
	</div>
	<div>
		<h1>Header</h1>
	</div>
	<!-- 	<h1>Header-0</h1> -->
	<!-- 	<h1>Header-1</h1> -->
	<!-- 	<h1>Header-2</h1> -->

</body>

</html>