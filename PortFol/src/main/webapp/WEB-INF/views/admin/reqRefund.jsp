<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false" %>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>환불 결정 페이지</title>
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
</style>
<body>
    <div class="wrap">
        <p> User_ID  :  ${test.userId}</p>
        <p> Refund_ProName  :  ${test.orderProName }</p>
        <p> ProCode  :  ${test.proCode }</p>
        <p> ProPrice  :  not yet</p>
        <p> OrderStock  :  ${test.orderStock }</p>
        <p> OrderPrice  :  ${test.orderPrice}</p>
        <p> Reason_Of_Refund  :  Option_N</p>        
        <p> Reason_Of_Refund  :  wrote_userSelf</p>

        <button>허가</button>
        <button>불허</button>
    </div>
</body>
</html>