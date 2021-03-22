<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>게시판</title>
</head>
<body>
	<section id="container">
			<table>
				<tr>
					<th>아이디</th>
					<th>이름</th>
					<th>번호</th>
					<th>등록일</th>
				</tr>
				<c:forEach items="${userlist}" var="userlist">
					<tr>
						<td><c:out value="${userlist.userId}"  /></td>
						<td><c:out value="${userlist.userName}" /></td>
						<td><c:out value="${userlist.userPhone}" /></td>
					</tr>
				</c:forEach>
			</table>
	</section>
</body>
</html>