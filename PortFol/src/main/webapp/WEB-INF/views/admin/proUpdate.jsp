<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="includeFile.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>상품 수정</title>
</head>
<style>
.inputArea {
	display: block;
	width : 35%;
	margin : 0 auto;
	margin-top : 15px;
	margin-bottom : 15px;
}

select {
	width: 100px;
}

label {
	display: inline-block;
	width: 100px;
	padding: 5px;
	font-size: 20px;
}

label[for='gdsDes'] {
	display: block;
}

input , textarea{
	width: 300px;
	border : 2px solid;
	border-radius : 7px;
}

textarea#gdsDes {
	width: 400px;
	height: 180px;
}

.select_img img{margin:20px 0;}

.oriImg{width: 500px; height: auto;}
.thumbImg{}
</style>
<script>
	function back(){
		window.history.back();
	}
	function img(){
		var src = jQuery('#img').attr("src");
		console.log(src);
	}	
</script>
<body>
	<header>
		<div id="header_box">
			<%@ include file="include/adminHeader.jsp"%>
		</div>
	</header><br><br>
	

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
			<button type="button" class="btn btn-secondary"onclick="back()">뒤로</button>
			<button type="submit" id="update_Btn" class="btn btn-primary">수정</button>
		</div>

	</form>
</body>
</html>