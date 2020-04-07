<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

   <!-- 좋아하는 게임의 종류는? -->
   <!-- RPG FPS 아케이드 전략 퍼즐 RTS TFT 슈팅 액션 -->
   <!-- 좋아하는 노래 종류는? -->
   <!-- 댄스 힙합 재즈 클래식 유에이지 팝 -->
   <!-- 대학 진학 제 1지망 학과를 선택하시오  -->
   <!-- 컴퓨터공학과 의류과 간호학과 법학과 체육학과 수학과 물리과 -->
   <!-- 제 2지망 학과를 선택하시오  -->
   <!-- 실용음악과 현대무용과 예체능과 무아과 -->
   <div id='theme' style="border: 1px solid black;">
      <form>
         <div>
            <span style="font-weight: bold; font-size: 20px;">좋아하는 게임의 장르는?</span><br>
            <input type="checkbox" value="RPG" name='gameChk1'>RPG
            <input type="checkbox" value="FPS" name='gameChk2'>FPS
            <input type="checkbox" value="acade" name='gameChk3'>아케이드
            <input type="checkbox" value="tactics" name='gameChk4'>전략
            <input type="checkbox" value="puzzle" name='gameChk5'>퍼즐
            <input type="checkbox" value="rts" name='gameChk6'>RTS
            <input type="checkbox" value="tft" name='gameChk7'>TFT
            <input type="checkbox" value="shooting" name='gameChk8'>슈팅
            <input type="checkbox" value="action" name='gameChk9'>액션
         </div><br>
         <div>
            <span style="font-weight: bold; font-size: 20px;">좋아하는 노래 종류는?</span><br>
            <input type="checkbox" value="dance" name='songChk1'>댄스
            <input type="checkbox" value="hiphop" name='songChk2'>힙합
            <input type="checkbox" value="jazz" name='songChk3'>재즈
            <input type="checkbox" value="classic" name='songChk4'>클래식
            <input type="checkbox" value="newage" name='songChk5'>뉴에이지
            <input type="checkbox" value="pop" name='songChk6'>팝
         </div><br>
         <div>
            <span style="font-weight: bold; font-size: 20px;">대학 진학 제 1지망 학과를 선택하시오</span><br>
            <input type="radio" value="com" name='firstHope'>컴퓨터공학과
            <input type="radio" value="clo" name='firstHope'>의류과
            <input type="radio" value="hel" name='firstHope'>간호학과
            <input type="radio" value="bub" name='firstHope'>법학과
            <input type="radio" value="che" name='firstHope'>체육학과
            <input type="radio" value="mat" name='firstHope'>수학과
            <input type="radio" value="mul" name='firstHope'>물리과
         </div><br>
         <div>
            <span style="font-weight: bold; font-size: 20px;">제 2지망 학과를 선택하시오</span><br>
            <input type="radio" value="sil" name='secondHope'>실용음악과
            <input type="radio" value="hyn" name='secondHope'>현대무용과
            <input type="radio" value="yeh" name='secondHope'>예체능과
            <input type="radio" value="moo" name='secondHope'>무아과
         </div><br>
      </form>
   </div>
   
</body>
</html>