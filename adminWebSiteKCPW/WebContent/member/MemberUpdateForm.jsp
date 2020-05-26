<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보</title>
<link rel="stylesheet" type="text/css" 
	href="<%=request.getContextPath()%>/css/style.css">
	
<script type="text/javascript">

	function successMsgFnc() {
		alert("성공적으로 변경되었습니다!");
		return;
	}
	function backPageMoveFnc() {
		location.href= "../";
	}
	
	function pageMoveDeleteFnc(no) {
		var result = "";
		
		result = confirm("정말 탈퇴하시겠습니까?\n탈퇴 시 작성된 글은 모두 삭제됩니다.");
		
		if (result) {
			var url = "./delete?no=" + no;
			location.href = url;
		} else {
			return;
		}
		
	}
</script>
</head>

<body>
<!-- 	Dao로 가서 값가져오기 -->
	<jsp:include page="/Header.jsp"/>

	<div id='memberWrap'>
		<h1 id='pageTitle'>Update Member</h1>
	
		<form action='./update' method='post' onsubmit="successMsgFnc();">
			<label>번호</label>
			<input type='text' name='no' class='inputText'
				value='${memberDto.no}' readonly='readonly'>
			<label>이름</label>
			<input type='text' name='name' class='inputText'
				value='${memberDto.name}'>
			<label>이메일</label>
			<input type='text' name='email' class='inputText'
				value='${memberDto.email}' readonly='readonly'>
			<label>가입일</label>
			<p class='fixedValue'>${memberDto.createdDate}</p>
			<label>수정일</label>
			<p class='fixedValue'>${memberDto.modifiedDate}</p>
			
			<div id='btnsWrap'>
				<input type='submit' value='저장' class='btns'>
				<input type='button' value='탈퇴' class='btns' 
					onclick="pageMoveDeleteFnc(${memberDto.no});">
				<input type='button' value='뒤로' class='btns'
					onclick="backPageMoveFnc();">
			</div>
		</form>
	</div>
	
	<jsp:include page="/Tail.jsp"/>

</body>
</html>