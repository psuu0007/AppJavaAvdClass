<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>회원 목록</title>
<link rel="stylesheet" type="text/css"
	 href="<%=request.getContextPath()%>/css/style.css">

<style type="text/css">

#table select {
	height: 20px;
	font-size: 10px;
}

</style>
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

function deleteMsgFnc(no){
<%-- 	 href="<%=request.getContextPath()%> --%>
// 			/member/delete?no=${memberDto.no}"
	
	if(confirm('삭제하시겠습니까?')){
		location.href="../../member/delete?no=" + no;
		alert("삭제 되었습니다.");
	}
}

</script>
</head>

<body>
	
	<jsp:include page="/Header.jsp" />
	
	<div id='membersTable'>
		<h1 id='pageTitle'>Members</h1>

		<table id='table'>
			<colgroup>
				<col width="12%">
				<col width="13%">
				<col width="25%">
				<col width="15%">
				<col width="10%">
				<col width="15%">
				<col width="10%">
			</colgroup>
			<thead>
				<tr>
					<th>회원번호</th>
					<th>이름</th>
					<th>이메일</th>
					<th>가입날짜</th>
					<th>정보수정</th>
					<th>등급</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="memberDto" items="${memberList}">
					<tr>
						<td class='tCenter'>${memberDto.no}</td>
						<td class='tCenter'>${memberDto.name}</td>
						<td class='textOFlow'>${memberDto.email}</td>
						<td class='tCenter'>${memberDto.createdDate}</td>
						<td class='tCenter'>
							<a href="<%=request.getContextPath()%>
								/member/update?no=${memberDto.no}">수정</a>
						</td>
						<td class='tCenter'>
							<c:if test="${memberDto.grade == 'admin'}">
								관리자
							</c:if>
							
							<c:if test="${memberDto.grade == 'user'}">
								사용자
							</c:if>
						</td>
						<td class='tCenter'>
							<div onclick="deleteMsgFnc(${memberDto.no});"
								style="cursor: pointer;">Y</div>
						</td>
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
		
		
	</div>
	
	<jsp:include page="/Tail.jsp" />
	
</body>

</html>