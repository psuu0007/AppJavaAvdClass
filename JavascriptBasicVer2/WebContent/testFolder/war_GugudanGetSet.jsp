<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>원아름</title>
<!-- 									특수코드	개수
2 * 1 = 2								&nbsp;	1
2  *  2  =  4									2
2   *   3   =   6								3
2    *    4    =    8							4
2     *     5     =     10						5	
2      *      6      =      12					6
2       *       7       =       14				7
2        *        8        =        16			8
2         *         9         =         18 		9

공백은 &nbsp;
함수명	setGugudan
		setGugudan은 리턴값이 없다
		setGugudan은 putNum의 매개변수만 받는다
	
		getGugudan
		getGugudan은 문자열을 반환해야 한다
	
		getGugudan을 통해 받은 내용을 출력한다
-->	
<script type="text/javascript"> 

	window.onload = function() {	 
		//띄어쓰기리스트
		spaceStrList = new Array();
		
		danNum = 0; 
		result = new Array();	 
	}
	
	//<input>의 숫자를 받아서 setGugudan에 매개변수로 넣음.
	function getNumber(){
		var inputNum = document.getElementById('dan').value;
		
		setGugudan(inputNum);
	}
	
	
	//setGugudan은 리턴값이 없다
	//setGugudan은 putNum의 매개변수만 받는다
	function setGugudan(putNum){
		
		// 단 저장
		danNum = Number(putNum);
		
		//구구단 계산
		for(var i = 0; i < 9; i++){
			result[i] = danNum * (i+1);
		}	
		
		
		// 띄어쓰기 리스트 저장 
		var space = '&nbsp;';
		
		for(var i = 0; i < 9; i++){
			
			var sumStr = '';
			for(var j = 0; j < i+1; j++){
				sumStr += space;
			}
			
			spaceStrList[i] = sumStr;
		}
		
	}

	
	//getGugudan은 문자열을 반환해야 한다
	function getGugudan(){
		 
		var gugudanStr = '';
		
		//출력 문자열
		for(var i = 0; i < 9; i++){
			gugudanStr += danNum + spaceStrList[i];
			gugudanStr += '*' + spaceStrList[i];
			gugudanStr += (i+1) + spaceStrList[i];
			gugudanStr += '=' + spaceStrList[i];
			gugudanStr += result[i] + '<br/>';
		}
		 
		return gugudanStr;
	}
	
	
	//getGugudan을 통해 받은 내용을 출력한다
	function outputFnc(){
		document.getElementById('outputDiv').innerHTML = getGugudan();
	}
	
</script>
</head>

<body>
	
	<h1>구구단</h1>
	
	<p>원하는 숫자를 입력해 주세요.</p>
	단 : <input id="dan" type="number" value="" onblur="getNumber();">
	<input id="output" type="button" value="구구단 출력" onclick="outputFnc();">
	
	<div id="outputDiv">
	</div>
	
	
</body>
</html>