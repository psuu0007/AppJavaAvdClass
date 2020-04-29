<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
</style>

<script type="text/javascript">
	window.onload = function() {

		var bodyTag = document.getElementsByTagName('body')[0];

		var bigDivTag = document.createElement('div');
		bigDivTag.setAttribute('id', 'theBox');
		bigDivTag.setAttribute('style',
				'background-color: silver; height: 80px;');

		var bigDivText = document.createTextNode('요소(태그) 생성 연습');

		var smallDivTag = document.createElement('div');

		var btnTag = document.createElement('button');
		btnTag.setAttribute('id', 'btn1');

		var btnText = document.createTextNode('버튼1');

		var inputTag = document.createElement('input');
		inputTag.setAttribute('type', 'button');
		inputTag.setAttribute('value', '버튼2');

		bodyTag.appendChild(bigDivTag);
		bigDivTag.appendChild(bigDivText);
		bigDivTag.appendChild(smallDivTag);
		smallDivTag.appendChild(btnTag);
		smallDivTag.appendChild(inputTag);
		btnTag.appendChild(btnText);

	}
</script>

</head>

<body>


</body>
</html>