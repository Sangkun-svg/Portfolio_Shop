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
        <div class="img">
            <img src="" alt="img"
                style="width: 100%; height: 100%;">
        </div>
        
        <li><h3>이름 : <c:out value="${pro.proName}"/></h3></li>
        <li><h3>가격 : <c:out value="${pro.proPrice}"/></h3></li>
        <li><h3>수량 : <c:out value="${pro.proStock}"/></h3></li>
        <li><h3>상품소개 : <c:out value="${pro.proDescription}"/></h3></li>
		<input type="hidden" value="${pro.proCode}">
					
		<script type="text/javascript">
			function goMyInfo(){
				alert('주문 정보에 상품이 저장 되었습니다 ! ')
				location.href="${pageContext.request.contextPath}/deliveryInfo";
			}
		</script>																		
        <li><button onclick="goMyInfo()" class="btn">주문하기</button><br></li>
        <li><button onclick="location.href='${pageContext.request.contextPath}/'" class="btn">장바구니에 담기</button><br></li>
	<div>
		<c:forEach items="${replyList}" var="replyList">
			<li>
				<p>
					작성자 : ${replyList.writer}<br />
					내용 : ${replyList.content}<br />
					R번호 : ${replyList.rno}<br />
					B번호 : ${replyList.bno}<br />					 
				</p>
			</li>
		</c:forEach>   
	</div>
     
		 
		<div>
			<label for="writer">댓글 작성자</label><input type="text" id="writer" name="writer" />
			<br/>
			<label for="content">댓글 내용</label><input type="text" id="content" name="content" />
		</div>

		<div>

		</div>


    </div>
</body>
</html>