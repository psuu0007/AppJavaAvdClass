<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>Insert title here</title>   

</head>

<body>
   <form>
	   <input id='yourNumber1' type="text" value="">+
	   <input id='yourNumber2' type="text" value="">=
	   <input id='resultNumber' type="text" value="">
   
	   <div>
	         버튼을 클릭하면 사용자가 입력한 두 숫자를 더해서
	         input 태그에 결과값을 출력한다.
	   </div>
   
   		<input type="button" value="더하기 버튼" onclick="sumNumFnc();">
   </form>
   
</body>

   <script type="text/javascript">
      
   		function sumNumFnc() {
			var firstNum = document.getElementById('yourNumber1').value;
			var secondNum = document.getElementById('yourNumber2').value;
			var result = Number(firstNum) + Number(secondNum);
			
			document.getElementById('resultNumber').value = result;
		}
   
   </script>
   
</html>