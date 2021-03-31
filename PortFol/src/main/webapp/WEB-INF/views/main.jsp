<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
</head>
<style>
	.test{
		border: 1px solid;
		width: 30%;
		height: 300px;
		float: left;
		margin-left: 3%;
		margin-top: 3%;
		cursor: pointer;
	}
	    .thumbnail{
        border: 1px solid;
        width: 80%;
        height: 55%;
        display: block;
        margin: 0 auto;
        margin-top: 20px;
    }
	    li{
        text-align: center;
        text-decoration: none;
        list-style: none;
    }
		
</style>
<body>
	<c:forEach items="${prolist}" var="prolist">
	    <div class="test" onclick="location.href='${pageContext.request.contextPath}/proInfo?n=${prolist.bno}'">
	        <div class="thumbnail">
	            <img src="" alt="썸네일">
	        </div>
	        <br><li>이름 : <c:out value="${prolist.proName}"/></li><br>
	        <li>가격 : <c:out value="${prolist.proPrice}"/></li>
	    </div>
	</c:forEach>
</body>
</html>