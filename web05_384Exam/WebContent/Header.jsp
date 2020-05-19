<%@page import="spms.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <jsp:useBean id="member" --%>
<%-- 	scope="session" --%>
<%-- 	class="spms.dto.MemberDto" --%>
<%-- /> --%>


<%-- <% --%>
<!--  	MemberDto memberDto = (MemberDto)session.getAttribute("memberDto"); -->
<!-- %> -->

<div style="background-color:#00008b; color:#ffffff; height:20px; padding: 5px;">
	SPMS(Simple Project Management System)
	
	<c:if test="${member.email ne null}">
		<span style="float:right;">
			${member.name}
			<a style="color:white;" href="<%=request.getContextPath()%>/auth/logout">로그아웃</a>
		</span>
	</c:if>

</div>

