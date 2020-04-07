<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
   div{
      border : 1px solid black;
      margin : 10px;
   }
</style>

<!-- 내가 좋아하는 게임의 종류는?
   RPG fPPTS 아케이드 전략 퍼즐 알티에스? TFT 슈팅 액션
   
   내가 좋아하는 노래 종류는?
   댄스 힙합 재즈 클래식 뉴에이지 팝
   
   대학 진학 제1지망 학과를 선택하시오?
   컴퓨터공학과 의류과 간호학과 법학과 체육학과 수학과 물리학과
   
   제2지망 학과를 선택하시오?
   실용음악과 현대무용과 예체능과 무아과
 
 -->

</head>
<body>
   <form>
      <div id='game'>
         <label for="game">내가 좋아하는 게임의 종류는??</label>
         <input type="checkbox" value="rpg" name='favoriteGame1'>RPG
         <input type="checkbox" value="fps" name='favoriteGame2'>FPS
         <input type="checkbox" value="arcade" name='favoriteGame3'>ARCADE
         <input type="checkbox" value="전략" name='favoriteGame4'>전략
         <input type="checkbox" value="puzzle" name='favoriteGame5'>PUZZLE
         <input type="checkbox" value="rts" name='favoriteGame6'>RTS
         <input type="checkbox" value="tft" name='favoriteGame7'>TFT
         <input type="checkbox" value="shooting" name='favoriteGame8'>SHOOTING
         <input type="checkbox" value="action" name='favoriteGame9'>ACTION
      </div>
      <div id='music'>
         <label for="music">내가 좋아하는 노래 종류는??</label>
         <input type="checkbox" value="dance" name='favoriteMusic1'>댄스
         <input type="checkbox" value="hiphop" name='favoriteMusic2'>힙합
         <input type="checkbox" value="jazz" name='favoriteMusic3'>재즈
         <input type="checkbox" value="classic" name='favoriteMusic4'>클래식
         <input type="checkbox" value="newage" name='favoriteMusic5'>뉴에이지
         <input type="checkbox" value="pop" name='favoriteMusic6'>팝
      </div>
      <div id='firstUniv'>
         <label for="firstUniv">대학 진학 제 1지망 학과를 선택하시오</label>
         <input type="radio" value="fUniv1" name="fUniv">컴퓨터공학과
         <input type="radio" value="fUniv2" name="fUniv">의류과
         <input type="radio" value="fUniv3" name="fUniv">간호학과
         <input type="radio" value="fUniv4" name="fUniv">법학과
         <input type="radio" value="fUniv5" name="fUniv">체육학과
         <input type="radio" value="fUniv6" name="fUniv">수학과
         <input type="radio" value="fUniv7" name="fUniv">물리과
      </div>
      <div id='secondUniv'>
         <label for="secondUniv">대학 진학 제 2지망 학과를 선택하시오</label>
         <input type="radio" value="sUniv1" name="sUniv">실용음악과
         <input type="radio" value="sUniv2" name="sUniv">현대무용과
         <input type="radio" value="sUniv3" name="sUniv">예체능과
         <input type="radio" value="sUniv4" name="sUniv">무아과
      </div>
   </form>

</body>
</html>