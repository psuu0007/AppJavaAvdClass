<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.democlass {
  color: red;
  font-style: italic;
  font-family: fantasy;
  /* text-align:center; */
}
</style>

<script type="text/javascript">
   
   function myFunction(){
      var h1Obj = document.getElementsByTagName('h1')[0];
      
      h1Obj.style.textAlign = "center";
      
      h1Obj.removeAttribute("id"); 
   }
   
   function myPFnc(){
      var pObj = document.getElementById('demo');
      
      var styleStr = pObj.getAttribute('style');
      //alert(styleStr);
      
      if(styleStr == 'background-color: black; color: white;'){
//          pObj.style = '';
         pObj.removeAttribute('style');
      }else{
         pObj.style = 'background-color: black; color: white;';
      }
      
   }
   
   window.onload = function(){
      var btnObjList = document.getElementsByTagName('button');
      
      var h1Btn = btnObjList[0];
      var pBtn = btnObjList[1];
      
      h1Btn.addEventListener('click', myFunction, false);
      pBtn.addEventListener('click', myPFnc, false);
      
//       h1Btn.setAttribute('onclick', 'myFunction();');
//       pBtn.setAttribute('onclick', 'myPFnc();');
   }
   
</script>

</head>

<body>
   <h1 id='democlass' class="democlass">Hello World</h1>

   <p id="demo" style="background-color: black; color: white;">
      Click the button to remove the class attribute from
      the h1 element.
   </p>

<!--    누르면 h1의 아이디가 날라감 + text-align:center; -->
   <button onclick="myFunction();">Try it h1</button> 
<!--    누르면 p 백그라운드, 폰트컬러 없애기 , 다시누르면 다시 생김 -->
   <button>Try it p</button>   

   <!-- <h1 id='democlass' class="democlass">Hello World</h1>

   <p id="demo" style="background-color: black; color: white;">
      Click the button to remove the class attribute from
      the h1 element.
   </p>

   <button onclick="myFunction();">Try it p</button> -->

</body>
</html>

