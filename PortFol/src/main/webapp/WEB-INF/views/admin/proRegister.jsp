<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file = "includeFile.jsp" %>
<title>상품등록</title>
</head>
<style>
.inputArea { margin:10px 0; }
select { width:100px; }
label { display:inline-block; width:70px; padding:5px; }
label[for='gdsDes'] { display:block; }
input { width:150px; }
textarea#gdsDes { width:400px; height:180px; }
</style>
<body>
	<form role="form" action="proRegister" method="post">
		<div class="inputArea">
			<label for="proCode">상품코드	</label> <input type="text" id="proCode" name="proCode" />
		</div>

		<div class="inputArea">
			<label for="proName">상품명</label> <input type="text" id="proName" name="proName" />
		</div>

		<div class="inputArea">
			<label for="proPrice">상품가격</label> <input type="text" id="proPrice" name="proPrice" />
		</div>

		<div class="inputArea">
			<label for="proStock">상품수량</label> <input type="text" id="proStock" name="proStock" />
		</div>

		<div class="inputArea">
			<label for="proDescription">상품소개</label>
			<textarea rows="5" cols="50" id="proDescription" name="proDescription"></textarea>
		</div>

		<div class="inputArea">
			<button type="submit" id="register_Btn" class="btn btn-primary">등록</button>
		</div>

	</form>
</body>
</html>