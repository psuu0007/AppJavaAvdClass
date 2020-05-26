<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/custom.css?ver=1.6" />
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>비밀번호 찾기</title>

</head>
<body>
	<div id="wrap">
		<br> <b><font size="4" color="gray">비밀번호 찾기</font></b> <br>
		<div id="chk">
			<form id="checkForm" method="post" action="FindPwdProc.jsp">
				<input type="text" name="email" id="userEmail" class="EmailInput"
					maxlength="20" autofocus placeholder="이메일을 입력해주세요">
				<div class="btnBox">
					<input class="submitBtn" type="submit" value="비번찾기"> 
					<input class="cancelBtn" type="button" value="취소"
						onclick="window.close()">
				</div>
			</form>
		</div>
	</div>
</body>
</html>


