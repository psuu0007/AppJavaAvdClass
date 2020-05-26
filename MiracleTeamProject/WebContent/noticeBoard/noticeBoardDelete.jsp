<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>

<body>

<!-- 	미구현 기능 -->

	<jsp:include page="/common/Header.jsp" />	
	
	<div style="width: 1000px; margin: auto;">
		<div style="border: 1px solid #B22222; width: 600px; height: 300px; margin: 100px auto; text-align:center; background-color: #f3f5f7">
			<h1 style="color: #FAFAD2;">정말로 삭제하시겠습니까?</h1>
			<input style="width: 150px; height: 75px;" type="button" value="확인">
			<input style="width: 150px; height: 75px;" type="button" value="취소">
		</div>
	</div>
	<jsp:include page="/common/Bottom.jsp" />	
	
</body>
</html>