<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>코드 순서</title>

<style type="text/css">
#id_first {
	color: blue;
}
div ol .cl_first, #id_third {
	color: yellow;
}
.cl_second{
	color: silver;
}
div ol li{
	color: olive;
}
div > ol > .cl_second {
	color: purple;
} 
div ol #id_first{
	color: green;
} 

</style>

</head>

<body>

	<div id='root'>
		<ol>
			<li id='id_first' class='cl_first'>first</li>
			<li id='id_second' class='cl_second'>second</li>
			<li id='id_third' class='cl_third'>third</li>
		</ol>
	</div>

</body>
</html>