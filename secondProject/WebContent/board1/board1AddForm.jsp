<%@page import="spms.dto.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>글쓰기</title>

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

<body>
<!-- 337 1번 문제 MemberAddServlet 화면출력 위임 -->
	<jsp:include page="/Header.jsp" />
	
	<div>
		<h1>글쓰기</h1>
		<form action='./add' method='post' onsubmit="return writeValiFnc()">
		
		
			<table>
				<tr>
					<td style="padding-bottom: 20px;">
						제목: 
					</td>
					
					<td>
						<input id="title" type='text' name='title' style="width: 505px; margin-bottom: 20px;">
					</td>
				</tr>

				<tr>
					<td style="vertical-align:top">
						내용:
					</td>
					<td>
						<textarea onkeyup="countNumFnc();" id="content" rows="20px" cols="70px" maxlength="300"
							 name='content' style="vertical-align: top; resize: none;"></textarea>
					</td>
				</tr>
			</table>
		
		
			<div>
				<span id="LengthSpan"></span> / 한글 300 글자
			</div>
			<input class="inputLikeButton" type='submit' value='글쓰기' style="margin-left: 470px;">
			
			<input class="inputLikeButton" type='button' value='취소' onclick="moveBoard1ListFnc();">
		</form>
	</div>
	<jsp:include page="/Tail.jsp" />
</body>
</html>