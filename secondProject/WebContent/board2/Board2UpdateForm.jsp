<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>

<script type="text/javascript">
	function moveBoard2ListFnc(){
		location.href = "./list";
	}
	
	function pageMoveDeleteFnc(bno2){
		var url = "./delete?bno2=" + bno2;
		location.href = url;
	}
	
	function len_chk(){
		var frm = document.insertFrm.contents2;
		if(frm.value.length > 300){
			alert("300자 이내로 기재해주세요.");
			frm.value = frm.value.substring(0,300);
			frm.focus();
		}
	}
	
	window.onload = function() {
		var lenInputObj = document.getElementById("lenInput");
		var frm = document.insertFrm.contents2;
		lenInputObj.value = frm.value.length;
		frm.addEventListener('keyup', function(){
			lenInputObj.value = frm.value.length;
		});
	}
</script>
<style>
	.inputLikeButton {
		border: none;
		background-color: #DAD9FF;
		border-radius: 4px;
		margin-top: 20px;
	}
	.inputLikeButton:hover {
		background-color: #4B58E3;
	}
	
	
</style>
</head>
<body>
	<jsp:include page="/Header.jsp" />
	
	<form action='./update' method='post' name='insertFrm'>
		<h2>글수정</h2>
		<c:if test="${(board2Dto.writer2 eq sessionScope.memberDto.name) && sessionScope.memberDto.adminCheck eq 'Y'}">
			<table>
				<tr>
					<td>제목:</td><td><input type='text' name='title2' value='${board2Dto.title2}'></td>
				</tr>
				<tr>
					<td style="vertical-align:top">내용:</td><td><textarea onKeyup="len_chk();" rows="20px" cols="70px" name='contents2' style="vertical-align: top;">${board2Dto.contents2}</textarea></td>
				</tr>
				<tr>
					<td>글자수:</td><td><input id='lenInput' type='text' value=''></td>
				</tr>
			 	<tr>
			 		<td><input class='inputLikeButton' type='button' value='삭제' onclick='pageMoveDeleteFnc(${board2Dto.bno2});'></td>
			 		<td>
			 			<input class='inputLikeButton' type='submit' value='저장'>
			 			<input class='inputLikeButton' type='button' value='뒤로가기' onclick="moveBoard2ListFnc();" style="margin-left: 12px;">
			 		</td>
			 	</tr>
			</table>
		</c:if>
		<c:if test="${(board2Dto.writer2 eq sessionScope.memberDto.name) && sessionScope.memberDto.adminCheck ne 'Y'}">
			<table>
				<tr>
					<td>제목:</td><td><input type='text' name='title2' value='${board2Dto.title2}'></td>
				</tr>
				<tr>
					<td style="vertical-align:top">내용:</td><td><textarea onKeyup="len_chk();" rows="20px" cols="70px" name='contents2' style="vertical-align: top;">${board2Dto.contents2}</textarea></td>
				</tr>
				<tr>
					<td>글자수:</td><td><input id='lenInput' type='text' value='' readonly="readonly"></td>
				</tr>
			 	<tr>
			 		<td><input class='inputLikeButton' type='button' value='삭제' onclick='pageMoveDeleteFnc(${board2Dto.bno2});'></td>
			 		<td>
			 			<input class='inputLikeButton' type='submit' value='저장'>
			 			<input class='inputLikeButton' type='button' value='뒤로가기' onclick="moveBoard2ListFnc();" style="margin-left: 12px;">
			 		</td>
			 	</tr>
			</table>
		</c:if>
		<c:if test="${(board2Dto.writer2 ne sessionScope.memberDto.name) && sessionScope.memberDto.adminCheck eq 'Y'}">
			<table>
				<tr>
					<td>제목:</td><td><input type='text' name='title2' value='${board2Dto.title2}'></td>
				</tr>
				<tr>
					<td style="vertical-align:top">내용:</td><td><textarea onKeyup="len_chk();" rows="20px" cols="70px" name='contents2' style="vertical-align: top;">${board2Dto.contents2}</textarea></td>
				</tr>
				<tr>
					<td>글자수:</td><td><input id='lenInput' type='text' value=''></td>
				</tr>
			 	<tr>
			 		<td><input class='inputLikeButton' type='button' value='삭제' onclick='pageMoveDeleteFnc(${board2Dto.bno2});'></td>
			 		<td>
			 			<input class='inputLikeButton' type='submit' value='저장'>
			 			<input class='inputLikeButton' type='button' value='뒤로가기' onclick="moveBoard2ListFnc();" style="margin-left: 12px;">
			 		</td>
			 	</tr>
			</table>
		</c:if>
		<c:if test="${(board2Dto.writer2 ne sessionScope.memberDto.name) && sessionScope.memberDto.adminCheck ne 'Y'}">
			<table>
				<tr>
					<td>제목:</td><td><input type='text' name='title2' value='${board2Dto.title2}'></td>
				</tr>
				<tr>
					<td style="vertical-align:top">내용:</td><td><textarea onKeyup="len_chk();" rows="20px" cols="70px" name='contents2' style="vertical-align: top;">${board2Dto.contents2}</textarea></td>
				</tr>
				<tr>
					<td>글자수:</td><td><input id='lenInput' type='text' value=''></td>
				</tr>
			 	<tr>
			 		<td><input class='inputLikeButton' type='button' value='뒤로가기' onclick="moveBoard2ListFnc();" style="margin-left: 12px;"></td>
			 	</tr>
			</table>
		</c:if>
		<input type='hidden' name='bno2' value='${board2Dto.bno2}' style="display: none;">
	</form>
	
	<jsp:include page="/Tail.jsp" />
	
</body>
</html>