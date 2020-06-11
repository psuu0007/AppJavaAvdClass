<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<style type="text/css">
nav > ul {
 	list-style-type: none; 
    padding: 0;
    overflow: hidden;
    background-color: #333333; 
    display: table; /* table을 주면  요소의 내용에 맞게 자동으로 크기 */ 
    margin-left: auto;
    margin-right: auto;
    
}

nav > ul > li {
	float: left;
}

nav > ul > li > a {
    display: block;
    color: white;  
    text-align: center;
    padding: 16px;
    text-decoration: none;
} 

nav > ul > li > a:hover { 
     color: #FFD9EC; 
     background-color: #5D5D5D; 
     font-weight: bold; 
 }  
 
.active {
	color: #FFD9EC;
	background-color: #5D5D5D;
	font-weight: bold;  
}
</style>

<!-- <script type="text/javascript"  -->
<!-- 	src="/springHome/resources/js/jquery-3.5.1.js"></script> -->
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script type="text/javascript">
	function goPageFnc(pageNumber){
<<<<<<< HEAD
		
// 		alert(pageNumber);
		var curPage = $('#curPage');
		
// 		curPage.value = pageNumber;
		curPage.val(pageNumber);
		
		var pagingForm = $('#pagingForm');
=======
// 		alert(pageNumber);
		var curPage = document.getElementById('curPage');
		
		curPage.value = pageNumber;
		
		var pagingForm = document.getElementById('pagingForm');
>>>>>>> branch 'master' of https://github.com/psuu0007/AppJavaAvdClass.git
		pagingForm.submit();
	}
	
	window.onload = function(){
		var curPage = document.getElementById('curPage');
		var pageButtonId = 'pageButton' + curPage.value;
		
		document.getElementById(pageButtonId)
			.setAttribute('class', 'active');
	}
</script>

	<nav>
		<ul>
			<li>
				<a href="#" 
					onclick="goPageFnc(${pagingMap.memberPaging.prevPage});">
					<span>≪</span>
				</a>
			</li>
			
			<c:forEach var="num" 
				begin="${pagingMap.memberPaging.blockBegin}" 
				end="${pagingMap.memberPaging.blockEnd}">
				
				<li id='pageButton${num}'>
					<a href="#" onclick="goPageFnc(${num});">
						<c:out value="${num}"/>
					</a>
				</li>
				
			</c:forEach>

			<li>
				<a href="#"
					onclick="goPageFnc(${pagingMap.memberPaging.nextPage});">
					<span>≫</span>
				</a>
			</li>
		</ul>
	</nav>

	
	
	