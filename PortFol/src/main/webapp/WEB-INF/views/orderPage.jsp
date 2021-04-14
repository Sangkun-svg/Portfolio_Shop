<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>주문 페이지</title>
</head>
	<script type="text/javascript">
		function goMyInfo(){
			alert('주문이 완료되었습니다 ! ')
			location.href="${pageContext.request.contextPath}/myInfo";
		}
	</script>																		
<style>
    .one{
        width: 500px;
        color: gray;
        border: thin solid ;
    }
    .수령자정보{
        border: 1px solid;
    }
    .결제정보_주문자동의{
        border: 1px solid;
    }
</style>
<body>
    <div class="wrap">
        <div class="수령자정보">
            신규 배송지 선택 <input type="radio" name="chk">
            기존 배송지<input type="radio" name="chk" checked="checked"><br>
            <div class="one"></div>
            수령인<input type="text"><br>
            휴대전화<input type="tel" placeholder="'-'없이 입력해주세요."><br>
	<%@ include file="addressAPI.jsp"%>
            배송메모
            <select name="job">
                <option value="option">배송 시 요청사항을 선택해주세요</option>
                <option value="option">부재 시 경비실에 맡겨주세요</option>
                <option value="option">부재 시 택배함에 맡겨주세요</option>
                <option value="option">부재 시 집 앞에 놔주세요</option>
                <option value="option">배송 전 연락 바랍니다</option>
                <option value="option">부재시 경비실에 맡겨주세요</option>
                <option value="option">파손의 위험이 있는 상품입니다. 배송 시 주의해주세요</option>
                <option value="기타">직접입력</option>
            </select><br>
            <div class="one"></div>
        </div>
		<div class="주문상품_정보">
			<h1>주문상품_정보</h1>
        <li><h3>상품번호 : <c:out value="${prolist.proCode}"/>bno값이 없어서 values 가 값을 못읽어옴</h3></li>
		</div>  
        <div class="결제정보_주문자동의">
            결제안내<input type="button" value="신용카드"><input type="button" value="가상계좌(무통장 입금)"><br>
            <div class="one"></div>
            <br>품절 시 처리방법<br>
            <input type="radio" name="chk_2">환불<br>
            <input type="radio" name="chk_2">교환<br>
            <div class="one"></div>
            주문자 동의<br>
            <input type="checkbox">전체 동의<br>
            <input type="checkbox">개인정보 제 3자 제공동의(필수)<br>
            <input type="checkbox">위 상품 정보 및 거래조건을 확인하였으며 , 구매 진행에 동의합니다.<br>
        </div>
        
        <button type="button" onclick="goMyInfo()">주문하기</button>
        
    </div>
</body>
</html>