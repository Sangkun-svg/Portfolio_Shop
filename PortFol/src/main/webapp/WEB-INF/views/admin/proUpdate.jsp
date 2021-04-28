<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="includeFile.jsp"%>
<title>상품 수정</title>
</head>
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
	<form role="form" action="${pageContext.request.contextPath}/admin/proUpdate" method="post">
		<div class="inputArea">
			<label for="proCode">상품코드 </label> <input type="text" id="proCode"
				name="proCode" value="${pro.proCode}"/>
		</div>

		<div class="inputArea">
			<label for="proName">상품명</label> <input type="text" id="proName"
				name="proName" value="${pro.proName}"/>
		</div>

		<div class="inputArea">
			<label for="proPrice">상품가격</label> <input type="text" id="proPrice"
				name="proPrice" value="${pro.proPrice}"/>
		</div>

		<div class="inputArea">
			<label for="proStock">상품수량</label> <input type="text" id="proStock"
				name="proStock" value="${pro.proStock}"/>
		</div>

		<div class="inputArea">
			<label for="proDescription">상품 설명</label>
			<input type="text" id="proDescription" name="proDescription" value="${pro.proDescription}" style="width: 300px; height: 100px">
		</div>

		<div class="inputArea">
			<label for="proImg">이미지</label>
			<p>원본 이미지</p>
		<img src="${pro.proImg}" class="oriImg" alt="Img Err"/>
		
		<p>썸네일</p>
			<img src="${pro.proThumbnail}" class="thumbImg" alt="Thumbmail Err"/>
		</div>

		<div class="inputArea">
			<button type="submit" id="update_Btn" class="btn btn-primary">수정</button>
		</div>

	</form>
</body>
</html>