<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">
* {
	box-sizing: border-box;
}

.box {
	float: left;
	width: 33.33%;
	padding: 50px;
}

.clearfix::after {
	content: "";
	clear: both;
	display: table;
}
</style>

</head>


<body>
	<h1>나의 아름다운 정원</h1>

	<h2>Grid of Boxes</h2>
	<p>Float boxes side by side:</p>

	<div class="clearfix">
		<div class="box" style="background-color: #bbb">
			<p>Some text inside the box.</p>
		</div>
		<div class="box" style="background-color: #ccc">
			<p>Some text inside the box.</p>
		</div>
		<div class="box" style="background-color: #ddd">
			<p>Some text inside the box.</p>
		</div>
	</div>

	<p>Note that we also use the clearfix hack to take care of the
		layout flow, and that add the box-sizing property to make sure that
		the box doesn't break due to extra padding. Try to remove this code to
		see the effect.</p>

</body>
</html>