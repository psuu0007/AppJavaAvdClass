<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>

<body>

</body>
<script type="text/javascript">
   /* 배열에다가 2000년부터 2020년까지 윤년 판별을 해라
      결과는 console log로 출력해라  */

   var leapYearArr = new Array();

   var startYear = 1900;
   var endYear = 2020;
   var count = 0;

   for (var i = startYear; i <= endYear; i++) {
      leapYearArr[count] = i;
      if ((i % 4 == 0 && i % 100 != 0) || (i % 400 == 0)) {
         leapYearArr[count] = i + " : 윤년";
         //console.log(leapYearArr[count] + " : 윤년입니다.");
         count++;
      } else {
         leapYearArr[count] = i + " : 윤년이 아닙니다.";
         //console.log(leapYearArr[count] + " : 윤년이 아닙니다.");
         count++;
      }
   }
   console.log(leapYearArr);
</script>

</html>