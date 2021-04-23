<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>주문 요청된 상품 리스트</title>
</head>
<style>
#container_box table td {
	width: 150px;
}
</style>
<body>
	<div id="container_box">
		<section id="container">
			<table>
				<tr>
					<th style="text-align:center">회원아이디</th>
					<th style="text-align:center">회원이름</th>
					<th style="text-align:center">회원 주소(상세보기)</th>
					<th style="text-align:center">주문 번호</th>
					<th style="text-align:center">상품 번호</th>
					<th style="text-align:center">상품 이름</th>
					<th style="text-align:center">주문 수량</th>
					<th style="text-align:center">주문 가격</th>
					<th style="text-align:center">환불 요청</th>
					<th style="text-align:center">취소 요청</th>
					<th style="text-align:center">교환 요청</th>
				</tr>
				<c:forEach items="${req}" var="req">
					<tr>
						<td style="text-align:center"><c:out value="${req.userId}"  /></td>
						<td style="text-align:center"><c:out value="${req.userName}"  /></td>
						<td style="text-align:center"><c:out value="${req.address}"  /></td>
						<td style="text-align:center"><c:out value="${req.orderId}"  /></td>
						<td style="text-align:center"><c:out value="${req.proCode}"  /></td>
						<td style="text-align:center"><c:out value="${req.orderProName}"  /></td>
						<td style="text-align:center"><c:out value="${req.orderStock}"  /></td>
						<td style="text-align:center"><c:out value="${req.orderPrice}"  /></td>

						<td style="text-align:center">
							<c:if test ="${req.deliveryInfo == 'Stop_for_refund'}">
								<button type="button" class="btn btn-danger"
								 onclick="location.href='${pageContext.request.contextPath}/admin/reqRefund?n=${req.userId}&orderId=${req.orderId }'">환불 요청</button>
							</c:if>  
							<c:if test ="${req.deliveryInfo != 'Stop_for_refund'}">
								<p style="text-align:center"> X </p>
							</c:if>  
						</td>

						<td style="text-align:center">
							<c:if test ="${req.deliveryInfo == 'Stop_for_delivery_Cancle'}">
								<button type="button" class="btn btn-danger"
								 onclick="location.href='${pageContext.request.contextPath}/admin/reqCancle?n=${req.userId}&orderId=${req.orderId }'">취소 요청</button>
							</c:if>
							<c:if test ="${req.deliveryInfo != 'Stop_for_delivery_Cancle'}">
								<p style="text-align:center"> X </p>
							</c:if>
						</td>

						
						<td style="text-align:center">
							<c:if test ="${req.deliveryInfo == 'Stop_for_change'}">
								<button type="button" class="btn btn-danger"
								 onclick="location.href='${pageContext.request.contextPath}/admin/reqChange?n=${req.userId}&orderId=${req.orderId }'">교환 요청</button>
							</c:if>
							<c:if test ="${req.deliveryInfo != 'Stop_for_change'}">
								<p style="text-align:center"> X </p>
							</c:if>
						</td>

					</tr>
				</c:forEach>
			</table>
		</section>
	</div>
</body>
</html>