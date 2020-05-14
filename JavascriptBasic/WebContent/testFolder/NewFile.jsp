<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>Insert title here</title>

<script type="text/javascript">
//console.log 사용
//콘솔 로그에다가 출력한다.

//배열에다가 2000년부터 2020년까지 있다. 
//윤년 판별을 해라 
/*    ① 서력 기원 연수가 4로 나누어 떨어지는 해는 우선 윤년으로 하고, 
   ② 그 중에서 100으로 나누어 떨어지는 해는 평년으로 하며, 
   ③ 다만 400으로 나누어 떨어지는 해는 다시 윤년으로 정하였다 
*/

   var yearList = new Array();
   
   for(var i = 2000; i <= 2020; i++){
      yearList[i-2000] = i;
   }
   
   
   for(var i = 0; i < yearList.length; i++){
      
      if((yearList[i] % 4 == 0) && (yearList[i] % 100 != 0)){
         console.log(yearList[i]+'년은 윤년이다.');
      }else if( yearList[i] % 400 == 0 ){
         console.log(yearList[i]+'년은 윤년이다.');
      }else{
         console.log(yearList[i]+'년은 윤년이 아니다.');
      }
      
   }

</script>

</head>

<body>
   

</body>
</html>