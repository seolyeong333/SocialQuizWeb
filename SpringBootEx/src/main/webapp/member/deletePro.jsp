<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="setting.jsp"%>
<script type="text/javascript" src="${project}script_member.js"></script>
  
<h2> ${page_delete} </h2>

<c:if test="${resultCheck eq 1}">
	<c:if test="${result eq 0}">	
		<script type="text/javascript">
			alert( error_delete );				
		</script>	
		<meta http-equiv="fresh" content="0; url=logonmain">		
	</c:if>
	<c:if test="${result eq 1}">				
		<c:redirect url="logonmain"/>			
	</c:if>
</c:if>
<c:if test="${resultCheck eq -1}">
	<script type="text/javascript">
		erroralert( error_passwd );
	</script>
</c:if>














