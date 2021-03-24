<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>상품 목록</title>
</head>
<style>
#container_box table td {
	width: 150px;
}
</style>
<body>
	<h2>상품 목록</h2>
	<div id="container_box">
		<table>
			<tr>
				<th>BNO</th>				
				<th>상품 코드</th>
				<th>상품 품명</th>
				<th>가격</th>
				<th>수량</th>
				<th>상품 설명</th>
				<th>등록 날짜</th>
			</tr>
			<c:forEach items="${proList}" var="proList">
				<tr>
					<td style="text-align:center"><c:out value="${proList.bno}"/></td>
					<td style="text-align:center"><c:out value="${proList.proCode}"/></td>
					<td style="text-align:center">
						<a href="${pageContext.request.contextPath}/admin/adminProView?n=${proList.bno}">
							<c:out value="${proList.proName}" />
						</a>
					</td>
					<td style="text-align:center"><c:out value="${proList.proPrice}" /></td>
					<td style="text-align:center"><c:out value="${proList.proStock}" /></td>
					<td style="text-align:center"><c:out value="${proList.proDescription}" /></td>
					<td style="text-align:center"><c:out value="${proList.regDate}" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>