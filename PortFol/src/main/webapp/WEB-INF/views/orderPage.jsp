<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="resource/includes/includeFile.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>주문 페이지</title>
</head>
<script type="text/javascript">
	function goMyInfo(){
		alert('주문이 완료되었습니다 ! ')
		location.href="${pageContext.request.contextPath}/orderPage";
	}
</script>																		
<style>
    wrap li{
    	border : 1px solid;
    	border-radius : 10px;
    }
    
    li{
		list-style: none;
	}    
    .one{
        width: 500px;
        color: gray;
    }
    

	.orderProduct_info > li{
		list-style: none;
	}
</style>
<body>
	<header>
		<div id="header_box">
			<%@ include file="resource/includes/header.jsp"%>
		</div>
	</header><br><br>

    <div class="wrap">
		<form action="${pageContext.request.contextPath}/orderPage?n=${member.userId}&bno=${pro.bno}" method="POST">
	        <div class="buyer_Info" style="margin-bottom : 30px">
				<div class="one"></div>
				<h2>수령인 정보</h2>
				<ul>
					<li>수령인<input type="text" value="${member.userName}"></li><br>
					<li>휴대전화<input type="tel" value="${member.userPhone}" placeholder="'-'없이 입력해주세요."></li><br>

					<%@ include file="addressAPI.jsp"%>
				</ul>
				<div class="one"></div>
		    </div>
				
				<div class="orderProduct_info">
					<h2>주문상품 정보</h2>
					<ul>
				        <li><h3>상품번호 : <c:out value="${pro.proCode}"/></li>
				        <li><h3>상품이름 : <c:out value="${pro.proName}"/></li>
				        <input type="hidden" value="${pro.proName}" name="proName">
				        <li><h3>상품가격 : <c:out value="${pro.proPrice}"/>원</li>
				        <li>
				        	<h3>주문 수량</h3>
				        	<input type="number" name="orderStock" max="${pro.proStock }" step="1" min="1" value="1" 
				        		style="width: 100px">
						<li>			       	
					</ul>
				</div>  

			<button type="button" class="btn btn-secondary" onclick="back()">뒤로</button>	        
	        <button type="submit" class="btn btn-primary">주문하기</button>
        </form>
    </div>
	<footer>
		<div id="footer_box">
			<%@ include file="resource/includes/footer.jsp"%>
		</div>
	</footer>
</body>
</html>