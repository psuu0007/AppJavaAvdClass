<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Refresh" content="3;url=./login">

<title>로그인 실패</title>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/common.css" type="text/css">

</head>

<body>
	<div>
		<jsp:include page="../Header.jsp"/>

		<p>
			로그인 실패입니다. 이메일 또는 암호가 맞지 않습니다.!<br> 잠시 후에 다시 로그인 화면으로 갑니다.
		</p>
	
		<jsp:include page="../Tail.jsp"/>
	</div>
</body>
</html>