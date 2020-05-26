<%@page import="spms.dto.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8" >
<title>회원 추가</title>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/common.css" type="text/css">

</head>

<body>

	<div>
	
		<jsp:include page="/Header.jsp"/>
		
			<form id="loginForm" action="./add" method="post">
				
				<table>
					<tr>
						<td>아이디(이메일)</td>		
						<td>
							<input type="text" id="inputId" value="" name='email'>
							<input type="button" value="중복확인" onclick="checkIdFnc()">
							<input id="idChk" type="hidden" value="false">
						</td>
					</tr>
					<tr>
						<td>닉네임</td>		
						<td>
							<input type="text" id="inputNick" value="" name='nickname'>
							<input type="button" value="중복확인" onclick="checkNicknameFnc()">
							<input id="nickChk" type="hidden" value="false">
						</td>		
					</tr>
					<tr>
						<td>비밀번호</td>		
						<td><input type="password" value="" name='pwd'></td>		
					</tr>
					<tr>
						<td>비밀번호 확인</td>		
						<td><input type="password" value="" name='pwdCheck'></td>		
					</tr>
				</table>
				
				<input id="addBtn" type="button" onclick="checkFnc()" value="가입하기" disabled="disabled">
				<input type="reset" value="초기화">
				<input type="button" value="취소" onclick="pageMoveListFnc()">
				
			</form>
		
		
		
		
		<jsp:include page="/Tail.jsp"/>
		
	</div>
	
</body>

<script type="text/javascript">
	
	
	function pageMoveListFnc() {
		location.href = "./list";
	}
	
	function checkFnc() {
		var formObj = document.getElementById('loginForm');
		var email = document.getElementsByName('email')[0];
		var nickname = document.getElementsByName('nickname')[0];
		var pwd = document.getElementsByName('pwd')[0];
		var pwdCk = document.getElementsByName('pwdCheck')[0];
		
		if(email.value==""){
			alert("이메일을 입력해주세요");
			return false;
		}else if (nickname.value=="") {
			alert("닉네임을 입력해주세요");
			return false;
		}else if(pwd.value==""){
			alert("비밀번호를 입력해주세요");
			return false;
		}else if (pwd.value!=pwdCk.value) {
			alert("비밀번호가 일치하지 않습니다");
			return false;
		}else {
			alert("가입이 완료되었습니다");
			formObj.submit();
		}
		
	}
	
	var openWin = '';

	function checkIdFnc()	{

		openWin = window.open("./idcheck",
                "childForm", "width=570, height=350, resizable = no, scrollbars = no");  
		
		openWin.onload = function(){
			openWin.document.getElementById("getText").value =  document.getElementById("inputId").value;
		}

	}
	
	function checkNicknameFnc()	{
		
		openWin = window.open("./nicknamecheck",
                "childForm", "width=570, height=350, resizable = no, scrollbars = no");  
		
		openWin.onload = function(){
			openWin.document.getElementById("getText2").value =  document.getElementById("inputNick").value;
		}

	}
	
	
</script>

</html>