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


	});
	
	function htmlFnc() {
		$('#userViewArea').html('<h1>Header-2</h1>');
		
// 		var innerHtmlStr = $('#first').html();
		
// 		alert(innerHtmlStr);
	}
	
	function textFnc() {
		$('#userViewArea').text('<h1>Header-2</h1>');
// 		var textStr = $('#third').text();
		
// 		alert(textStr);
	}
	
	
</script>

</head>

<body>
	
	<div id='userViewArea' 
		style="border: 1px solid black; height: 50px;">
		
	</div>
	
	<h1 id='first'>Header-1</h1>
	<h1 id='third'>Header-3</h1>
	
	<button onclick="htmlFnc();">html</button>
	<button onclick="textFnc();">text</button>
	
</body>

</html>