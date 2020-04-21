<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>
	<div id="resultBox">
	</div>
	<input type="text" id="inputNum" onchange="refreshFnc();" value="">
</body>

<script type="text/javascript">
	
	var inputBox = document.getElementById('inputNum');
	var resultBox = document.getElementById('resultBox');
	
	function refreshFnc() {
		var inputNum = Number(inputBox.value);
		if(isNaN(inputNum)){
			alert('숫자를 입력하세요');
		}else{
			setGugudan(inputNum);
			resultBox.innerHTML = getGugudan();
		}
	}
	
	var resultList = [];
	
	function setGugudan(putNum){
		for (var i = 1; i <= 9; i++) {
			resultList[i - 1] = putNum + blank(i) + '*' + blank(i) + i + 
								blank(i) + '=' + blank(i) + (putNum * i); 
		}
	}
	
	function getGugudan(){
		var resultStr = '';
		for (var i = 0; i < resultList.length; i++) {
			resultStr += resultList[i] + '<br/>';
		}
		return resultStr;
	}
	
	function blank(num){
		var resultStr = '';
		for (var i = 0; i < num; i++) {
			resultStr += '&nbsp;';
		}
		return resultStr;
	}
</script>

</html>