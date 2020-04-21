<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>

<script type="text/javascript">

	window.onload = function() {
		var divTag = document.getElementById('resultBox');
		
		divTag.style.border = '1px solid black';
		
		var divBtnObj = document.getElementById('divBtn');
		
		divBtnObj.onclick = printUserInfoBtn;
	}
	
	function printUserInfoBtn() {
		var userNameInput = document.getElementById('userName');
		var userBirthInput = document.getElementById('userBirth');
		
// 		alert(userNameInput.id);
		
		var resultBox = document.getElementById('resultBox');
		
		var htmlStr = '';
		
		htmlStr += '이름: ' + userNameInput.value;     
		htmlStr += '<br>';                          
		htmlStr += '태어난 해: ' + userBirthInput.value;
		
		resultBox.innerHTML = htmlStr;
	}
	
	
</script>

</head>

<body>
	<div id='divBtn' style="border: 1px solid black;">버튼</div>
	
	<div>
		<span>이름</span><input id='userName' type="text" value="">
		<span>태어난 해</span><input id='userBirth' type="text" value="">
	</div>
	
	<div id='resultBox'>  보더준다 
		이곳 안의 내용이 결과로 출력되어야 하는 영역이다.
		이름: 박성욱
		태어난 해: 1987
	</div>
</body>



</html>












