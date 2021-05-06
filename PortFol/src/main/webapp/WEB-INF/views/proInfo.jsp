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
		display : block;
		width: 300px;
		height: 100px;
		border: 1px solid;
		margin : 0 auto;
		margin-top : 10px;
		margin-bottom : 10px;
	}
	.replyWrite{
		display : block;
		width: 300px;
		height: 100px;
		margin : 0 auto;
		margin-top : 10px;
		margin-bottom : 10px;
	}
</style>
<body>
    <div class="wrap">
    	<form action="${pageContext.request.contextPath}/orderPage?n=${login.userId}&bno=${pro.bno}" method="get">
			<input type="hidden" value="${login.userId}" name="n">
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

			<input type="hidden" value="${pro.proCode}" name="proCode">

						
	        <li><button type="submit"  class="btn">주문하기</button><br></li>
		</form>
	        <li><button onclick="location.href='${pageContext.request.contextPath}/goCart?n=${login.userId}&bno=${pro.bno}'" class="btn">장바구니에 담기</button><br></li>
			<input type="hidden" value="${pro.proCode}" name="proCode">


				<!-- 댓글 -->
			    <c:forEach items="${replyList}" var="replyList">
					<div id="reply">
						<tr>
							<td style="text-align:center">bno : <c:out value="${replyList.bno}" /></td><br>
							<td style="text-align:center">rno : <c:out value="${replyList.rno}" /></td><br>
							<td style="text-align:center">writer : <c:out value="${replyList.writer}" /></td><br>
							<td style="text-align:center">content : <c:out value="${replyList.content}" /></td><br>
						</tr>
					</div>				
			    </c:forEach> 


				<c:if test="${reply != null}">
					<form class="replyWrite" action="${pageContext.request.contextPath}/replyWrite" method="get">
						<label for="writer">작성자</label>
						<input type="hidden" value="${user.userId} " name="n">
						<input type="hidden" value="${pro.bno} " name="bno">
	
				    	<input type="text" value="${login.userName }" readonly="readonly" name="writer"/>						    
				    	<input type="text" name="content" placeholder="댓글을 작성해주세요" style="width : 100%; height: 100%" />
				    	<button type="submit">댓글 작성</button>
					</form>
				</c:if>
	
    </div>
</body>
</html>