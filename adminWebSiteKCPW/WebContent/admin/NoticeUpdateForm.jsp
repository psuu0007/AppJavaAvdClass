<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>게시글 상세보기</title>
<link rel="stylesheet" type="text/css" 
	href="<%=request.getContextPath()%>/css/style.css">

<script type="text/javascript">

	function deletePostFnc(noticeNo) {
		if(confirm("삭제하시겠습니까?")){
			location.href = "./delete?noticeNo=" + noticeNo;
		}
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
		
		if(confirm('수정하시겠습니까?')){
			return;
		} else{
			return false;
		}
	}

</script>
</head>

<body>

	<jsp:include page="/Header.jsp" />

	<div id='viewWrap'>
		<h1 id='pageTitle'>Edit Post</h1>
		
		<form action="./update" method="post" onsubmit="return validationChk();">
			<table id='viewTable'>
				<colgroup>
					<col width="20%">
					<col width="80%">
				</colgroup>
				<tbody>
					<tr>
						<td class='th'>번호</td>
						<td class='td'>
							<input type="text" name="noticeNo" class='readonly'
								value="${noticeDto.noticeNo}" readonly="readonly">
						</td>
					</tr>
					<tr>
						<td class='th'>제목</td>
						<td class='td'>
							<input type="text" name="title" id='titleInput' 
								value="${noticeDto.title}">
						</td>
					</tr>
					<tr>
						<td class='th'>내용</td>
						<td class='td'>
							<textarea rows="10" cols="30" id='contTxtarea'
								name="content">${noticeDto.content}</textarea>
						</td>
					</tr>
					<tr>
						<td class='th'>작성일</td>
						<td class='td'>${noticeDto.createdDate}</td>
					</tr>
				</tbody>
			</table>
			
			<div id='btnsWrap'>
				<input type="submit" value="적용" class='btns'>
				<input type="reset" value="초기화" class='btns'>
				<input type="button" value="삭제"  class='btns'
					onclick="deletePostFnc(${noticeDto.noticeNo});">
				<a href="./list" class='btns'>목록</a>
			</div>
		</form>
	</div>
	
	<jsp:include page="/Tail.jsp" />
	
</body>

</html>