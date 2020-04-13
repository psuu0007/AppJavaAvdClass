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
	//1. reverse()-배열 데이터 역순 정렬
	var theFood = [ "짜장면", "냉면", "갈비탕", "돈까스", "삼겹살" ];
	theFood.reverse();
	console.log(theFood);

	//2. sort()-배열 데이터 이름또는숫자 정렬
	var theSubway = [ "2호선", "9호선", "7호선", "4호선", "3호선" ];
	theSubway.sort();
	console.log(theSubway);

	//3. concat()-배열들에 데이터를 결합
	var Mountain1 = [ "남산", "도봉산", "관악산", "청계산", "북한산" ];
	var Mountain2 = [ "설악산", "지리산", "한라산", "속리산" ];
	var joinResult = Mountain1.concat(Mountain2);
	console.log(joinResult);

	//4. slice(시작인덱스,마지막인덱스)-원하는 데이터만 선택
	var theName = [ "최준호", "이성은", "기오정", "김민경", "정예선" ];
	var result = theName.slice(2, 4);
	console.log(result);

	//5. join("구분자")-구분자 기준으로 데이터를 합칩니다.
	var theProduct = [ "냉장고", "컴퓨터", "선풍기", "밥솥", "핸드폰" ];
	var joinResult = theProduct.join("-");
	console.log(joinResult);
</script>

</html>








