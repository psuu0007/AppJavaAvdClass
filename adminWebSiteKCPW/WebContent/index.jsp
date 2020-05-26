<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>KCPW Homepage</title>
<link rel="stylesheet" type="text/css" 
	href="<%=request.getContextPath()%>/css/style.css">

<style type="text/css">
#mainImg{
	width: 400px;
	height: 400px; 
	margin: 60px auto 0px; 
	border-radius: 50%; 
	background:url('<%=request.getContextPath()%>/img/sky.jpg') no-repeat 0% 0%; 
	background-size: cover;
	animation-name: imgAni;
	animation-duration: 20s;
	animation-timing-function: linear;
	animation-fill-mode: forwards;
}
@keyframes imgAni {
	from {
		background-position: 0% 0%;
	}
	to {
		background-position: 100%;
	}
}
</style>

<script type="text/javascript">

	function listPageMoveFnc() {
		location.href = '<%=request.getContextPath()%>/auth/login';
	}
	
</script>

</head>

<body>

	<jsp:include page="/Header.jsp"/>
	
		<div id='wrap'>
			<div id='mainImg'>
			</div>
			
			<p style='margin: 20px 0px 10px; text-align: center; font-family: "Times New Roman", Times, serif;
				font-size: 35px; font-weight: bold;'>
				WELCOME
			</p>
			<p style='text-align: center; font-family: "Times New Roman", Times, serif;
				font-size: 14px;'>
				This site is a temporary site made solely for the purpose of <br>
				a team project. By &copy;KCPW 2020
			</p>

<!-- 			<p onclick="listPageMoveFnc();">adminWebSite</p> -->
			
<%-- 			<c:if test="${memberDto.email == null}"> --%>
<!-- 				<a href="./auth/login">로그인</a> -->
<%-- 			</c:if> --%>
			
<%-- 			<c:if test="${memberDto.email ne null}"> --%>
<!-- 				<a href="./auth/logout">로그아웃</a> -->
				
<%-- 				<c:if test="${memberDto.grade == 'admin'}"> --%>
<!-- 					<a href="./admin/member/list">회원리스트</a> -->
<!-- 					<a href="./member/add">회원추가</a> -->
<%-- 				</c:if> --%>
				
<%-- 				<a href="./member/info?no=${memberDto.no} ">마이페이지</a> --%>
<%-- 			</c:if>	 --%>
			
<!-- 			<a href="./board/list">게시판</a> -->
			
<!-- 			<a href="./admin/list">공지 게시판</a> -->
		</div>
	
	<jsp:include page="/Tail.jsp"/>

</body>

</html>