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
<script type="text/javascript">
	function deleteConfirm(){
		}
</script>
<body>
	<h2>상품 목록</h2>
	<div id="container_box">
		<table>
			<tr>
				<th style="text-align:center">BNO</th>				
				<th style="text-align:center">상품 코드</th>
				<th style="text-align:center">상품 품명</th>
				<th style="text-align:center">가격</th>
				<th style="text-align:center">수량</th>
				<th style="text-align:center">상품 설명</th>
				<th style="text-align:center">등록 날짜</th>
				<th style="text-align:center">수정하기</th>				
				<th style="text-align:center">삭제하기</th>				
				<th style="text-align:center">썸네일</th>				
			</tr>
			<c:forEach items="${proList}" var="proList">
				<tr>
					<td style="text-align:center"><c:out value="${proList.bno}"/></td>
					<td style="text-align:center"><c:out value="${proList.proCode}"/></td>
					<td style="text-align:center"><c:out value="${proList.proName}"/></td>
					<td style="text-align:center"><c:out value="${proList.proPrice}" /></td>
					<td style="text-align:center"><c:out value="${proList.proStock}" /></td>
					<td style="text-align:center"><c:out value="${proList.proDescription}" /></td>
					<td style="text-align:center"><c:out value="${proList.proRegDate}" /></td>
					<td style="text-align:center"><button type="button" onclick="location.href='${pageContext.request.contextPath}/admin/proUpdate?n=${proList.bno}'" id="update_Btn" class="btn btn-warning">수정</button></td>
					<td style="text-align:center"><button type="button" onclick="location.href='${pageContext.request.contextPath}/admin/proDelete?n=${proList.bno}'"id="delete_Btn" class="btn btn-danger">삭제</button></td>
					<td style="text-align:center"><img alt="Thumnail" src="${proList.proImg}"></td>
				</tr>				
			</c:forEach>


		</table>
	</div>
</body>
</html>