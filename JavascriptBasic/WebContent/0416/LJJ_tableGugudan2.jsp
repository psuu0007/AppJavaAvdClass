<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이정주</title>
<style type="text/css">
	table,tr,td{
		border: 1px solid black;
		border-collapse: collapse;  
	}
	td{
		width: 80px;
		text-align: center;
	}

</style>
</head>
<body>
<div>
	<table>
		<tr>
			<td>2단</td>
			<td>3단</td>
			<td>4단</td>
			<td>5단</td>
			<td>6단</td>
			<td>7단</td>
			<td>8단</td>
			<td>9단</td>
		</tr>
		
		<tr>
			<td id='two'></td>
			<td id='three'></td>
			<td id='four'></td>
			<td id='five'></td>
			<td id='six'></td>
			<td id='seven'></td>
			<td id='eight'></td>
			<td id='nine'></td>
			
		</tr>
	</table>
</div>
</body>
<script type="text/javascript">
	var numArr = new Array();
	var valueArr2 = new Array();
	var valueArr3 = new Array();
	var valueArr4 = new Array();
	var valueArr5 = new Array();
	var valueArr6 = new Array();
	var valueArr7 = new Array();
	var valueArr8 = new Array();
	var valueArr9 = new Array();
	var count = 0;
	var count2 = 0;
	
	/* 2단 */
	for (var i = 2; i < 3; i++) {
		for (var j = 1; j < 10; j++) {
			valueArr2[count] =i*j;
			count++;
		}
	}
	
	count = 0;
	
	for (var i = 2; i < 3; i++) {
		for (var j = 1; j < 10; j++) {
			numArr[count2] =i + " * " + j + " = " + valueArr2[count] + " ";
			count++;
			count2++;
			
		}
	}
	
	count = 0;
	count2 = 0;
	
	
		for (var j = 1; j < 10; j++) {
			var two = document.getElementById('two');
			two.innerHTML += numArr[count2];
			count2++;
		}
	
	count = 0;
	count2 = 0;
	
	/* 3단 */
	for (var i = 3; i < 4; i++) {
		for (var j = 1; j < 10; j++) {
			valueArr3[count] =i*j;
			count++;
		}
	}
	
	count = 0;
	
	for (var i = 3; i < 4; i++) {
		for (var j = 1; j < 10; j++) {
			numArr[count2] =i + " * " + j + " = " + valueArr3[count] + " ";
			count++;
			count2++;
			
		}
	}
	count = 0;
	count2 = 0;
	
	for (var j = 1; j < 10; j++) {
		var three = document.getElementById('three');
		three.innerHTML += numArr[count2];
		count2++;
	}
	
	count = 0;
	count2 = 0;
	/* 4단 */
	for (var i = 4; i < 5; i++) {
		for (var j = 1; j < 10; j++) {
			valueArr4[count] =i*j;
			count++;
		}
	}
	
	count = 0;
	
	for (var i = 4; i < 5; i++) {
		for (var j = 1; j < 10; j++) {
			numArr[count2] =i + " * " + j + " = " + valueArr4[count] + " ";
			count++;
			count2++;
			
		}
	}
	count = 0;
	count2 = 0;
	
	for (var j = 1; j < 10; j++) {
		var three = document.getElementById('four');
		three.innerHTML += numArr[count2];
		count2++;
	}
	
	count = 0;
	count2 = 0;
	/* 5단 */
		for (var i = 5; i < 6; i++) {
		for (var j = 1; j < 10; j++) {
			valueArr4[count] =i*j;
			count++;
		}
	}
	
	count = 0;
	
	for (var i = 5; i < 6; i++) {
		for (var j = 1; j < 10; j++) {
			numArr[count2] =i + " * " + j + " = " + valueArr4[count] + " ";
			count++;
			count2++;
			
		}
	}
	count = 0;
	count2 = 0;
	
	for (var j = 1; j < 10; j++) {
		var three = document.getElementById('five');
		three.innerHTML += numArr[count2];
		count2++;
	}
	
	count = 0;
	count2 = 0;
	/* 6단 */
		for (var i = 6; i < 7; i++) {
		for (var j = 1; j < 10; j++) {
			valueArr4[count] =i*j;
			count++;
		}
	}
	
	count = 0;
	
	for (var i = 6; i < 7; i++) {
		for (var j = 1; j < 10; j++) {
			numArr[count2] =i + " * " + j + " = " + valueArr4[count] + " ";
			count++;
			count2++;
			
		}
	}
	count = 0;
	count2 = 0;
	
	for (var j = 1; j < 10; j++) {
		var three = document.getElementById('six');
		three.innerHTML += numArr[count2];
		count2++;
	}
	
	count = 0;
	count2 = 0;
	/* 7단 */
		for (var i = 7; i < 8; i++) {
		for (var j = 1; j < 10; j++) {
			valueArr4[count] =i*j;
			count++;
		}
	}
	
	count = 0;
	
	for (var i = 7; i < 8; i++) {
		for (var j = 1; j < 10; j++) {
			numArr[count2] =i + " * " + j + " = " + valueArr4[count] + " ";
			count++;
			count2++;
			
		}
	}
	count = 0;
	count2 = 0;
	
	for (var j = 1; j < 10; j++) {
		var three = document.getElementById('seven');
		three.innerHTML += numArr[count2];
		count2++;
	}
	
	count = 0;
	count2 = 0;
	/* 8단 */
		for (var i = 8; i < 9; i++) {
		for (var j = 1; j < 10; j++) {
			valueArr4[count] =i*j;
			count++;
		}
	}
	
	count = 0;
	
	for (var i = 8; i < 9; i++) {
		for (var j = 1; j < 10; j++) {
			numArr[count2] =i + " * " + j + " = " + valueArr4[count] + " ";
			count++;
			count2++;
			
		}
	}
	count = 0;
	count2 = 0;
	
	for (var j = 1; j < 10; j++) {
		var three = document.getElementById('eight');
		three.innerHTML += numArr[count2];
		count2++;
	}
	
	count = 0;
	count2 = 0;
	/* 9단 */
		for (var i = 9; i < 10; i++) {
		for (var j = 1; j < 10; j++) {
			valueArr4[count] =i*j;
			count++;
		}
	}
	
	count = 0;
	
	for (var i = 9; i < 10; i++) {
		for (var j = 1; j < 10; j++) {
			numArr[count2] =i + " * " + j + " = " + valueArr4[count] + " ";
			count++;
			count2++;
			
		}
	}
	count = 0;
	count2 = 0;
	
	for (var j = 1; j < 10; j++) {
		var three = document.getElementById('nine');
		three.innerHTML += numArr[count2];
		count2++;
	}
	
	count = 0;
	count2 = 0;
</script>
</html>