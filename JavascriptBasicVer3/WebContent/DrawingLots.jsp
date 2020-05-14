<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>랜덤추천 시스템</title>

<script type="text/javascript">
var stuInfoArr = new Array();
	
	function studentsAdd(){
		
		for (var i = 0; i < 17; i++) {
			stuInfoArr[i] = {
				no: i+1,
				name: ''
			};
		}
		
		stuInfoArr[0].name = '고재민'; 
		stuInfoArr[1].name = '김윤진'; 
		stuInfoArr[2].name = '김홍'; 
		stuInfoArr[3].name = '류제건'; 
		stuInfoArr[4].name = '박상아'; 
		stuInfoArr[5].name = '박지훈'; 
		stuInfoArr[6].name = '양우진'; 
		stuInfoArr[7].name = '오현석'; 
		stuInfoArr[8].name = '원아름'; 
		stuInfoArr[9].name = '윤형식'; 
		stuInfoArr[10].name = '이용훈'; 
		stuInfoArr[11].name = '이정주';
		stuInfoArr[12].name = '이찬양';
		stuInfoArr[13].name = '이환상';
		stuInfoArr[14].name = '정의광';
		stuInfoArr[15].name = '차정경';
		stuInfoArr[16].name = '황지원';
		
		var stuCntObj = document.getElementById('stuCnt');
		stuCntObj.innerHTML = '남은 학생수: ' + stuInfoArr.length + '명';
	}
	
	function drawingLots(){
		var inputNumTag = document.getElementById('inputNum');
		var num = Number(inputNumTag.value);
		var outputTag = document.getElementById('output');
		
		if(stuInfoArr.length == 0){
			alert('학생을 등록해줘');
			return;
		}
		
		if(num <= 0 || num > stuInfoArr.length){
			output.innerHTML = num + '은 안되, 1 ~' + stuInfoArr.length + '까지 가능해\n다시 ㄱㄱ';
			
			return;
		}
		
		
		var str = '';
		var stuNo = -1;
		
		for (var i = 0; i < num; i++) {
			// 0.12312312 ~ 13.342342
			stuNo = (Math.random() * stuInfoArr.length);
			stuNo = Math.floor(stuNo);
			
// 			alert('번호: ' + stuInfoArr[stuNo].no + ' / 이름: ' + stuInfoArr[stuNo].name);
			str = str + '번호: ' + stuInfoArr[stuNo].no 
				+ ' / 이름: ' + stuInfoArr[stuNo].name + '<br/>';
			
			
			stuInfoArr.splice(stuNo, 1);
		}
		
		outputTag.innerHTML = str;
		outputTag.style = 'border: 1px solid black; width: 300px;';
		
		var stuCntObj = document.getElementById('stuCnt');
		stuCntObj.innerHTML = '남은 학생수: ' + stuInfoArr.length + '명';
	}
	
	
</script>

</head>
<body>
	<input id='inputNum' type="text" value="" placeholder="숫자만 입력해! 몇 명?">
	<input id='inputBtn' type="button" value="랜덤추천 학생"
		onclick="drawingLots();">
	<input type="button" value="전체 학생 추가" onclick="studentsAdd();">
	<br />
	<br />

	<div id='output'></div>
	<span id='stuCnt'></span>

</body>


</html>