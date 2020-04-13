<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	/* 형식
	function 함수명(){
		
	} */

// 	function testFnc() {
// 		var sum = 0;

// 		for (var i = 0; i < 10; i++) {
// 			sum = sum + (i + 1);
// 		}

// 		document.write(sum);

// 	}

	function testFnc(paramNum) {
		var sum = 0;

		for (var i = 0; i < paramNum; i++) {
			sum = sum + (i + 1);
			document.write(sum + ' + ' + i + '   = ');
			document.write('<br/>');
		}

	}
	testFnc(3);
// 	testFnc();
// 	testFnc(5, 10);
</script>

</head>

<body>

	<!-- <button>버튼</button> -->

</body>
</html>