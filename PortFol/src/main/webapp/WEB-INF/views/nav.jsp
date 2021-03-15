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
				<a href="${pageContext.request.contextPath}/admin/index">관리자 화면</a>
			</li>
		</c:if>
		
		<li>${member.userName}님환영합니다.</li>
		<li><a href="${pageContext.request.contextPath}/userUpdate">정보 수정</a></li>
		<li><a href="${pageContext.request.contextPath}/signout">로그아웃</a></li>
	</c:if>
</ul>
