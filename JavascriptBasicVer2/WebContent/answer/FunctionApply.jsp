<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>

</head>
<body>

</body>

<script type="text/javascript">

	var gugudanResultNumArr = new Array();
	function setGugudan(putNum){
		var gugudanFormulaStr = '';
		var spaceStr = '';
		
		for (var i = 0; i < 9; i++) {
			for (var n = 0; n < (i + 1); n++) {
				spaceStr += '&nbsp;';
			}
			gugudanFormulaStr = 2 + spaceStr + '*' + spaceStr 
				+ (i+1) + spaceStr + '=' + spaceStr;
			gugudanResultNumArr[i] = gugudanFormulaStr + ((i * putNum) + putNum);
			
			spaceStr = '';
		}
		
	}

	function getGugudan(){
		var gugudanResult = '';
		
		for (var i = 0; i < gugudanResultNumArr.length; i++) {
			gugudanResult = gugudanResult + gugudanResultNumArr[i] + '<br/>';
		}
				
		return gugudanResult;
	}
	
	setGugudan(2);
	
	var gugudanResult = getGugudan();
	
	document.write(gugudanResult);
	
	
	
	
	
	
	
</script>


</html>