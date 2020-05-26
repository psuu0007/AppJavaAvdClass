<%@page import="spms.dto.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>글 수정</title>

<style type="text/css">

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
	
	window.onload = function() {
		
		var content = document.getElementById('content');
		
		var contentLength = content.value.length;
		
		var LengthSpan = document.getElementById('LengthSpan');
		
		LengthSpan.innerHTML = contentLength + '글자';
		
		
	}
	
	function moveBoard1ListFnc() {
		
		location.href = "./list?pageNo=1";
	}

	function moveDeleteFnc() {
		
		location.href = "./delete?no=" + ${requestScope.board1Dto.no};
		
	}
	
	
	function countNumFnc(){
		
		var content = document.getElementById('content');
		
		var contentLength = content.value.length;
		
		var LengthSpan = document.getElementById('LengthSpan');
		
		LengthSpan.innerHTML = contentLength + '글자';
	}
	
	function writeValiFnc() {
		
		var title = document.getElementById('title');
		
		var content = document.getElementById('content');
	
		if(title.value == '' || content.value == ''){
			alert('제목 또는 내용을 입력해 주세요');
			return false;
		}
		
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
		<h2>글 수정</h2>
		<form action='./update' method='post' onsubmit="return writeValiFnc()">
		
			<table>
				<tr>
					<td>
						제목: 
					</td>
					<td>
						<input type='text' name='title' id="title" value='${requestScope.board1Dto.title}'>
					</td>
				</tr>
				
				<tr>
					<td style="vertical-align:top">
						내용: 
					</td>
					<td>
						<textarea onkeyup="countNumFnc();" rows="20px" cols="70px" id="content"  name='content' style="vertical-align: top;">${requestScope.board1Dto.contents}</textarea>
					</td>
				</tr>
				
			</table>
		
		
			<div style="text-align: right; width: 600px;">
				<span id="LengthSpan"></span> / 한글 300 	글자
				
			</div>
			<input class="inputLikeButton" type='submit' value='완료' style="margin-left: 470px;">
			<input class="inputLikeButton" type='button' value='삭제' onclick="moveDeleteFnc();">
			<input class="inputLikeButton" type='button' value='취소' onclick="moveBoard1ListFnc();">



			<input type="hidden" name='no' readonly="readonly" value='${requestScope.board1Dto.no}' style="display:none; ">
		</form>
	</div>
	<jsp:include page="/Tail.jsp" />
</body>
</html>