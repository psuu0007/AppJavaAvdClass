<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>

<script type="text/javascript">
	function tempFnc() {
		alert('hello script');
	}

// 	익명함수
	
	window.onload = function() {
		var myBtn = document.getElementById('divBtn');
		myBtn.onclick = tempFnc;
// 		alert(myBtn.id);
// 		alert(myBtn.style);
		alert(myBtn.style.border);
	}
</script>

</head>

<body>
	<div id='divBtn' style="border: 1px solid black;">버튼</div>
</body>
</html>












