<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>게시글 쓰기</title>
<link rel="stylesheet" type="text/css" 
	href="<%=request.getContextPath()%>/css/style.css">

<script type="text/javascript">
	function validationChk() {
		var titleInput = document.getElementsByName('title')[0];
		var contentInput = document.getElementsByName('content')[0];

		if (titleInput.value == "") {
			alert('제목을 입력하세요');
			titleInput.focus();
			return false;
		}

		else if (contentInput.value == "") {
			alert('내용을 입력하세요');
			contentInput.focus();
			return false;
		}
		return;
	}
	
	function toListFnc() {
		location.href="./list";
	}
</script>
</head>
<body>

	<jsp:include page="/Header.jsp"/>
	
	<div id='viewWrap'>
		<h1 id='pageTitle'>Write Post</h1>
			
		<form action="./add" method="post" onsubmit="return validationChk();">
			<input type="hidden" name="email" value="${memberDto.email}">
			<table id='viewTable'>
				<colgroup>
					<col width="20%">
					<col width="80%">
				</colgroup>
				<tbody>
					<tr>
						<td class='th'>제목</td>
						<td class='td'>
							<c:if test="${title != ''}">
								<input type="text" name="title" value="${title}">
							</c:if>
							<c:if test="${title == ''}">
								<input type="text" name="title" value="">
							</c:if>
						</td>
					</tr>
					<tr>
						<td class='th'>내용</td>
						<td class='td'>
							<c:if test="${content != ''}">
								<textarea rows="10" cols="30" name="content">${content}</textarea>							
							</c:if>
							<c:if test="${content == ''}">
								<textarea rows="10" cols="30" name="content"></textarea>							
							</c:if>
							
						</td>
					</tr>
					<tr>
						<td class='th'>작성자</td>
						<td class='td'>
							<input type="text" name="name" class="readonly"
								value="${memberDto.name}" readonly="readonly">
						</td>
					</tr>
				</tbody>
			</table>
			
			<div id='btnsWrap'>
				<input type="submit" value="글쓰기" class='btns'>
				<input type="reset" value="초기화" class='btns'>
				<input type="button" class='btns' value="뒤로" onclick='toListFnc();'>
			</div>		
		</form>
	</div>
	
	<jsp:include page="/Tail.jsp"/>

</body>
</html>