<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	function clickFnc(){
		for(var i=6; i>=1; i--){
			document.write("<h"+i+">h"+i+" 재미있는 자바스크립트"+"</h"+i+">");
		}
	}
	
</script>

</head>

<body>
	<p style="border: 1px solid black;" onclick="clickFnc();">버튼</p>

	<div>
		내가 만든 버튼이야 누르면 경고창으로 '와 이게 이벤트구나' 라고 뜬다
		단, 마우스 왼쪽 버튼을 누르면 항상 작동한다
	</div>









</body>
</html>