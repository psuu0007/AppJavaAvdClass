<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>Insert title here</title>
<style type="text/css">
   *{margin:0; padding:0;}
   h1{margin: 20px;}
   img{vertical-align:top; border:0;}
   #galleryWrap{width:550px; margin:0 auto; text-align:center;}
   #galleryWrap img{vertical-align:middle;}
</style>
<script type="text/javascript">
var num = 1;


	function nextGallery() {
		if (num >= 7) {
			return false;
		}

		num++;
		//if(num>7) num=1;

		document.getElementById("gallery").src = "images/img" + num + ".jpg";
	}

	function prevGallery() {
		num--;
		//if(num<1) num=7;
		if (num < 1) {
			num = 1;
		}
		document.getElementById("gallery").src = "images/img" + num + ".jpg";
		return false;
	}
</script>

</head>
<!-- 
   함수(function)
   일련의 실행문들을 메모리에 저장했다가 필요할 때 해당 함수의 이름으로 
   다시 호출하여 사용할 수 있다. 
 -->
<body>
<!-- #id : 동일한 id위치로 이동한다.(위치이동) -->
<!-- 같은 페이지 내 위치전환이 가능하다.  -->

   <div id="galleryWrap" style="margin : 150px auto;">
      <h1>이미지 넘기기</h1>
      <p>
         <!-- a태그를 보면 text-decoration값이 들어있다. 그걸 해제시키면 됨~!! -->
         <!-- 나는 a태그를 보고 색상이 들어있어서 눈속임으로 색상변경.. -->
         <!-- <a href="#prev" onclick="prevGallery();" style="color:white;"> -->
         <a href="#prev" onclick="prevGallery();" 
         	style="text-decoration: none;">
            <img src="images/left_btn.png" alt="이전 그림"/>
         </a>
         
         <!-- 원래는 공백없이 붙이면 가능함~(공백=데이터) 하지만 가독성을 해침-->
         <!-- <a href="#prev" onclick="prevGallery();" 
         	style="text-decoration: none;"><img src="images/left_btn.png" alt="이전 그림" /></a> -->
         
         <img src="images/img1.jpg" alt="갤러리 그림" id="gallery"/>
         
         <a href="#next" onclick="nextGallery();">
            <img src="./images/right_btn.png" alt="다음 그림"/>
         </a>
      </p>
   </div>
   
</body>
</html>