<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	li{
		font-size: 30px;
	}
</style>

<script type="text/javascript">
	window.onload = function() {
		var theListObj = document.getElementById('theList');
		
		var liTag = document.createElement('li');
		var liText = document.createTextNode('리스트3');
		
		liTag.appendChild(liText);
		
		var liObjList = theListObj.getElementsByTagName('li');
		
// 		alert(liObjList[2].innerHTML);
// 		표현식 
// 		선택 태그.insertBefore(새 태그, 위치 태그);
// 		theListObj.insertBefore(liTag, liObjList[2]);
		
		// 잠시 보류
		theListObj.insertBefore(liTag, liObjList[2]);
		
	}
</script>

</head>

<body>
	<h1>문서 객체 조작</h1>

	<ul id='theList'>
		<li>리스트1</li>
		<li>리스트2</li>
		<li>리스트4</li>
	</ul>	

<!-- 	<ul id='theList'> -->
<!-- 		<li>리스트1</li> -->
<!-- 		<li>리스트2</li> -->
<!-- 		<li>리스트3</li> -->
<!-- 		<li>리스트4</li> -->
<!-- 	</ul> -->

</body>
</html>






