<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css">

<style type="text/css">
	#wrap {
		width: 250px;
	}
	#loginForm label {
		display: block;
		font-size: 13px;
		padding:15px 0px 3px;
	}
	
</style>

<script type="text/javascript">

	function toLoginFnc() {
		location.href="./login";
	}

</script>

</head>
<body>

	<jsp:include page="/Header.jsp"/>
	
	<div id='wrap'>
		<h2 id='pageTitle'>Find Password</h2>
		<form action="" method="post" id='loginForm'>
			<label>이메일</label>
			<input type="text" class='inputText' name="email" value="${email}">
			<label>비밀번호</label>
<%-- 			<input type="text" class='inputText' name="password" value="${password}" style="color:red;"> --%>
			<div class="inputText" id="password" style="color:red; font-size: 13px; 
					padding:6px 8px; font-family: Arial;">
				<c:if test="${password ne null}">
					${password}
				</c:if>
			</div>
			
			<c:if test="${errorMsg ne null}">
				<span style="font-size:12px; color:red;">${errorMsg}</span>
			</c:if>
			
			<div id='btnWrap' style='margin-top: 35px;'>
				<input type="submit" class='loginBtn' id='confirmBtn' value="찾기">
			</div>
		</form>
		
		<input type="button" class='loginBtn' value="로그인 페이지" onclick="toLoginFnc();"/>
	</div>

	<jsp:include page="/Tail.jsp"/>
	
</body>
</html>