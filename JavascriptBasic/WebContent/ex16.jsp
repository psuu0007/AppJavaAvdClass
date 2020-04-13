<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>



</head>

<body>
<!-- 	Array 객체 -->
<!-- 	하나의 변수에 여러 개의 데이터를 저장할 수 있다. -->
<!-- 	각 공간마다 인덱스 번호가 존재한다. -->
<!-- 	배열 객체를 생성하는 법을 배우자 -->
	
	
</body>

<script type="text/javascript">
	/* 1.new 연산자를 사용한 배열 객체 생성법
	var 변수명 = new Array();
	
	2. 저장 공간을 지정한 배열 객체 생성법
	var 변수명 = new Array(5);
	
	3. 값을 바로 할당하여 생성하는 배열 객체 생성법
	var 변수명 = [val1, val2, val3, ...]; */
	
	var dayArr = ['일', '월', '화'];
// 	var numList = '';
	
	for (var i = 0; i < dayArr.length; i++) {
		document.write(dayArr[i] + ' ');
	}
	
</script>

</html>








