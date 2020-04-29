<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>웹 문서구조2</title>

<!-- 외부형 선언문 -->
<script type="text/javascript" src="./DomModelBasic2.js">
	alert('sdf');
</script>

</head>
<body>
   
   
   <!-- 구조화 -->
   <!-- getElementbyID, Parantnode , firstchild , priviues, newxt 는 같은 배경색-->
   <!-- tagname childnode children 은 같은 색, 폰트는 tagname 10 20 30-->
   <!-- 원거리선택자 근거리 선택자는 또ㅓㄱ같은 보더 -->


   <div>
      <h1 id="bigTitle">선택자</h1>
      <h2 id="title" class="setLine">
         원거리 선택자
      </h2>
      <ul>
         <li class="setColor">
            getElementById
         </li>
         <li class="setFont">
            getElementsByTagnName
         </li>
      </ul>
      <h2 id="title2" class="setLine">
         근거리 선택자
      </h2>
      <ul id="list">
         <li class="setColor">
            parentNode
         </li>
         <li class="setFont">
            childNodes
         </li>
         <li class="setFont">
            children
         </li>
         <li class="setColor">
            firstChild
         </li>
         <li class="setColor">
            previousSibling
         </li>
         <li class="setColor">
            nextSibling
         </li>
      </ul>
   </div>
</body>
</html>



