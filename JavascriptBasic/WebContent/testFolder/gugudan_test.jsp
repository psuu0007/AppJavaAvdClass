<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	

</head>

<body>
	<button onclick="setGugudan();">입력</button>
	<button onclick="getGugudan();">출력</button>
</body>


<script type="text/javascript">

	function setGugudan() {
		var danArr = new Array();
		var valueArr = new Array();
		
		for (var i = 2; i < 10; i++) {
			danArr[i] = i + "단";
			document.write(danArr[i]);
			document.write("<br>");
			for (var j = 1; j < 10; j++) {
				valueArr[i] = i * j;
				document.write(i + " * " + j + " = " 
						+ valueArr[i] + "&nbsp;&nbsp;&nbsp;&nbsp;");
			}
			document.write("<br>");
		}
	}
	
</script>
</html>