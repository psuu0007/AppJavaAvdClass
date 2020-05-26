<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>글수정</title>

<style type="text/css">
	
	#wholeDiv{
		width: 600px;
		margin: auto;
		height: 700px;
		border: 1px solid white;
		padding-top: 150px;
	}
	
	#firstDiv{
		width: 600px;
		margin: auto;
		border: 1px solid #DAD9FF;;
		text-align: center;

	}
	
	#secondDiv{
		height: 80px;
		line-height: 80px;
		font-size: 30px;
		font-weight: bold;
		border: 1px solid #DAD9FF;;
		text-align: center;
	}
	
	#threeDiv{
		height: 300px;
		text-align: left;
		font-size: 15px;
		padding-top: 10px;
		padding-left: 10px;
		border: 1px solid #DAD9FF;;
	}
	
	#fourDiv{
		height: 80px;
		line-height: 80px;
		font-size: 20px;
		font-weight: bold;
		border: 1px solid #DAD9FF;;
		text-align: center;
	}
	
 	#firstInput{ 
 		float: right; 
		width: 70px;
		height: 40px;
		margin-top: 10px;
		margin-left: 10px;
		border: none;		
 	}
 	
 	#secondInput{ 
 		float: right; 
		width: 70px;
		height: 40px;
		margin-top: 10px;
		margin-left: 10px;
		border: none;
 	}
 	
 	#threeInput{
 		float: right; 
		width: 70px;
		height: 40px;
		margin-top: 10px;
		border: none;
 	}
 	
 	.inputTag{
 		font-size: 20px;
 	}
 	
</style>

</head>



<body>

	<jsp:include page="/Header.jsp"></jsp:include>
	
	<div id="wholeDiv">
		<form action="./update" method="post">
			<div id="firstDiv">
				<div id="secondDiv">
					공지사항
				</div>
				<div id="threeDiv">

				<c:if test="${sessionScope.memberDto.adminCheck eq 'Y'}">
					제목 : <input class="inputTag" type="text" value="${requestScope.noticeDto.title}"	name="title">
					<br>
					<br>	
						<p style="float: left;">내용 :</p>
						<textarea style="width: 500px; height: 240px; float: left; margin-left: 5px;" rows="10" cols="10" name="contents" onKeyUp="javascript:fnChkByte(this,'90')">${requestScope.noticeDto.contents}</textarea>
					
				</c:if>
				<c:if test="${sessionScope.memberDto.adminCheck eq 'N'}">
					제목 : <input class="inputTag" type="text" value="${requestScope.noticeDto.title}" name="title" readonly="readonly"><br>
					<br>	
							
					<p style="float: left;">내용 :</p>
					<textarea style="width: 500px; height: 240px; float: left; margin-left: 5px;" rows="10" cols="10" name="contents">${requestScope.noticeDto.contents}</textarea>
				</c:if>
						
						<input type="hidden" value="${requestScope.noticeDto.writer}" name="writer">
						<input type="hidden" value="${requestScope.noticeDto.no}" name="no">

				</div>
				<div id="fourDiv">
				관리자
				</div>
			</div>
			<input id="firstInput" type="button" value="뒤로가기" style="background-color: #FFBB00; color: white;
				border-radius: 5px;" onclick='pageMoveFnc();'>
			<c:if test="${sessionScope.memberDto.adminCheck eq 'Y'}">
				<input id="secondInput" type="button" value="삭제" style="background-color: #00D8FF; color: white;
					border-radius: 5px;" onclick="pageDeleteFnc(${requestScope.noticeDto.no});">
				<input id="threeInput" type="submit" value="저장" style="background-color: #47C83E; color: white;
					border-radius: 5px;" >
			</c:if>
		</form>
		
	</div>
	
	<jsp:include page="/Tail.jsp"></jsp:include>
</body>

<script type="text/javascript">
	
	function pageMoveFnc() {
		
		location.href = './list';
	}
	
	function pageDeleteFnc(no) {
		
		var url = "./delete?no=" + no;
		location.href = url;
	}
	
	
		
		function fnChkByte(obj, maxByte){
			
		    var str = obj.value;
		    var str_len = str.length;

		    var rbyte = 0;
		    var rlen = 0;
		    var one_char = "";
		    var str2 = "";


		    for(var i=0; i<str_len; i++){
		    	
		        one_char = str.charAt(i);
		        
		        if(escape(one_char).length > 4){
		        	
		            rbyte += 2;                                         //한글2Byte
		        }
		        else
		        {
		            rbyte++;                                            //영문 등 나머지 1Byte
		        }


		        if(rbyte <= maxByte)
		        {
		            rlen = i+1;                                          //return할 문자열 갯수
		        }
		     }


		     if(rbyte > maxByte)
		     {
		  alert("한글 "+(maxByte/2)+"자 / 영문 "+maxByte+"자를 초과 입력할 수 없습니다.");
		  str2 = str.substr(0,rlen);                                  //문자열 자르기
		  obj.value = str2;
		  fnChkByte(obj, maxByte);
		     }
		     else
		     {
		        document.getElementById('byteInfo').innerText = rbyte;
		     }
		}
		
		
	
	
</script>

</html>