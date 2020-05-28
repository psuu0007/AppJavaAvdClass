<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="./js/jquery-3.5.1.min.js"></script>

<script type="text/javascript">
	var array = [
		{name: 'hanbit media', link: 'http://hanb.co.kr'},
		{name: 'daum', link: 'https://www.daum.net'},
		{name: 'naver', link: 'https://www.naver.com'}
	];
	
	alert(array[0].name);
	alert(array[0].link);
	
	$(document).ready(function() {
		var divObj = $('#thisIsView');		
		
		var output = '';
		$.each(array, function(index, item){
			output += '<div>';
			output += '<a href="' + item.link + '"> ' + item.name + '</a>';
			output += '</div>';
		});
		
		divObj.html(output);
	});
	
</script>

</head>

<body>

   <div id='thisIsView' style="border: 1px solid black;">
		 
   </div>

</body>

</html>