<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
   "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">
   /* 모든 ul */
   .box li {
      border: 1px solid darkgreen;
      padding: 10px;
   }
   
   /* 두번째 ul */
   .box:last-child li {
      border-color: yellow;
   }
   .box:last-child div{
      border: 1px solid orange;
      padding: 5px 10px 5px 10px;
   }
</style>

</head>


<body>
   <!-- 하위 선택자(Descendant Selector)
   한 선택자 내부에 존재하는 또 다른 선택자 -->

   자손 선택자

   <!-- 첫번째 ul start -->
   <ul class='box'>
      <li><a href="#">모든 li태그에 경계선을 입힌다 1px</a></li>
      <li><a href="#">첫 번째 ul태그의 li경계선 색상은 green</a></li>
      <li><a href="#">패딩은 각 10px로 준다</a></li>
   </ul>
   <!-- 첫번째 ul end -->

   <!-- 두번째 ul start -->
   <div>
      <ul class='box'>
         <li>
            <div>
               <a href="#">두 번째 ul의 li태그의 경계 색상은 위와 다른색 1px</a>
            </div>
         </li>
         <li>
            <div>
               <a href="#">div 태그의 div태그에도 경계 색상을 위와 다른색 1px 
               	패딩은 위 아래 5px 왼쪽  오른쪽 10px으로 준다 
               </a>
            </div>
         </li>
      </ul>
   </div>
   <!-- 두번째 ul end -->

</body>
</html>
