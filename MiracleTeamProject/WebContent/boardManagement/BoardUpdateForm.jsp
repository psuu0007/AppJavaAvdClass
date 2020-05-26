<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>글 수정</title>

<style type="text/css">
	    #mainWrap{
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
        
        table {
        	border: 3px solid lightgray;
        	margin: auto;
        	width: 700px;
        }
        
       	tr, td {
       		border: 1px solid lightgray;
       	}
</style>

<script type="text/javascript">
	function pageMoveListFnc(){
		location.href = "./search?no=${boardManagementDto.no}&page=${page}";
	}
</script>

</head>

<body>
<jsp:include page="../common/Header.jsp"/>

	<div id='mainWrap'>
		<br>
	    <b style="margin-left: 25px;"><font size="6" color="gray">글수정</font></b>
	    <br>
	    
	    <form method="post" action="./update">
	    <input name="no" type="hidden" value="${boardManagementDto.no}">
	    <table>
	        <tr>
	            <td class="subTitle">작성자</td>
	            <td>
	            	<input name="writer" type="text" value="${boardManagementDto.writer}"
	            		 readonly="readonly" maxlength="20">
	            </td>
	        </tr>
	            <tr>
	            <td class="subTitle">
	                             제 목
	            </td>
	            <td>
	                <input name="title" type="text" size="70" 
	                	maxlength="15" value="${boardManagementDto.title}"/>
	            </td>        
	        </tr>
	        <tr>
	            <td class="subTitle">
	                             내 용
	            </td>
	            <td>
	                <textarea name="context" cols="72" rows="20"
	                	 style="resize: none">${boardManagementDto.context}</textarea>            
	            </td>        
	        </tr>
	        <tr>
	            <td class="subTitle">
	                             파일첨부
	            </td>
	            <td>
	                <input type="file" name="board_file" />
	            </td>    
	        </tr>
	 
	        <tr align="center" valign="middle">
	            <td colspan="5">
	                <input type="submit" value="수정완료" >
	                <input type="reset" value="복구">
	                <input type="button" value="수정취소" onclick='pageMoveListFnc();'>           
	            </td>
	        </tr>
	    </table>    
	</form>
	</div>
<jsp:include page="../common/Bottom.jsp"/>
</body>
</html>