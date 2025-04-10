<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="setting.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
	    <title>종합 랭킹</title>
	    <link rel="stylesheet" type="text/css" href="style_rank.css">
	<body>
		<h2> ${ page_rank } </h2>
		<!-- 게임 선택 및 나가기 -->
		<div class="filter-bar" style="margin: 20px;">
		    <form style="display:inline;">
		        <select name="game_id">
		            <option value="1">OX게임</option>
		            <option value="2">끝말잇기</option>
		            <option value="3">라이어 게임</option>
		        </select>
		    </form>
		    <button onclick="location.href='/logonmain'" class="action-btn" style="float: right; background-color: #4CAF50;">나가기</button>
		</div>
		
		<div class="ranking-container">
		    <h1 class="ranking-title"><%= gameName %> 랭킹</h1>
		    <table class="ranking-table">
		        <thead>
		            <tr>
		                <th>순위</th>
		                <th>프로필</th>
		                <th>닉네임</th>
		                <th>점수</th>
		                <th>시간</th>
		                <th>상태</th>
		                <th>정보</th>
		            </tr>
		        </thead>
		        <tbody></tbody>
		    </table>
		</div>
	</body>
	</head>
</html>