<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>게시물 조회</title>
<style type="text/css">
     #mainWrap {
         width: 1000px;
         height: 600px;
         margin: auto;
     }
    .subTitle {
		height: 16;
		font-family: '돋움';
		font-size: 12;
		text-align: center;
	}
	.inputBox{
		border: none;
	}
	.inputArea{
		border: none; 
		resize: none; 
	}
     
     table {
       	border: 3px solid lightgray;
       	margin: auto;
       	width: 700px;
     }
        
   	tr, td {
   		border: 1px solid lightgray;
   	}
</style>

</head>

<body>
<jsp:include page="/common/Header.jsp" />
		
	<div id='mainWrap'>
		<br>
		<b style="margin-left: 25px;"><font size="6" color="gray">게시물 조회</font></b>
		<br>
	
		<form action="./update" method="get">
			<input type="hidden" name="no" value='${boardManagementDto.no}'/>
			<input type="hidden" name="page" value='${page}'/>
			<table>
				<tr>
					<td class="subTitle">작성자</td>
					<td>
						<input type="text" name="writer" value='${boardManagementDto.writer}'
							 maxlength="15" readonly="readonly" class='inputBox'/>
					</td>
				</tr>
				<tr>
					<td class="subTitle">제 목</td>
					<td>
						<input class='inputBox' type="text" name="title" size="70"
							   maxlength="100" value='${boardManagementDto.title}' readonly="readonly"/>
					</td>
				</tr>
				<tr>
					<td class="subTitle">내 용</td>
					<td>
						<textarea class='inputArea' name="context" cols="72" rows="20" 
							readonly="readonly">${boardManagementDto.context}</textarea>
					</td>
				</tr>
				<tr>
					<td class="subTitle">파일첨부</td>
					<td>
						<input type="file" name="board_file"/>
					</td>
				</tr>			
				<tr style="text-align: center;">
					<td colspan="5">						
						<c:if test="${member.email.equals('admin') || member.name 
							== boardManagementDto.writer}">
							<input type="submit" value="수정"> 
							<input type="button" value="삭제" 
								onclick="location.href = './delete?no=${boardManagementDto.no}'">
						</c:if> 
						<input type="button" value="목록" onclick="location.href = './list?page=${page}'">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="/common/Bottom.jsp" />
</body>
</html>