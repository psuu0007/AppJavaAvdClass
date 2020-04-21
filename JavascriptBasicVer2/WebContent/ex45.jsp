<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>

<script type="text/javascript">
	function testFnc() {
		alert('버튼1 호출');
	}
	
	function anotherFnc(){
		alert('다른 함수 호출');
	}
	
	window.onload = function(){
		var btn2Obj = document.getElementById('anotherBtn');
		
// 		btn2Obj.onclick = testFnc; 
		btn2Obj.onclick = anotherFnc;
	}
</script>

</head>

<body>
	<button onclick="testFnc(); anotherFnc();">
		버튼1
	</button>

	<button id='anotherBtn' onclick="testFnc();">
		버튼2
	</button>
</body>

</html>












