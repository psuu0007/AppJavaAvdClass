<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>게시판 상세 페이지</title>
<link rel="stylesheet" type="text/css" 
	href="<%=request.getContextPath()%>/css/style.css">

<script type="text/javascript">
	function moveListFnc() {
		location.href="./list";
	}
	
	function deleteFnc(no){
		if(confirm('삭제하시겠습니까?')){
			location.href="./delete?no="+no;
		}
	}
	
</script>

</head>

<body>

	<jsp:include page="/Header.jsp"/>
	
	<div id='viewWrap'>
		<h1 id='pageTitle'>View Post</h1>
	<!--  상세페이지에 제목 작성자 내용 등록일 수정일  -->
	
		<form action="./detail" method="post">
			<input type="hidden" name="no" value="${boardDto.getBoardNo()}">
			<table id='viewTable'>
				<colgroup>
					<col width="20%">
					<col width="80%">
				</colgroup>
				<tr>
					<td class='th'>제목</td>
					<td colspan='3'>${boardDto.getTitle()}</td>
				</tr>
				<tr>
					<td class='th'>내용</td>
					<td colspan='3'>${boardDto.getContent()}</td>
				</tr>
				<tr>
					<td class='th'>작성자</td>
					<td>${boardDto.getMyName()}</td>
				</tr>
				<tr>
					<td class='th'>등록일</td>
					<td>${boardDto.getCreatedDate()}</td>
				</tr>
				<tr>
					<td class='th'>수정일</td>
					<td>${boardDto.getModifiedDate()}</td>
				</tr>
			</table>
			
			<div id='btnsWrap'>
				<c:if test='${memberDto.email == boardDto.email}'>
					<input type="submit" value="수정" class='btns'>
				</c:if>	
				<c:if test='${memberDto.email == boardDto.email || memberDto.grade == "admin"}'>
					<input type="button" value="삭제" class='btns' onclick="deleteFnc(${boardDto.getBoardNo()});">
				</c:if>	
				<input onclick="moveListFnc();" type="button" 
					class='btns' value="목록">
			</div>		
		</form>
	</div>
	
	<jsp:include page="/Tail.jsp"/>

</body>

</html>