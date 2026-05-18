package mc.sbm.operaconductor.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDto {

    private String timestamp;
    private String primaryKey;
    private String hotelId;

    // RESERVATION_NAME table elements
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

    // RESERVATION_DAILY_ELEMENT_NAME table elements
    private String adults;
    private String children;
    private String rateCode;
    private String stayDate;
    private String applySeq;
    private String travelAgentId;
    private String companyId;

    // RESERVATION_DAILY_ELEMENTS table elements
    private String origin;
    private String actionDate;
    private String room;
}
