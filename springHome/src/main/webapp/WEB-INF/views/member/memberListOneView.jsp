<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<title>회원정보 상세조회</title>

<script type="text/javascript">
	function pageMoveListFnc(){
		location.href = "./list.do";
	}
		
</script>

</head>

<body>
	<jsp:include page="/WEB-INF/views/Header.jsp" />
	
	<h1>회원정보 상세조회</h1>
	<form action='./update.do' method='get'>
		번호: ${memberDto.no}
		<br>
		이름: ${memberDto.name}
		<br>
		이메일: ${memberDto.email}
		<br>
		
		첨부파일:
		<c:choose>
			<c:when test="${empty fileList}">
				첨부파일이 없습니다.<br>
			</c:when>
			<c:otherwise>
				<c:forEach var="row" items="${fileList}">
<!-- 					<input type="button" value="이미지" name="file"> -->
					${row.ORIGINAL_FILE_NAME}
					(${row.FILE_SIZE}KB)<br>
					<img alt="image not found" 
						src="<c:url value='/img/${row.STORED_FILE_NAME}'/>">
					<br>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		
		가입일: <fmt:formatDate value="${memberDto.createdDate}" 
			pattern="yyyy-MM-dd hh:mm"/> 
		<br>
		<div>
			<input type="hidden" name="no" value="${memberDto.no}">
		</div>
		<div>
			<input type='submit' value='수정하기 페이지'>
			<input type='button' value='이전 페이지' 
				onclick='pageMoveListFnc();'>
		</div>
	</form>
	
	<jsp:include page="/WEB-INF/views/Tail.jsp" />
</body>
</html>