<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>일반 게시판</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css">

<script type="text/javascript">
	
	window.onload = function(){
		<% int pageNum = (Integer) request.getAttribute("pageNum");%>
		<% int startNum = (Integer) request.getAttribute("startNum");%>
		<% int endNum = (Integer) request.getAttribute("endNum");%>
		<% int current = (Integer) request.getAttribute("currentNo");%>
		
		<% String orderBy = request.getParameter("orderBy"); %>
		
		var pageDiv = document.getElementById("pageNumDiv");
		
		var totalPage = <%=pageNum%>;
		var currentNo = <%=current%>;
		var startNum = <%=startNum%>;
		var endNum = <%=endNum%>;
		
		for(var i=startNum; i<=endNum; i++){
			var aTag = document.createElement("a");
			aTag.innerHTML = i;
			aTag.setAttribute("style", "margin: 0 3px;");
			
			if(i == currentNo){
				aTag.style.backgroundColor = "#a3a3c2";
				aTag.style.color = "#fff";
			}
			
			var url = "./list?currentNo="+i;
			aTag.setAttribute("href", url);
			pageDiv.appendChild(aTag);
		}
		
		
		if(currentNo == 1){
			var firstMoveBtnObj = document.getElementById("firstMoveBtn");
			firstMoveBtnObj.style.visibility = "hidden";
			var leftBtnObj = document.getElementById("pageleftBtn");
			leftBtnObj.style.visibility = "hidden";
		}
		
		if(currentNo == totalPage){
			var lastMoveBtnObj = document.getElementById("lastMoveBtn");
			lastMoveBtnObj.style.visibility="hidden";
			var rightBtnObj = document.getElementById("pageRightBtn");
			rightBtnObj.style.visibility="hidden";
		}
		
	}
	
	
	
	function pageLeftFnc(){
		
		var currentNo = <%=current%> -1;
		if(currentNo >= 1){
			location.href="./list?currentNo="+currentNo;
		}else{
			location.href="./list?currentNo=1";
		}
	}
	
	function pageRightFnc(){
	      var currentNo = <%=current%> +1;
	      var endNo = <%=pageNum%>;
	      if(currentNo <= endNo){
	         location.href="./list?currentNo="+currentNo;
	      }else{
	         location.href="./list?currentNo="+endNo;
	      }
	}
	   
	function firstMoveFnc(){
	    location.href="./list";
	}
	function lastMoveFnc(){
	    location.href="./list?currentNo="+<%=pageNum%>;
	}
	
	function boardAddFnc(){
		location.href="./add";
	}
	
	function moveLoginFnc(){
		location.href="../auth/login";
	}
	
	function deleteFnc(no) {
		if(confirm("삭제하시겠습니까?")){
			location.href="./delete?no=" + no;
		}
	}
</script>
</head>

<body>

	<jsp:include page="/Header.jsp" />

	<div id='wrap'>
		<h1 id='pageTitle'>Member Board</h1>
		
		<c:if test="${memberDto.getGrade() != 'user' && memberDto.getGrade() != 'admin'}">
			<p style="font-size: 13px; color: #333; margin: 10px 0px 30px">
				로그인해주세요.
			</p>
		</c:if>
		
		<c:if test="${memberDto.getGrade() == 'user' || memberDto.getGrade() == 'admin'}">
			<div style="overflow: hidden; margin: 10px 0px 15px;">
				<c:if test="${memberDto ne null}">
					<p style="float: left;">
						<button id='addLink' onclick="boardAddFnc();">글쓰기</button>
					</p>
				</c:if>
				<c:if test="${memberDto == null}">
					<p style="float: left;">
						<button id='addLink' onclick="moveLoginFnc();">글쓰기</button>
					</p>
				</c:if>
				
			</div>
			
			
			<table id='table'>
				<colgroup>
					<c:if test="${memberDto.getGrade() == 'admin'}">
						<col width="15%">
						<col width="45%">
						<col width="15%">
						<col width="15%">
						<col width="10%">
					</c:if>
					<c:if test="${memberDto.getGrade() != 'admin'}">
						<col width="15%">
						<col width="50%">
						<col width="20%">
						<col width="15%">
					</c:if>
				</colgroup>
				<thead>
					<tr>
						<th>게시글번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>등록일</th>
						<c:if test="${memberDto.getGrade() == 'admin'}">
							<th>관리</th>
						</c:if>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="boardDto" items="${boardList}">
						<tr>
							<td class='tCenter'>${boardDto.boardNo}</td>
							<td>
								<p class='textOFlow' style="display: inline-block; max-width: calc(100% - 40px);
									vertical-align: middle;">
									<a href='./detail?no=${boardDto.boardNo}'>
											${boardDto.title}
									</a>
								</p>
								<c:if test="${memberDto.getGrade() == 'admin' && boardDto.email == memberDto.getEmail()}">
									<a href='./update?no=${boardDto.boardNo}'
										style="display:inline-block; font-size: 10px;
										vertical-align: middle;">
										[수정]
									</a>
								</c:if>
							</td>
							<td class='tCenter'>${boardDto.myName}</td>
							<td class='tCenter'>${boardDto.createdDate}</td>
							<c:if test="${memberDto.getGrade() == 'admin'}">
								<td class='tCenter'>
									<a onclick="deleteFnc(${boardDto.boardNo});"
										style="display:inline-block; font-size: 10px; cursor: pointer;">
										삭제
									</a> 
								</td>
							</c:if> 
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<div id='pagingWrap'>
				<div id="firstMoveBtn" onclick="firstMoveFnc();" 
					style="display: inline-block;">
					&lt;&lt;
				</div>
				<div id="pageleftBtn" onclick="pageLeftFnc();" 
					style="display: inline-block;">
					&lt;
				</div>
				<div id="pageNumDiv" style="display: inline-block;"></div>
				<div id="pageRightBtn" onclick="pageRightFnc();" 
					style="display: inline-block;">
					&gt;
				</div>
				<div id="lastMoveBtn" onclick="lastMoveFnc();" 
					style="display: inline-block;">
					&gt;&gt;
				</div>
			</div>
		</c:if>
		
	</div>
	
	
	<jsp:include page="/Tail.jsp" />

</body>

</html>