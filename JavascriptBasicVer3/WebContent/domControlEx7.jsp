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
		var liObjList = theListObj.getElementsByTagName('li');
		
// 		선택 태그를 복제한 객체를 반환  
// 		liObjList[3].cloneNode(true); 
// 		매개변수 : true-> 나 포함 자식까지 완전복제
// 				 false -> 나만 포함(자식배제)한 복사
		var copyLiObj = liObjList[3].cloneNode(false);
		
		// 잠시 보류
		theListObj.insertBefore(copyLiObj, liObjList[0]);
		
		//선택 태그의 자식인 태그를 삭제한다
		theListObj.removeChild(liObjList[4]);
	}
</script>

</head>

<body>
	<h1>문서 객체 조작</h1>

	<ul id='theList'>
		<li>리스트2</li>
		<li>리스트3</li>
		<li>리스트4</li>
		<li>리스트1</li>
	</ul>
</body>
</html>






