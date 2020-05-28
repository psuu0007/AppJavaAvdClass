<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
span{
	border: 1px solid black;
	margin-right: 30px;
}
</style>
<script type="text/javascript" src="./js/jquery-3.5.1.min.js"></script>

</head>

<body>

	<h2>JSON Object Creation</h2>

	<p id='demo'>
		
	</p>

</body>

<script type="text/javascript">
// 	json 객체를 생성하고
// 	name : John Johnson
// 	street : Oslo West 16
// 	phone : 555-1234567
	
// 	p태그에 name, street, phone 정보를 출력하시오
	
// 	<div>John Johnson</div> 스타일은 배경색 좀 넣어주자
// 	Oslo West 16
// 	555-1234567

	var text = '{"name" : "John Johnson",' +  
		'"street" : "Oslo West 16",' +
		'"phone" : "555-1234567"}';
	
	var jsonObj = JSON.parse(text);
	
	$.each(jsonObj, function(key, value) {
		var htmlStr = '';
		
		htmlStr += '<div>';
		htmlStr += '<span>' + key + '</span><span>' + value + '</span>';
		htmlStr += '</div>';
		
		$('#demo').append(htmlStr);
	});
</script>

</html>