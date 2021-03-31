<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세 보기</title>
</head>
<style>
    .wrap{
        width: 80%;
        height: 1000px;
        border: 1px solid;
        margin: 0 auto;
    }
    .img{
        border: 1px solid;
        width: 80%;
        height: 600px;
        margin: 0 auto;
        margin-top: 30px;
    }
    li{
        text-align: center;
        text-decoration: none;
        list-style: none;
        margin: 20px 0;
    }
    .btn{
        width: 250px;
        height: 50px;
        border-radius: 30px;
        cursor: pointer;
    }

</style>
<body>
    <div class="wrap">
        <div class="img">
            <img src="" alt="img"
                style="width: 100%; height: 100%;">
        </div>
        <li><h3>이름 : <c:out value="${pro.proName}"/></h3></li>
        <li><h3>가격 : <c:out value="${pro.proPrice}"/></h3></li>
        <li><h3>수량 : <c:out value="${pro.proStock}"/></h3></li>
        <li><h3>상품소개 : <c:out value="${pro.proDescription}"/></h3></li>
																				
        <li><button onclick="" class="btn">주문하기</button><br></li>
        <li><button onclick="" class="btn">장바구니에 담기</button><br></li>
        후기<br>
        평점<br>
    </div>
</body>
</html>