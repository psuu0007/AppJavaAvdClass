<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>환영합니다 ^_^</title>

<script type="text/javascript">
	function listPageMoveFnc() {
		location.href = '<%=request.getContextPath()%>/auth/login';
	}
</script>

</head>


<body>

	<jsp:include page="/Header.jsp" />

	<div>
		<strong>테일아!!</strong> 진화시켜줘!!
	</div>
	<div>
		<img onclick="listPageMoveFnc();" alt="아구몬 안녕" src="<%=request.getContextPath()%>/img/agumon.png">
	</div>		

	<jsp:include page="/Tail.jsp" />

</body>

</html>