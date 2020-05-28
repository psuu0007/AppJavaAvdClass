<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Hello Spring</title>

<script type="text/javascript">
	window.onload = function() {
		var inputObj = document.getElementById('anonymous');
		
		inputObj.addEventListener("click", function(e) {
			location.href = './home.do';	
		}, false);
	}
</script>

</head>

<body>

   Hello Spring Projects..
   
    
   딱 하나 버튼만들어서 누르니까 home.do로 넘어가드라
<!--    <a href='./home.do'>눌렀다</a> -->
   
   <form action="./home.do" method="post">
   	<input id='anonymous' type="button" 
   		value="get로 전송">
   	<input type="submit" value="post로 전송">
   </form>

</body>

</html>