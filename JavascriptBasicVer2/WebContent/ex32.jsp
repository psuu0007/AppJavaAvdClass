<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


</head>

<body>

	<h2>JavaScript Global Methods</h2>

<p>The Number() method converts variables to numbers:</p>

<p id="demo"></p>
</body>

<script type="text/javascript">
// 	 var num = '10';
	 var num = Number('10,');
	 var sum = 0;
	 
	sum = 100 + num;
	alert(sum);
	
	document.getElementById("demo").innerHTML = 
	  Number("10.33") + "<br>" + 
	  Number("10,33") + "<br>" +
	  Number("10 33") + "<br>" +
	  Number("John");

</script>
</html>






