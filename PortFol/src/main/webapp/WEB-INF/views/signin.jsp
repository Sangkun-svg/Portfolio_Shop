<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<style>
    .Lmain{
        width: 45%;
        height: 1000px;
        float: left;
        margin-left:70px
    }
    .Rmain{
        width: 45%;
        height: 1000px;
        float: left;
        margin-left:70px
    }
    .sosialLogin{
        width: 500px;
        height: 70px;
        border: 1px solid;
        border-radius: 10px;
        display: block;
        margin: 0 auto;
        margin-bottom: 15px;
        position: relative;
        top: 300px;
        cursor: pointer;
    }

    .Rmain > form{
        position: relative;
        top: 400px;
        left:160px ;  
    }

    .Rmain> form > input{
        width: 400px;
        height: 40px;
        border-radius: 15px;
    }
    .Rmain> form  > button{
        width: 100px;
        height: 100px;
        font-size: 20px;
        background-color: black;    
        color: wheat;
        position: relative;
        bottom: 30px;
    }
</style>

<body>
	<div class="Lmain">
		<h2 style="text-align: center;">소셜 로그인</h2>
		<div class="sosialLogin" style="background-color: yellow;"
			onclick="location.href='${kakao_url}'">
			<h1 style="text-align: center;">카카오 로그인</h1>	
		</div>
		<div class="sosialLogin" style="background-color: greenyellow;"
			onclick="location.href='${naver_url}'">
			<h1 style="text-align: center;">네이버 로그인</h1>
		</div>
		<div class="sosialLogin" style="background-color: skyblue;"
			onclick="location.href=''">
			<h1 style="text-align: center;">페이스북 로그인</h1>
		</div>
		<div class="sosialLogin" style="background-color: pink;"
			onclick="location.href=''">
			<h1 style="text-align: center;">구글 로그인</h1>
		</div>
	</div>
	<div class="Rmain">
		<h1 style="text-align: center;">로그인 폼</h1>
		<form role="form" method="post">
			<input type="email" id="userId" name="userId" required="required" /><br>
			<input type="password" id="userPass" name="userPass" required="required" />			
			<button type="submit" id="signin_btn" name="signin_btn">로그인</button>
			
			<c:if test="${msg == false}">
				<p style="color: #f00;">로그인에 실패했습니다.</p>
			</c:if>
		</form>		
	</div>
</body>
</html>