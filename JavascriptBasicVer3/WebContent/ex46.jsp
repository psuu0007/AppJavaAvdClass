<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	
<script type="text/javascript">
	function clickBtn1Fnc() {
		alert('clickBtn1Fnc 호출');
	}
	
	function clickBtn1OtherFnc() {
		alert('clickBtn1OtherFnc 호출');
	}

	window.onload = function() {
		var myBtn1 = document.getElementById('btn1');
		
		// 표현식
// 		addEventListener('이벤트명', 함수명, 아직 시기상조);
		
		if(window.addEventListener){
			myBtn1.addEventListener('click', clickBtn1Fnc, false);
			myBtn1.addEventListener('click', clickBtn1OtherFnc, false);
		}else if(window.attachEvent){
			myBtn1.attachEvent('onclick', clickBtn1Fnc);
			myBtn1.attachEvent('onclick', clickBtn1OtherFnc);
		}
		
	}
</script>

</head>

<body>

	<button id='btn1'>버튼1</button>
	
	
	
</body>
</html>