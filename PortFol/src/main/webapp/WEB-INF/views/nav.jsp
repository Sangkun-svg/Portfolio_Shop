<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<ul>
	<c:if test="${login == null}">
		<li><a href="${pageContext.request.contextPath}/signin">로그인</a></li>
		<li><a href="${pageContext.request.contextPath}/signup">회원가입</a></li>
	</c:if>
	<c:if test="${login != null}">
		<c:if test="${login.verify == 9}">
			<li>
				<a href="${pageContext.request.contextPath}/admin/index">관리자 화면</a>
			</li>
		</c:if>
		
		<li>${login.userName}님환영합니다.</li>
		<li><a href="${pageContext.request.contextPath}/myPage">마이페이지</a></li>		
		<li><a href="${pageContext.request.contextPath}/main?n=${login.userId}">쇼핑몰 가기</a></li>		
		<li><a href="${pageContext.request.contextPath}/userUpdate">정보 수정</a></li>
		<li><a href="${pageContext.request.contextPath}/userDelete">회원 탈퇴</a></li>
		<li><a href="${pageContext.request.contextPath}/signout">로그아웃</a></li>
	</c:if>
</ul>
