<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객 요청</title>
</head>
<style>  
	.aside{
		height: 500px;
	}
	.nav{
		width: 250px;
		height: 150px;
		border: 2px solid;
		border-radius : 8px ;
		float: left;
		margin: 10% 5% 0 21.5%;
		cursor: pointer;
		background-color:#C0C0C0 ;
	}

	.nav > a {
		text-decoration: none;
		color: black;
		line-height: 100px;
	}

	.nav a:hover{
		color: white;
	}

	.nav > a > p{
		text-align: center;
		text-decoration: none;
	}
</style>
<body>
	<header>
		<div id="header_box">
			<%@ include file="resource/includes/header.jsp"%>
		</div>
	</header><br><br>

	<aside class="aside">
		<div class="nav">
			<a href="${pageContext.request.contextPath}/userUpdate?n=${user.userId}"><p>내 정보 수정</p></a>
		</div>

		<div class="nav">
			<a href="${pageContext.request.contextPath}/deliveryInfo?n=${user.userId}"><p>주문 정보</p></a>
		</div>
	</aside>

	<footer>
		<div id="footer_box">
			<%@ include file="resource/includes/footer.jsp"%>
		</div>
	</footer> 
</body>
</html>