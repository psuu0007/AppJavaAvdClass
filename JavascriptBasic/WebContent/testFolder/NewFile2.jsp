<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>



</head>

<body>
   <div id='demo'>
      I can eat bananas all day
   </div>
   
   <input onclick="txtChangeFnc();" type="button" value="실행">

</body>

<script type="text/javascript">
   
   /* 13_2 수정  */
   function txtChangeFnc(){
      var questionStr = '';
      questionStr = 'Iam can eat ban all day';
      
      var solutionStr = '';
      var strList = questionStr.split(' '); 
   
      //i 소문자화
      strList[0] = strList[0].toLowerCase();
      
      //a만 대문자화
      strList[4] = strList[4].charAt(0).toUpperCase() + 
      	strList[4].substring(1, strList[4].length);
      
      //재조합
      solutionStr += strList[4] + ' ';
      solutionStr += strList[2] + ' ';
      solutionStr += strList[1] + ' ';
      solutionStr += strList[5] + ' ';
      solutionStr += strList[3] + ' ';
      solutionStr += strList[0];
      
     
      //원하는 출력
      //var solutionStr = 'All eat can day bananas i';
      document.getElementById('demo').innerHTML = solutionStr;
   }
   
   
</script>

</html>






