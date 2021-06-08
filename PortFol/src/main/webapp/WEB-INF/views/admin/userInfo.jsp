<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="includeFile.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 보기</title>
<style>
.inputArea {
	width : 35%;
	margin-top : 15px;
	margin-bottom : 15px;
}

label {
	display: inline-block;
	width: 100px;
	padding: 5px;
	font-size: 20px;
}
input , textarea{
	width: 200px;
	border : 2px solid;
	border-radius : 7px;
}

.wrap{
	display: block;
	width: 300px;
	margin-top: 50px;
	margin: 0 auto;
}
</style>
<script>
	function back(){
		window.history.back();
	}
	
</script>
<body>
	<header>
		<div id="header_box">
			<%@ include file="include/adminHeader.jsp"%>
		</div>
	</header><br><br>

	<div class="wrap">
		<div class="inputArea">
			<label for="userId">아이디</label> <input type="text" id="userId"
				name="userId" value="${userInfo.userId}"/>
		</div>

		<div class="inputArea">
			<label for="userName">이름</label> <input type="text" id="userName"
				name="userName" value="${userInfo.userName}"/>
		</div>

		<div class="inputArea">
			<label for="userPhone">번호</label> <input type="text" id="userPhone"
				name="userPhone" value="${userInfo.userPhone}"/>
		</div>

		<div class="inputArea">
			<label for="regDate">등록일</label> <input type="text" id="regDate"
				name="regDate" value="${userInfo.userJoinDate}"/>
		</div>


		<div class="inputArea">
			<button type="button" onclick="back()" class="btn btn-danger">뒤로</button>
		</div>
	</div>
</body>
</html>