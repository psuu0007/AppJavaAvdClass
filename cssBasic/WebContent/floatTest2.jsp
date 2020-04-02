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
</style>

</head>


<body>
	<h1>나의 아름다운 정원</h1>

	<div id="container">
		<p class="intro">
			사람들 아마 자신에게 <strong>자신감을 북돋워 주는</strong> 표정 있는 꽃들을 선호할 것이다.
		</p>

		<ul class="gallery">
			<li class="tulip"><h2>튜 울립</h2>
				<p>너무 화려하지 않으며 고귀한 느낌을 가지고 있다. 붉은 색이 단연 으뜸이며 한 송이만 있어도 빼어나다.</p></li>
		</ul>
	</div>

</body>
</html>