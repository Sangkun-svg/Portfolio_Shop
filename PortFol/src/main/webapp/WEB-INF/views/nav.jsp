<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<ul>
	<c:if test="${member == null}">
		<li><a href="${pageContext.request.contextPath}/signin">로그인</a></li>
		<li><a href="${pageContext.request.contextPath}/signup">회원가입</a></li>
	</c:if>
	<c:if test="${member != null}">
		<c:if test="${member.verify == 9}">
			<li>
				<meta http-equiv="refresh" content="0;url=${pageContext.request.contextPath}/admin/index/">
				<input type="hidden" name="id" value="${member.userId}">
				<input type="hidden" name="name" value="${member.userName }">				
			</li>
		</c:if>
		
		<li>${member.userName}님환영합니다.</li>
		<li><a href="${pageContext.request.contextPath}/main?n=${member.userId}">쇼핑몰 가기</a></li>		
		<li><a href="${pageContext.request.contextPath}/signout">로그아웃</a></li>
	</c:if>
</ul>
