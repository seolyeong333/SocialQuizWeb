	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="setting.jsp"%>

<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<br>
  <div class="position-absolute top-0 end-0 m-3">
    <a href="../home" class="btn btn-outline-primary">메인페이지</a>
  </div>

<br>
 <span>&nbsp; &nbsp;</span> <h2>${ page_quiz }</h2>
<br>
<div class="container mt-3">
  <div class="mt-4 p-5 bg-primary text-white rounded" onclick="location='startox'">
    <h1>OX게임</h1> 
    <p>맞으면 O!, 틀리면 X!</p> 
  </div>
</div>
<div class="container mt-3">
  <div class="mt-4 p-5 bg-primary text-white rounded" onclick="location='startword'">
    <h1>끝말잇기 게임</h1> 
    <p>(2인용) 끝말로 시작하는 단어를 입력!</p> 
  </div>
</div>
<div class="container mt-3">
  <div class="mt-4 p-5 bg-primary text-white rounded" onclick="location='apiliar'">
    <h2>라이어 게임</h2>
    <p> (4인용) 제시어를 받지 못한 자를 찾아라!</p> 
  </div>
</div>
	