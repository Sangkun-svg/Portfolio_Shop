package com.sh.Enum;

public enum DeliverySituation {
	// 배송 관련
	Ready , GOING , Success , Destroied 
	// 환불 or 취소 
	, Stop_for_refund , Stop_for_delivery_Cancle , Stop_for_change
	// 환불 or 취소 완료
	, Success_refund , Success_delivery_cancle
}
