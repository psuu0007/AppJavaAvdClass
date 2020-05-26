<%@page import="spms.dto.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>회원정보 수정</title>

<script type="text/javascript">
	function pageMoveListFnc(){
		location.href = "./list";
	}
	
	function pageMoveDeleteFnc(no){
		var url = "./delete?no=" + no;
		location.href = url;
	}
</script>

<style type="text/css">
	tr, td {
		height: 30px; 
		width: 100px;
	}
	.tdBtn {
		text-align: center;
		margin-left: 20px;
		width: 60px;
	}
	.underLine {
		border: none;
		border-bottom: 2px solid gray;
		text-align: center;
	}
	#greenBtn{
   background-color: rgb(92, 184, 92);
	}

	#blueBtn{
	   background-color: rgb(91, 192, 222);
	}
	
	#orangeBtn{
	   background-color: rgb(240, 173, 78);
	}

	#greenBtn, #blueBtn, #orangeBtn {
	   border: 1px solid white;
	   border-radius: 4px;
	   color: white;
	   height: 25px;
	   width: 65px;
	}
	
</style>
</head>

<body>
<!-- 337 3번 문제 MemberUpdateServlet 화면출력 위임 -->
	<jsp:include page="/Header.jsp" />
	
	<h1>회원정보</h1>
	<form action='./update' method='post'>
		<table>
			<tr>
				<td>
					번&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;호&nbsp;&nbsp;&nbsp;&nbsp;:
				</td>
				<td class="inputText">
					<input class="underLine" type='text' name='no' value='${memberDto.no}' readonly><br>
				</td>
			</tr>	
			<tr>
				<td>
					이&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;름&nbsp;&nbsp;&nbsp;&nbsp;: 
				</td>
				<td>
					<input class="underLine" type='text' name='name' value='${memberDto.name}' readonly><br>
				</td>
			</tr>	
			<tr>
				<td>
					이&nbsp;메&nbsp;일&nbsp;&nbsp;&nbsp;&nbsp;: 
				</td>
				<td>
					<input class="underLine" type='text' name='email' value='${memberDto.email}'><br>
				</td>
			</tr>	
			<tr>
				<td class='td'>
					비밀번호&nbsp;&nbsp;&nbsp;: 
				</td>
				<td>
					<input class="underLine" type='password' name='password'><br>
				</td>
			</tr>	
			<tr>
				<td>
					가&nbsp;입&nbsp;일&nbsp;&nbsp;&nbsp;&nbsp;: 
				</td>
				<td class="underLine">
					${requestScope.memberDto.createDate}<br>
				</td>
			</tr>
			<tr>
				<td colspan="3">
					<br>
					<input id="greenBtn" class='tdBtn' type='submit' value='저장'>
					<input id="blueBtn" class='tdBtn' type='button' value='삭제' 
						onclick='pageMoveDeleteFnc(${memberDto.no});'>
					<input id="orangeBtn" class='tdBtn' type='button' value='취소' onClick='pageMoveListFnc();'>
				</td>
			</tr>			
		</table>
	</form>
	
	<jsp:include page="/Tail.jsp" />
</body>
</html>