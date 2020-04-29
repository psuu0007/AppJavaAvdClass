<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
</style>

<script type="text/javascript">
   
   window.onload = function() {

      var newDivTag = document.createElement('div');
      var childDivTag = document.createElement('div');
      var buttonTag = document.createElement('button');
      var inputTag = document.createElement('input');
      
      var newDivText = document.createTextNode('요소(태그) 생성 연습');
      var buttonText = document.createTextNode('버튼1');
      
      newDivTag.setAttribute('id', 'theBox');
      newDivTag.setAttribute('style', 'background-color: silver; height: 80px;');
      buttonTag.setAttribute('id', 'btn1');
      inputTag.setAttribute('type', 'button');
      inputTag.setAttribute('value', '버튼2');
      
      newDivTag.appendChild(newDivText);
      newDivTag.appendChild(childDivTag);
      childDivTag.appendChild(buttonTag);
      childDivTag.appendChild(inputTag);
      buttonTag.appendChild(buttonText);
      
      var bodyTag = document.getElementsByTagName('body')[0];
      
      bodyTag.appendChild(newDivTag);
   }
   
</script>

</head>

<body>

     <!--  <div id='theBox' style="background-color: silver; height: 80px;">
            요소(태그) 생성 연습
         <div>
            <button id='btn1'>버튼1</button>
            <input type="button" value="버튼2">
         </div>
        </div> -->

</body>
</html>