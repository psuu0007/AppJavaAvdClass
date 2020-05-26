<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
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

	function validationChk() {
		var emailInput = document.getElementsByName('email')[0];
		var pwdInput = document.getElementsByName('password')[0];
		
		if(emailInput.value.trim() == ''){
			alert('이메일을 입력하세요');
			emailInput.focus();
			return false;
		}else if(pwdInput.value == ''){
			alert('패스워드를 입력하세요');
			pwdInput.focus();
			return false;
		}
		
		return;
	}
	
	function findPageFnc(){
		location.href="../auth/find";
	}
	
</script>

</head>
<body>

	<jsp:include page="/Header.jsp"/>

	<div id='wrap'>
		<h2 id='pageTitle'>Login</h2>
	
		<form action="" method="post" id='loginForm' onsubmit="return validationChk();">
			<label>이메일</label>
			<input type="text" class='inputText' name="email" value="">
			<label>암호</label>
			<input type="password" class='inputText' name="password" value="">
			
			<c:if test="${errorMsg != null}">
				<span id="msgSpan" style="font-size:12px; color:red;">${errorMsg}</span>
			</c:if>
			
			<div id='btnWrap' style='margin-top: 35px;'>
				<input type="submit" class='loginBtn' value="로그인">
			</div>
		</form>
		
		<input type="button" class='loginBtn' value="비밀번호 찾기" onclick="findPageFnc()"/>
	</div>

	<jsp:include page="/Tail.jsp"/>
	
</body>
</html>