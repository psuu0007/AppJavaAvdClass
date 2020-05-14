<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>류제건</title>
	
<script type="text/javascript">
	var obj = document.getElementById('here');
	
	function guguVerOneFnc() {
		
		for (var i = 2; i <= 9; i++) {
			document.write('<div style="width: 80px; border:1px solid black; float: left;">');
			document.write('<div style="text-align: center; font-weight: bold; border-bottom: 1px solid black;">');
			document.write(i + '단');
			document.write('</div>');
			for (var j = 1; j <= 9; j++) {
				document.write(i + ' * ');
				document.write(j + ' = ');
				document.write((i)*(j) + ' ');
			}
			document.write('</div>')
		}

	}
	
	guguVerOneFnc();
	
	
</script>

</head>

<body id='here'>
	
</body>
</html>