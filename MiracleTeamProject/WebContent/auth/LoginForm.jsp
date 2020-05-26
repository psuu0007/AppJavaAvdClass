<%@ page import="mtp.login.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/log-in.css?ver=1.2" />
<script type="text/javascript" src="../js/login.js?ver=1.1"></script>
<meta charset="UTF-8">
<title>로그인 페이지</title>

</head>
<body>
	<jsp:include page="../common/Header.jsp" />
	<div id="root">
		<div class="member-card-layout">
			<div class="member-card">
				<div class="member-card-layout-inner">

					<div class="member-card-layout__logo">
						<img id="mainImg" class="member-card-layout__logo-image"
							src="../img/pika4.gif" alt="로고">
					</div>

					<form id="formFirst" action="./login" method="post" name="userInfo"
						onsubmit="return nextStepFnc();">

						<div class="input-box">
							<label class="member-input__label" for="email-input">이메일 주소
							</label> 
							<input class="input-contents" type="text" id="email-input"
								autocomplete="off" value="" name="email" />
						</div>

						<div class="input-box">
							<label class="member-input__label" for="pwd-input">비밀번호
							</label> 
							<input class="input-contents" type="password" id="pwd-input"
								autocomplete="off" value="" name="password" />
						</div>

						<input id="target" type="submit" class="login-button" value="로그인"
							disabled>

						<div class="btn_group">
							<input class="find-password" type="button" onclick="findPwd()"
								value="비밀번호 찾기"> 
							<input class="signUp" type="button"	value="회원가입하기" 
								onclick="location.href='../member/add';">
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="../common/Bottom.jsp" />
</body>
</html>