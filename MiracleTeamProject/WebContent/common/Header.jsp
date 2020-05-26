<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style type="text/css">
.titleMenu{
	color: #EEE8AA;
	cursor: pointer;
	transition: all 0.2s;	
}
.titleMenu:hover{
	background-color: #fff;
	border: 1px solid #ffffff;
	border-radius: 5px;
	color: #B22222;
}
#headerH1{
	background: linear-gradient( to top, white, red );
	-webkit-background-clip:text;
	-webkit-text-fill-color:transparent;
	cursor: pointer;
 	font-family: Comic Sans MS, Comic Sans, cursive;
}
#headerH1:hover{
	background: linear-gradient( to top, red, white );
	-webkit-background-clip:text;
	-webkit-text-fill-color:transparent;
}
</style>
<script type="text/javascript">
	function PageMoveFnc(address) {
		location.href='<%=request.getContextPath()%>'+address;
	}
</script>

<div style="width: 1000px; margin:auto; text-align: center;">
	<img style="width: 50px; height: 50px; position: absolute; left: 50%; margin-left: -240px;" alt="logoBall" src="<%=request.getContextPath()%>/img/monsterball1.png">
	<img style="width: 50px; height: 50px; position: absolute; right: 50%; margin-right: -240px;" alt="logoBall" src="<%=request.getContextPath()%>/img/monsterball1.png">
	<h1 id='headerH1' onclick="location.href='<%=request.getContextPath()%>'">Miracle Team Project</h1>	
</div>

<div style="background-color: #B22222; color: #FAFAD2; margin:auto; width: 1000px; padding: 15px; box-sizing: border-box;
			border-top-right-radius: 30px; border-top-left-radius: 30px;">
	<a class='titleMenu' onclick="PageMoveFnc('/noticeBoard/list');">공지사항</a>
	<a class='titleMenu' onclick="PageMoveFnc('/boardManagement/list');">게시판</a>
	<c:if test="${sessionScope.member.email eq 'admin'}">
		<a class='titleMenu' onclick="PageMoveFnc('/memberManagement/list');">회원관리</a>
	</c:if>
	
	<c:if test="${sessionScope.member eq null}">
		<a class='titleMenu' style="float: right;" onclick="PageMoveFnc('/member/MemberForm.jsp');">회원가입</a>
		<a class='titleMenu' style="float: right; margin-right: 10px;" onclick="PageMoveFnc('/auth/LoginForm.jsp');">로그인</a>
	</c:if>
	
	<c:if test="${sessionScope.member.email ne null}">
		<a class='titleMenu' style="float: right;" onclick="PageMoveFnc('/auth/logout');">로그아웃</a>		
		<c:if test="${sessionScope.member.email eq 'admin'}">
			<a class='titleMenu' style="float: right; margin-right: 10px;"onclick="location.href='<%=request.getContextPath()%>/memberManagement/update?adNo=${sessionScope.member.no}'" >${sessionScope.member.name}</a>
		</c:if>
		<c:if test="${sessionScope.member.email ne 'admin'}">
			<a class='titleMenu' style="float: right; margin-right: 10px;"onclick="location.href='<%=request.getContextPath()%>/memberManagement/update?mmNo=${sessionScope.member.no}'" >${sessionScope.member.name}</a>
		</c:if>
	</c:if>

</div>