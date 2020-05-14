<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>원아름</title>

<script type="text/javascript">
	
	//테이블 생성 
	document.write("<table id='gugudanTB'>");
	for(var n = 1; n<=10; n++){	
		document.write("<tr>");
		//단
		for(var m = 2; m<=9; m++){	
			document.write("<td>");
			document.write("</td>");
		}
		document.write("</tr>");
	}
	document.write("</table>");
	
	
	var tableObj =  document.getElementById("gugudanTB");
	var tdObjArr = tableObj.getElementsByTagName('td');
	 
	
	// 단 입력
	for(var i =2; i<=9; i++){
		tdObjArr[i-2].innerHTML = i+"단 ";
	}
	
	
	var count = 8;
	var result = 0;
	// * 1~9
	for(var n = 1; n<=9; n++){	
		//단
		for(var m = 2; m<=9; m++){	
			result = m * n;
			
			tdObjArr[count].innerHTML = m+" * "+n+"="+ result ;
			
			count++;
		}
	}
	
</script>

</head>

<body id="bodyContent">
	
</body>
</html>