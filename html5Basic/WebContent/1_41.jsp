<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>progress 요소와 meter 요소</title>
</head>
<body>
	<h1>progress 요소와 meter 요소</h1>
	<h2>파일 다운로드</h2>
	<p>
		다운로드 진행 :
		<progress max=“100”>
			<span>0</span>%
		</progress>
	</p>
	<h2>투표상황</h2>
	<p>
		현재 투표 진행상황:
		<meter min="0" max="100" value="20" low="30" high="65" 
			title="percent">20%</meter>
	</p>
	<p>
		현재 투표 진행상황:
		<meter min="0" max="100" value="60" low="30" high="65" 
			title="percent">60%</meter>
	</p>
	<p>
		현재 투표 진행상황:
		<meter min="0" max="100" value="70" low="30" high="65" 
			title="percent">70%</meter>
	</p>
</body>
</html>