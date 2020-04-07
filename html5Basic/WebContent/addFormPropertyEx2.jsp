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
			<legend>필드에 입력형식 힌트주기 </legend>
			<ul>
				<li><label for="phone">핸드폰 번호</label>
					<input type="tel"
					id="phone" placeholder="01011112222" />
				</li>
				<li><label for="email">이메일</label>
					<input type="email"
					id="email" placeholder="id@domain.com" />
				</li>
			</ul>
		</fieldset>
	</form>
</body>
</html>