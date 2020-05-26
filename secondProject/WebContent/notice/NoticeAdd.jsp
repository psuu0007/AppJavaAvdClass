<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>글쓰기</title>

<style type="text/css">
	
	form > div{
		border: 1px solid black;
		text-align: center;
	}
	#wholeDiv{
		width: 600px;
		margin: auto;
		border: 1px solid white;
		padding-top: 100px;
	}
	#firstDiv{
		width: 600px;
		margin: auto;
	}
	#secondDiv{
		line-height: 80px;
	}
	#contentsDiv{
		width: 595px;
		text-align: left;
	}
	
	#contentsInput{
		width: 600px;
		text-align: left;
	}
	.threeDiv{
		height: 20px;
 		text-align: center;
 		margin: auto;
 		vertical-align: middle;
 		
	}
	#fourDiv{
		height: 80px;
		line-height: 80px;
		text-align: right;
		padding-right: 10px;
	}
 	#firstInput{ 
 		float: right; 
		width: 70px;
		height: 40px;
		margin-top: 10px;
		margin-left: 10px;
		border: none;
 	}
  	#secondInput{ 
 		float: right; 
		width: 70px;
		height: 40px;
		margin-top: 10px;
		border: none;		
 	}
 	
</style>

</head>

<script type="text/javascript">
	
	function pageMoveFnc() {
		
		location.href = './list';
	}
	
	function sucessFnc() {
		
		var contents = document.getElementsByClassName('threeDiv')[1];
		var contentsInner = contents.value;
		
		var title = document.getElementsByName('nTitle')[0];
		var titleValue = title.value;
		
		if (contentsInner != "" && titleValue != "") {
		}else if(titleValue == "") {
			alert("제목이 입력되지않았습니다.");
			return false;
		}else if(contentsInner == "") {
			alert("내용이 입력되지않았습니다.");
			return false;
		}
	}
	
</script>

<body>
<jsp:include page="/Header.jsp"/>

	<div id="wholeDiv">
		<form action="./add" method="post" onsubmit = 'return sucessFnc();'>
			<div id="firstDiv">
				<div id="secondDiv">
					<h2>글쓰기</h2>
				</div>			
					<div id="contentsDiv">
						제목: <input class="threeDiv" type="text" value="" name="nTitle"><br><br>
						<textarea  rows="20" cols="10" style="width: 594px;" name="nContents"></textarea>

					</div>
				<div id="fourDiv">
					작성자: 관리자
				</div>
			</div>
			<input class="threeDiv" id="firstInput" type="button" value="뒤로가기" 
				onClick='pageMoveFnc();' style="border-radius: 5px;
				background-color: #00D8FF; color: white;" >	
			<input class="threeDiv" id="secondInput" type="submit" value="작성완료" 
				style="background-color: #47C83E; color: white;
				border-radius: 5px;">
		</form>
		
		<div style="clear: right">
		</div>
		
	</div>
	
<jsp:include page="/Tail.jsp"/>	
</body>

</html>