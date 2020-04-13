<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>



</head>

<body>

	<div id='demo'></div>

	<input onclick="demoFnc()" type="button" value="실행">

</body>

<script type="text/javascript">
	var questionStr = '';
	questionStr = 'Iam can eat ban all day';

	var demoDiv = document.getElementById('demo');
	demoDiv.innerHTML = questionStr

	function demoFnc() {
		//공백을 기준으로 문자열을 나누어 배열에 담는다.
		/* questionStr = questionStr.toLowerCase(); */

		/* questionStr = questionStr.toLowerCase();
		solutionStr = solutionStr.substring(0, 1).toUpperCase() + solutionStr.substring(1); */

		/* var demoStrList = questionStr.split(' ');
		               
		demoStrList[0] = demoStrList[0].toLowerCase(); */

		/* demoStrList[4] = demoStrList[4].charAt(0).toUpperCase() 
		             + demoStrList[4].substring(1); */

		/* //i 소문자화
		demoStrList[0] = demoStrList[0].toLowerCase();
		
		//a만 대문자화
		demoStrList[4] = demoStrList[4].charAt(0).toUpperCase() + 
		               demoStrList[4].substring(1, demoStrList[4].length); */

		/* var demoStrList = [questionStr.substring(0, 3), questionStr.substring(4, 7)
		               , questionStr.substring(8, 11), questionStr.substring(12, 15)
		               , questionStr.substring(16, 19), questionStr.substring(20, 23)]; */

		/* substring은 charAt과 indexOf와 length를 알아야 한다 */

		var firstList = questionStr.substring(0, 4);
		var secondList = questionStr.substring(4, 8);
		var thirdList = questionStr.substring(8, 12);
		var fourthList = questionStr.substring(11, 16);
		var fifthList = questionStr.substring(16, 20);
		var sixthList = questionStr.substring(20, 23);

		firstList = firstList.charAt(0).toLowerCase() 
			+ firstList.substring(1);

		fifthList = fifthList.charAt(0).toUpperCase() 
			+ fifthList.substring(1);

		var solutionStr = '';
		//순서대로 재배치
		/* solutionStr += demoStrList[4];
		solutionStr += ' ';
		solutionStr += demoStrList[2];
		solutionStr += ' ';
		solutionStr += demoStrList[1];
		solutionStr += ' ';
		solutionStr += demoStrList[5];
		solutionStr += ' ';
		solutionStr += demoStrList[3];
		solutionStr += ' ';
		solutionStr += demoStrList[0]; */

		solutionStr += fifthList;
		solutionStr += thirdList;
		solutionStr += secondList;
		solutionStr += sixthList;
		solutionStr += fourthList;
		solutionStr += firstList;

		/* solutionStr += strList[4] + ' ';
		solutionStr += strList[2] + ' ';
		solutionStr += strList[1] + ' ';
		solutionStr += strList[5] + ' ';
		solutionStr += strList[3] + ' ';
		solutionStr += strList[0]; */

		//solutionStr = solutionStr.substring(0, 1).toUpperCase() + solutionStr.substring(1)

		//소문자로 변환 후 첫글자만 대문자로 바꿈
		/* solutionStr = solutionStr.toLowerCase();
		solutionStr = solutionStr.substring(0, 1).toUpperCase() + solutionStr.substring(1); */

		document.getElementById('demo').innerHTML = solutionStr;

	}
</script>

</html>






