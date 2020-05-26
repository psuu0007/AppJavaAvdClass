<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>관리자 전용 페이지</title>
<link rel="stylesheet" type="text/css"
	 href="<%=request.getContextPath()%>/css/style.css">

<style type="text/css">
.subTitle{
	display:inline-block;
	position: relative;
	padding: 0px 5px;
	font-size: 18px;
	letter-spacing: -0.1em;
}
.subTitle:after{
	display: block;
	content: '';
	position: absolute;
	left: 0px;
	bottom: -3px;
	width: 100%;
	height: 1px;
	border-bottom: 1px dotted #333;
}
#boxesWrap{
	overflow: hidden;
	width: 520px;
	margin: 50px auto 0px;
}
.boxes{
	float: left;
}
.box1{
	position: relative;
}
.box1:after{
	display: block;
	content: '';
	position: absolute;
	right: -40px;
	top: 50px;
	width: 1px;
	height: 40px;
	background: #ddd;
}
.listUl{
	margin-top: 10px;
	font-size: 0;
}
.listUl li{
	display: inline-block;
	width: 110px;
}
.listText{
	display: block;
	margin-top: -15px;
	font-size: 13px;
}
</style>
</head>

<body>
	
	<jsp:include page="/Header.jsp" />
	
	<div id='wrap' class='tCenter'>
		<h1 id='pageTitle' style="text-align: left;">Administration Page</h1>
	
		<div id='boxesWrap'>
			<div class='boxes box1' style="margin-right: 80px;">
				<h2 class='subTitle'>회원 관리</h2>
				
				<ul class="listUl tCenter">
					<li>
						<a href="./member/list">
							<img alt="회원리스트 아이콘" src="../img/admin_icon2.jpg">
							<span class='listText'>회원리스트</span>
						</a>
					</li>
					<li>
						<a href="../member/add">
							<img alt="회원리스트 아이콘" src="../img/admin_icon1.jpg">
							<span class='listText'>회원추가</span>
						</a>
					</li>
				</ul>
			</div>
			
			<div class='boxes'>
				<h2 class='subTitle tCenter'>게시판 관리</h2>
				
				<ul class="listUl tCenter">
					<li>
						<a href="../board/list">
							<img alt="회원리스트 아이콘" src="../img/admin_icon3.jpg">
							<span class='listText'>일반 게시판</span>
						</a>
					</li>
					<li>
						<a href="./list">
							<img alt="회원리스트 아이콘" src="../img/admin_icon4.jpg">
							<span class='listText'>공지 게시판</span>
						</a>
					</li>
				</ul>
			</div>
		</div>
	</div>
	
	<jsp:include page="/Tail.jsp" />
	
</body>

</html>