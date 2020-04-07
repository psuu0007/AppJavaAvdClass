<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form>
		<fieldset>
			<legend>자동완성 기능</legend>
			<ul>
				<li><label for="phone">전화번호</label>
					<input type="tel" id="phone"
					autocomplete="on" />
				</li>
				<li><label for="email">이메일</label>
					<input type="email"
					id="email" autocomplete="off" />
				</li>
			</ul>
		</fieldset>
	</form>
</body>
</html>