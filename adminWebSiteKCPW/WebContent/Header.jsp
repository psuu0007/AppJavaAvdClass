<%@page import="spms.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div id='header'>
	<a href="<%=request.getContextPath()%>/" id='logo'>KCPW</a>
	
	<c:if test="${memberDto ne null}">
		<c:if test="${memberDto.grade == 'admin'}">
			<a href="<%=request.getContextPath()%>/admin/member/list" class='depth1'>
				회원리스트
			</a>
			<a href="<%=request.getContextPath()%>/member/add" class='depth1'>
				회원추가
			</a>
		</c:if>
	</c:if>
	
	<a href="<%=request.getContextPath()%>/board/list" class='depth1'>
		게시판
	</a>
	
	<a href="<%=request.getContextPath()%>/admin/list" class='depth1'>
		공지 게시판
	</a>
	
	
	<c:if test="${memberDto eq null}">
		<span style="float:right;">
			<a href="<%=request.getContextPath()%>/auth/login" class='rightLinks'>로그인</a>
			<a href="<%=request.getContextPath()%>/member/add" class='rightLinks'>회원가입</a>
		</span>
	</c:if>
	
	<c:if test="${memberDto ne null}">
		<c:if test="${memberDto.grade == 'user'}">
			<span style="float:right;">
				<a href="<%=request.getContextPath()%>/member/info?no=${memberDto.no}"
					class='rightLinks'>
					${memberDto.name}
				</a>
				<a href="<%=request.getContextPath()%>/auth/logout" class='rightLinks'>
				 	로그아웃
				</a>
			</span>
		</c:if>
		
		<c:if test="${memberDto.grade == 'admin'}">
			<span style="float:right;">
				<a href="<%=request.getContextPath()%>/admin/AdminFunctionPage.jsp" 
					class='rightLinks' style="color: #a3a3c2; font-weight: bold;">
					 관리자
				</a>
				<a href="<%=request.getContextPath()%>/auth/logout" class='rightLinks'>
				 	로그아웃
				 </a>
			</span>
		</c:if>
	</c:if>

</div>

