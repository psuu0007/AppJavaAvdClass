<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	document.write("<h3>문자치환</h3>");
	var theText1 = "img2_out.jpg";
	theText1 = theText1.replace("out.jpg", "over.jpg");
	document.write(theText1 + "<br />");

	document.write("<h3>문자추출</h3>");
	var theText2 = "images/img10.jpg";
	theText2 = theText2.split("/")[1];
	theText2 = theText2.substring(3);
	// 이슈1
	theText2 = parseInt(theText2);
	
	document.write(theText2 + "<br />");

	document.write("<h3>마지막 문자 추출</h3>");
	var theText3 = "hello javascript";
	var lastIndex = theText3.length - 1;
	theText3 = theText3.charAt(lastIndex);
	document.write(theText3 + "<br />");
	
	document.write();
	var theText4 = "tel phone now home";
	var findIndex = theText4.indexOf("mobile");
	
	if(findIndex < 0){
		document.write("텍스트에 찾는 문자가 없습니다.");
	}else{
		document.write("텍스트에 찾는 문자가 포함 되어있습니다.");
	}
</script>

</head>

<body>


</body>

</html>








