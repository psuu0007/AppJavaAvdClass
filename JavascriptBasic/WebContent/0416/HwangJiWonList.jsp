<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>황지원</title>



</head>

<body>
	<button onclick="setGugudanFnc();">입력</button>
	<button onclick="getGugudanFnc();">출력</button>


</body>
<script type="text/javascript">
	var mulList = new Array();
	var danList = new Array();
	var colList = new Array()
	var count = 0;

	function setGugudanFnc() {

		for (var i = 0; i < 8; i++) {
			danList[i] = i + 2
		}

		for (var i = 0; i < 10; i++) {
			colList[i] = i + 1;
		}

		for (var i = 0; i < danList.length; i++) {
			for (var n = 0; n < colList.length; n++) {
				mulList[count++] = danList[i] * colList[n];
			}

		}

		count = 0;
	}
	//출력

	function getGugudanFnc() {
		for (var i = 0; i < danList.length; i++) {
			document.write('<br>')
			document.write(danList[i] + '단')
			document.write('<br>')
			for (var n = 0; n < colList.length - 1; n++) {
				document.write(danList[i] + ' * ' + colList[n] + ' = '
						+ mulList[count++] + ' ')

			}
		}
	}
</script>
</html>