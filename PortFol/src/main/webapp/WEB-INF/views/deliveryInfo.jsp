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
<script type="text/javascript">
	function goDeliveryCanclePage(){
		alert('주문 취소 페이지로 이동합니다.');
	}
	function goDeliveryRefundPage(){
		alert('상품 환불 페이지로 이동합니다.');
		location.href='${pageContext.request.contextPath}/refund?n=${user.userId}';
	}
</script>
<body>
	<c:forEach items="${orderList}" var="orderList">
		<div class="wrap">
			<li>이름 : <c:out value="${orderList.userId}"/></li><br>
			<li>가격 : <c:out value="${orderList.orderPrice}"/></li>		
			<li>주문수량 : <c:out value="${orderList.orderStock}"/></li>		
			<li>배송 주소 : <c:out value="${orderList.address}"/></li>		
			<li>
				배송상황 : <c:out value="${orderList.deliveryInfo}"/>
				<c:if test="${orderList.deliveryInfo == 'Ready' }">
					<button type="button" onclick="goDeliveryCanlePage()">배송 취소</button>
				</c:if>				
				<c:if test="${orderList.deliveryInfo == 'Success' }">
					<button type="button" onclick="goDeliveryRefundPage()">환불 및 교환</button>
				</c:if>				
			</li>		
						
		</div>
	</c:forEach>
</body>
</html>