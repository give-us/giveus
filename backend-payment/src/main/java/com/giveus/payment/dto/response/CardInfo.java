package com.giveus.payment.dto.response;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CardInfo {
    private String kakaopay_purchase_corp; // 카카오페이 매입사명
    private String kakaopay_purchase_corp_code; // 카카오페이 매입사 코드
    private String kakaopay_issuer_corp; // 카카오페이 발급사명
    private String kakaopay_issuer_corp_code; // 카카오페이 발급사 코드
    private String bin; // 카드 BIN
    private String card_type; // 카드 타입
    private String install_month; // 할부 개월 수
    private String approved_id; // 카드사 승인번호
    private String card_mid; // 카드사 가맹점 번호
    private String interest_free_install; // 무이자할부 여부(Y/N)
    private String installment_type; // 할부 유형. CARD_INSTALLMENT(업종 무이자),  SHARE_INSTALLMENT(분담 무이자)
}
