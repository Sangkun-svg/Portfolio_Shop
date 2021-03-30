<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.inputArea {
	margin: 10px 0;
}

select {
	width: 100px;
}

label {
	display: inline-block;
	width: 70px;
	padding: 5px;
}

label[for='gdsDes'] {
	display: block;
}

input {
	width: 150px;
}

textarea#gdsDes {
	width: 400px;
	height: 180px;
}

.select_img img{margin:20px 0;}

.oriImg{width: 500px; height: auto;}
.thumbImg{}
</style>
<body>
	<form role="form"  method="post">
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
				name="regDate" value="${userInfo.regDate}"/>
		</div>


		<div class="inputArea">
			<button type="submit" id="update_Btn" class="btn btn-danger">뒤로</button>
		</div>

	</form>
</body>
</html>