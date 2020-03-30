<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">

	#firstUl > li{
		border: 1px solid black;
		padding: 10px;
	}
	
/* 	#firstUl li{ */
/* 		border: 1px solid black; */
/* 		padding: 10px; */
/* 	} */
	
	#testContainer div{
		border: 1px solid orange;
	}

/* 	#testContainer > ul > li > div{ */
/* 		border: 1px solid orange; */
/* 	} */

</style>

</head>

<!-- 하위 선택자 or 자손 선택자
한 선택자 내부에 존재하는 또 다른 선택자 -->

<body>
	<ul class='box' id='firstUl'>
		<li><a href="#">ul태그에 li태그에 경계선을 입힌다 1px</a></li>
		<li><a href="#">냉무</a></li>
		<li><a href="#">첫 ul에 존재하는 li의 패딩은 각 10px로 준다</a></li>
	</ul>

	<div id='testContainer'>
		<ul class='box'>
			<li>
				<div>
					<a href="#">
						a태그의 부모인 div들에 대해 경계선
						1px solid 오렌지색 적용
					</a>
				</div>
			</li>
			<li>
				<div>
					<a href="#">냉무</a>
				</div>
			</li>
		</ul>
	</div>
</body>
</html>