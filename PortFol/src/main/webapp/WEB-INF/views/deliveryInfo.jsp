<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 정보</title>
</head>
<style>
	.wrap{
		width: 500px;
		height: 300px;
		border: 2px solid;
		display: block;
		margin: 0 auto;
	}
</style>
<body>
	<div class="wrap">
		<c:forEach items="${orderList}" var="prolist">
				<li>상품코드 : <c:out value="${orderList.proCode}"/></li>
				<li>가격 : <c:out value="${orderList.orderPrice}"/></li>
				<li>배달상황 : <c:out value="${orderList.deliveryInfo}"/></li>
		</c:forEach>
	</div>
</body>
</html>