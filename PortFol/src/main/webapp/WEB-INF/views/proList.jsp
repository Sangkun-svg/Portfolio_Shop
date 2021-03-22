<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>상품 목록</title>
</head>
<body>
	<section id="container">
			<table>
				<tr>
					<th>상품 코드</th>
					<th>상품 품명</th>
					<th>가격</th>
					<th>수량</th>
					<th>상품 설명</th>
				</tr>
				<c:forEach items="${proList}" var="proList">
					<tr>
						<td><c:out value="${proList.proCode}"  /></td>
						<td><c:out value="${proList.proName}"  /></td>
						<td><c:out value="${proList.proPrice}"  /></td>
						<td><c:out value="${proList.proStock}"  /></td>
						<td><c:out value="${proList.proDescription}"  /></td>
					</tr>
				</c:forEach>
			</table>
	</section>
</body>
</html>