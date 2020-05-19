<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>회원정보</title>

<script type="text/javascript">
	function pageMoveListFnc() {
		location.href = './list';
	}
	
	function pageMoveDeleteFnc(no) {
		var url = "./delete?no=" + no;
		location.href = url;
	}
</script>

</head>

<body>
<jsp:include page="/Header.jsp" />
	
	<h1>회원정보</h1>
	<form action='./update' method='post'>
		번호: <input type='text' name='no' value='${memberDto.no}' 
				readonly><br>
		이름: <input type='text' name='name'	value='${memberDto.name}'>
		<br>
		이메일: <input type='text' name='email' 
			value='${memberDto.email}'>
		<br>
		가입일: ${requestScope.memberDto.createDate}
		<br>
		<input type='submit' value='저장'>
		<input type='button' value='삭제' 
			onclick='pageMoveDeleteFnc(${memberDto.no});'>
		<input type='button' value='취소' onClick='pageMoveListFnc();'>	
	</form>
	
	<jsp:include page="/Tail.jsp" />

</body>

</html>