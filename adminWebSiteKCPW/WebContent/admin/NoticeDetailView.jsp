<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>게시글 상세보기</title>
<link rel="stylesheet" type="text/css" 
	href="<%=request.getContextPath()%>/css/style.css">

</head>

<body>

	<jsp:include page="/Header.jsp" />

	<div id='viewWrap'>
		<h1 id='pageTitle'>View Post</h1>
		
		<table id='viewTable'>
			<colgroup>
				<col width="20%">
				<col width="80%">
			</colgroup>
			<tbody>
				<tr>
					<td class='th'>제목</td>
					<td class='td'>
						${noticeDto.title}
					</td>
				</tr>
				<tr>
					<td class='th'>내용</td>
					<td class='td'>
						${noticeDto.content}
					</td>
				</tr>
				<tr>
					<td class='th'>작성자</td>
					<td class='td'>
						${noticeDto.myName}
					</td>
				</tr>
				<tr>
					<td class='th'>등록일</td>
					<td class='td'>${noticeDto.createdDate}</td>
				</tr>
			</tbody>
		</table>
		
		<div id='btnsWrap'>
			<c:if test="${memberDto.getGrade() == 'admin'}">
				<a href="./update?noticeNo=${noticeDto.noticeNo}" class='btns'>
					수정
				</a>
			</c:if>
			<a href="./list" class='btns'>목록</a>
		</div>
	
	</div>
	
	<jsp:include page="/Tail.jsp" />
	
</body>

</html>