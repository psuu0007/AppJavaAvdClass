<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
	var arr = [];

	
	for(var i = 0; i < 100; i++){
		
		arr[i] = new Array(); 
		for(var j = 0; j < 100; j++){
			arr[i][j] = new Array();
			arr[i][j] = '';
		}
	}
	arr[0]['test'] = 10000;
// 	alert(arr);
	
	var arr2 = [{'name': 'psu', 'age': 30}, {'name':'ogh', 'age':20}];
	
// 	alert(arr2[0].name);
// 	alert(arr2[1].age);
	
	$(document).ready(function(){
		
		var time = 0;
		
		var intervalId = setInterval(function(){
			var pro = document.getElementById('progressbar');
			var proSpan = document.getElementById('progress-value');
			var proVal = document.getElementById('progress-value').childNodes[0];
			
// 			alert(proVal.nodeValue);
//	 		for (var i = 0; i < 100; i++) {
				pro.value = pro.value + 1;
				proSpan.innerHTML = Number(proVal.nodeValue) + 1;
//	 		}
			  time = pro.value;
		}, 100);
		
		
		
		setTimeout(function(){
			clearInterval(intervalId);
		}, 10000);
	
	});
	

</script>

</head>
<body>
	<div>
		<progress id="progressbar" value="0" max="100"></progress>
		<span id="progress-value">0</span>%
	</div>
</body>
</html>