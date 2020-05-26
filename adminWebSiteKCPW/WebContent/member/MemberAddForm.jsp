<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>회원 등록</title>
<link rel="stylesheet" type="text/css" 
	href="<%=request.getContextPath()%>/css/style.css">

<script type="text/javascript">
	

// 	function validationChk() {
// 		var nameObj = document.getElementById('name');
// 		var emailObj = document.getElementById('email');
// 		var passwordObj = document.getElementById('password');
		
// 		if (nameObj.value == '') {
// 			alert("이름을 입력해주세요.");
// 			nameObj.focus();
// 			return false;
// 		} else if (emailObj.value == '') {
// 			alert("이메일을 입력해주세요.");
// 			emailObj.focus();
// 			return false;
// 		}else if(passwordObj.value == '') {
// 			alert("비밀번호를 입력해주세요.");
// 			passwordObj.focus();
// 			return false;
// 		}
// 		return;
// 	}

	function validationChk() {
		var nameObj = document.getElementsByName('name')[0];
		var emailObj = document.getElementsByName('email')[0];
		var passwordObj = document.getElementsByName('password')[0];
		
		if (nameObj.value == '') {
			alert("이름을 입력해주세요.");
			nameObj.focus();
			return false;
		} else if (emailObj.value == '') {
			alert("이메일을 입력해주세요.");
			emailObj.focus();
			return false;
		}else if(passwordObj.value == '') {
			alert("비밀번호를 입력해주세요.");
			passwordObj.focus();
			return false;
		}
		
		alert('회원가입에 성공하셨습니다.');
		return;
	}

	function toHomeFnc() {
		location.href='../';
	}
	
	
</script>
</head>

<body>

	<jsp:include page="/Header.jsp" />

	<div id='memberWrap'>
		<h1 id='pageTitle' id='addForm'>Add Member</h1>
		<form action='./add' method='post' onsubmit="return validationChk();">
			<label>이름</label>
			<input type='text' name='name' class='inputText'>
			<label>이메일</label>
			<input type='text' name='email' class='inputText'>
			<label>암호</label>
			<input type='password' name='password' class='inputText'>
			<div id='btnsWrap'>
				<input type='submit' value='추가' class='btns'>
				<input type='reset' value='초기화' class='btns'>
				<input type='button' onclick="toHomeFnc();" value='뒤로' class='btns'>
					
			</div>
		</form>
	</div>
	
	<jsp:include page="/Tail.jsp" />
	
</body>
</html>