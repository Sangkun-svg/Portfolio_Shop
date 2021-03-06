<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>

ul {
	list-style: none;
}

a {
	text-decoration: none;
	outline: none;
}

.container {
	width:1440px;
	margin:0 auto;
}

header {
	width: 100%;
	height: 100px;
	display: flex;
	align-items: center;
	justify-content: space-between;
	background-color: beige;
}

header>h2 {
	margin-left: 20px;
}

header>nav {
	width: 600px;
	height: 100%;
}

header ul {
	width: 100%;
	height: 100%;
	display: flex;
	justify-content: space-between;
}

header ul>li {
	font-size: 20px;
	height: 100%;
	display: flex;
	align-items: center;
	
}
</style>
<body>
	<div class="header">
		<div class="container">
			<header>
				<h2><a href="${pageContext.request.contextPath}/main?n=${member.userId}">Sangkun-Svg Portfolio</a></h2>
				<nav>
					<ul>
						<c:if test="${empty member2}">
							<li><a href="${pageContext.request.contextPath}/signin">Login</a></li>
							<li><a href="${pageContext.request.contextPath}/signup">Join</a></li>
						</c:if>
						<c:if test="${!empty member2}">
							<li>${member.userName}님환영합니다.</li>
							<li><a href="${pageContext.request.contextPath}/myInfo?n=${member.userId}">My Info</a></li>
							<li><a href="${pageContext.request.contextPath}/signout">Logout</a></li>
						</c:if>
					</ul>
				</nav>
			</header>
		</div>
	</div>
</body>