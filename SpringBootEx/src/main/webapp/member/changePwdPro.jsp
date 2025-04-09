<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="setting.jsp" %>
<script type="text/javascript" src="${project}script_member.js"></script>    

<c:if test="${result eq 0}">
	<script type="text/javascript">
		erroralert( "아니 아이디가 틀린데염?" );
	</script>
</c:if>

<c:if test="${result eq 1}">
	<script type="text/javascript">
		alert( "비밀번호가 변경되었습니다." );
		<c:redirect url="logonlogin"/>		
	</script>
</c:if>

<c:if test="${result eq 2}">
	<script type="text/javascript">
	erroralert( "아니 비밀번호가 전이랑 같은데염?" );	
	</script>
</c:if>