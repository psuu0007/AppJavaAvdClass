<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/custom.css?ver=1.6" />
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>��й�ȣ ã��</title>

</head>
<body>
	<div id="wrap">
		<br> <b><font size="4" color="gray">��й�ȣ ã��</font></b> <br>
		<div id="chk">
			<form id="checkForm" method="post" action="FindPwdProc.jsp">
				<input type="text" name="email" id="userEmail" class="EmailInput"
					maxlength="20" autofocus placeholder="�̸����� �Է����ּ���">
				<div class="btnBox">
					<input class="submitBtn" type="submit" value="���ã��"> 
					<input class="cancelBtn" type="button" value="���"
						onclick="window.close()">
				</div>
			</form>
		</div>
	</div>
</body>
</html>


