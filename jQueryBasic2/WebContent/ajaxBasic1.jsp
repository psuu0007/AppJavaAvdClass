<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="./js/jquery-3.5.1.min.js"></script>
	
<script type="text/javascript">
	$(document).ready(function(){
		
		$.ajax({
			url: './employees.jso',
			dataType: 'json',
			success: function(data){
				alert("성공이닷! : " + data.employees);
			},
			error: function(e){
				alert('실패라니!');
			}
		});
		
	});
</script>
	
</head>

<body>

   <div id='ajaxDataPrint' style="border: 1px solid black;"> 
   		
   </div>

</body>

</html>