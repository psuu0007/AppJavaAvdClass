<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	function spaceFnc(spaceNum) {
		var spaceStr = '';

		for (var i = 0; i < spaceNum; i++) {
			spaceStr = spaceStr + "&nbsp;";
		}

		return spaceStr;
	}
	/* 2차원 배열 */
	var numArr = new Array();

	for (var i = 0; i < 4; i++) {
		numArr[i] = new Array();
	}

	//    numArr[0] = new Array();
	//    numArr[1] = new Array();
	//    numArr[2] = new Array();
	//    numArr[3] = new Array();

	for (var i = 0; i < numArr.length; i++) {
		for (var j = 0; j < numArr.length; j++) {
			numArr[i][j] = "" + i + "," + j + spaceFnc(2);
		}

	}

	for (var i = 0; i < numArr.length; i++) {
		for (var j = 0; j < numArr.length; j++) {
			document.write(numArr[i][j]);
		}
		document.write("<br>");
	}
</script>

</head>

<body>



</body>
</html>