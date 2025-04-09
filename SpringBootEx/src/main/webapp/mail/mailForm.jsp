<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>mail test</title>
</head>
<body>
    <!-- 이메일 전송 폼 -->
    <form action="/sendmail" method="post">
        이메일을 입력하세요:
        <input type="text" name="toEmail" required>
        <input type="submit" value="전송">
    </form>

    <br>

    <!-- 인증번호 확인 폼 -->
    <form action="/sendmailcheck" method="post">
        <input type="text" name="emailAuth" placeholder="인증번호 입력" required>
        <input type="submit" value="인증">
    </form>
</body>
</html>
