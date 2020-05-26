<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>게시글 쓰기</title>
<link rel="stylesheet" type="text/css" 
	href="<%=request.getContextPath()%>/css/style.css">

<script type="text/javascript">
	function toListFnc() {
		location.href="./list";
	}
	
	function validationChk() {
		var titleInput = document.getElementById('titleInput');
		var contTxtarea = document.getElementById('contTxtarea');
		
		if(titleInput.value == ''){
			alert('제목을 작성해주세요.');
			titleInput.focus();
			return false;
		} else if(contTxtarea.value == ''){
			alert('내용을 작성해주세요.');
			contTxtarea.focus();
			return false;
		}
		
		if(confirm('게시글을 올리겠습니까?')){
			return;
		} else {
			return false;
		}
	}
</script>

</head>

<body>

	<jsp:include page="/Header.jsp" />

	<div id='viewWrap'>
		<h1 id='pageTitle'>Write Post</h1>
	
		<form action="./add" method="post" onsubmit="return validationChk();">
			<table id='viewTable'>
				<colgroup>
					<col width="20%">
					<col width="80%">
				</colgroup>
				<tbody>
					<tr>
						<td class='th'>제목</td>
						<td class='td'>
							<input type="text" name="title" id='titleInput'
								value="${titleStr}">
						</td>
					</tr>
					<tr>
						<td class='th'>내용</td>
						<td class='td'>
							<textarea rows="10" cols="30" name="content"
								id='contTxtarea'>${contentStr}</textarea>
						</td>
					</tr>
				</tbody>
			</table>
			
			<div id='btnsWrap'>
				<input type="submit" class='btns' value="글쓰기">
				<input type="reset" class='btns' value="초기화">
				<input type="button" class='btns' 
					value="뒤로" onclick='toListFnc();'>
			</div>
		</form>
	</div>
	
	<jsp:include page="/Tail.jsp" />
	
</body>

</html>