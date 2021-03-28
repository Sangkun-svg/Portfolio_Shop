<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="includeFile.jsp"%>
<script type="text/javascript" src="http://code.jquery.com/jquery-2.1.0.min.js"></script>
<title>상품등록</title>
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
</style>
<script type="text/javascript">
	$(function() {
	    $("#filename").on('change', function(){
	        readURL(this);
	    });
	});
	function readURL(input) {
	    if (input.files && input.files[0]) {
	       var reader = new FileReader();
	       reader.onload = function (e) {
	          $('#preImage').attr('src', e.target.result);
	       }
	       reader.readAsDataURL(input.files[0]);
	    }
	}
</script>
<body>
	<form role="form" action="proRegister" method="post">
		<div class="inputArea">
			<label for="proCode">상품코드 </label> <input type="text" id="proCode"
				name="proCode" />
		</div>

		<div class="inputArea">
			<label for="proName">상품명</label> <input type="text" id="proName"
				name="proName" />
		</div>

		<div class="inputArea">
			<label for="proPrice">상품가격</label> <input type="text" id="proPrice"
				name="proPrice" />
		</div>

		<div class="inputArea">
			<label for="proStock">상품수량</label> <input type="text" id="proStock"
				name="proStock" />
		</div>

		<div class="inputArea">
			<label for="proDescription">상품소개</label>
			<textarea rows="5" cols="50" id="proDescription"
				name="proDescription"></textarea>
		</div>

		<div class="image-container">
			<label for="proImg">상품 이미지</label> 
       		<input type='file' id="filename" name="proImg"/>
       		<img id="preImage" src="${pageContext.request.contextPath}/saveFile/${noticeVO.filename}" alt="image_title"/>
       	</div>
 
		<div class="inputArea">
			<button type="submit" id="register_Btn" class="btn btn-primary">등록</button>
		</div>

	</form>
</body>
</html>