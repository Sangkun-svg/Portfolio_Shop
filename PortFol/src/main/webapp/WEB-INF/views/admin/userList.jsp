<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>유저 리스트</title>
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
					<th style="text-align:center">아이디</th>
					<th style="text-align:center">이름</th>
					<th style="text-align:center">번호</th>
					<th style="text-align:center">등록일</th>
					<th style="text-align:center">권한</th>
					<th style="text-align:center">상세정보 보기</th>
					<th style="text-align:center">환불 요청</th>
					<th style="text-align:center">취소 요청</th>
				</tr>
				<c:forEach items="${userlist}" var="userlist">
					<tr>
						<td style="text-align:center"><c:out value="${userlist.userId}"  /></td>
						<td style="text-align:center"><c:out value="${userlist.userName}" /></td>
						<td style="text-align:center"><c:out value="${userlist.userPhone}" /></td>
						<td style="text-align:center"><c:out value="${userlist.regDate}" /></td>
						<td style="text-align:center"><c:out value="${userlist.verify}" /></td>					
						<c:if test ="${userlist.verify != 9}">
							<td style="text-align:center"><button type="button" onclick="location.href='${pageContext.request.contextPath}/admin/userInfo?n=${userlist.userId }'" class="btn btn-danger">수정</button></td>
						</c:if>
						<c:if test ="${userlist.verify == 9}">
							<td style="text-align:center">타 관리자 정보</td>
						</c:if>
					</tr>
				</c:forEach>
			</table>
		</section>
	</div>
</body>
</html>