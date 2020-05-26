<%@page import="spms.dto.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>회원 등록</title>
<style type="text/css">
table {
	width: 300px;
    border-collapse: collapse;
}
tr, td {
		height: 30px; 
		width: 100px;
}
.underLine {
	border: none;
	border-bottom: 2px solid gray;
	text-align: center;
}
#greenBtn{
   background-color: rgb(92, 184, 92);
}

#orangeBtn{
   background-color: rgb(240, 173, 78);
}
#greenBtn, #orangeBtn {
   border: 1px solid white;
   border-radius: 4px;
   color: white;
   height: 25px;
   width: 100px;
   margin-left: 20px;
}
</style>
</head>
<body>
<!-- 337 1번 문제 MemberAddServlet 화면출력 위임 -->
<jsp:include page="/Header.jsp" />
	
	<h1>회원등록</h1>
	<form action='./add' method='post'>
		<table>
			<tr>
				<td>
					이&nbsp;&nbsp;&nbsp;름&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: 
				</td>
				<td>
					<input class='underLine' type='text' name='name'><br>
				</td>
			</tr>	
			<tr>
				<td>
					이메일&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: 
				</td>
				<td>
					<input class='underLine' type='text' name='email'><br>
				</td>
			</tr>	
			<tr>
				<td>
					암&nbsp;&nbsp;&nbsp;호&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: 
				</td>
				<td>
					<input class='underLine' type='password' name='password'><br><br>
				</td>
			</tr>	
			<tr>
				
				<td colspan="2">
					<input class="btn" id="greenBtn" type='submit' value='추가'>
					
					<c:if test="${sessionScope.memberDto ne null}">
						<input class="btn" id="orangeBtn" type='button' value='취소' onclick="location.href='./list'">
					</c:if>
					
					<c:if test="${sessionScope.memberDto eq null}">
						<input class="btn" id="orangeBtn" type='button' value='취소' onclick="location.href='<%=request.getContextPath()%>/auth/login'">
					</c:if>
					
				</td>
			</tr>	
		</table>
	</form>
	
	
	<jsp:include page="/Tail.jsp" />
</body>
</html>