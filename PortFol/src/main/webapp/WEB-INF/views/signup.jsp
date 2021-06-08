<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
 	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<title>회원가입</title>
</head>
<style>
	#container{
		width: 500px;
	    height: auto;
	    display: block;
	    margin: 0 auto;
		margin-top : 30px;
		margin-bottom : 50px;
		padding : 15px;
	}
</style>
<script type="text/javascript">
	$(document).ready(function(){
		// 취소
		$(".cencle").on("click", function(){
			location.href = "${pageContext.request.contextPath}/";
		})
		
		$("#submit").on("click", function(){
			if($("#userId").val()==""){
				alert("아이디를 입력해주세요.");
				$("#userId").focus();
				return false;
			}
			if($("#userPass").val()==""){
				alert("비밀번호를 입력해주세요.");
				$("#userPass").focus();
				return false;
			}
			if($("#userName").val()==""){
				alert("성명을 입력해주세요.");
				$("#userName").focus();
				return false;
			}
			var idChkVal = $("#idChk").val();
			if(idChkVal == "N"){
				alert("중복확인 버튼을 눌러주세요.");
			}else if(idChkVal == "Y"){
				$("#regForm").submit();
			}
		});
	})
	
	function fn_idChk(){
		$.ajax({
			url : "${pageContext.request.contextPath}/idValidation",
			type : "post",
			dataType : "json",
			data : {"userId" : $("#userId").val()},
			success : function(data){
				if(data == 1){
					alert("중복된 아이디입니다.");
				}else if(data == 0){
					$("#idChk").attr("value", "Y");
					alert("사용가능한 아이디입니다.");
				}
			}
		    ,error:function(request,status,error){
		        alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);}
		})
	}
</script>
<body>
	<header>
		<div id="header_box">
			<%@ include file="resource/includes/header.jsp"%>
		</div>
	</header><br><br>
	

	<div id="container">
		<form action="${pageContext.request.contextPath}/signup" method="post" id="regForm">
				<label class="control-label" for="userId">아이디</label>
				<input class="form-control" type="text" id="userId" name="userId" />
				<button class="idChk btn btn-outline-primary" type="button" id="idChk" onclick="fn_idChk();" value="N">중복확인</button><br>
			
				<label class="control-label" for="userPass">패스워드</label>
				<input class="form-control" type="password" id="userPass" name="userPass" />

				<label class="control-label" for="userName">성명</label>
				<input class="form-control" type="text" id="userName" name="userName" />

				<label class="control-label" for="userPhone">번호</label>
				<input class="form-control" type="text" id="userPhone" name="userPhone" />

				<label class="control-label" for="address">주소</label>
				<input class="form-control" type="text" id="address" name="address" placeholder="Ex) 은평구 녹번동"/>

				<label class="control-label" for="gender">성별</label><br>
				<input type="radio" name="gender" value="남성">남성				
				<input type="radio" name="gender" value="여성">여성<br>
		
				<button type="submit" class="btn btn-success" >회원가입</button>
				<button class="cencle btn btn-danger" type="button">취소</button>
		</form>
	</div>
	
	<footer>
		<div id="footer_box">
			<%@ include file="resource/includes/footer.jsp"%>
		</div>
	</footer><br><br>
		
</body>
</html>