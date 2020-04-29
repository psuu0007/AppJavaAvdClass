<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	/* 
	   자바스크립트의 DOM 제어 - 문서 객체 조작
	   .createElement( '태그명' )    -> 새로운 태그 생성
	   .createTextNode( content(String) )
	   .setAttribute( 속성명(name) , value값 )
	   선택요소.appendChild( 새 태그 )   -> 선택 태그에 새로운 자식 태그를 추가 
	 */
	window.onload = function() {

		//두 객체는 관계설정 없이 각각 독립적으로 생성하며
		//그 후에 .appendChild로 부모자식관계를 설정으로 해줌으로
		//객체지향적으로 만들 수 있다. 

		var newDivTag = document.createElement('div');
		//멀티태그들은 자식요소 textnode가 있음- 텍스트입력가능 (블럭태그는 대부분 멀티태그)
		var newDivText = document.createTextNode('요소(태그)');
		var spaceText = document.createTextNode(' ');
		var newDivText2 = document.createTextNode('생성 연습');

		//태그의 속성 수정
		/* = document.getElementById('')가 아닌
		   함수단위, .setAttribute로 할당~!!! ***현업에서 많이 씀*** */
		newDivTag.setAttribute('id', 'theBox');
		newDivTag.setAttribute('style',
				'background-color: silver; height:80px;');

		//선택 요소에 새로운 자식 요소를 추가
		newDivTag.appendChild(newDivText);
		newDivTag.appendChild(spaceText);
		newDivTag.appendChild(newDivText2);

		//newDivTag는 document에 div를 만들었을 뿐
		//문서에 관계설정은 되어있지 않으므로
		//body태그에 자식요소로 넣어주면 화면에 나타나진다.
		var bodyTag = document.getElementsByTagName('body')[0];

		bodyTag.appendChild(newDivTag);

	}
</script>

</head>

<body>

	<!-- <div id='theBox' style="background-color: silver; height:80px;">
      요소(태그) 생성 연습
   </div> -->

</body>
</html>