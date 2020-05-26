<%@page import="spms.dto.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8" >
<title>회원 수정</title>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/common.css" type="text/css">

</head>
<% 
	String a ="123";

%>
<body>
	
	<div>
	
		<jsp:include page="/Header.jsp"/>
		
		
		<form id="updateForm" action="./update" method="post">
			<table>
				<tr>
					<td>아이디(이메일)</td>		
					<td>
						<input type="text" id="inputId" value="${memberDto.email}" name='email' readonly="readonly">
						<input type="button" value="변경" onclick="checkIdFnc()">
						<input id="idChk" type="hidden" value="false">
					</td>		
				</tr>
				<tr>
					<td>닉네임</td>		
					<td>
						<input type="text" id="inputNick" value="${memberDto.nickname}" name='nickname' readonly="readonly">
						<input type="button" value="변경" onclick="checkNicknameFnc()">
						<input id="nickChk" type="hidden" value="false">
					</td>		
				</tr>
				<tr>
					<td>회원등급</td>		
					<td>
						<c:choose>
							<c:when test="${memberDto.grade eq '1'}">관리자</c:when>
							<c:when test="${memberDto.grade eq '0'}">회원</c:when>
							<c:otherwise>사장님</c:otherwise>
						</c:choose>
					</td>		
				</tr>
				<tr>
					<td>비밀번호</td>		
					<td>
						<input type="password" value="${memberDto.pwd}" name='pwd'>	
					</td>		
				</tr>
				<tr>
					<td>비밀번호 확인</td>		
					<td>
						<input type="password" value="" name='pwdChk'>	
					</td>		
				</tr>
			</table>
			<input type="hidden" value="${memberDto.no}" name='no'>			
			<input type="hidden" value="${memberDto.grade}" name='grade'>		

			<input type="button" value="수정" onclick="updateFnc(${memberDto.no})">
			<input type="button" value="삭제" onclick="deleteFnc(${memberDto.no})">
			<input type="hidden" value="" id="addBtn">
			<c:choose>
				<c:when test="${memberDto.grade eq '1'}"><input type="button" value="돌아가기" onclick="pageMoveListFnc()"></c:when>
				<c:when test="${memberDto.grade eq '0'}"><input type="button" value="돌아가기" onclick="pageMoveListFnc2()"></c:when>
				<c:otherwise><a>망했다</a></c:otherwise>
			</c:choose>
		</form>
		
		
		<jsp:include page="/Tail.jsp"/>
		
	</div>
	
	
</body>

<script type="text/javascript">
	function pageMoveListFnc(){
		location.href = './list';
	}
	function pageMoveListFnc2(){
		location.href = '../bulletin/list';
	}
	
	function deleteFnc(no) {
		const result = confirm('정말 탈퇴하시겠습니까?')
		if(result){
			location.href='./delete?no='+no;
		}else{
			return false;
		}	
	}
	function updateFnc(no) {
		var pwd = document.getElementsByName("pwd")[0];
		var pwdChk = document.getElementsByName("pwdChk")[0];
		var formObj = document.getElementById("updateForm");
		
		if(pwd.value==pwdChk.value){
			alert("수정되었습니다");
			formObj.submit();
		}else{
			alert("비밀번호가 일치하지 않습니다");
			return false;
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