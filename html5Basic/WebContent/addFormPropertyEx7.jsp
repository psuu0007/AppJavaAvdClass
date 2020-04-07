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
			<legend>pattern 속성</legend>
			<p>
			<!-- 정규표현식 -->
				<label for="tel">휴대폰 번호 : </label>
				<input type="tel" id="tel"
					pattern="\d{3}-\d{3,4}-\d{4}"
					title="휴대폰 번호는 3자리 숫자-3자리에서 4자리 숫자-4자리 숫자로 
					입력하셔야 합니다." 
				/>
			</p>
			<p>
				<input type="submit" value="전송" />
			</p>
		</fieldset>
	</form>
</body>
</html>