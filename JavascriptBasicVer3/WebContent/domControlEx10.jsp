<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
li {
	font-size: 30px;
}
</style>

<script type="text/javascript">
	window.onload = function() {
		var ulControlH1 = document.getElementById('updateBtn');

		ulControlH1.setAttribute('onclick', 'addFnc();');
	}

	function addFnc() {
		// 		alert('된다');

		var bodyObj = document.getElementsByTagName('body')[0];
		var ulObj = document.getElementsByTagName('ul')[0];

		var ulCloneObj = ulObj.cloneNode(false);
		
		//       alert(ulObj.children[0].textContent);
		var liObjArr = ulObj.getElementsByTagName('li');
		
		
		var liCloneArr = [];
		var newLiTextObj = '';
		
		for (var i = 0; i < liObjArr.length; i++) {
			liCloneArr[i] = liObjArr[0].cloneNode(false);
			newLiTextObj = document.createTextNode('리스트' + (i+1));
			liCloneArr[i].appendChild(newLiTextObj);
		}
		
		for (var i = 0; i < liCloneArr.length; i++) {
			ulCloneObj.appendChild(liCloneArr[i]);
		}
		
		bodyObj.insertBefore(ulCloneObj, ulObj);

	}
</script>

</head>

<body>
	<h1 id='updateBtn'>문서 객체 조작 버튼</h1>

	<ul>
		<li>리스트2</li>
		<li>리스트3</li>
		<li>리스트4</li>
		<li>리스트1</li>
	</ul>

</body>
</html>



