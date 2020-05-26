<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>회원정보수정</title>
<style type="text/css">
	#mainWrap {
		width: 1000px;
		height: 600px;
		margin: auto;
	}
	div {
		width: 1000px;
		margin: auto;
	}
	
	h1 {
		color: grey;
	}

</style>
<script type="text/javascript">
	function pageMoveListFnc(){
		location.href = "../noticeBoard/list";
	}
	
	function pageMoveMemberListFnc() {
		location.href = "../noticeBoard/list";
	}
	
	function pageMoveCheckListFnc() {
		location.href = "./list"
	}
	
	function pageMoveDeleteFnc(no){
		var url = "./delete?mmNo=" + no;
		location.href = url;
	}
</script>
</head>

<body>
	<jsp:include page="../common/Header.jsp"/>
	<div id="mainWrap">
		<br>
			<h1 style="margin: 0px 25px;">회원정보</h1>
		<br>
		<form style="margin-left: 25px;" action='./update' method='post'>
			<c:if test="${adminDto != null}">
				번&emsp;&emsp;호: <input type='text' name='adNo' value='${adminDto.no}' readonly><br>
				이&emsp;&emsp;름: <input type='text' name='name' value='${adminDto.name}' readonly><br>
				이&nbsp;메&nbsp;&nbsp;일: <input type='text' name='email' value='${adminDto.email}' readonly><br>
				비밀번호: <input type='text' name='password' value='${adminDto.password}'><br>
				<input type='submit' value='저장'>
				<input type='button' value='취소' onClick='pageMoveListFnc();'>	
	<!-- 		</form> -->
			</c:if>
			<c:if test="${memberDto != null}">
	<!-- 		<form action='./update' method='post'> -->
				번&emsp;&emsp;호: <input type='text' name='mmNo' value='${memberDto.no}' readonly><br>
				이&emsp;&emsp;름: <input type='text' name='name' value='${memberDto.name}' readonly><br>
				이&nbsp;메&nbsp;&nbsp;일: <input type='text' name='email' value='${memberDto.email}' readonly><br>
				비밀번호: <input type='text' name='password' value='${memberDto.password}'><br>
				<input type='submit' value='저장'>
				<input type='button' value='삭제' onclick='pageMoveDeleteFnc(${memberDto.no});'>
			</c:if>
			<c:if test="${member.email != 'admin'}">
				<input type='button' value='취소' onClick='pageMoveMemberListFnc();'>	
			</c:if>
			<c:if test="${member.email == 'admin' && memberDto != null}">
				<input type='button' value='취소' onClick='pageMoveCheckListFnc();'>	
			</c:if>
		</form>
	</div>
	<jsp:include page="../common/Bottom.jsp"/>

</body>

</html>