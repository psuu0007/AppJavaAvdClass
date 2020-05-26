<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>로그인</title>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/common.css" type="text/css">

</head>

<body>
	<div>
		<jsp:include page="/Header.jsp"/>
		<form action="./login" method="post">
			<h2>로그인</h2>
			<table>
				<tr>
					<td>이메일</td>
					<td><input type="text" name="email"></td>
				</tr>
				<tr>
					<td>암호</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td style="text-align:center;" colspan="2">
						<input type="submit" value="로그인">
						<input type="button" onclick="pageMoveAddMember();" value="회원가입">		
					</td>
				</tr>
			</table>
		</form>
		<jsp:include page="/Tail.jsp"/>
	</div>
</body>

<script type="text/javascript">
	function pageMoveAddMember(){
		location.href = "../member/add";
	}
</script>

</html>
