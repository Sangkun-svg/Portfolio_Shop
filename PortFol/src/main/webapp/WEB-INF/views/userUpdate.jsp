<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보 수정</title>
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

.info{
	display : block;
    width: 23%;
    height: 650px;
    border: 2px solid;
    border-radius: 10px;
	margin : 0 auto;
}

.info > .input-area > input{
    width: 300px;
    height: 40px;
    border-radius: 15px;
    margin: 12px 0px 12px 15px;
}
.btn {
	width: 150px;
	height: 35px;
	border : 2px solid;
	border-radius : 10px;
	background-color: white;
	margin-top: 10px;
	margin-left: 97px;
	cursor : pointer;
	
}
</style>
<script type="text/javascript">
	function back(){
		window.history.back();
	}
</script>
<body>
	<header>
		<div id="header_box">
			<%@ include file="resource/includes/header.jsp"%>
		</div>
	</header><br><br>
	

    <form class="info" method="post">
        <div class="input-area">
            <label for><h2 style="margin: 0;">ID</h2></label><br>
            <input type="text" id="userId" name="userId" value='${info.userId }'>
			<input type="hidden" value="${info.userId }" name="infoUserId">
        </div>

        <div class="input-area">
            <label for><h2 style="margin: 0;">Name</h2></label><br>
            <input type="text" id="userPass" name="userPass" value='${info.userName}'>    
			<input type="hidden" value="${info.userId }" name="infoUserName">
        </div>

        <div class="input-area">
            <label for><h2 style="margin: 0;">Phone</h2></label><br>
            <input type="text" id="userPhone" name="userPhone" value='${info.userPhone}'>    
			<input type="hidden" value="${info.userId }" name="infoUserPhone">
        </div>

        <div class="input-area">
            <label for><h2 style="margin: 0;">Address</h2></label><br>
            <input type="text" id="" name="address" value='${info.address }' >    
			<input type="hidden" value="${info.userId }" name="infoUserAddress">
        </div>

			<button class="btn" type="submit">수정</button><br>
			<button class="btn" type="button" onclick="location.href='${pageContext.request.contextPath}/userDelete?n=${user.userId}'">회원탈퇴</button><br>
			<button class="btn" type="button" onclick="back()">뒤로</button>

    </form>
		<footer>
		<div id="footer_box">
			<%@ include file="resource/includes/footer.jsp"%>
		</div>
	</footer>
</body>
</html>
