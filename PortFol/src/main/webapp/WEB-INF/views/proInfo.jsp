<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="resource/includes/includeFile.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세 보기</title>
</head>
<style>
    .wrap{
        width: 80%;
        height: 1500px;
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
        border : 1px solid ;
        border-radius: 30px;
        cursor: pointer;
        background-color: skyblue;
    }
	#reply{
		width: 500px;
		height: 300px;
		border: 1px solid;
	}
</style>
<body>
    <div class="wrap">
    	<form action="${pageContext.request.contextPath}/orderPage?n=${member.userId}&bno=${pro.bno}" method="get">
			<input type="hidden" value="${member.userId}" name="n">
			<input type="hidden" value="${pro.bno}" name="bno">
	        <div class="img">
	            <img src="" alt="img"
	                style="width: 100%; height: 100%;">
	        </div>
	        
	        <li><h3>이름 : <c:out value="${pro.proName}"/></h3></li>
	        <li><h3>가격 : <c:out value="${pro.proPrice}"/></h3></li>
	        <li><h3>수량 : <c:out value="${pro.proStock}"/></h3></li>
	        <li><h3>상품소개 : <c:out value="${pro.proDescription}"/></h3></li>
	        <li><h3>상품번호 : <c:out value="${pro.proCode}"/></h3></li>
	        <li><h3>상품Bno : <c:out value="${pro.bno}"/></h3></li>

			<input type="hidden" value="${pro.proCode}">

						
	        <li><button type="submit"  class="btn">주문하기</button><br></li>
		</form>
	        <li><button onclick="goCart()" class="btn">장바구니에 담기</button><br></li>
				<script type="text/javascript">
					function goCart(){
						alert('장바구니에 저장 되었습니다 !')
						location.href="${pageContext.request.contextPath}/main";
					}
				</script>																		
				
	
			<div>
				<!-- 댓글에 값이 없어서 ERR 뜸 -> 그래서 일단 빼놈 -->
			</div>
    </div>
</body>
</html>