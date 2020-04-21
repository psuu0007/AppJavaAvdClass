<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var obj = new Array();

	obj[0] = {
		productNo : '521822',
		productName : 'Animal Crossing: New Horizons',
		price : '$59.99'
	}
	
	obj[1] = {
		productNo : '111111',
		productName : 'hureja',
		price : '$99.99'
	}
	
	var productSummaryStr = '';

	for (var i = 0; i < obj.length; i++) {
		productSummaryStr = productSummaryStr + obj[i].productNo + '\n';
		productSummaryStr = productSummaryStr + obj[i].productName + '\n';
		productSummaryStr = productSummaryStr + obj[i].price;
		
		alert(productSummaryStr);
		productSummaryStr = '';
	}
	
</script>

</head>
<body>


</body>
</html>
