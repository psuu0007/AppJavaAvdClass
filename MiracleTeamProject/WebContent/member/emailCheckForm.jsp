<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/custom.css?ver=1.2" />
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�̸��� �ߺ�üũ</title>

<script type="text/javascript">
	// ȸ������â�� ���̵� �Է¶��� ���� �����´�.
	function pValue() {
		document.getElementById("userEmail").value = opener.document.userInfo.email.value;
	}
</script>

</head>
<body onload="pValue()">
	<div id="wrap">
		<br> <b><font size="4" color="gray">�̸��� �ߺ�üũ</font></b> <br>
		<div id="chk">
			<form id="checkForm" method="post" action="emailCheckProc.jsp">
				<input type="text" name="email" id="userEmail" class="EmailInput"
					maxlength="20" autofocus placeholder="�̸����� �Է����ּ���">
				<div class="btnBox">
					<input class="submitBtn" type="submit" value="�ߺ�Ȯ��"> 
					<input class="cancelBtn" type="button" value="���" onclick="window.close()">
				</div>
		</form>
		</div>
	</div>
</body>
</html>


