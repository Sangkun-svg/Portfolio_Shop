<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	.aside li{
		border: 2px solid;
		border-radius : 8px;
		margin-top : 15px ;
	}
	.aside a{
		color : black;
	}
	.aside a:hover {
		color : gray;
	}
</style>
<body>
	<aside>
		<ul class="aside">
			<li><a href="https://desk.channel.io/#/channels/47583/user_chats/60865fecb8a34f2b1a27" target="_blank">채널톡 접속</a></li>
			<li><a href="${pageContext.request.contextPath}/admin/proRegister">상품 등록</a></li>
			<li><a href="${pageContext.request.contextPath}/admin/proList">상품 목록</a></li>
			<li><a href="${pageContext.request.contextPath}/admin/reqProList">주문 요청된 상품</a></li>
			<li><a href="${pageContext.request.contextPath}/admin/userList">유저 목록</a></li>
			<li><a href="${pageContext.request.contextPath}/admin/chart/gender">남/녀 성비 그래프</a></li>
		</ul>
	</aside>
</body>
</html>