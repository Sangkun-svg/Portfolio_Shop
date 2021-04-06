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


aside {
	float: left;
	width : 200px;
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
}

aside ul li a:hover {
	background: #eee;
}

.select{
    width: 30%;
    height: 500px;
    border: 1px solid;
    float: left;

}
.select > aside > ul > li>a{
    width: 100%;
    height: 90px;
    margin-top: 15px;
}

.info{
    width: 30%;
    height: 500px;
    border: 1px solid;
    float: left;
}

.info > .input-area > input{
    width: 300px;
    height: 40px;
    border-radius: 15px;
    margin: 12px 0px 12px 15px;
}
</style>
<body>
    <div class="select">
        <aside style="width: 100%;">
            <ul style="width: 100%;">
                <li><a href="${pageContext.request.contextPath}/">아이디 변경</a></li>
                <li><a href="${pageContext.request.contextPath}/">이름 변경</a></li>
                <li><a href="${pageContext.request.contextPath}/">주소 변경</a></li>
                <li><a href="${pageContext.request.contextPath}/">번호 변경</a></li>
                </ul>
        </aside>
    </div>

    <div class="info">
        <div class="input-area">
            <label for><h2 style="margin: 0;">ID</h2></label><br>
            <input type="text" id="" name="" value="" readonly="readonly" >
            <button type="button" class="btn">수정하기</button>    

        </div>

        <div class="input-area">
            <label for><h2 style="margin: 0;">Name</h2></label><br>
            <input type="text" id="" name="" value="" readonly="readonly">    
            <button type="button" class="btn">수정하기</button>    
        </div>

        <div class="input-area">
            <label for><h2 style="margin: 0;">Phone</h2></label><br>
            <input type="text" id="" name="" value="" readonly="readonly">    
            <button type="button" class="btn">수정하기</button>    
        </div>

        <div class="input-area">
            <label for><h2 style="margin: 0;">Address</h2></label><br>
            <input type="text" id="" name="" value="" readonly="readonly">    
            <button type="button" class="btn">수정하기</button>    
        </div>
    </div>
</body>
</html>
