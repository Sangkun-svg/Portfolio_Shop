<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>매출 관련 페이지</title>
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
	background: #F5F5DC;

}

aside ul li a:hover {
	background: #eee;
}

</style>

<body>
	<aside>
		<ul>
			<li><a href="" >일별 매출</a></li>
			<li><a href="">월별 매출</a></li>
			<li><a href="">연별 매출</a></li>
			<li><a href="">방문자 수</a></li>
			<li><a href="">남녀 성비</a></li>
		</ul>
	</aside>
</body>
</html>