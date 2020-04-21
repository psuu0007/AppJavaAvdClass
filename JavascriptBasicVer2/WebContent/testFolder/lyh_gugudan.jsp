<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>

<script type="text/javascript">

	function setGugudanFnc(putNum) {
		for (var i = 0; i < putNum; i++) {
			document.write('&nbsp;');
		}
	}

	function getGugudanFnc() {
		for (var i = 1; i <= 9; i++) {
			document.write('6');
			setGugudanFnc(i);
			document.write('*');
			setGugudanFnc(i);
			document.write(i);
			setGugudanFnc(i);
			document.write('=');
			setGugudanFnc(i);
			document.write(6 * i);
			document.write('<br/>');
		}
	}

	getGugudanFnc();
	
</script>

</head>

<body>



</body>
</html>