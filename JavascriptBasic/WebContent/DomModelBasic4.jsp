<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>웹 문서구조2</title>

<script type="text/javascript">
	
</script>

</head>

<body>

	<div>
		<h1>선택자</h1>
		<h2 id="title">원거리 선택자</h2>
		<ul>
			<li>getElementById</li>
			<!-- 경계선 색상이 파란색이다 -->
			<li>getElementsByTagnName</li>
		</ul>
		<h2 id="title2">근거리 선택자</h2>
		<ul id="list">
			<li>parentNode</li>
			<!-- 배경색이 동일한 원하는 색이고 경계선도 자신이 원하는 동일한 색이다. -->
			<li>childNodes</li>
			<li>children</li>
			<li>firstChild</li>
			<li>previousSibling</li>
			<li>nextSibling</li>
		</ul>
	</div>

</body>

<script type="text/javascript">
	var ulObjArr = document.getElementsByTagName('ul');

	var firstArr = ulObjArr[0];
	var secondArr = ulObjArr[1];

	var liObjArr = firstArr.getElementsByTagName('li');

	for (var i = 0; i < liObjArr.length; i++) {
		liObjArr[i].style.border = '1px solid blue';
	}

	var liObjArr2 = secondArr.getElementsByTagName('li');

	for (var i = 0; i < liObjArr2.length; i++) {
		liObjArr2[i].style.backgroundColor = 'skyblue';
		liObjArr2[i].style.border = '3px solid blue';
	}
</script>
</html>