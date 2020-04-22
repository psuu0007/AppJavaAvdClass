<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>Insert title here</title>
   
<script type="text/javascript">
   
//표현식
/* addEventListener('이벤트명', 함수명, 아직 시기상조); 이벤트명은 on빼고 적는다 */
   
   window.onload = function() {
      var divBorder = document.getElementById('border');
      divBorder.style.border = '1px solid black';
      divBorder.style.width = '350px';
      
      var pwdObj = document.getElementById('pwdSerch');
      pwdObj.addEventListener('click', textFnc, false);
   }
   
   function textFnc() {
      var textObj = document.getElementById('pwd');
      var textValue = textObj.value;
      
      document.getElementById('texta').innerHTML = textValue;
   
   }
   
   
</script>

</head>

<body>
   
   <!--비밀번호를 입력한 후 비밀번호 찾기 버튼을 클릭하면
      텍스트에어리어에 비밀번호가 나타난다 -->
   <div id='border'> <!--보더  -->
      <input id="pwd" type="password">
      <button id='pwdSerch'>비밀번호 찾기</button>
   </div>
   
   <textarea id="texta" rows="2" cols="12"></textarea>
   
   
</body>
</html>