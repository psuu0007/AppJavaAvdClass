<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>이메일로 비밀번호 찾기</title>
<script type="text/javascript">
		
	window.onload = function() {
		
		var hiddenPwd = document.getElementById('hiddenPwd');
		
		
		if(hiddenPwd.value != ''){
			alert('${memberDto.name}' + "님의 비밀번호는" + '${memberDto.password}' +"입니다.");
			
			location.href = "../auth/login?id=${memberDto.email}";
		}
		
		
	}		
	
	function movePageLoginFnc(){
		location.href = "../auth/login";
	}
</script>	
<style type="text/css">
.divClass{
	text-align: center;
	width: 240px;
}

#greenBtn{
	background-color: rgb(92, 184, 92);
}

#blueBtn{
	background-color: rgb(91, 192, 222);
}

#greenBtn, #blueBtn {
	border: 1px solid white;
	border-radius: 4px;
	color: white;
	height: 25px;
	width: 90px;
}

.underLine {
	border: none;
	border-bottom: 2px solid gray;
}

</style>
	
</head>

<body>
	<jsp:include page="/Header.jsp" />

	<h2>이메일로 비밀번호 찾기</h2>
	<div class="divClass">
		<form action="./find" method = "post">
			<div class="divClass">
				이메일:	<input class = 'underLine' type="text" name="email">
			</div>
			<br>
			<div class="divClass">
				<input id='greenBtn' type="submit" value="찾기">
				<input id='blueBtn' type="button" onclick="movePageLoginFnc();"value="로그인">
				<input id="hiddenPwd" type="hidden" value="${requestScope.memberDto.password}">
			</div>
		</form>
	</div>

	<jsp:include page="/Tail.jsp" />
</body>

</html>