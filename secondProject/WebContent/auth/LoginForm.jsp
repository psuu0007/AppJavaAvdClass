<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>로그인</title>
<script type="text/javascript">
	function moveAddPageFnc() {
		location.href = '<%=request.getContextPath()%>/member/add';
	}
	
	function moveFindPageFnc() {
		location.href = '../auth/find';
	}

	
</script>

<style type="text/css">

.divClass {
	text-align: center;
/* 	border: 1px solid black; */
	width: 240px;
}

.underLine {
	border: none;
	border-bottom: 2px solid gray;
}

#greenBtn{
	background-color: rgb(92, 184, 92);
}

#blueBtn{
	background-color: rgb(91, 192, 222);
}

#orangeBtn{
	background-color: rgb(240, 173, 78);
}

#greenBtn, #blueBtn, #orangeBtn {
	border: 1px solid white;
	border-radius: 4px;
	color: white;
	height: 25px;
	width: 70px;
}
</style>

</head>

<% String id = request.getParameter("id"); 
	if(id == null){
		id = "";
	}
%>

<body>

	<jsp:include page="/Header.jsp" />

	<h2>사용자 로그인</h2>
	<div class="divClass">
		<form action="./login" method="post">
			<div class="divClass"> 
				이메일: 	<input class = 'underLine' type="text" name="email" value="<%=id%>">
			</div>
			<br>
			<div class="divClass">
				암&ensp;&nbsp;호: 	<input class = 'underLine' type="password" name="password">
			</div>
			<br>
			<div class="divClass">
				<input id='greenBtn' type="submit" value="로그인">
				<input id='blueBtn' onclick="moveAddPageFnc();" type="button" value="회원가입">
				<input id='orangeBtn' onclick="moveFindPageFnc();" type="button" value="비번 찾기">
			</div>
		</form>
	</div>
	
		<jsp:include page="/Tail.jsp" />
	
</body>
</html>