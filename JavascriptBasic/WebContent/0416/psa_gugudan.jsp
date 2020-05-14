<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>박상아</title>

</head>

<body id='body'>

</body>

<script type="text/javascript">
	
	var result = 0;
	
	document.write('<table style=\"border-collapse: collapse;\">');
	document.write('<tr>');
	for (var i = 2; i <= 9; i++) {
		document.write('<th style=\"border: 1px solid #000;\">' + i + '단' + '</th>');
	}
	document.write('</tr>');
	
	for (var i = 2; i <= 9; i++) {
		document.write('<tr>');
		for (var j = 2; j <= 9; j++) {
			result = j * i;
			document.write('<td style=\"border: 1px solid #000; border-collapse: collapse;\">');
			document.write(j + '*' + i + '=' + result + ' ');
			document.write('</td>');
		}
		document.write('</tr>');
	}
	document.write('</table>');
</script>

</html>