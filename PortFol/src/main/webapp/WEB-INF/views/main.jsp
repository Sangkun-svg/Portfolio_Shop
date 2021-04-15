<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
</head>
<style>
.test {
	border: 1px solid;
	width: 30%;
	height: 300px;
	float: left;
	margin: 3% 0 3% 3%;
	cursor: pointer;
}

.thumbnail {
	border: 1px solid;
	width: 80%;
	height: 55%;
	display: block;
	margin: 0 auto;
	margin-top: 15px;
}

li {
	text-align: center;
	text-decoration: none;
	list-style: none;
}

@import
	url('https://fonts.googleapis.com/css?family=Noto+Sans+KR|ZCOOL+QingKe+HuangYou')
	;

* {
	margin: 0;
	padding: 0;
	color: #000;
	font-family: 'ZCOOL QingKe HuangYou', cursive;
	box-sizing: border-box;
}

.fn-font {
	font-family: 'Noto Sans KR', sans-serif;
}

ul {
	list-style: none;
}

a {
	text-decoration: none;
	outline: none;
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

header ul li :hover {
	color: brown;
}
/*-----------------------------------------------------*/
.center {
	border: 2px solid;
	width: 90%;
	height: 1600px;
	margin: 0 auto;
	margin-top: 50px;
	margin-bottom: 50px;
}
/*-----------------------------------------------------*/
.footer {
	width: 100%;
	height: 200px;
	padding: 15px 0;
	text-align: center;
	color: white;
	background-color: beige;
	position: absolute;
}
</style>
<body>

	<div class="header">
		<div class="container">
			<header>
				<h2>Sangkun-Svg Portfolio</h2>
				<nav>
					<ul>
						<c:if test="${session == null}">
							<li><a href="${pageContext.request.contextPath}/signin">Login</a></li>
							<li><a href="${pageContext.request.contextPath}/signup">Join</a></li>
						</c:if>
						<c:if test="${session != null}">
							<li>어서오세요! ${member.userName}님</li>
							<li><a href="${pageContext.request.contextPath}/signout">Logout</a></li>
							<li><a href="${pageContext.request.contextPath}/myInfo">My Info</a></li>
						</c:if>
					</ul>
				</nav>
			</header>
		</div>
	</div>


	<div class="center">
		<c:forEach items="${prolist}" var="prolist">
			<div class="test" onclick="location.href='${pageContext.request.contextPath}/proInfo?n=${prolist.bno}'">

			<div class="thumbnail">
				<img src="" alt="Err">
			</div>
				<br><li>이름 : <c:out value="${prolist.proName}"/></li><br>
				<li>가격 : <c:out value="${prolist.proPrice}"/></li>
			</div>
		</c:forEach>
	</div>
	
	<div class="footer">
		<br>
		<h2>
			<p>Sangkun-svg</p>
		</h2>
		<br>
		<p>Copyrightⓒ All Right Reserved.</p>
	</div>

</body>
</html>