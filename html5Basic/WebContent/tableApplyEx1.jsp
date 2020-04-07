<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>label 요소</h1>
	<form action="" method="">
		<fieldset>
			<legend>회원가입</legend>
			<table border="1" width="100%" summary="회원가입에 필요한 개인정보 입력">
				<caption>회원가입 서식 작성</caption>
				<colgroup>
					<col width="30%" />
					<col width="70%" />
				</colgroup>
				<tbody>
					<tr>
						<th scope="row"><label for="name">이름</label></th>
						<td><input type="text" id="name" /></td>
					</tr>
					<tr>
						<th scope="row"><label for="id">아이디</label></th>
						<td><input type="text" id="id" /></td>
					</tr>
					<tr>
						<th scope="row"><label for="pw">비밀번호</label></th>
						<td><input type="password" id="pw" /></td>
					</tr>
					<tr>
						<th scope="row"><label for="r_pw">비밀번호확인</label></th>
						<td><input type="password" id="r_pw" /></td>
					</tr>
					<tr>
						<th scope="row"><label for="jumin_num">주민번호</label></th>
						<td>
							<input type="text" id="jumin_num" 
								title="주민번호 앞 6자리" />-
							<input type="text" title="주민번호 뒤 7자리" />
						</td>
					</tr>
					<tr>
						<th scope="row"><label for="email">이메일</label></th>
						<td><input type="text" id="email" title="이메일 아이디" />@<input
							type="text" title="이메일 주소" /></td>
					</tr>
					<tr>
						<th scope="row"><label for="hp">핸드폰</label></th>
						<td><input type="text" id="hp" /></td>
					</tr>
				</tbody>
			</table>
			<p>
				<input type="submit" value="전송" />
				<input type="reset" value="취소" />
			</p>
		</fieldset>
	</form>


</body>
</html>