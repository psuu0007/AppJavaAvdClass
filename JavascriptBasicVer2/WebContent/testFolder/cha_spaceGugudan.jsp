<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>


<body id='output'>
</body>
<script type="text/javascript">

	function spaceFnc(cnt) {
		var spaceStr = '';
		
		for (var i = 0; i < cnt; i++) {
			spaceStr += '&nbsp;'		
		}
		return spaceStr;
	}
	
	function getGugudan() {
		
		return resultStr;		
	} 
	
	
	function setGugudan(putNum) {	
		resultStr = '';
		var dan = putNum;
		
		for (var i = 1; i <= 9; i++) {				
			resultStr += dan + spaceFnc(i) + '*' + spaceFnc(i) + i + spaceFnc(i) 
						+ '=' + spaceFnc(i) + (dan*i) + '<br/>';		
		}			
	}
	
	setGugudan(5);
	var resultList = getGugudan();
	var bodyObj = document.getElementById('output');
	
	bodyObj.innerHTML = resultList;

</script>
</html>