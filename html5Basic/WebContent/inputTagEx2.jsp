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
				검색 박스로 텍스트 입력 시 지우기(x) 버튼이 나타난다
				<input type="search" id="search" />
			</p>
			<p>
				<span>이메일: </span>
				email 입력 양식에 맞지 않을 경우 
				오류 메시지를 제공하며
				아이폰에서는 경우 입력하기 편리한 키패드로 변한한다.
				<input type="email" id="email" />
			</p>
			<p>
				url 입력 양식에 맞지 않을 경우 오류 메시지를 
				제공하며 아이폰에서는 입력하기 편리한 키패드로 변한다 
				<label for="url">사이트 주소 : </label>
				<input type="url" id="url" />
			</p>
			<p>
			전화번호 입력 박스
				<label for="tel">전화번호 : </label>
				<input type="tel" id="tel" />
			</p>
			<p>
				<label for="number">수량 : </label>
				숫자 입력 박스에 직접 입력하거나 상하 화살표를 눌러 선택할 수 있다
				<input type="number" min="1"
					max="10" step="1" value="1" id="number" />
			</p>
			<p>
				<label for="range">만족도 : </label>
				숫자 범위가 슬라이드 바로 나타난다
				<input type="range" min="1"
					max="10" step="2" value="1" id="range" />
			</p>
			<p>
				<label for="date">날짜 : </label>
				연, 월, 일을 선택할 수 있는 박스가 나온다
				<input type="date" id="date" />
			</p>
			<p>
				<label for="datetime">날짜시간(UTC) : </label>
				연,월,일과 시,분을 선택할 수 있는 박스가 나온다 (UTC, 국제표준시간)
				<input type="datetime"
					id="datetime" />
			</p>
			<p>
				<label for="datetime-local">날짜시간 : </label>
				연,월,일,시,분을 선택할 수 있다. local(시스템시간)
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