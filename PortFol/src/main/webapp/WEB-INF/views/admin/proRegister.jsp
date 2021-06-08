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

	function back(){
		window.history.back();
	}
</script>
<body>
	<header>
		<div id="header_box">
			<%@ include file="include/adminHeader.jsp"%>
		</div>
	</header>
	
	
	<form role="form" action="proRegister" method="post" enctype="multipart/form-data">
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


		<div class="inputArea">
			<label for="proImg">이미지</label>
			<input type="file" id="proImg" name="file" />
		<div class="select_img">
			<img src="" />
		</div>

		<script>
			$("#proImg").change(function(){
				if(this.files && this.files[0]) {
					var reader = new FileReader;
					reader.onload = function(data) {
						$(".select_img img").attr("src", data.target.result).width(500);        
					}
					reader.readAsDataURL(this.files[0]);
				}
			});
		</script>
		</div>



 
		<div class="inputArea">
			<button type="button" class="btn btn-secondary" onclick="back()">뒤로</button>
			<button type="submit" id="register_Btn" class="btn btn-primary">등록</button>
		</div>

	</form>
</body>
</html>