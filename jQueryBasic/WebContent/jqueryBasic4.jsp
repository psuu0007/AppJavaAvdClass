<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>


<script type="text/javascript" src='./jquery-3.5.1.min.js'></script>

<script type="text/javascript">
	
	$(document).ready(function() {
// 		$('body > *').css('color', 'red');
		
		$('body *').css('color', 'red');
	});

</script>

</head>

<body>

	<div>
		<ul>
			<li>apple</li>
			<li>bag</li>
			<li>cat</li>
			<li>dog</li>
			<li>god</li>
		</ul>
	</div>

	<div style="color: black;">
		나도 body의 자식이야
		<p>난 body의 자식이 아냐</p>
	</div>
</body>

</html>