<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
</style>

<script type="text/javascript">
	function requestJoinInfoFnc() {
		location.href = './getJoinInfo.jsp?userId1=sdf&userPwd1=ssfd';
	}
</script>

</head>

<body>
	<div style="border: 1px solid black;">
		<form action="./getJoinInfo.jsp">
			<div>
				<input type="text" id='userId' name="userId1" value="">
			</div>
			<div>
				<input type="text" id='userPwd' name="userPwd1" value="">
			</div>
			<div>
				<input type="submit" value="data 전달">
			</div>
		</form>
	</div>

	<div style="border: 1px solid black;">
		<form action="./getJoinInfo.jsp">
			<div>
				<input type="text" id='userId' name="userId1" value="">
			</div>
			<div>
				<input type="text" id='userPwd' name="userPwd1" value="">
			</div>
			<div>
				<img onclick="requestJoinInfoFnc();"
					src="./img/img1.jpg" alt="활용법">
			</div>
		</form>
	</div>
</body>
</html>






