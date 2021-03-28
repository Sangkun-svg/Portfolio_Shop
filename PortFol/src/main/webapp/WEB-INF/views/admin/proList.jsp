<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="includeFile.jsp"%>
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
				<th>수정하기</th>				
				<th>삭제하기</th>				
				<th>썸네일</th>				
			</tr>
			<c:forEach items="${proList}" var="proList">
				<tr>
					<td style="text-align:center"><c:out value="${proList.bno}"/></td>
					<td style="text-align:center"><c:out value="${proList.proCode}"/></td>
					<td style="text-align:center"><c:out value="${proList.proName}"/></td>
					<td style="text-align:center"><c:out value="${proList.proPrice}" /></td>
					<td style="text-align:center"><c:out value="${proList.proStock}" /></td>
					<td style="text-align:center"><c:out value="${proList.proDescription}" /></td>
					<td style="text-align:center"><c:out value="${proList.regDate}" /></td>
					<td style="text-align:center"><button type="button" onclick="location.href='${pageContext.request.contextPath}/admin/proUpdate?n=${proList.bno}'" id="register_Btn" class="btn btn-warning">수정</button></td>
					<td style="text-align:center"><button type="button" onclick="location.href='${pageContext.request.contextPath}/admin/proDelete?n=${proList.bno}'"id="register_Btn" class="btn btn-danger">삭제</button></td>
					<td style="text-align:center">tr끼리 간격 주기</td>
				</tr>				
			</c:forEach>


		</table>
	</div>
</body>
</html>