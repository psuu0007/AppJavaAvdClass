<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.democlass {
	color: red;
	font-style: italic;
	font-family: fantasy;
}
</style>

<script type="text/javascript">
	// 전역변수
	var pOriginalStyle = '';

	window.onload = function() {

		var pBtn = document.getElementsByTagName('button')[1];
		pBtn.addEventListener('click', styleAddRemoveFnc, false);

		var pObj = document.getElementById('demo');
		pOriginalStyle = pObj.getAttribute('style');
	}

	function myFunction() {
		var h1Obj = document.getElementsByClassName('democlass')[0];
		h1Obj.removeAttribute('id');
		h1Obj.style.textAlign = 'center';

	}

	function styleAddRemoveFnc() {

		var pObj = document.getElementById('demo');

		if (pObj.getAttribute('style') != undefined) {
			pObj.removeAttribute('style');
		} else {
			pObj.setAttribute('style', pOriginalStyle);
		}
	}
	
</script>

</head>

<body>
	<h1 id='democlass' class="democlass">Hello World</h1>

	<p id="demo" style="background-color: black; color: white;">Click
		the button to remove the class attribute from the h1 element.</p>

	<button onclick="myFunction();">Try it h1</button>
	<!--    h1의 아이디가 날라감 -->
	<!--    text-align이 추가됨 -->
	<button>Try it p</button>
	<!--    한번 클릭시 style이 없게끔, 두번 클릭시 다시 추가 -->


</body>
</html>

