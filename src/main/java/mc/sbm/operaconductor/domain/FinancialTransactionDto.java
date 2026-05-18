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
    private String businessDate;
    private String fromResvId;
    private String grossAmount;
    private String guestAccountCredit;
    private String guestAccountDebit;
    private String marketCode;
    private String nameId;
    private String rateCode;
    private String resvNameId;
    private String room;
    private String trxAmount;
    private String transactionCode;
    private String trxDate;
    private String folioType;
    private String postingDate;
    private String remark;
}
