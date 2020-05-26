<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>글쓰기</title>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/common.css" type="text/css">
</head>
<script type="text/javascript" src="../js/common.js"></script>

<script type="text/javascript">
	window.onload = function(){
		navBtnCngFnc();
	}
	function pageMoveListFnc(){
		location.href = "./list";
	}
</script>
<body>

	<div>
		<jsp:include page="/Header.jsp"/>
		<div style="margin-left: 50px; margin-top: 20px;">
		<h3>글쓰기</h3>
      <form action="./add" method="post">
		작성자 : <input type="text" name="writer" value="${member.nickname}" readonly="readonly"><br><br>
		제목 : <input type="text" name="title"><br><br>		           
		<h4>내용</h4>
		<textarea name="text" style="width: 500px; height: 500px; resize:none;" ></textarea><br>
		<input type="hidden" name="writerNo" value="${member.no}">
      <div>
      <input type="submit" value="추가">
      <input type="reset" value="취소">
       <input type="button" value="목록" onClick='pageMoveListFnc();'>
      </div>
     
	</form>
      
      </div>
      <jsp:include page="/Tail.jsp"/>
   </div>

</body>

</html>