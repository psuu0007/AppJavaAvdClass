<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<script type="text/javascript">
	function moveBoard2ListFnc() {
		location.href = "./list";
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
	}
	.inputLikeButton:hover {
		background-color: #4B58E3;
	}
</style>
</head>
<body>
	<jsp:include page="/Header.jsp" />
	
	<h2>글쓰기</h2>
	<form action='./add' method='post' name='insertFrm'>
		<table>
			<tr>
				<td>제목:</td><td><input type='text' name='title2'></td>
			</tr>
			<tr>
				<td style="vertical-align:top">내용:</td><td><textarea onKeyup="len_chk();" rows="20px" cols="70px" name='contents2' style="vertical-align: top;" placeholder="300자 이내로 기재해주세요." ></textarea></td>
			</tr>
			<tr>
				<td>글자수:</td><td><input id='lenInput' type='text' value='' readonly="readonly"></td>
			</tr>
			<tr>
				<td><input class='inputLikeButton' type='button' value='취소' onclick="moveBoard2ListFnc();" style="margin-top: 20px;"></td>
				<td><input class='inputLikeButton' type='submit' value='글쓰기' style="margin-top: 20px;"></td>
			</tr>
		</table>
	</form>
	<jsp:include page="/Tail.jsp" />
</body>
</html>