<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="">
		<input type="button" onclick="setGugudanFnc(6);" value="구구단 그만하자">
		<input type="button" onclick="getGugudanFnc();" value="구구단 지겨워">
	</form>
</body>
<script type="text/javascript">
	var result = "";
	
	function setGugudanFnc(putNum) {
		result = "";
		var tab = "&nbsp;";
		for (var i = Number(putNum); i < (Number(putNum)+1); i++) {
			for (var j = 1; j < 10; j++) {
				result += i +tab.repeat(j)+"*"+tab.repeat(j) + j+tab.repeat(j) + 
					"="+tab.repeat(j) + (i*j)+tab.repeat(j)+j + '<br>';
			}
		}
	}
	
	function getGugudanFnc() {
		document.write(result);
	}
	
</script>
</html>