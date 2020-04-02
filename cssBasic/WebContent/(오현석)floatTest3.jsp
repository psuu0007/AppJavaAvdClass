<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
   "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

li {
	list-style-type: none;
}

body {
	font: 12px "굴림", Gulim;
	color: #333;
}

h1 {
	background: #ccc;
	padding: 10px 90px;
	letter-spacing: 3px;
}

.intro {
	padding: 10px;
	font-size: 120%;
}

.gallery li {
	width: 140px;
	text-align: center;
}

h2 {
	width: 100px;
	height: 20px;
	margin-left: 20px;
	padding-top: 10px;
	color: #fff;
}

.tulip h2 {
	background: #c00;
}

.jebi h2 {
	background: #248;
}

.hobak h2 {
	background: #f90;
}

.sunflower h2 {
	background: #880;
}

.gallery li p {
	padding: 10px;
	text-align: justify;
}

.container {
	clear: both;
	width: 500px;
	padding: 15px;
}
</style>

</head>


<body>
	<h1>나의 아름다운 정원</h1>
	<p class="intro">
		사람들 아마 자신에게 <strong>자신감을 북돋워 주는</strong> 표정 있는 꽃들을 선호할 것이다.
	</p>
	<div class="container">

		<ul class="gallery" style="float: left">
			<li class="tulip">
				<h2>튜 울립</h2>
				<p>너무 화려하지 않으며</p>
			</li>
		</ul>

		<ul class="gallery" style="float: left">
			<li class="jebi">
				<h2>제 비꽃</h2>
				<p>드물게 푸른색을 띠고</p>
			</li>
		</ul>


		<ul class="gallery" style="clear: left; float: left">
			<li class="hobak">
				<h2>호 박꽃</h2>
				<p>색도 모양도 화려하며</p>
			</li>
		</ul>

		<ul class="gallery" style="float: left">
			<li class="sunflower">
				<h2>해바 라기</h2>
				<p>태양만 바라보는</p>
			</li>
		</ul>
	</div>

	<br />

	<div class="container">
		<ul class="gallery" style="float: left">
			<li class="tulip">
				<h2 style="background-color: purple;">나 팔꽃</h2>
				<p>나팔을 닮았으며</p>
			</li>
		</ul>

		<ul class="gallery" style="float: left">
			<li class="jebi">
				<h2 style="background-color: brown;">목 화</h2>
				<p>문익점이 훔쳐온</p>
			</li>
		</ul>

		<ul class="gallery" style="float: left">
			<li class="hobak">
				<h2 style="background-color: pink;">무 궁화</h2>
				<p>한국의 국화이며</p>
			</li>
		</ul>

		<ul class="gallery" style="clear: left; float: left;">
			<li>
				<h2 style="background-color: hotpink;">벚꽃</h2>
				<p>봄의 시작을 알리는 꽃</p>
			</li>
		</ul>
	</div>

</body>
</html>