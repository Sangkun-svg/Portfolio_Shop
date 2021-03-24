<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>상품 상세 조회</title>
</head>
<style>
#container_box table td {
	width: 150px;
}
</style>
<%@ include file="includeFile.jsp"%>
<body>
	
	<h2>상품 목록</h2>
	
	<div id="container_box">
		<form role="form" method="post">
		
			<div class="inputArea">
				<label for="proCode">상품번호</label>
				<span>${pro.proCode}</span>
			</div>
			
			
			<div class="inputArea">
				<label for="proName">상품명</label>
				<span>${pro.proName}</span>
			</div>
			
			<div class="inputArea">
				<label for="proPrice">상품가격</label>
				<span><fmt:formatNumber value="${pro.proPrice}" pattern="###,###,###"/></span>
			</div>
			
			<div class="inputArea">
				<label for="proStock">상품수량</label>
				<span>${pro.proStock}</span>
			</div>
			
			<div class="inputArea">
				<label for="proDescription">상품소개</label>
				<span>${pro.proDescription}</span>
			</div>
			
			<div class="inputArea">
				<button type="button" id="register_Btn" class="btn btn-warning">수정</button>
				<button type="button" id="register_Btn" class="btn btn-danger">삭제</button>
			</div>
			
		</form>	
	</div>
</body>
</html>