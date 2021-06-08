<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>adminHeader</title>
</head>
<style>
li {
	text-align: center;
	text-decoration: none;
	list-style: none;
}


ul {
	list-style: none;
}

a {
	text-decoration: none;
	outline: none;
	color : white;
}

.container {
	width: 1440px;
	margin: 0 auto;
}

header {
	width: 100%;
	height: 100px;
	display: flex;
	align-items: center;
	justify-content: space-between;
	background-color: gray;
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
				<h2><a href="${pageContext.request.contextPath}/main?n=${user.userId}">${user.userName}관리자님 환영합니다.</a></h2>
				<nav>
					<ul>
							<li><a href="${pageContext.request.contextPath}/main?n=${user.userId}">Main</a></li>
							<li><a href="${pageContext.request.contextPath}/signout">Logout</a></li>
					</ul>
				</nav>
			</header>
		</div>
	</div>

</body>
</html>