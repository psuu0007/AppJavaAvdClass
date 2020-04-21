<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	function spaceFnc(spaceNum) {
		var spaceStr = '';

		for (var i = 0; i < spaceNum; i++) {
			spaceStr = spaceStr + "&nbsp;";
		}

		return spaceStr;
	}
	
	var obj = {
		num : 100,
		myName : 'psu'
	}
	
	document.write(obj.num);
	document.write(obj.myName);
	
	
	
	
</script>

</head>

<body>
	<h1></h1>


</body>
</html>