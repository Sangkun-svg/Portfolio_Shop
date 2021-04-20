<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false" %>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>환불 페이지 </title>
</head>
<style>
.wrap{
    display: block;
    width: 80%;
    height: 1000px;
    border: 2px solid;
    margin: 0 auto;
    margin-top:100px ;
    margin-bottom:100px ;
}

.line{
    width: 100%;
    height: 1px;
    border-top: 2px solid;
}

#radio_btn{
    width: 30px;
    height: 20px;
}

#refund_select{
    width: 300px;
    height: 30px;
}
#refund_reason_textarea{
    width: 400px;
    height: 130px;    
}

.refund_btn{
    width: 100px;
    height: 50px;
}
</style>
<script>
    function goBack(){
        alert("환불 진행이 중단되었습니다.");
        window.history.back();
    }

    function goRefund(){
        alert("환불이 완료되었습니다.");
        location.href='/main';
    }
</script>
<body>
    <div class="wrap">
        <h1 style="text-align: center;">환불 페이지</h1>
        <div class="line"></div>
        
        <label for="refund_Price"><h2>상품명 : </h2></label><br>
        <label for="refund_Price"><h2>상품 가격 : </h2></label><br>
        <label for="refund_Price"><h2>주문 수량 : </h2></label><br>
        <label for="refund_Price"><h2>환불 방법 :             
            <input type="radio" name="chk_info" value="credit" id="radio_btn">신용카드
            <input type="radio" name="chk_info" value="address" id="radio_btn">계좌입금
</h2>
        </label><br>

        <label for="refund_Price"><h2>환불 이유 : 
        <select name="referenceInfo" id="refund_select">
            <option value="option_1" selected="selected">환불 이유를 선택해 주세요.</option>
            <option value="option_2">환불이유 2---------------</option>
            <option value="option_3">환불이유 3---------------</option>
            <option value="option_4">환불이유 4---------------</option>
            <option value="option_5">환불이유 5---------------</option>
            <option value="option_6">---------------그 외---------------</option>
        </select></h2></label><br>
        <textarea id="refund_reason_textarea" placeholder="환불하시는 이유를 자세하게 기제해 주세요."></textarea>
        <br>


        <button type="button" class="refund_btn" onclick="goBack()">취소</button>
        <button type="button" class="refund_btn" onclick="goRefund()">환불</button>
    </div>
</body>
</html>