
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>회원탈퇴</title>
</head>
<script type="text/javascript">
	$(document).ready(function() {
		// 취소
		$(".cencle").on("click", function() {
			location.href = "${pageContext.request.contextPath}/";
		})

		$("#submit").on("click", function() {
			if ($("#userPass").val() == "") {
				alert("비밀번호를 입력해주세요.");
				$("#userPass").focus();
				return false;
			}
		});

		$.ajax({
			url : "${pageContext.request.contextPath}/passValidation",
			type : "POST",
			dataType : "json",
			data : $("#delForm").serializeArray(),
			success: function(data){
				
				if(data==0){
					alert("패스워드가 틀렸습니다.");
					return;
				}else{
					if(confirm("회원탈퇴하시겠습니까?")){
						$("#delForm").submit();
					}
					
				}
			}
		})
		
	});

})
</script>
<body>
	<section id="container">
		<form action="${pageContext.request.contextPath}/userDelete" method="post">
			<div class="form-group has-feedback">
				<label class="control-label" for="userId">아이디</label> <input
					class="form-control" type="text" id="userId" name="userId"
					value="${member.userId}" readonly="readonly" />
			</div>
			<div class="form-group has-feedback">
				<label class="control-label" for="userPass">패스워드</label> <input
					class="form-control" type="password" id="userPass" name="userPass" />
			</div>
			<div class="form-group has-feedback">
				<label class="control-label" for="userName">성명</label> <input
					class="form-control" type="text" id="userName" name="userName"
					value="${member.userName}" readonly="readonly" />
			</div>
			<div class="form-group has-feedback">
				<button class="btn btn-success" type="submit" id="submit">회원탈퇴</button>
				<button class="cencle btn btn-danger" type="button">취소</button>
			</div>
		</form>
		<div>
			<c:if test="${msg == false}">
					비밀번호가 맞지 않습니다.
				</c:if>
		</div>
	</section>

</body>

</html>