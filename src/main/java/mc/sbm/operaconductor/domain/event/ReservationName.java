package mc.sbm.operaconductor.domain.event;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "oc_reservation_name")
@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationName extends BaseHotelEvent {

    // RESERVATION_NAME table
    private String resvNameId;
    private String resort;
    private String beginDate;
    private String endDate;
    private String reservationStatus;
    private String confirmationNo;
    private String nameId;
    private String guestFirstName;
    private String guestName;
    private String externalReference;
    private String partyCode;
    private String udfc16;
    private String udfc22;
    private String resInsertSource;
    private String insertDate;

    // RESERVATION_DAILY_ELEMENT_NAME table
    private String adults;
    private String children;
    private String rateCode;
    private String stayDate;
    private String applySeq;
    private String travelAgentId;
    private String companyId;

    // RESERVATION_DAILY_ELEMENTS table
    private String origin;
    private String actionDate;
    private String room;

    private String membershipId;
}
