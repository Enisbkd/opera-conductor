package mc.sbm.operaconductor.service.mapper;

import java.util.Map;
import java.util.stream.Collectors;
import mc.sbm.operaconductor.GenericEvent;
import mc.sbm.operaconductor.domain.ReservationDto;

public abstract class ReservationBaseMapper implements SinkMapper<ReservationDto> {

    @Override
    public Class<ReservationDto> targetClass() {
        return ReservationDto.class;
    }

    protected static ReservationDto fromEvent(GenericEvent event) {
        Map<String, String> d = event
            .getDetail()
            .stream()
            .collect(
                Collectors.toMap(
                    GenericEvent.EventDetail::getElementName,
                    detail -> detail.getNewValue() != null ? detail.getNewValue() : "",
                    (a, b) -> a
                )
            );
        return ReservationDto.builder()
            .timestamp(event.getTimestamp())
            .primaryKey(event.getPrimaryKey())
            .hotelId(event.getHotelId())
            // RESERVATION_NAME
            .resvNameId(d.get("RESV NAME ID"))
            .resort(d.get("RESORT"))
            .beginDate(d.get("BEGIN DATE"))
            .endDate(d.get("END DATE"))
            .reservationStatus(d.get("RESERVATION STATUS"))
            .confirmationNo(d.get("CONFIRMATION NO"))
            .nameId(d.get("GUEST NAME ID"))
            .guestFirstName(d.get("FIRST NAME"))
            .guestName(d.get("NAME"))
            .externalReference(d.get("EXTERNAL REFERENCE"))
            .partyCode(d.get("PARTY CODE"))
            .udfc16(d.get("UDF CHAR 16"))
            .udfc22(d.get("UDF CHAR 22"))
            .resInsertSource(d.get("SOURCE NAME"))
            .insertDate(d.get("INSERT DATE"))
            // RESERVATION_DAILY_ELEMENT_NAME
            .adults(d.get("ADULTS"))
            .children(d.get("CHILDREN"))
            .rateCode(d.get("RATE CODE"))
            .stayDate(d.get("STAY DATE"))
            .applySeq(d.get("APPLY SEQ"))
            .travelAgentId(d.get("TRAVEL AGENT NAME ID"))
            .companyId(d.get("COMPANY NAME ID"))
            // RESERVATION_DAILY_ELEMENTS
            .origin(d.get("ORIGIN"))
            .actionDate(d.get("ACTION DATE"))
            .room(d.get("ROOM"))
            .build();
    }
}
