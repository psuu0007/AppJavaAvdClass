<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Hello Spring</title>

<style type="text/css">
	div{
		border: 1px solid black; width: 200px;
		background-color: orange;
		margin: 20px;
	}
</style>

<script type="text/javascript">

	var loginMove = function(){
		location.href = '/springHome/login.do';
	}
	
</script>


<body>

	Hello Spring Projects..

	<div onclick="loginMove();">
		로그인 버튼
	</div>
	
   
    
</body>

</html>