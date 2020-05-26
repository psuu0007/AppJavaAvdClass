<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<div>
		<a href="<%=request.getContextPath()%>/index.jsp">
			<img src="<%=request.getContextPath()%>/img/logo.png">
		</a>
		
		<div style="background-color:#4782A4; color:#4782A4; background: linear-gradient(to left, #FFFFFF, #4782A4);
		height:20px; padding: 5px; font-weight: bold;">
		
			<ul id="mainNav">
				<c:if test="${member.grade eq '1'}">
					<li>
						<a id="navMember" href="<%=request.getContextPath()%>/member/list">회원목록</a>
					</li>
				</c:if>
				<li>
					<a id="navBulletin" href="<%=request.getContextPath()%>/bulletin/list">게시판</a>
				</li>
				<li>
					<a id="navNotice" href="<%=request.getContextPath()%>/notice/list">공지사항</a>
				</li>
			</ul>
		
			<c:if test="${member.email ne null}" var="result">
				<span style="float:right;">
					<c:if test="${member.grade eq '1' }" var="result2">
						관리자님 안녕하세요.
					</c:if>
					<c:if test="${!result2 }">
						${member.nickname}님 안녕하세요.
					</c:if>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="<%=request.getContextPath()%>/member/update?no=${member.no}">회원정보수정</a>
					&nbsp;&nbsp;
					<a href="<%=request.getContextPath()%>/auth/logout">로그아웃</a>
				</span>
			</c:if>
			<c:if test="${!result }">
				<span style="float:right;">
					GUEST님 안녕하세요.&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="<%=request.getContextPath()%>/member/add">회원가입</a>
					&nbsp;
					<a href="<%=request.getContextPath()%>/auth/login">로그인</a>
				</span>
			</c:if>
		</div>
	</div>