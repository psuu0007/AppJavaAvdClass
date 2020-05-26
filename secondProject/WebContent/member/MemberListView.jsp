<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
</head>
<style type="text/css">
button{
	border: 1px solid black;
	width: 150px;
	margin-right: 100px;
	border-radius: 2px;
	box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2), 
		0 6px 20px 0 rgba(0,0,0,0.19);
}
a {
	text-decoration: none;
}
table {
	width: 700px;
    border-collapse: collapse;
}
th, td {
    border-top: 1px solid #444444;
    padding: 10px;
    border-color: #DAD9FF;
}
#trHead {
	font-weight: bold;
	font-size: 15px;
	text-align: center;
	color: #4B58E3;
}
.listBtn {
	text-align: center;
}
</style>
<script type="text/javascript">

</script>
<body>

	<jsp:include page="/Header.jsp" />
	
	<c:if test="${sessionScope.memberDto.adminCheck eq 'N'}">
		<h1>게시판 선택 페이지</h1>
	</c:if>
	<c:if test="${sessionScope.memberDto.adminCheck eq 'Y'}">
	
		<h1>관리자 페이지</h1>
		<p>
			
			<input type="button" onclick="location.href = './add'" value="신규회원" style="border: none;
			background-color: rgb(255,243,235); border-radius: 4px; width:100px; height: 30px; 
			color: black; font-weight: bold; cursor: pointer;">
			
		</p>
		<table>
			<tr id='trHead'>
				<td style="text-align: left; 
					border-top: 1px solid white;">회원번호</td>
				<td style="border-top: 1px solid white;">회원이름</td>
				<td style="border-top: 1px solid white;">회원이메일</td>
				<td style="border-top: 1px solid white;">가입날짜</td>
				<td style="border-top: 1px solid white;">관리버튼</td>
			</tr>
			<c:forEach var="memberDto" items="${memberList}">
				<tr>
					<td>${memberDto.no}</td>
					<td class="listBtn">${memberDto.name}</td>
					<td class="listBtn">${memberDto.email}</td>
					<td class="listBtn">${memberDto.createDate}</td>
					<td class="listBtn">
						<a href='./delete?no=${memberDto.no}'>
							<input type='button' value='삭제'>
						</a>
						<a href='./update?no=${memberDto.no}'>
							<input type='button' value='수정'>
						</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	
	<br>
	
		<c:if test="${sessionScope.memberDto.adminCheck eq 'N'}">
				
			<div>
				<img onclick="listPageMoveFnc();" alt="아구몬 안녕" src="<%=request.getContextPath()%>/img/agumon.png">
			</div>
				
		</c:if>	
	
		<a href="<%=request.getContextPath()%>/board1/list?pageNo=1" style="margin-right: 50px; text-decoration: none;">
			<input type="button" value="게시판1" 
				style="border: none; background-color: #5CB85C; color: white; 
				width: 200px; height: 50px; border-radius: 7px; margin-top: 10px; cursor: pointer;" >
		</a>
		<a href="<%=request.getContextPath()%>/board2/list" style="margin-right: 50px; text-decoration: none;">
			<input type="button" value="게시판2"
				style="border: none; background-color: #5BC0DE; color: white;
				 width: 200px; height: 50px;  border-radius: 7px; cursor: pointer;">
		</a>
		<a href="<%=request.getContextPath()%>/notice/list" text-decoration: none;>
			<input type="button" value="공지사항" 
				style="border: none; background-color: #F0AD4E; color: white; 
				width: 200px; height: 50px; border-radius: 7px; cursor: pointer;">
		</a>
			
	<jsp:include page="/Tail.jsp" />
	
</body>
</html>