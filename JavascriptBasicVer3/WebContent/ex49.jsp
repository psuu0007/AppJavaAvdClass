<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	function testFnc(myObj) {
		alert(myObj.id);
	}
	
	function test2Fnc(myObj) {
		alert(myObj.value);
	}
</script>

</head>

<body>

	<div style="background-color: yellow;">
		<input id="inputTag" type="text">
		<button id='btn1' onclick="testFnc(this);">버튼1</button>
	</div>

	<div style="background-color: red;">
		<input id="inputTag" type="text">
		<button id='btn2' onclick="testFnc(this);">버튼2</button>
	</div>


</body>
</html>