<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>게시판</title>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/common.css" type="text/css">

</head>

<body>
	
	<div>
	
		<jsp:include page="/Header.jsp"/>
		
		<img style="height:500px;" src="./img/board.png"/>
		
		<div style="margin: auto; text-align: center;">
			<c:if test="${member.email eq null }" var="result">
				<input style="width:150px; height: 80px; margin: 20px 50px" type="button" onclick="pageMoveLogin();" value="로그인">
				<input style="width:150px; height: 80px; margin: 20px 50px" type="button" onclick="pageMoveMemberAdd();" value="회원가입">
			</c:if>
			<c:if test="${member.grade eq '1' }">
				<input style="width:150px; height: 80px; margin: 20px 50px" type="button" onclick="pageMoveMemberList();" value="회원목록"> 
			</c:if>
			<c:if test="${!result}">
				<input style="width:150px; height: 80px; margin: 20px 50px" type="button" onclick="pageMoveBulletinList();" value="게시판">
			</c:if>
			<input style="width:150px; height: 80px; margin: 20px 50px" type="button" onclick="pageMoveNoticeList();" value="공지사항">
		</div>
		
		<jsp:include page="/Tail.jsp"/>
		
	</div>

</body>



<script type="text/javascript">
	function pageMoveLogin() {
		location.href = '<%=request.getContextPath()%>/auth/login';
	}
	
	function pageMoveMemberAdd(){
		location.href = '<%=request.getContextPath()%>/member/add';
	}
	
	function pageMoveMemberList(){
		location.href = '<%=request.getContextPath()%>/member/list';
	}
	
	function pageMoveBulletinList(){
		location.href = '<%=request.getContextPath()%>/bulletin/list';
	}
	
	function pageMoveNoticeList(){
		location.href = '<%=request.getContextPath()%>/notice/list';
	}
</script>

</html>