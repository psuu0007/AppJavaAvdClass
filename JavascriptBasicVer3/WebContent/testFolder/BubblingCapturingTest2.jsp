<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<style type="text/css">
#rootDiv {
	border: 5px solid red;
	padding: 30px;
}

#parentDiv {
	border: 5px solid green;
	padding: 30px;
}

#childBtn{
	border: 5px solid black;
	padding: 30px;
}

#parentDiv2 {
	border: 5px solid green;
	padding: 30px;
	margin-top: 10px;
}

#childBtn2 {
	border: 5px solid black;
	padding: 30px;
}
</style>
<script type="text/javascript">
	window.onload = function() {
		var rootDivObj = document.getElementById('rootDiv');
		rootDivObj.addEventListener('click', rootDivFunc, true);

		var parentDivObj = document.getElementById('parentDiv');
		parentDivObj.addEventListener('click', parentDivFunc, true);

		var childBtnObj = document.getElementById('childBtn');
		childBtnObj.addEventListener('click', childBtnFunc, true);

		var parentDivObj2 = document.getElementById('parentDiv2');
		parentDivObj2.addEventListener('click', parentDivFunc, false);

		var childBtnObj2 = document.getElementById('childBtn2');
		childBtnObj2.addEventListener('click', childBtnFunc, false);

	};

	function rootDivFunc() {
// 		alert('rootDiv');
		alert(this.id);
		alert(event.target.id);
// 		alert(this.title);
	}

	function parentDivFunc() {
// 		alert('parentDiv');
		alert(this.id);
		alert(event.target.id);

// 		alert(this.title);
	}

	function childBtnFunc() {
// 		alert("childBtn");
		alert(this.id);
		alert(event.target.id);
// 		alert(this.title);
	}
</script>
</head>

<body>
	rootDiv
	<div id='rootDiv' title="난 최상위 Div야">
		parentDiv
		<div id='parentDiv' title='난 첫번째 부모DIv야'>
			<button id="childBtn" title='난 첫번째 부모의 자식Button이야'>
				버튼1
			</button>
		</div>
		
		<div id='parentDiv2' title="난 두번째 부모 Div야">
			<button id="childBtn2" title="난 두번째 부모의 자식Button이야">
				버튼2
			</button>
		</div>
	</div>
</body>
</html>