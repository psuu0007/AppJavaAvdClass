<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	
<script type="text/javascript">
	
	

	var gugudanTitle = new Array();
	var gugudanVal = new Array();

	
	
	// 헤더 입력
	for (var i = 0; i < 8; i++) {
		gugudanTitle[i] = (i+2) + '단' + spaceFnc(10);
	}
	
	
	var cnt = 0;
	var cnt2 = 0;
	
	//구구단 내용 입력
	for (var i = 1; i < 9; i++) {
		for (var n = 1; n <= 9; n++) {
			gugudanVal[cnt] = (i+1) * n;
			cnt++;
		}
	}
	function gugudanFnc() {
		var danObj = document.getElementsByTagName('input')[0].value;
		/* var putObj = document.getElementsByTagName('div')[0]; */
		// 구구단 내용 출력문
		cnt = 0;	
		for (var i = danObj; i <= danObj; i++) {
			for (var n = 0; n < 9; n++) {
				document.write(i + spaceFnc(cnt) + ' * ' + spaceFnc(cnt) + (n+1) + spaceFnc(cnt) +
						' = ' + spaceFnc(cnt) + gugudanVal[cnt] + '<br>');
				cnt++;
				
			}
			document.write('<br>');
		}
	}
	
	
	
	//공백
	 function spaceFnc(spaceNum) {
		var spaceStr = '';
		
		for (var i = 0; i < spaceNum; i++) {
			spaceStr = spaceStr + '&nbsp;'
		}
		
		return spaceStr;
	}
	
	var spaceStr = spaceFnc();
	
	
	
	
</script>

</head>

<body>
	<form action="">
		<input type="text">
		<input type="button" onclick="gugudanFnc();" value="버튼">
		<!-- <div style="width: 400px; height: 400px; border: 1px solid black;">
		</div> -->
	
	</form>
	
</body>
</html>