<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>



</head>

<body>
	<div id='demo' style="width: 300px; height: 300px; 
		border: 1px solid black;">
		이것은 간장인가 김장인가
	</div>
	
	<div onclick="innerFnc();" style="width: 120px; 
		border: 1px solid black;">
		innerHTML 버튼
	</div>
	<div onclick="writeFnc();" style="width: 160px; 
		border: 1px solid black;">
		document.write 버튼
	</div>
	
	<p id='myPlace'>
		나만의 공간
	</p>
	
	<h1 id='myDestiny'>
		myDestiny 자바스크립트
	</h1>
	
	
</body>

<script type="text/javascript">
	function innerFnc(){
		var obj = document.getElementById('demo');
		
		obj.innerHTML = 'innerHTML은 100% 이해해야 한다.';
	}
	
	function writeFnc(){
		var obj = document.getElementById('demo');
		
		document.write('write는 공부용일뿐 안쓴다 물론 100%는 아닐듯');
	}
	
</script>

</html>








