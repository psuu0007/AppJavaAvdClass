<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>회원 목록</title>

<style type="text/css">
table {
	border-collapse: collapse;
}

table, tr, th, td{
	border: 1px solid black;
}

</style>

</head>

<body>
	<jsp:include page="/WEB-INF/views/Header.jsp" />
	<h1>회원목록</h1>
	<div>
		<a href='./add.do'>회원가입</a>
	</div>

	<form action="./list.do" method="post">
		<select name='searchOption'>
		<c:choose>
			<c:when test="${searchMap.searchOption eq 'all'}">
				<option value="all" selected="selected">이름+이메일</option>
				<option value="name">이름</option>
				<option value="email">이메일</option>
			</c:when>
			
			<c:when test="${searchMap.searchOption eq 'name'}">
				<option value="all">이름+이메일</option>
				<option value="name" selected="selected">이름</option>
				<option value="email">이메일</option>
			</c:when>

			<c:when test="${searchMap.searchOption eq 'email'}">
				<option value="all">이름+이메일</option>
				<option value="name">이름</option>
				<option value="email" selected="selected">이메일</option>
			</c:when>
		</c:choose>
		</select>
		<input type="text" name="keyword" value="${searchMap.keyword}">
		<input type="submit" value="검색">
	</form>	
	
	<table>
		<tr>
			<th>번호</th><th>회원이름</th>
			<th>이메일</th><th>가입일</th>
			<th>첨부파일명</th><th></th>
		</tr>
	
	<c:choose>
		<c:when test="${empty memberList}">
			<tr>
				<td colspan="6" style="text-align: center;">
					등록된 게시글이 없습니다.
				</td>
			</tr>
		</c:when>
		<c:otherwise>
			<c:forEach var="memberDto" items="${memberList}">
			<tr>
				<td>${memberDto.no}</td>
				<td>
					<a href='./listOne.do?no=${memberDto.no}'>
						${memberDto.name}
					</a>
				</td>
				<td>${memberDto.email}</td>
				<td>
					<fmt:formatDate value="${memberDto.createdDate}" 
						pattern="yyyy년MM월dd일 hh시mm분"/>
				</td>
				
				<c:if test="${empty memberDto.originalFileName}" var="fileFlag">
					<td>첨부파일 없음</td>			
				</c:if>
				<c:if test="${fileFlag eq false}">
					<td>${memberDto.originalFileName}</td>			
				</c:if>
				
				<td>
					<a href='./deleteCtr.do?no=${memberDto.no}'>[삭제]</a>
				</td>
			</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
		
	
	</table>
	
	
	<jsp:include page="/WEB-INF/views/common/paging.jsp">
		<jsp:param value="${pagingMap}" name="pagingMap"/>
	</jsp:include>
	
	<form action="./list.do" id='pagingForm' method="get">
		<input type="hidden" id='curPage' name='curPage' 
			value="${pagingMap.memberPaging.curPage}">
	</form>
	
	
	<jsp:include page="/WEB-INF/views/Tail.jsp" />
</body>
</html>