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
    width: 30%;
    height: 500px;
    border: 1px solid;
	margin : 0 auto;
}

.info > .input-area > input{
    width: 300px;
    height: 40px;
    border-radius: 15px;
    margin: 12px 0px 12px 15px;
}
</style>
<body>
    <form class="info" method="post">
        <div class="input-area">
            <label for><h2 style="margin: 0;">ID</h2></label><br>
            <input type="text" id="userId" name="userId" value='${info.userId }' readonly="readonly" >
			<input type="hidden" value="${info.userId }" name="infoUserId">
            <button type="button" class="btn">수정하기</button>    

        </div>

        <div class="input-area">
            <label for><h2 style="margin: 0;">Name</h2></label><br>
            <input type="text" id="userPass" name="userPass" value='${info.userName}' readonly="readonly">    
			<input type="hidden" value="${info.userId }" name="infoUserName">
            <button type="button" class="btn">수정하기</button>    
        </div>

        <div class="input-area">
            <label for><h2 style="margin: 0;">Phone</h2></label><br>
            <input type="text" id="userPhone" name="userPhone" value='${info.userPhone}' readonly="readonly">    
			<input type="hidden" value="${info.userId }" name="infoUserPhone">
            <button type="button" class="btn">수정하기</button>    
        </div>

        <div class="input-area">
            <label for><h2 style="margin: 0;">Address</h2></label><br>
            <input type="text" id="" name="address" value='${info.address }' >    
			<input type="hidden" value="${info.userId }" name="infoUserAddress">
            <button type="button" class="btn">수정하기</button>    
	
		<button type="submit">수정</button>
        </div>
    </form>
</body>
</html>
