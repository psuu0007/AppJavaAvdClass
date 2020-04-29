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

		var btnObj = document.getElementById('deleteUlBtn');

		btnObj.setAttribute('onclick', 'removeFnc();');

	}

	function removeFnc() {
		var ulObj = document.getElementsByTagName('ul')[0];
		var bodyObj = document.getElementsByTagName('body')[0];
		
		bodyObj.removeChild(ulObj);
	}
</script>

</head>

<body>
	<h1 id='deleteUlBtn'>문서 객체 조작</h1>

	<ul>
		<li>리스트2</li>
		<li>리스트3</li>
		<li>리스트4</li>
		<li>리스트1</li>
	</ul>


</body>
</html>