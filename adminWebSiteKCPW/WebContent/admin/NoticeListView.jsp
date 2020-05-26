<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>공지 게시판</title>
<link rel="stylesheet" type="text/css" 
	href="<%=request.getContextPath()%>/css/style.css">

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
	
</script>

</head>

<body>

	<jsp:include page="/Header.jsp" />

	<div id='wrap'>
		<h1 id='pageTitle'>Notice Board</h1>
		
		<c:if test="${memberDto.getGrade() == 'admin'}">
			<p style="margin: 10px 0px 20px">
				<a href="./add" id='addLink'>글쓰기</a>
			</p>
		</c:if>
		
		<c:if test="${memberDto.getGrade() != 'user' && memberDto.getGrade() != 'admin'}">
			<p style="font-size: 13px; color: #333; margin: 10px 0px 30px">
				로그인해주세요.
			</p>
		</c:if>
	
		<c:if test="${memberDto.getGrade() == 'user' || memberDto.getGrade() == 'admin'}">
			<table id='table'>
				<colgroup>
					<col width="10%">
					<col width="45%">
					<col width="15%">
					<col width="15%">
					<col width="15%">
				</colgroup>
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>수정일</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="noticeDto" items="${noticeList}">
						<tr>
							<td class='tCenter'>${noticeDto.noticeNo}</td>
							<td class='textOFlow'>
								<a href="./detail?noticeNo=${noticeDto.noticeNo}">
									${noticeDto.title}
								</a>
							</td>
							<td class='tCenter'>${noticeDto.myName}</td>
							<td class='tCenter'>${noticeDto.createdDate}</td>
							<td class='tCenter'>${noticeDto.modifiedDate}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<div id='pagingWrap'>
				<div id="firstMoveBtn" onclick="firstMoveFnc();" 
					style="display: inline-block;">
					&lt;&lt;
				</div>
				<div id="pageleftBtn" onclick="pageLeftFnc();">
					&lt;
				</div>
				<div id="pageNumDiv" ></div>
				<div id="pageRightBtn" onclick="pageRightFnc();">
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