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
	font: bold 42px "굴림", Gulim;
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
	font: bold 35px "굴림", Gullim;
	width: 100px;
	height: 90px;
	margin-left: 20px;
	padding-top: 10px;
	color: #fff;
}

.tulip h2 {
	background: #c00;
}

.gallery li p {
	padding: 10px;
	text-align: justify;
}

#container {
	float: left;
}
</style>

</head>

<body>

	<h1>나의 아름다운 정원</h1>
	<p class="intro">
		사람들 아마 자신에게 <strong>자신감을 북돋워 주는</strong> 표정 있는 꽃들을 선호할 것이다.
	</p>

	<div id="container">
		<ul class="gallery">
			<li class="tulip"><h2>튜 울립</h2>
				<p>너무 화려하지 않으며 고귀한 느낌을 가지고 있다. 붉은 색이 단연 으뜸이며 한 송이만 있어도 빼어나다.</p></li>
		</ul>
	</div>

	<div id="container">
		<ul class="gallery">
			<li><h2 style="background-color: blue;">제 비꽃</h2>
				<p>겨울나러 갔던 제비가 돌아오는 무렵에 꽃이 핀다고 제비꽃이라 부른다고 한다.</p></li>
		</ul>
	</div>

	<div id="container">
		<ul class="gallery">
			<li><h2  style="background-color: orange;">호 박꽃</h2>
				<p>해독, 포용, 사랑의용기, 관대함, 아름다운 마음, ​등으로 긍정적인 꽃말을 지니고있다.</p></li>
		</ul>
	</div>

	<div id="container">
		<ul class="gallery">
			<li><h2 style="background-color: olive;">해바라기</h2>
				<p>숭배, 기다림, 다른 뜻으로 당신만을 사랑합니다.</p></li>
		</ul>
	</div>

</body>

</html>