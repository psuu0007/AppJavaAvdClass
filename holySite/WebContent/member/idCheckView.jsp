<%@page import="spms.dto.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>아이디 중복체크</title>
</head>


<body>
	<br>
    <b><font size="5" color="#4782A4">이메일(ID) 중복체크</font></b>
    <br><br>
 	
 	<form id="checkId" action="./idcheck" method="post">
    <input type="text" id="getText" name="email" value="${email}">
    <input type="submit" value="중복체크">
	<div id="notice">
		<c:choose>
			<c:when test="${cnt == 0}"><a style="color: blue;">사용가능한 아이디입니다</a></c:when>
			<c:when test="${cnt == 1}"><a style="color: red;">중복된 아이디입니다</a></c:when>
			<c:otherwise>아이디를 입력해 주세요</c:otherwise>
		</c:choose>
	</div>
    </form>
    <br><br>
    	<c:choose>
			<c:when test="${cnt == 0}"><input type="button" id="useBtn" value="사용하기" onclick="inputIdFnc();"></c:when>
			<c:when test="${cnt == 1}"><input type="button" id="useBtn" value="사용하기" onclick="inputIdFnc();" disabled="disabled"></c:when>
			<c:otherwise><input type="button" id="useBtn" value="사용하기" onclick="inputIdFnc();" disabled="disabled"></c:otherwise>
		</c:choose>
    
    <input type="button" value="창닫기" onclick="window.close()">  


	
	
	
</body>

<script type="text/javascript">
	

	function inputIdFnc() {
		
		var parentObj = window.opener.document; 
		parentObj.getElementById("inputId").value = document.getElementsByName("email")[0].value;
		parentObj.getElementById("idChk").value = true;
		
		if(parentObj.getElementById("idChk").value == 'true' 
				&& parentObj.getElementById("nickChk").value == 'true'){
			parentObj.getElementById("addBtn").disabled = false;
		}
		
		window.close()
	}
	
// 	function rockDownFnc(){
		
// 		document.getElementsByName("email")[0].disabled=true;
		
// 		var formObj = document.getElementById('loginForm');
// 		formObj.submit();
// 	}

</script>

</html>