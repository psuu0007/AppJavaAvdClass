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
			<legend>input type</legend>
			<p>
				검색:
				<input type="search" id="search" />
			</p>
			<p>
				<span>이메일: </span>
				<input type="email" id="email" />
			</p>
			<p>
				<label for="url">사이트 주소 : </label>
				<input type="url" id="url" />
			</p>
			<p>
				<label for="tel">전화번호 : </label>
				<input type="tel" id="tel" />
			</p>
			<p>
				<label for="number">수량 : </label>
				<input type="number" min="1"
					max="10" step="1" value="1" id="number" />
			</p>
			<p>
				<label for="range">만족도 : </label>
				<input type="range" min="1"
					max="10" step="2" value="1" id="range" />
			</p>
			<p>
				<label for="date">날짜 : </label>
				<input type="date" id="date" />
			</p>
			<p>
				<label for="datetime">날짜시간(UTC) : </label>
				<input type="datetime"
					id="datetime" />
			</p>
			<p>
				<label for="datetime-local">날짜시간 : </label>
				<input
					type="datetime-local" id="datetime-local" />
			</p>
			<p>
				<label for="month">월 : </label>
				<input type="month" id="month" />
			</p>
			<p>
				<label for="week">주 : </label>
				<input type="week" id="week" />
			</p>
			<p>
				<label for="time">시간 : </label>
				<input type="time" id="time" />
			</p>
			<p>
				<label for="color">색상 : </label>
				<input type="color" id="color" />
			</p>
			<p>
				<input type="submit" value="완료">
			</p>
		</fieldset>
	</form>
</body>
</html>