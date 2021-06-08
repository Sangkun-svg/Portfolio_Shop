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
        margin: 0 auto;
    }
    .img{
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
<script>
	function back(){
		window.history.back();
	}
	function img(){
		var src = jQuery('#img').attr("src");
		console.log("src : " + src);
	}	
</script>
<body>
	<header>
		<div id="header_box">
			<%@ include file="resource/includes/header.jsp"%>
		</div>
	</header><br><br>

    <div class="wrap">
    	<form action="${pageContext.request.contextPath}/orderPage?n=${user.userId}&bno=${pro.bno}" method="get">
			<input type="hidden" value="${user.userId}" name="n">
			<input type="hidden" value="${pro.bno}" name="bno">
	        <div class="img">
	            <img src="${pro.proImg}" id="img" alt="img" style="width: 100%; height: 100%;">
	        </div>
	        
	        <li><h3>이름 : <c:out value="${pro.proName}"/></h3></li>
	        <li><h3>가격 : <c:out value="${pro.proPrice}"/></h3></li>
	        <li><h3>수량 : <c:out value="${pro.proStock}"/></h3></li>
	        <li><h3>상품소개 : <c:out value="${pro.proDescription}"/></h3></li>

			<input type="hidden" value="${pro.proCode}" name="proCode">

						
	        <li><button type="submit"  class="btn">주문하기</button><br></li>
		</form>
			<li><button type="button" class="btn"onclick="back()">뒤로</button></li>
			<input type="hidden" value="${pro.proCode}" name="proCode">


				<!-- 댓글 -->
			    <c:forEach items="${replyList}" var="replyList">
					<div id="reply" style="border : 1px solid;border-radius : 5px; margin-top : 30px">
						<tr>
							<td style="text-align:center">
								
								<p>작성자 → <c:out value="${replyList.writer}" /></p>
								<p>댓글 → <c:out value="${replyList.content}" /></p>
							</td><br>
						</tr>
					</div>				
			    </c:forEach> 


				<c:if test="${reply != null}">
					<form class="replyWrite" action="${pageContext.request.contextPath}/replyWrite" method="get">
						<label for="writer">작성자</label>
						<input type="hidden" value="${user.userId} " name="n">
						<input type="hidden" value="${pro.bno} " name="bno">
	
				    	<input type="text" value="${user.userName }" readonly="readonly" name="writer"/>						    
				    	<input type="text" name="content" placeholder="댓글을 작성해주세요" style="width : 100%; height: 100%" />
				    	<button class="btn btn-secondary" style="width: 100px; height: 35px" type="submit">댓글 작성</button>
					</form>
				</c:if>		
    </div>
    
    <footer>
		<div id="footer_box">
			<%@ include file="resource/includes/footer.jsp"%>
		</div>
	</footer>
    
</body>
</html>