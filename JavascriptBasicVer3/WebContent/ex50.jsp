<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
#myDiv1, #myDiv2 {
	background-color: coral;
	padding: 50px;
}

#myP1, #myP2 {
	background-color: white;
	font-size: 20px;
	border: 1px solid;
	padding: 20px;
}
</style>

<script type="text/javascript">

function test1Fnc() {
	alert("P> You clicked the white element!");
}

function test2Fnc() {
	alert("DIV> You clicked the orange element!");
}

window.onload = function(){
	document.getElementById("myP1").addEventListener(
			"click", test1Fnc, true);

	document.getElementById("myDiv1").addEventListener(
			"click", test2Fnc, false);

	document.getElementById("myP2").addEventListener(
			"click", test1Fnc, true);

	document.getElementById("myDiv2").addEventListener(
			"click", test2Fnc, true);
}
</script>

</head>

<body>

	
	<h2>JavaScript addEventListener()</h2>

	<div id="myDiv1">
		<h2>Bubbling:</h2>
		<p id="myP1">Click me!</p>
	</div>
	<br>

	<div id="myDiv2">
		<h2>Capturing:</h2>
		<p id="myP2">Click me!</p>
	</div>

</body>
</html>