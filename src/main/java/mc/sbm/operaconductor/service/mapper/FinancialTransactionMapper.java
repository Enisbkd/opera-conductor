package mc.sbm.operaconductor.service.mapper;

import java.util.Map;
import java.util.stream.Collectors;
import mc.sbm.operaconductor.GenericEvent;
import mc.sbm.operaconductor.domain.FinancialTransactionDto;
import org.springframework.stereotype.Component;

@Component
public class FinancialTransactionMapper implements SinkMapper<FinancialTransactionDto> {

    @Override
    public String eventKey() {
        return "CASHIERING_NEW_POSTING";
    }

    @Override
    public FinancialTransactionDto map(GenericEvent event) {
        return fromEvent(event);
    }

    @Override
    public Class<FinancialTransactionDto> targetClass() {
        return FinancialTransactionDto.class;
    }

    public static FinancialTransactionDto fromEvent(GenericEvent event) {
        Map<String, String> details = event
            .getDetail()
            .stream()
            .collect(
                Collectors.toMap(
                    d -> d.getElementName(),
                    d -> d.getNewValue() != null ? d.getNewValue() : "",
                    (existing, replacement) -> existing
                )
            );

        return FinancialTransactionDto.builder()
            .timestamp(event.getTimestamp())
            .amount(details.get("AMOUNT"))
            .approvalCode(details.get("APPROVAL CODE"))
            .approvalDate(details.get("APPROVAL DATE"))
            .approvalStatus(details.get("APPROVAL STATUS"))
            .authorizer(details.get("AUTHORIZER"))
            .cashier(details.get("CASHIER"))
            .confirmationNo(details.get("CONFIRMATION NO"))
            .confirmationLegNo(details.get("CONFIRMATION LEG NO"))
            .compNo(details.get("COMP NO"))
            .credit(details.get("CREDIT"))
            .currencyCode(details.get("CURRENCY CODE"))
            .debit(details.get("DEBIT"))
            .guestNameId(details.get("GUEST NAME ID"))
            .firstName(details.get("FIRST NAME"))
            .name(details.get("NAME"))
            .membershipNumber(details.get("MEMBERSHIP NUMBER"))
            .membershipType(details.get("MEMBERSHIP TYPE"))
            .resvNameId(details.get("RESV NAME ID"))
            .room(details.get("ROOM"))
            .subGroup(details.get("SUB GROUP"))
            .transactionCode(details.get("TRANSACTION CODE"))
            .transactionDesc(details.get("TRANSACTION DESC"))
            .transactionId(details.get("TRANSACTION ID"))
            .transactionStatus(details.get("TRANSACTION STATUS"))
            .transactionDate(details.get("TRANSACTION DATE"))
            .window(details.get("WINDOW"))
            .userName(details.get("USER NAME"))
            .externalUserId(details.get("EXTERNAL USER ID"))
            .trxAmount(details.get("TRX AMOUNT"))
            .postedAmount(details.get("POSTED AMOUNT"))
            .depositCredit(details.get("DEPOSIT CREDIT"))
            .depositDebit(details.get("DEPOSIT DEBIT"))
            .articleId(details.get("ARTICLE ID"))
            .arCredit(details.get("AR CREDIT"))
            .arDebit(details.get("AR DEBIT"))
            .arNumberId(details.get("AR NUMBER ID"))
            .arState(details.get("AR STATE"))
            .arTransferDate(details.get("AR TRANSFER DATE"))
            .autoCreditbillYn(details.get("AUTO CREDITBILL YN"))
            .autoSettleYn(details.get("AUTO SETTLE YN"))
            .billNumber(details.get("BILL NUMBER"))
            .businessDate(details.get("BUSINESS DATE"))
            .cashierCredit(details.get("CASHIER CREDIT"))
            .cashierDebit(details.get("CASHIER DEBIT"))
            .checkNumber(details.get("CHECK NUMBER"))
            .covers(details.get("COVERS"))
            .creditCardId(details.get("CREDIT CARD ID"))
            .currency(details.get("CURRENCY"))
            .depTaxTransferedYn(details.get("DEP TAX TRANSFERED YN"))
            .exchangeRate(details.get("EXCHANGE RATE"))
            .fiscalBillNo(details.get("FISCAL BILL NO"))
            .folioNo(details.get("FOLIO NO"))
            .folioType(details.get("FOLIO TYPE"))
            .fromResvId(details.get("FROM RESV ID"))
            .grossAmount(details.get("GROSS AMOUNT"))
            .guestCredit(details.get("GUEST CREDIT"))
            .guestDebit(details.get("GUEST DEBIT"))
            .insertDate(details.get("INSERT DATE"))
            .insertUser(details.get("INSERT USER"))
            .invoiceNo(details.get("INVOICE NO"))
            .marketCode(details.get("MARKET CODE"))
            .netAmount(details.get("NET AMOUNT"))
            .originalResvNameId(details.get("ORIGINAL RESV NAME ID"))
            .originalRoom(details.get("ORIGINAL ROOM"))
            .passerByName(details.get("PASSER BY NAME"))
            .postitYn(details.get("POSTIT YN"))
            .product(details.get("PRODUCT"))
            .quantity(details.get("QUANTITY"))
            .reference(details.get("REFERENCE"))
            .remark(details.get("REMARK"))
            .updateDate(details.get("UPDATE DATE"))
            .updateUser(details.get("UPDATE USER"))
            .depositTransactionId(details.get("DEPOSIT TRANSACTION ID"))
            .packageTransactionId(details.get("PACKAGE TRANSACTION ID"))
            .adjustTransactionId(details.get("ADJUST TRANSACTION ID"))
            .taxTransactionId(details.get("TAX TRANSACTION ID"))
            .toResvNameId(details.get("TO RESV NAME ID"))
            .taxRate(details.get("TAX RATE"))
            .taxRateType(details.get("TAX RATE TYPE"))
            .routedYn(details.get("ROUTED YN"))
            .routingDate(details.get("ROUTING DATE"))
            .roomClass(details.get("ROOM CLASS"))
            .resvDepositId(details.get("RESV DEPOSIT ID"))
            .revenueAmt(details.get("REVENUE AMT"))
            .reversePaymentTrxNo(details.get("REVERSE PAYMENT TRX NO"))
            .rateCode(details.get("RATE CODE"))
            .recptNo(details.get("RECPT NO"))
            .recptType(details.get("RECPT TYPE"))
            .build();
    }
}
