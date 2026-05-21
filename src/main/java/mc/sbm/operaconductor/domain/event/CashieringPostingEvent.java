package mc.sbm.operaconductor.domain.event;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "oc_cashiering_posting_events")
@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CashieringPostingEvent extends BaseHotelEvent {

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

    @Column(length = 2000)
    private String remark;
}
