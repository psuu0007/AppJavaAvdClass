<%@page import="spms.dto.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>글읽기</title>

<style type="text/css">

	tr{
	
		height: 40px;
	
	}

	.inputLikeButton {
		border: none;
		background-color: #DAD9FF;
		border-radius: 4px;
		margin-top: 20px;
	}
	.inputLikeButton:hover {
		background-color: #4B58E3;
	}
	
	a:link {text-decoration: none; color: black;}
	a:visited {text-decoration: none; color: black;}
	a:active {text-decoration: none; color: black;}
	a:hover {text-decoration: none; color: #4B58E3;}

</style>
<script type="text/javascript">
	
	function moveBoard1ListFnc() {
		
		location.href = "./list?pageNo=1";
	}

	function moveUpdateFnc() {
		
		location.href = "./update?no=" + ${requestScope.board1Dto.no};
	}
	
</script>

</head>

<jsp:useBean 
	id="board1Dto"
	scope="request"
	class="spms.dto.Board1Dto"
/>



<body>
<!-- 337 1번 문제 MemberAddServlet 화면출력 위임 -->
	<jsp:include page="/Header.jsp" />
	
	<div>
		<h2>글 읽기</h2>
	</div>
		
		<table>
			<tr>
				<td style="width: 70px;">
					작성자 :
				</td>
				<td style="width: 600px;">
					${requestScope.board1Dto.writer}
				</td>
			</tr>
			<tr>
				<td>
					제목 :
				</td>
				<td>
					${requestScope.board1Dto.title}
				</td>
			</tr>
			<tr>
				<td>
					내용 :
				</td>
				<td>
					${requestScope.board1Dto.contents}
				</td>
			</tr>
		 	<tr>
			 	<td></td>
			 	<td style="text-align: right;">
					<input class="inputLikeButton" type='button' value='뒤로가기' onclick="moveBoard1ListFnc();">
			 		<c:if test="${requestScope.board1Dto.writerEmail eq sessionScope.memberDto.email || sessionScope.memberDto.adminCheck eq 'Y'}">
						<input class="inputLikeButton" type='button' value='글 수정' onclick="moveUpdateFnc();">
					</c:if>
			 	</td>
		 	</tr>
		</table>
			
	<jsp:include page="/Tail.jsp" />
</body>
</html>