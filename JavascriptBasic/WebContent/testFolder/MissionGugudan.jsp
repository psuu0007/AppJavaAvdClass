<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<style type="text/css">
table, tr, td {
	border: 1px solid black;
	border-collapse: collapse;
}

table {
	margin: auto;
}

.danTitle {
	text-align: center;
	font-weight: bold;
}
</style>

</head>
<body>


</body>

<script type="text/javascript">
	document.write("<table>");
	document.write("<tr class='danTitle'>");
	for (var i = 2; i < 10; i++) {
		document.write("<td>" + i + "단</td>");
	}
	document.write("</tr>");
	document.write("<tr>");
	for (var i = 2; i < 10; i++) {
		document.write("<td>");
		for (var j = 1; j < 10; j++) {
			document.write(i + " * " + j + " = " + i * j);
			document.write("<br>");
		}
		document.write("</td>");
	}
</script>

</html>