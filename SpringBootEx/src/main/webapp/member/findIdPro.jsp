<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${empty result}">
	<script>
    alert("이메일 없는데용?");
    history.back();
    </script>
</c:if>
    
<c:if test="${not empty result}">
	<script>
    alert("아이디는 ${result}입니다.");
    location.href = 'logonlogin'; 
    </script>	
</c:if>