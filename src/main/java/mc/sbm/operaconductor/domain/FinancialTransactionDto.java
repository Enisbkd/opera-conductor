package mc.sbm.operaconductor.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FinancialTransactionDto {

    private String timestamp;

    private String amount;
    private String approvalCode;
    private String approvalDate;
    private String approvalStatus;
    private String authorizer;
    private String cashier;
    private String confirmationNo;
    private String confirmationLegNo;
    private String compNo;
    private String credit;
    private String currencyCode;
    private String debit;
    private String guestNameId;
    private String firstName;
    private String name;
    private String membershipNumber;
    private String membershipType;
    private String resvNameId;
    private String room;
    private String subGroup;
    private String transactionCode;
    private String transactionDesc;
    private String transactionId;
    private String transactionStatus;
    private String transactionDate;
    private String window;
    private String userName;
    private String externalUserId;
    private String trxAmount;
    private String postedAmount;
    private String depositCredit;
    private String depositDebit;
    private String articleId;
    private String arCredit;
    private String arDebit;
    private String arNumberId;
    private String arState;
    private String arTransferDate;
    private String autoCreditbillYn;
    private String autoSettleYn;
    private String billNumber;
    private String businessDate;
    private String cashierCredit;
    private String cashierDebit;
    private String checkNumber;
    private String covers;
    private String creditCardId;
    private String currency;
    private String depTaxTransferedYn;
    private String exchangeRate;
    private String fiscalBillNo;
    private String folioNo;
    private String folioType;
    private String fromResvId;
    private String grossAmount;
    private String guestCredit;
    private String guestDebit;
    private String insertDate;
    private String insertUser;
    private String invoiceNo;
    private String marketCode;
    private String netAmount;
    private String originalResvNameId;
    private String originalRoom;
    private String passerByName;
    private String postitYn;
    private String product;
    private String quantity;
    private String reference;
    private String remark;
    private String updateDate;
    private String updateUser;
    private String depositTransactionId;
    private String packageTransactionId;
    private String adjustTransactionId;
    private String taxTransactionId;
    private String toResvNameId;
    private String taxRate;
    private String taxRateType;
    private String routedYn;
    private String routingDate;
    private String roomClass;
    private String resvDepositId;
    private String revenueAmt;
    private String reversePaymentTrxNo;
    private String rateCode;
    private String recptNo;
    private String recptType;
}
