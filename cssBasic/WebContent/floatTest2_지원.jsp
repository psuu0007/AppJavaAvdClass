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

#flower1 h2 {
	background: red;
}

#flower2 h2 {
	background: orange;
}

#flower3 h2 {
	background: yellow;
}

#flower4 h2 {
	background: green;
}

#flower5 h2 {
	background: blue;
}

#flower6 h2 {
	background: navy;
}

#flower7 h2 {
	background: purple;
}

#flower8 h2 {
	background: black;
}

.gallery li p {
	padding: 10px;
	text-align: justify;
}

li {
	float: left;
}

</style>

</head>

<body>
	<h1>나의 아름다운 정원</h1>

	<div id="container">
		<p class="intro">
			사람들 아마 자신에게 <strong>자신감을 북돋워 주는</strong> 
			표정 있는 꽃들을 선호할 것이다.
		</p>

		<div class='divClass' style="float: left;">
			<ul class="gallery">
				<li id="flower1">
					<h2>튜 울립</h2>
					<p>너무 화려하지 않으며</p>
				</li>
				<li id="flower2">
					<h2>제 비꽃</h2>
					<p>드물게 푸른색을 띠고</p>
				</li>
			</ul>
		</div>

		<div class='divClass' style="clear: left">
			<ul class="gallery">
				<li id="flower3">
					<h2>호 박꽃</h2>
					<p>색도 모양도 화려하며</p>
				</li>
				<li id="flower4">
					<h2>해바 라기</h2>
					<p>태양만 바라보는</p>
				</li>
			</ul>
		</div>

		<div class='divClass' style="clear: left">
			<ul class="gallery">
				<li id="flower5">
					<h2>튜 울립</h2>
					<p>너무 화려하지 않으며</p>
				</li>
				<li id="flower6">
					<h2>제 비꽃</h2>
					<p>드물게 푸른색을 띠고</p>
				</li>
				<li id="flower7">
					<h2>호 박꽃</h2>
					<p>색도 모양도 화려하며</p>
				</li>
			</ul>
		</div>

		<div class='divClass' style="clear: left">
			<ul class="gallery">
				<li id="flower8">
					<h2>해바 라기</h2>
					<p>태양만 바라보는</p>
				</li>
			</ul>
		</div>
	</div>

</body>
</html>