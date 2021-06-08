
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="resource/includes/includeFile.jsp"%>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>회원탈퇴</title>
</head>
<style>
	.container_userDelete{
		display: block;
		width : 350px;
		padding-top : 100px;
		padding-left : 15px;
		height : 490px;
		margin : 0 auto;
	}
	.form-control{
		width: 300px;
	}
</style>
<script type="text/javascript">
	$(document).ready(function() {
		// 취소
		$("#cancel").on("click", function() {
			window.history.back();
		})

		$("#submit").on("click", function() {
			if ($("#userId").val() == "") {
				alert("아이디를 입력해주세요.");
				$("#userId").focus();
				return false;
			}
			if ($("#userPass").val() == "") {
				alert("비밀번호를 입력해주세요.");
				$("#userPass").focus();
				return false;
			}
		    if (!confirm("정말 탈퇴 하시겠습니끼?")) {
		        // 취소(아니오) 버튼 클릭 시 이벤트
				alert('취소되었습니다.')
		    } else {
		        // 확인(예) 버튼 클릭 시 이벤트
				alert('그동안 사용해주셔서 감사합니다.');
		    }
		});		
	});
</script>
<body>
	<header>
		<div id="header_box">
			<%@ include file="resource/includes/header.jsp"%>
		</div>
	</header><br><br>

	<div class="container_userDelete">
		<form actoin="${pageContext.request.contextPath}/userDelete?n=${info.userId}" method="post">
			<label class="control-label" for="userId">아이디</label> 
			<input class="form-control" type="text" id="userId" name="userId"/>
		
			<label class="control-label" for="userPass">패스워드</label> 
			<input class="form-control" type="password" id="deletePass" name="deletePass" /><br>

			<button class="btn btn-success" type="submit" id="submit">회원탈퇴</button>
			<button class="cancel btn btn-danger" type="button" id="cancel">취소</button>

			<c:if test="${msg == false}">
					비밀번호가 맞지 않습니다.
				</c:if>
		</form>
	</div>

	<footer>
		<div id="footer_box">
			<%@ include file="resource/includes/footer.jsp"%>
		</div>
	</footer> 
</body>
</html>