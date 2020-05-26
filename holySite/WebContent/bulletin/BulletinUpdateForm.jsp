<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>수정</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/common.css" type="text/css">
</head>
<script type="text/javascript" src="../js/common.js"></script>

<script type="text/javascript">
	window.onload = function(){
		navBtnCngFnc();
	}
	function pageMoveDeleteFnc(no){
		var url = "./delete?no=" + no;
		location.href = url;
	}
	
	function pageMoveListFnc(){
		location.href = "./list";
	}
</script>

<body>
	
	<div>
		<jsp:include page="/Header.jsp"/>
      <form action="./update" method="post">
      <c:if test="${member.grade eq '1' || bulletinDto.writer.nickname eq member.nickname}">
      	번호:<input type="text" name="no" value="${bulletinDto.no}" readonly="readonly"><br>
      	작성자:<input type="text" name="writer" value="${bulletinDto.writer.nickname}" readonly="readonly"><br>
      	제목:<input type="text" name="title" value="${bulletinDto.title}" ><br>
      	<h3>내용:</h3><textarea name="text" style="width: 500px; height: 500px;  resize:none;">${bulletinDto.text}</textarea><br>
      </c:if>
      
      <c:if test="${member.grade != '1' && bulletinDto.writer.nickname != member.nickname}">
      	번호:<input type="text" name="no" value="${bulletinDto.no}" readonly="readonly"><br>
      	작성자:<input type="text" name="writer" value="${bulletinDto.writer.nickname}" readonly="readonly"><br>
      	제목:<input type="text" name="title" value="${bulletinDto.title}" readonly="readonly"><br>
      	<h3>내용:</h3><textarea name="text" style="width: 500px; height: 500px;  resize:none;" readonly="readonly">${bulletinDto.text}</textarea><br>
      </c:if>
		<c:if test="${bulletinDto.writer.nickname eq member.nickname}">      
      		<input type="submit" value="수정">
      	</c:if>
      <c:if test="${member.grade eq '1' || bulletinDto.writer.nickname eq member.nickname}">
      	<input type="button" value="삭제" onclick='pageMoveDeleteFnc(${bulletinDto.no});'>
      </c:if>
      <input type="button" value="취소" onClick='pageMoveListFnc();'>
      <input type="hidden" name="no" value="${bulletinDto.no}">
      </form>
      <jsp:include page="/Tail.jsp"/>
   </div>
	

</body>

</html>