<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<style type="text/css">
h1 {
	text-align: center;
}


</style>

</head>
<body>

		<h1>
			구구단 <br />
		</h1>

	<div>
		<script type="text/javascript">
			for (var i = 2; i <= 9; i++) {
				document.write(i + "단 <br/>");
				for (var j = 1; j <= 9; j++) {
					document.write(i + " * " + j + " = &nbsp;&nbsp;" + (i * j)
							+ "&nbsp;&nbsp;&nbsp;/&nbsp;&nbsp;");
				}
				document.write("<br/>");
			}
		</script>
	</div>
</body>
</html>