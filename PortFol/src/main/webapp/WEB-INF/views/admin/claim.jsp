<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="includeFile.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객 요청</title>
</head>
<style>
style>body {
	font-family: '맑은 고딕', verdana;
	padding: 0;
	margin: 0;
}

ul {
	padding: 0;
	margin: 0;
	list-style: none;
	 
}


aside {
	float: left;
	width: 200px;
}

div#container_box {
	float: right;
	width: calc(100% - 200px - 20px);
}

aside ul li {
	text-align: center;
	margin-bottom: 10px;
}

aside ul li a {
	display: block;
	width: 100%;
	padding: 10px 0;
	text-decoration:none;
}

aside ul li a:hover {
	background: #eee;
}

</style>
<body>
	<aside>
		<ul>
			<li><a href="${pageContext.request.contextPath}/admin/sales">매출 그래프</a></li>
			<li><a href="${pageContext.request.contextPath}/admin/delivery">배송 상태</a></li>
			<li><a href="${pageContext.request.contextPath}/admin/refund">환불요청 &승인</a></li>
		</ul>
	</aside>
</body>
</html>