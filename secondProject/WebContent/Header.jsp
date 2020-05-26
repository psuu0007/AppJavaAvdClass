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

<div style="background-color:#FFFFFF; color:#000000; height:50px; padding: 5px;">
	
	<div style="float:left;  margin-right: 30px; width: 120px;" >
	
		<c:if test="${sessionScope.memberDto ne null}">
			<a href="<%=request.getContextPath()%>/member/list" style="cursor: pointer;">
				<img src="<%=request.getContextPath()%>/img/agumon.png"
					style="width:50px; height: 50px; margin-left:20px; margin-right: 30px;">
			</a>
		</c:if>
		<c:if test="${sessionScope.memberDto eq null}">
			<a href="<%=request.getContextPath()%>/auth/login">
				<img src="<%=request.getContextPath()%>/img/agumon.png"
					style="width:50px; height: 50px; margin-left:20px; margin-right: 30px;">
			</a>
		</c:if>



	</div>
	
	
	
	<div>
		<c:if test="${sessionScope.memberDto ne null}">
			<a href="<%=request.getContextPath()%>/board1/list?pageNo=1" style="margin-right: 50px; text-decoration: none; cursor: pointer;">
				<input type="button" value="게시판1" 
					style="border: none; background-color: #5CB85C; color: white; 
					width: 90px; height: 25px; border-radius: 7px; margin-top: 10px; cursor: pointer;" >
			</a>
			<a href="<%=request.getContextPath()%>/board2/list" style="margin-right: 50px; text-decoration: none;">
				<input type="button" value="게시판2"
					style="border: none; background-color: #5BC0DE; color: white;
					 width: 90px; height: 25px;  border-radius: 7px; cursor: pointer;">
			</a>
			<a href="<%=request.getContextPath()%>/notice/list" style="text-decoration: none; cursor: pointer;">
				<input type="button" value="공지사항" 
					style="border: none; background-color: #F0AD4E; color: white; 
					width: 90px; height: 25px; border-radius: 7px; cursor: pointer;">
			</a>
		</c:if>


		<c:if test="${sessionScope.memberDto eq null}">
			<a href="<%=request.getContextPath()%>/auth/login" style="margin-right: 50px; text-decoration: none;">
				<input type="button" value="게시판1" 
					style="border: none; background-color: #5CB85C; color: white; 
					width: 90px; height: 25px; border-radius: 7px; margin-top: 10px; cursor: pointer;" >
			</a>
			<a href="<%=request.getContextPath()%>/auth/login" style="margin-right: 50px; text-decoration: none;">
				<input type="button" value="게시판2"
					style="border: none; background-color: #5BC0DE; color: white;
					 width: 90px; height: 25px;  border-radius: 7px; cursor: pointer;">
			</a>
			<a href="<%=request.getContextPath()%>/auth/login" style="text-decoration: none;">
				<input type="button" value="공지사항" 
					style="border: none; background-color: #F0AD4E; color: white; 
					width: 90px; height: 25px; border-radius: 7px; cursor: pointer;">
			</a>
		</c:if>	
		
		
		<div style=" float: right; margin-top: 10px; font-weight: bold; color: ">
			<c:if test="${sessionScope.memberDto.email eq null}">
				<a href="<%=request.getContextPath()%>/auth/login" style="color:black; text-decoration: none;">
					로그인
				</a>				
			</c:if>
			
			<c:if test="${sessionScope.memberDto.email ne null}">
					<a style="color:black; text-decoration: none;"
						href="<%=request.getContextPath()%>/member/update?no=${sessionScope.memberDto.no}">
						
						<c:if test="${sessionScope.memberDto.adminCheck == 'N'}">
							${sessionScope.memberDto.name} 님
						</c:if>
						
						<c:if test="${sessionScope.memberDto.adminCheck == 'Y'}">
							관리자 님
						</c:if>
					</a>
					<a style="color:black; text-decoration: none;" href="<%=request.getContextPath()%>/auth/logout">로그아웃</a>
			</c:if>

		</div>
		
	</div>
	
</div>


<hr style="border-color: yellow;">
