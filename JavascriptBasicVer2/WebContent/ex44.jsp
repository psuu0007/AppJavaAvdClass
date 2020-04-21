<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>

<script type="text/javascript">
	function testFnc() {
		alert('버튼1 호출');
	}
	
</script>

</head>

<body>
	
	<button onclick="testFnc();">
		버튼1
	</button>
	버튼2는 직접적으로 tag를 건드리지 않는다.
	버튼2에 마우스를 올리면 배경색이 변경된다.
	마우스가 버튼2를 벗어나면 배경색은 원래 되로 돌아간다.
	버튼2를 클릭하면 버튼2 호출 경고창을 보여준다.
	<button onclick="" onmouseleave="" onmouseenter="">
		버튼2
	</button>
</body>

</html>












