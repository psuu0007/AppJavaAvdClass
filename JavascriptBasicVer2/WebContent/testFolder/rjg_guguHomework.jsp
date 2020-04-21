<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	
<script type="text/javascript">
	
	var putNum = 0;
	
	function setGugudanFnc(putNum) {
		resultNum = 0;			
		resultNum = putNum;	
		guguArr = new Array();
		for (var i = 1; i <= 9; i++) {
			guguArr[i-1] = putNum * i;
		}
	}
	
	function getGugudanFnc() {
		var resultStr = '';
		for (var i = 1; i <= 9; i++) {
			resultStr = resultStr + resultNum + spaceFnc(i) + '*' + spaceFnc(i) + i + spaceFnc(i) + '=' + spaceFnc(i) + guguArr[i-1] + '<br>'; 
		}
		
		document.write(resultStr);
	}
	
	
	function spaceFnc(spaceNum) {
		var spaceStr = '';
		for (var i = 0; i < spaceNum; i++) {
			spaceStr = spaceStr + '&nbsp;';
		}
		
		return spaceStr;
	}

	setGugudanFnc(2);
	getGugudanFnc();
</script>

</head>

<body>
	<form>
		<input id='danNumber' type="text" value="">
			여기에 숫자를 입력하세요 입력한대로 해당 단이 세팅됩니다
		<br>
		<button onclick="setGugudanFnc(2);">이거는 구구단을 세팅하는 버튼</button>
		<button onclick="getGugudanFnc();">이거는 구구단을 출력하는 버튼</button>
	</form>
	<p>
		지금 value연결이 안되었고 innerHtml이 사용되지 않았다. 
	</p>
</body>
</html>