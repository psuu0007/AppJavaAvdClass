<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>

<body>
   <div style="width: 100px; 
   	height: 300px; border: 1px solid black;" id='demo'></div>
   <button onclick="arrPrintFnc();">출력</button>
</body>

<script type="text/javascript">

   var Mountain1 = [ "남산", "도봉산", "관악산", "청계산", "북한산" ];
   var Mountain2 = [ "설악산", "지리산", "한라산", "속리산" ];
   
//   var joinResult = Mountain1.concat(Mountain2);
   
   function arrPrintFnc(){
      var obj = document.getElementById('demo');
      var joinResult = new Array();
      var count = 0;
      
      for (var i = 0; i < Mountain1.length; i++) {
         joinResult[count] = Mountain1[i];
         count++;
      }
      
      for (var i = 0; i < Mountain2.length; i++) {
         joinResult[count] = Mountain2[i];
         count++;
      }
      
      count = 0;
      for (var i = 0; i < joinResult.length; i++) {
         obj.innerHTML += i + ' : ' + joinResult[i] + '<br/>';
      }
   }
   
</script>

</html>