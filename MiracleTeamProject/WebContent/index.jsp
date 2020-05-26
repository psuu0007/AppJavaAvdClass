<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>시작 화면</title>
<script type="text/javascript">
	function PageMoveFnc(address) {
		location.href = '<%=request.getContextPath()%>' + address;
		
	}

	function changeImgFnc() {
		var mainImg = document.getElementById("mainImg");
		mainImg.setAttribute("src", "./img/poke2.gif");
	}
	
	function reChangeImgFnc() {
		var mainImg = document.getElementById("mainImg");
		mainImg.setAttribute("src", "./img/poke1.gif");
	}
</script>
</head>

<body>
	<jsp:include page="/common/Header.jsp" />
	
	<c:if test="${member eq null}">
		<div style="width: 1000px; margin: auto; background-color: #f3f5f7; text-align: center;">
			<p onclick="PageMoveFnc('/auth/login');" style="margin: 0px;">
				<img id='mainImg' style="display: block; width: 1000px; height: 600px;" 
				onmouseenter="changeImgFnc();" onmouseleave="reChangeImgFnc();" src="./img/poke1.gif" alt="MainImg">
			</p>		
		</div>
	</c:if>
	
	<c:if test="${member ne null}">
		<div style="width: 1000px; margin: auto; background-color: #f3f5f7; text-align: center;">
			<p onclick="PageMoveFnc('/noticeBoard/list');" style="margin: 0px;">
				<img id='mainImg' style="display: block; width: 1000px; height: 600px;" 
				onmouseenter="changeImgFnc();" onmouseleave="reChangeImgFnc();" src="./img/poke1.gif" alt="MainImg">
			</p>		
		</div>
	</c:if>
	
	<jsp:include page="/common/Bottom.jsp" />
</body>
</html>