package mc.sbm.operaconductor.domain;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.*;

@Entity
@Table(name = "FINANCIAL_TRANSACTIONS", schema = "OPERA")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class FinancialTransaction {

    @Id
    @Column(name = "TRX_NO", nullable = false)
    private Long trxNo;

    @Column(name = "RESORT", nullable = false, length = 20)
    private String resort;

    @Column(name = "TRX_CODE", nullable = false, length = 20)
    private String trxCode;

    @Column(name = "TRX_DATE", nullable = false)
    private LocalDate trxDate;

    @Column(name = "BUSINESS_DATE", nullable = false)
    private LocalDate businessDate;

    @Column(name = "ROOM", length = 20)
    private String room;

    @Column(name = "RESV_NAME_ID")
    private Long resvNameId;

    @Column(name = "CASHIER_ID")
    private Long cashierId;

    @Column(name = "FOLIO_VIEW", precision = 9)
    private Long folioView;

    @Column(name = "REMARK", length = 2000)
    private String remark;

    @Column(name = "REFERENCE", length = 2000)
    private String reference;

    @Column(name = "TRX_AMOUNT", precision = 38, scale = 12)
    private BigDecimal trxAmount;

    @Column(name = "NAME_ID")
    private Long nameId;

    @Column(name = "MARKET_CODE", length = 20)
    private String marketCode;

    @Column(name = "GUEST_ACCOUNT_CREDIT", precision = 38, scale = 12)
    private BigDecimal guestAccountCredit;

    @Column(name = "SOURCE_CODE", length = 20)
    private String sourceCode;

    @Column(name = "RATE_CODE", length = 20)
    private String rateCode;

    @Column(name = "GUEST_ACCOUNT_DEBIT", precision = 38, scale = 12)
    private BigDecimal guestAccountDebit;

    @Column(name = "TRAN_ACTION_ID")
    private Long tranActionId;

    @Column(name = "FIN_DML_SEQ_NO")
    private Long finDmlSeqNo;

    @Column(name = "ROUTING_INSTRN_ID")
    private Long routingInstrnId;

    @Column(name = "FROM_RESV_ID")
    private Long fromResvId;

    @Column(name = "NUMBER_DIALED", length = 40)
    private String numberDialed;

    @Column(name = "NET_AMOUNT", precision = 38, scale = 12)
    private BigDecimal netAmount;

    @Column(name = "GROSS_AMOUNT", precision = 38, scale = 12)
    private BigDecimal grossAmount;

    @Column(name = "RECPT_NO")
    private Long recptNo;

    @Column(name = "ROOM_CLASS", length = 20)
    private String roomClass;

    @Column(name = "FOLIO_NO")
    private Long folioNo;

    @Column(name = "INSERT_DATE", nullable = false)
    private LocalDateTime insertDate;

    @Column(name = "RESV_DEPOSIT_ID")
    private Long resvDepositId;
}
